package cccc.vlm.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EquipmentUseing {

    @Id
    @Column(nullable = false, columnDefinition = "varchar(128)")
    private String equipmentSerialId;

    @Column(nullable = false, columnDefinition = "int(10) unsigned")
    private int userId;

    @Column(nullable = false, columnDefinition = "int(10) unsigned")
    private int equipmentId;

    @Column(nullable = false, columnDefinition = "varchar(128)")
    private String name;

    @Column(nullable = false, columnDefinition = "int(10) unsigned")
    private int category;

    @Column(nullable = false, columnDefinition = "varchar(1024)")
    private String propose;

    @Column(nullable = false, columnDefinition = "int(10) unsigned")
    private int qty;

    @Column(nullable = true, columnDefinition = "varchar(128)")
    private String hp;

    @Column(nullable = false)
    @CreatedDate
    private String createdAt;

}
