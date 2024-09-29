package shop.mtcoding.test.core.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Resp<T> {

    private T body;

    public static <B> Resp<?> ok(B body){
        return new Resp<>( body);
    }

    public static Resp<?> fail(Integer status, String msg){
        return new Resp<>(null);
    }
}
