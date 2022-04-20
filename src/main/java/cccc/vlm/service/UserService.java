package cccc.vlm.service;

import cccc.vlm.entity.User;
import cccc.vlm.payload.request.InsertUserRequest;
import cccc.vlm.payload.response.UserResponse;
import cccc.vlm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse insertUser(InsertUserRequest request) {
        User user = User.byUserBuilder()
                        .name(request.getName())
                        .nickName(request.getNickName())
                        .email(request.getEmail())
                        .build();
        return null;
    }
}
