package cccc.vlm.service;

import cccc.vlm.entity.User;
import cccc.vlm.payload.request.InsertUserRequest;
import cccc.vlm.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void 사용자_등록() {
        //given
        InsertUserRequest userRequest = InsertUserRequest.builder()
                .name("김도령")
                .nickName("미친강아지")
                .userId("kimehfud")
                .password("1324")
                .build();

        User userEntity = User.byUserBuilder()
                .name(userRequest.getName())
                .nickName(userRequest.getNickName())
                .userId(userRequest.getUserId())
                .password(userRequest.getPassword())
                .build();

        //when
        User result = userRepository.save(userEntity);

        //then
        Assertions.assertEquals(result.getName(), userRequest.getName());
    }
}