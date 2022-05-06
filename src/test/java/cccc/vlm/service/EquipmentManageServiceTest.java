package cccc.vlm.service;

import cccc.vlm.entity.Equipment;
import cccc.vlm.entity.EquipmentLog;
import cccc.vlm.entity.EquipmentStats;
import cccc.vlm.payload.request.ApplyEquipmentRequest;
import cccc.vlm.repository.EquipmentLogRepository;
import cccc.vlm.repository.EquipmentRepository;
import cccc.vlm.repository.EquipmentStatsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class EquipmentManageServiceTest {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private EquipmentStatsRepository equipmentStatsRepository;

    @Autowired
    private EquipmentLogRepository equipmentLogRepository;

    private final static int USER_ID = 1;
    private final static int CATEGORY = 1;

    private Equipment EQUIP;

    @BeforeEach
    public void beforeTestCode() {
        // 1. 테스트 장비를 입력하여 준다.
        Equipment equipment1 = Equipment.byInsertEquipmentBuilder()
                .name("장비1")
                .category(CATEGORY)
                .qty(1)
                .description("장비입니다.")
                .build();

        Equipment equipment2 = Equipment.byInsertEquipmentBuilder()
                .name("장비2")
                .category(CATEGORY)
                .qty(2)
                .description("장비입니다.")
                .build();
        equipmentRepository.save(equipment1);
        EQUIP = equipmentRepository.save(equipment2);

        EQUIP.updateUseQty(1);
        EQUIP = equipmentRepository.save(equipment2);
    }

    @Test
    public void 장비_반출_테스트() {
        // given
        // 1. 반출수량과 반출정보를 입력받는다.
        ApplyEquipmentRequest applyEquipment = ApplyEquipmentRequest.builder()
                .equipmentId(EQUIP.getEquipmentId())
                .hp("01030350403")
                .name(EQUIP.getName())
                .qty(2)
                .category(EQUIP.getCategory())
                .propose("촬영시에 사용합니다.")
                .userId(USER_ID)
                .build();

        // when
        // 2. 반출정보를 받고, 실제 저장되어 있는 값과 비교하여 대여할수 있는 상태인지를 체크한다.
        Equipment verifyEquipment = equipmentRepository.findById(EQUIP.getEquipmentId()).get();
        if (!verifyEquipment.canUseQty(applyEquipment.getQty())) {
            throw new IllegalArgumentException();
        }

        // 3. 상태에 데이터를 적재하고, 로그에 데이터를 적재한다.
        EquipmentStats statEquipment = EquipmentStats.byInsertStats()
                .equipmentId(EQUIP.getEquipmentId())
                .userId(USER_ID)
                .build();
        EquipmentStats stats = equipmentStatsRepository.save(statEquipment);

        EquipmentLog log = EquipmentLog.byInsertEquipmentLog()
                .equipmentSerialId(stats.getEquipmentSerialId())
                .category(EQUIP.getCategory())
                .name(EQUIP.getName())
                .equipmentId(EQUIP.getEquipmentId())
                .qty(applyEquipment.getQty())
                .hp(applyEquipment.getHp())
                .propose(applyEquipment.getPropose())
                .userId(USER_ID)
                .build();
        equipmentLogRepository.save(log);

        // 4. 현상태를 업데이트 한다.
        Equipment resultEquipment = equipmentRepository.save(EQUIP);

        // then
        Assertions.assertEquals(resultEquipment.getUseQty(), applyEquipment.getQty());
    }

}
