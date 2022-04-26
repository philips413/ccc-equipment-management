package cccc.vlm.service;

import cccc.vlm.controller.VerifyIdRequest;
import cccc.vlm.payload.response.VerifyIdResponse;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    public VerifyIdResponse canUsingUserId(VerifyIdRequest request) {
        // something;
        return new VerifyIdResponse();
    }
}
