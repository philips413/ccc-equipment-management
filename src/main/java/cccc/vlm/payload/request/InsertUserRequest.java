package cccc.vlm.payload.request;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
@Builder
public class InsertUserRequest implements RequestTemplate{

    private String name;

    private String nickName;

    private String userId;

    private String password;

    public boolean verify() {
        if (StringUtils.isBlank(getName())) {
            throw new IllegalArgumentException();
        } else if (StringUtils.isBlank(getUserId())) {
            throw new IllegalArgumentException();
        } else if (StringUtils.isBlank(getPassword())) {
            throw new IllegalArgumentException();
        }

        if (StringUtils.isBlank(getNickName())) {
            setNickName(getName());
        }
        return true;
    }
}
