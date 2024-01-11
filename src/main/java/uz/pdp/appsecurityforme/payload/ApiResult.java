package uz.pdp.appsecurityforme.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult<T> implements Serializable {

    private boolean success;
    private String message;
    private T data;
    private List<ErrorData> errors;

    private ApiResult() {
        this.success = true;
    }

    private ApiResult(String message) {
        this();
        this.message = message;
    }


    private ApiResult(T data) {
        this();
        this.data = data;
    }

    private ApiResult(List<ErrorData> errors) {
        this.errors = errors;
    }

    public static <E> ApiResult<E> successResponse(String message) {
        return new ApiResult<>(message);
    }

    public static <E> ApiResult<E> successResponse(E data) {
        return new ApiResult<>(data);
    }

    public static <E> ApiResult<E> errorResponse(List<ErrorData> errors) {
        return new ApiResult<>(errors);
    }

    public static <E> ApiResult<E> errorResponse(int errorCode, String message) {
        return new ApiResult<>(List.of(new ErrorData(message, errorCode)));
    }


}
