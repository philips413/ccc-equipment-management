package cccc.vlm.controller;

import cccc.vlm.entity.User;
import cccc.vlm.payload.request.InsertUserRequest;
import cccc.vlm.payload.request.UpdateEquipmentRequest;
import cccc.vlm.payload.request.UpdateUserRequest;
import cccc.vlm.payload.response.UserResponse;
import cccc.vlm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UserResponse insertUser(InsertUserRequest request) {
        request.verify();
        UserResponse userResponse = userService.insertUser(request);
        return userResponse;
    }

    @GetMapping("/list")
    public List<UserResponse> getUserResponseList() {
        return userService.getUserResponseList();
    }

    @PatchMapping("/{userId}")
    public UserResponse updateUser(@PathVariable("userId") Integer userId, UpdateUserRequest request) {
        request.verify();
        UserResponse userResponse = userService.updateUser(userId, request);
        return userResponse;
    }

}
