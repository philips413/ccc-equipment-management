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
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class EquipmentLog {

    @Id
    @Column
    private String equipmentSerialId;

    @Column
    private int equipmentId;

    @Column
    private int userId;

    @Column
    private String name;

    @Column
    private int category;

    @Column
    private String propose;

    @Column
    private int qty;

    @Column
    private String hp;

    @CreatedDate
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Builder(builderMethodName = "byInsertEquipmentLog")
    public EquipmentLog(String equipmentSerialId, int equipmentId, int userId, String name, int category, String propose, int qty, String hp) {
        this.equipmentSerialId = equipmentSerialId;
        this.equipmentId = equipmentId;
        this.userId = userId;
        this.name = name;
        this.category = category;
        this.propose = propose;
        this.qty = qty;
        this.hp = hp;
    }
}
