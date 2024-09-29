package shop.mtcoding.test.user;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.test.core.util.Resp;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> list(){
        List<UserResponse.ListDTO> userList = userService.목록보기();
        return ResponseEntity.ok(Resp.ok(userList));
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<?> retrieve(@PathVariable("id") Integer id){
        UserResponse.RetrieveAndReviseDTO model = userService.조회하기(id);
        return ResponseEntity.ok(Resp.ok(model));
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<?> revise(@PathVariable("id") Integer id, @Valid UserRequest.UpdateDTO updateDTO){
        UserResponse.RetrieveAndReviseDTO model = userService.수정하기(id,updateDTO);
        return ResponseEntity.ok(Resp.ok(model));
    }
}
