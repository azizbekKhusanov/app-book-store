package uz.pdp.appsecurityforme.dto;

import lombok.Builder;
import lombok.Data;
import uz.pdp.appsecurityforme.utils.AppConstants;

@Data
@Builder
public class TokenDTO {

    private String accessToken;
    private String refreshToken;

    private final String tokenType = AppConstants.BEARER_TYPE;


}
