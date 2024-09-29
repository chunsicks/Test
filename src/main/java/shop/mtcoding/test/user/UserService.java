package shop.mtcoding.test.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.test.core.error.ex.ExceptionApi404;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<UserResponse.ListDTO> 목록보기(){
        List<UserResponse.ListDTO> userDTO = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for(User user : userList){
            UserResponse.ListDTO dto = new UserResponse.ListDTO(user);
            userDTO.add(dto);
        }
        return userDTO;
    }
    public UserResponse.RetrieveAndReviseDTO 조회하기(Integer id){
        User userPS = userRepository.findById(id)
                .orElseThrow(()-> new ExceptionApi404("유저를 찾을 수 없습니다"));
        return new UserResponse.RetrieveAndReviseDTO(userPS);
    }
    public UserResponse.RetrieveAndReviseDTO 수정하기(Integer id, UserRequest.UpdateDTO updateDTO){
        User userPS = userRepository.findById(id)
                .orElseThrow(()-> new ExceptionApi404("유저를 찾을 수 없습니다."));

        userPS.setId(updateDTO.getId());
        userPS.setName(updateDTO.getName());
        return new UserResponse.RetrieveAndReviseDTO(userPS);
    }

}
