package cccc.vlm.service;

import cccc.vlm.entity.Equipment;
import cccc.vlm.entity.EquipmentLog;
import cccc.vlm.entity.EquipmentStats;
import cccc.vlm.payload.request.ApplyEquipmentRequest;
import cccc.vlm.payload.response.ApplyEquipmentResponse;
import cccc.vlm.repository.EquipmentLogRepository;
import cccc.vlm.repository.EquipmentRepository;
import cccc.vlm.repository.EquipmentStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentManageService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private EquipmentStatsRepository equipmentStatsRepository;

    @Autowired
    private EquipmentLogRepository equipmentLogRepository;

    public ApplyEquipmentResponse applyEquipment(ApplyEquipmentRequest request) {

        Equipment verifyEquipment = equipmentRepository.findById(request.getEquipmentId()).get();
        if (!verifyEquipment.canUseQty(request.getQty())) {
            throw new IllegalArgumentException();
        }

        EquipmentStats statEquipment = EquipmentStats.byInsertStats()
                .equipmentId(verifyEquipment.getEquipmentId())
                .userId(request.getUserId())
                .build();
        EquipmentStats stats = equipmentStatsRepository.save(statEquipment);

        EquipmentLog log = EquipmentLog.byInsertEquipmentLog()
                .equipmentSerialId(stats.getEquipmentSerialId())
                .category(request.getCategory())
                .name(request.getName())
                .equipmentId(request.getEquipmentId())
                .qty(request.getQty())
                .hp(request.getHp())
                .propose(request.getPropose())
                .userId(request.getUserId())
                .build();
        equipmentLogRepository.save(log);

        // 4. 현상태를 업데이트 한다.
        equipmentRepository.save(verifyEquipment);

        return ApplyEquipmentResponse.builder()
                .equipmentSerialId(log.getEquipmentSerialId())
                .build();
    }
}
