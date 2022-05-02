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
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userSysId;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String name;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String nickName;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String userId;

    @Column(nullable = false, columnDefinition = "varchar(128)")
    private String password;

    @ColumnDefault("3")
    private int level;

    @Column(nullable = true, columnDefinition = "varchar(256)")
    private String profileImage;

    @ColumnDefault("2")
    private int status;

    @CreatedDate
    private LocalDateTime createdAt;


    @Builder(builderMethodName = "byUserBuilder")
    public User(String name, String nickName, String userId, String password) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.userId = userId;
    }

}
