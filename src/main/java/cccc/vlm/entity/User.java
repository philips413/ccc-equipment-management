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
    private Integer userId;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String name;

    @Column(nullable = true, columnDefinition = "varchar(20)")
    private String nickName;

    @Column(nullable = false, columnDefinition = "varchar(128)")
    private String password;

    @Column(nullable = false, columnDefinition = "int(10) unsigned")
    @ColumnDefault("3")
    private Integer level;

    @Column(nullable = false, columnDefinition = "varchar(256)")
    private String profileImage;

    @Column(nullable = false, columnDefinition = "varchar(100)")
    @ColumnDefault("'kakao'")
    private String loginPlatform;

    @Column(nullable = false, columnDefinition = "varchar(512)")
    private String platformUserId;

    @Column(nullable = false, columnDefinition = "varchar(128)")
    private String email;

    @Column(nullable = false, columnDefinition = "int(10) unsigned" )
    @ColumnDefault("2")
    private Integer status;

    @CreatedDate
    private LocalDateTime createdAt;

    @Builder(builderMethodName = "byUserBuilder")
    public User(String name, String nickName, String password, Integer level, String profileImage, String loginPlatform, String platformUserId, String email, Integer status) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.level = level;
        this.profileImage = profileImage;
        this.loginPlatform = loginPlatform;
        this.platformUserId = platformUserId;
        this.email = email;
        this.status = status;
    }

}
