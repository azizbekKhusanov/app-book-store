package uz.pdp.appsecurityforme.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorData {
    private int errorCode;
    private String message;
    private String fieldName;

    public ErrorData(String message, int errorCode){
        this.errorCode = errorCode;
        this.message = message;
    }
}
