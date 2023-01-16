package main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value= { ApplicationException.class})
    protected ResponseEntity<Object> handleMethodArgumentNotValid(ApplicationException ex) {

        return new ResponseEntity<>(ex.getMessage(), ex.getStatus());
    }


    @ExceptionHandler(value= { Exception.class})
    protected ResponseEntity<Object> generalExc(ApplicationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
// alloi exception gia kathe custom exception pou exo ftiaksei