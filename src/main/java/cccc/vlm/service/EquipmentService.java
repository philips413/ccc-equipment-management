package cccc.vlm.service;


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
        return null;
    }
}
