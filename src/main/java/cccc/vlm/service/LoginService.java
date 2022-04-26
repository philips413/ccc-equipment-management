package cccc.vlm.service;

import cccc.vlm.payload.request.LoginRequest;
import cccc.vlm.payload.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public LoginResponse tryToLogin(LoginRequest request) {
        return new LoginResponse();
    }
}
