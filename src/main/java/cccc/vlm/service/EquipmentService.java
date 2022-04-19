package cccc.vlm.service;


import cccc.vlm.entity.Equipment;
import cccc.vlm.payload.request.InsertEquipmentRequest;
import cccc.vlm.payload.response.EquipmentResponse;
import cccc.vlm.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Transactional
    public EquipmentResponse insertEquipment(InsertEquipmentRequest request) {
        Equipment equipmentBuild = Equipment.builder()
                .name(request.getName())
                .category(request.getCategory())
                .description(request.getDescription())
                .qty(request.getQty())
                .maxUseQty(request.getMaxUseQty())
                .minUseQty(request.getMinUseQty())
                .build();
        equipmentRepository.save(equipmentBuild);
        return null;
    }
}
