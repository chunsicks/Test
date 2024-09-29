package shop.mtcoding.test.user;

import lombok.Data;

public class UserResponse {

    @Data
    public static class ListDTO{
        private Integer id;

        public ListDTO(User user) {
            this.id = user.getId();
        }
    }
    @Data
    public static class RetrieveAndReviseDTO{
        private Integer id;
        private String name;

        public RetrieveAndReviseDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
        }
    }
}
