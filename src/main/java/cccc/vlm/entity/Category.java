package cccc.vlm.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(nullable = false, columnDefinition ="varchar(128)")
    private String categoryName;

    @Column(nullable = false)
    @ColumnDefault("1")
    private int status;

    @Column(nullable = true, columnDefinition ="varchar(1024)")
    private String description;

    @CreatedDate
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @ColumnDefault("1")
    private int createdId;

    @Builder
    public Category(String categoryName, String description) {
        this.categoryName = categoryName;
        if(StringUtils.isNotBlank(description)) {
            this.description = description;
        }
    }
}
