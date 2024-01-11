package uz.pdp.appsecurityforme.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import uz.pdp.appsecurityforme.dto.LoginDTO;
import uz.pdp.appsecurityforme.dto.TokenDTO;
import uz.pdp.appsecurityforme.entity.User;

import java.util.Optional;

public interface AuthService extends UserDetailsService {

    Optional<User> findUserById(String userId);

    TokenDTO login(LoginDTO loginDTO);

}
