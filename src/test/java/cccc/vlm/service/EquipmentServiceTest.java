package cccc.vlm.service;

import cccc.vlm.entity.Equipment;
import cccc.vlm.payload.request.InsertEquipmentRequest;
import cccc.vlm.repository.EquipmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class EquipmentServiceTest {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Test
    public void 장비_등록() {
        // given
        InsertEquipmentRequest request = InsertEquipmentRequest.builder()
                .name("장비 테스트")
                .description("TEST")
                .category(1)
                .qty(1)
                .build();

        request.verify();

        // when
        Equipment equipment = Equipment.byInsertEquipmentBuilder()
                .name(request.getName())
                .description(request.getDescription())
                .category(request.getCategory())
                .qty(request.getQty())
                .build();
        Equipment saveEquipment = equipmentRepository.save(equipment);

        // then
        Assertions.assertEquals(saveEquipment.getName(), request.getName());
    }

}