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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(10) unsigned")
    private Integer userSysId;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String name;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String nickName;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String userId;

    @Column(nullable = false, columnDefinition = "varchar(128)")
    private String password;

    @Column(nullable = false, columnDefinition = "int(10) unsigned")
    private Integer level;

    @Column(nullable = true, columnDefinition = "varchar(256)")
    private String profileImage;

    @Column(nullable = true, columnDefinition = "int(10) unsigned" )
    private Integer status;

    @CreatedDate
    private LocalDateTime createdAt;

    @PrePersist
    public void PrePersist() {
        if(this.status == null) {
            this.status = 2;
        }
        if (this.level == null) {
            this.level = 3;
        }
    }

    @Builder(builderMethodName = "byUserBuilder")
    public User(String name, String nickName, String userId, String password) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.userId = userId;
    }

}
