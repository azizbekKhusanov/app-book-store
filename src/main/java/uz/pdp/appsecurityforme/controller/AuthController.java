package uz.pdp.appsecurityforme.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.appsecurityforme.dto.LoginDTO;
import uz.pdp.appsecurityforme.dto.RegisterDTO;
import uz.pdp.appsecurityforme.dto.TokenDTO;
import uz.pdp.appsecurityforme.payload.ApiResult;


@RequestMapping("/api/auth")
public interface AuthController {


    @PostMapping("/login")
    HttpEntity<ApiResult<TokenDTO>> login(@RequestBody LoginDTO loginDTO);

    @PostMapping("/register")
    HttpEntity<ApiResult<TokenDTO>> register(@RequestBody RegisterDTO registerDTO);


}
