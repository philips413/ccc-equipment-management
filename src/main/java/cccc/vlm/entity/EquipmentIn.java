package cccc.vlm.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class EquipmentIn {

    @Id
    @Column(nullable = false, columnDefinition = "varchar(128)")
    private String equipmentSerialId;

    @Column(nullable = false)
    public int equipmentId;

    @Column(nullable = false)
    private int qty;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @CreatedDate
    private String createdAt;

    @Builder
    public EquipmentIn(Integer equipmentId, Integer qty, String description, Integer userId) {
        this.equipmentId = equipmentId;
        this.qty = qty;
        this.description = description;
        this.userId = userId;
        this.equipmentSerialId = UUID.randomUUID().toString();
    }

    public void ableToQty(int currentQty, int applyQty) throws Exception {
        // 1. 가능한 대여 갯수인가
        if (currentQty < applyQty) {
            throw new Exception("가용 갯수를 초과하였습니다.");
        }
    }

}
