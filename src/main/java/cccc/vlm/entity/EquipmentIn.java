package cccc.vlm.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EquipmentIn {

    @Id
    @Column(nullable = false, columnDefinition = "varchar(128)")
    private String equipmentSerialId;

    @Column(nullable = false, columnDefinition = "int(10) unsigned")
    private int qty;

    @Column(nullable = false)
    @CreatedDate
    private String createdAt;
}
