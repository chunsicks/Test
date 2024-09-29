package shop.mtcoding.test.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name="user_tb")
@Entity
@Data
public class User {

    @Id
    private Integer id;

    private String name;

    @Builder
    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
