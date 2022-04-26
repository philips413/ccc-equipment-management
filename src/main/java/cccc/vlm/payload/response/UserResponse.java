package cccc.vlm.payload.response;

import lombok.Data;

@Data
public class UserResponse {

    private int userSysId;

    private String userId;

    private String name;

    private String nickName;

    private String email;

    private String password;

    private String createdAt;
    
}
