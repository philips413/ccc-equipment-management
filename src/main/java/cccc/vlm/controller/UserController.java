package cccc.vlm.controller;

import cccc.vlm.payload.request.InsertUserRequest;
import cccc.vlm.payload.response.UserResponse;
import cccc.vlm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponse insertUser(@RequestBody InsertUserRequest request) {
        request.verify();
        userService.insertUser(request);
        return null;
    }

}
