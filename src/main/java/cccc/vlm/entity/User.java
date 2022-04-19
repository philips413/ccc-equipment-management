package cccc.vlm.entity;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(10) unsigned")
    private int userId;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String name;

    @Column(nullable = false, columnDefinition = "int(10) unsigned")
    @ColumnDefault("3")
    private int level;

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
    private int status;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;
}
