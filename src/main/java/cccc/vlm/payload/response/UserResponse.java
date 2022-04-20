package cccc.vlm.payload.response;

import lombok.Data;

@Data
public class UserResponse {

    private int userId;

    private String name;

    private String nickName;

    private String email;

    private String password;
}
