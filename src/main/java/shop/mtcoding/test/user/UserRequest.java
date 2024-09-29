package shop.mtcoding.test.user;

import lombok.Data;

public class UserRequest {
    @Data
    public static class UpdateDTO {

        private Integer id;
        private String name;
    }
}
