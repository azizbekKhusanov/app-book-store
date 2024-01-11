package uz.pdp.appsecurityforme.exceptions;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.pdp.appsecurityforme.payload.ApiResult;
import uz.pdp.appsecurityforme.payload.ErrorData;

@RestControllerAdvice
public class AppExceptionHandler {


    @ExceptionHandler(value = RestException.class)
    public HttpEntity<ApiResult<ErrorData>> exceptionHandler(RestException exception) {

        return ResponseEntity.status(exception.getHttpStatus())
                .body(ApiResult.errorResponse(exception.getHttpStatus().value(), exception.getMessage()));
    }

    @ExceptionHandler(value = RuntimeException.class)
    public HttpEntity<ApiResult<ErrorData>> exceptionHandler(RuntimeException exception) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResult.errorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage()));
    }

}
