package uz.pdp.appsecurityforme.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RestException extends RuntimeException{

    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    private RestException(String message){
        super(message);
    }

    private RestException(HttpStatus httpStatus, String message){
        super(message);
        this.httpStatus = httpStatus;
    }

    public static RestException exception(String message){
        return new RestException(message);
    }

    public static RestException exception(String message, HttpStatus httpStatus){
        return new RestException(httpStatus, message);
    }

}
