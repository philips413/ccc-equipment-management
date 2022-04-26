package cccc.vlm.payload.response;

import lombok.Data;

@Data
public class VerifyIdResponse {

    private String userId;

    private boolean canUsing;
}
