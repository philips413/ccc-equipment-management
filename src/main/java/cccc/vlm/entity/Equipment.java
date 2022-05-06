package cccc.vlm.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;
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
    private int equipmentId;

    @Column(nullable = false, columnDefinition ="varchar(128)")
    private String name;

    @Column(nullable = false)
    private int category;

    @Column(nullable = true, columnDefinition = "varchar(1024)")
    private String description;

    @Column(nullable = false)
    private int status;

    @Column(nullable = false)
    private int qty;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int useQty;

    @Column(nullable = false)
    @ColumnDefault("1")
    private int createdId;

    @CreatedDate
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Builder(builderMethodName = "byInsertEquipmentBuilder")
    public Equipment(String name, Integer category, String description, Integer qty) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.qty = qty;
        this.status = 1;
    }

    public void updateUseQty(int useQty) {
        this.useQty = useQty;
    }

    public boolean canUseQty(int applyQty) {
        int ableQty = this.qty - this.useQty;
        if (ableQty - applyQty >= 0) {
            this.useQty = (this.useQty + applyQty);
            return true;
        }
        return false;
    }
}
