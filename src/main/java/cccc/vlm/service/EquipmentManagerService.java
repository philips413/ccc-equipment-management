package cccc.vlm.service;

import cccc.vlm.entity.Equipment;
import cccc.vlm.entity.EquipmentIn;
import cccc.vlm.payload.request.ApplyEquipmentRequest;
import cccc.vlm.payload.response.ApplyEquipmentResponse;
import cccc.vlm.repository.EquipmentInRepository;
import cccc.vlm.repository.EquipmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EquipmentManagerService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private EquipmentInRepository equipmentInRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ApplyEquipmentResponse apply(ApplyEquipmentRequest request) throws Exception {
        // 현상태의 장비상태를 가져온다.
        Equipment currentEquipment = equipmentRepository.findById(request.getEquipmentId()).get();

        EquipmentIn builderEquipment = EquipmentIn.builder()
                .equipmentId(request.getEquipmentId())
                .qty(request.getQty())
                .description(request.getDescription())
                .userId(request.getUserId())
                .build();

        builderEquipment.ableToQty(currentEquipment.getQty(), request.getQty());

        EquipmentIn saveEquipment = equipmentInRepository.save(builderEquipment);

        return ApplyEquipmentResponse.builder()
                .equipmentSerialId(saveEquipment.getEquipmentSerialId())
                .equipmentId(currentEquipment.getEquipmentId())
                .equipmentName(currentEquipment.getName())
                .qty(request.getQty())
                .build();
    }

}

