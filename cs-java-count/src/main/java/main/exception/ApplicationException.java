package main.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationException extends RuntimeException{

    private HttpStatus status;
    private String message;

    public ApplicationException(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

}


