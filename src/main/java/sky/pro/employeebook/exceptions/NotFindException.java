package sky.pro.employeebook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFindException extends RuntimeException {
    public  NotFindException(String massage) {
        super(massage);
    }
}