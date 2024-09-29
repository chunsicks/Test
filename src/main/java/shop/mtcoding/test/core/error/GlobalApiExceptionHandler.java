package shop.mtcoding.test.core.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shop.mtcoding.test.core.error.ex.ExceptionApi400;
import shop.mtcoding.test.core.error.ex.ExceptionApi404;
import shop.mtcoding.test.core.util.Resp;

@RestControllerAdvice
public class GlobalApiExceptionHandler {
    @ExceptionHandler(ExceptionApi400.class)
    public ResponseEntity<?> ex400(Exception e) {
        return new ResponseEntity<>(Resp.fail(400,"reason : " + e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExceptionApi404.class)
    public ResponseEntity<?> ex404(Exception e) {
        return new ResponseEntity<>(Resp.fail(404, "reason : " + e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
