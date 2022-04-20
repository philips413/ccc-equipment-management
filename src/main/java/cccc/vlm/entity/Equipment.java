package cccc.vlm.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
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
    private int status;

    @Column(nullable = false, columnDefinition = "int(10) unsigned")
    private Integer qty;

    @Column(nullable = false, columnDefinition = "int(10) unsigned")
    private Integer maxUseQty;

    @Column(nullable = true, columnDefinition = "int(10) unsigned")
    private Integer minUseQty;

    @CreatedDate
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @ColumnDefault("1")
    private int createdId;

    @Builder(builderMethodName = "byInsertEquipmentBuilder")
    public Equipment(String name, Integer category, String description, Integer qty, Integer maxUseQty, Integer minUseQty) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.qty = qty;
        this.status = 1;
        // 선택사항
        this.maxUseQty = maxUseQty;
        if (maxUseQty == null) {
            this.maxUseQty = qty;
        }
        // 선택사항
        this.minUseQty = minUseQty;
        if (minUseQty == null) {
            this.minUseQty = qty;
        }
    }
}
