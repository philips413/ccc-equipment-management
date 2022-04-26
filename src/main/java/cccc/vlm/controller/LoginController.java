package cccc.vlm.controller;

import cccc.vlm.payload.request.LoginRequest;
import cccc.vlm.payload.response.LoginResponse;
import cccc.vlm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("")
    public LoginResponse postLogin(LoginRequest request) {
        return loginService.tryToLogin(request);
    }
}
