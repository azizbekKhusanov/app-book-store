package uz.pdp.appsecurityforme.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appsecurityforme.dto.LoginDTO;
import uz.pdp.appsecurityforme.dto.RegisterDTO;
import uz.pdp.appsecurityforme.dto.TokenDTO;
import uz.pdp.appsecurityforme.payload.ApiResult;
import uz.pdp.appsecurityforme.service.AuthService;


@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;


    @Override
    public HttpEntity<ApiResult<TokenDTO>> login(LoginDTO loginDTO) {
//        try {
//            TokenDTO tokenDTO = authService.login(loginDTO);
//            return ResponseEntity.ok(ApiResult.successResponse(tokenDTO));
//        } catch (RestException e) {
//            throw RestException.exception(e.getMessage(), e.getHttpStatus());
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }

        TokenDTO tokenDTO = authService.login(loginDTO);
        return ResponseEntity.ok(ApiResult.successResponse(tokenDTO));
    }

    @Override
    public HttpEntity<ApiResult<TokenDTO>> register(RegisterDTO registerDTO) {
        //todo
        return null;
    }

}
