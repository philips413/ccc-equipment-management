package cccc.vlm.payload.response;

import lombok.Data;

@Data
public class LoginResponse {

    private String userId;

    private String name;

    private String nickName;

    private String accessToken;

    private String refreshToken;

    private String level;

    private String status;

}
