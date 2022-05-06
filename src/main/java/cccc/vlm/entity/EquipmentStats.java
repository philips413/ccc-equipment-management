package cccc.vlm.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class EquipmentStats {

    @Id
    private String equipmentSerialId;

    @Column
    private int equipmentId;

    @Column
    private int userId;

    @Column
    @ColumnDefault("1")
    private int status;

    @CreatedDate
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Builder(builderMethodName = "byInsertStats")
    public EquipmentStats(int equipmentId, int userId) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        this.equipmentSerialId = uuid;
        this.equipmentId =equipmentId;
        this.userId = userId;
    }

}
