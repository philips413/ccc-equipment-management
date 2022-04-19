package cccc.vlm.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
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
