package cccc.vlm.entity;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(10) unsigned not null")
    private int equipmentId;

    @Column(nullable = false, columnDefinition ="varchar(128) not null")
    private String name;

    @Column(nullable = false, columnDefinition = "int(10) unsigned")
    private int category;

    @Column(nullable = true, columnDefinition = "varchar(1024)")
    private String description;

    @Column(nullable = false, columnDefinition = "int(10) unsigned")
    @ColumnDefault("1")
    private int status;

    @Column(nullable = false, columnDefinition = "int(10) unsigned")
    @ColumnDefault("1")
    private String qty;

    @Column(nullable = false, columnDefinition = "int(10) unsigned")
    private String maxUseQty;

    @Column(nullable = true, columnDefinition = "int(10) unsigned")
    private String minUseQty;

    @Column(nullable = false)
    @CreatedDate
    private String createdAt;

    @Column(nullable = false)
    private int createdId;
}
