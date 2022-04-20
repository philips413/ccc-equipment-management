package cccc.vlm.service;


import cccc.vlm.entity.Equipment;
import cccc.vlm.payload.request.InsertEquipmentRequest;
import cccc.vlm.payload.request.UpdateEquipmentRequest;
import cccc.vlm.payload.response.EquipmentResponse;
import cccc.vlm.repository.EquipmentRepository;
import org.hibernate.persister.spi.UnknownPersisterException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public EquipmentResponse insertEquipment(InsertEquipmentRequest request) {
        Equipment equipment = Equipment.byInsertEquipmentBuilder()
                .name(request.getName())
                .category(request.getCategory())
                .description(request.getDescription())
                .qty(request.getQty())
                .maxUseQty(request.getMaxUseQty())
                .minUseQty(request.getMinUseQty())
                .build();
        Equipment saveEquipment = equipmentRepository.save(equipment);
        EquipmentResponse response = modelMapper.map(saveEquipment, EquipmentResponse.class);
        return response;
    }

    @Transactional
    public List<EquipmentResponse> getList() {
        List<Equipment> list = equipmentRepository.findAll();
        return list.stream()
                .map(item -> modelMapper.map(item, EquipmentResponse.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public EquipmentResponse updateEquipment(Integer equipmentId, UpdateEquipmentRequest request) throws NoSuchMethodException {

        Equipment equipment = equipmentRepository.findById(equipmentId).get();
        equipment.setName(request.getName());
        equipment.setCategory(request.getCategory());
        equipment.setDescription(request.getDescription());
        equipment.setQty(request.getQty());
        equipment.setMaxUseQty(request.getMaxUseQty());
        equipment.setMinUseQty(request.getMinUseQty());

        Equipment responseEquipment = equipmentRepository.save(equipment);

        EquipmentResponse response = modelMapper.map(responseEquipment, EquipmentResponse.class);
        return response;
    }
}
