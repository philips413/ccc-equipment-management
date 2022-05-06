package cccc.vlm.service;

import cccc.vlm.entity.User;
import cccc.vlm.payload.request.InsertUserRequest;
import cccc.vlm.payload.request.UpdateUserRequest;
import cccc.vlm.payload.response.UserResponse;
import cccc.vlm.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserResponse insertUser(InsertUserRequest request) {
        User user = User.byUserBuilder()
                        .name(request.getName())
                        .userId(request.getUserId())
                        .password(request.getPassword())
                        .nickName(request.getNickName())
                        .build();
        User userEntity = userRepository.save(user);

        UserResponse userResponse = modelMapper.map(userEntity, UserResponse.class);
        return userResponse;
    }

    public List<UserResponse> getUserResponseList() {
        List<User> allUser = userRepository.findAll();
        return allUser.stream()
                .map(item -> modelMapper.map(item, UserResponse.class))
                .collect(Collectors.toList());
    }

    public UserResponse updateUser(Integer userId, UpdateUserRequest request) {
        User userEntity = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        userEntity.setName(request.getName());
        userEntity.setNickName(request.getNickName());

        User saveUser = userRepository.save(userEntity);

        UserResponse userResponse = modelMapper.map(saveUser, UserResponse.class);
        return userResponse;
    }
}
