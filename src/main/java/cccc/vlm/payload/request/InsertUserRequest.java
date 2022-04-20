package cccc.vlm.payload.request;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
@Builder
public class InsertUserRequest implements RequestTemplate{

    private String name;

    private String nickName;

    private String password;

    private String email;

    public boolean verify() {
        if (StringUtils.isBlank(this.name)) {
            throw new IllegalArgumentException();
        } else if (StringUtils.isBlank(this.password)) {
            throw new IllegalArgumentException();
        } else if (StringUtils.isBlank(this.email)) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
