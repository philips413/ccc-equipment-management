package cccc.vlm.entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Data
@Entity
@Builder
public class Equipment{

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
    private Integer qty;

    @Column(nullable = false, columnDefinition = "int(10) unsigned")
    private Integer maxUseQty;

    @Column(nullable = true, columnDefinition = "int(10) unsigned")
    private Integer minUseQty;

    @Column(nullable = false)
    @CreatedDate
    private String createdAt;

    @Column(nullable = false)
    @ColumnDefault("1")
    private int createdId;

    public Equipment() {

    }
}
