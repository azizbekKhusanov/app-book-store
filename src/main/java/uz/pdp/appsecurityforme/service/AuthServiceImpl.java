package uz.pdp.appsecurityforme.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.appsecurityforme.dto.ChangePasswordDTO;
import uz.pdp.appsecurityforme.dto.LoginDTO;
import uz.pdp.appsecurityforme.dto.TokenDTO;
import uz.pdp.appsecurityforme.dto.UserDTO;
import uz.pdp.appsecurityforme.entity.User;
import uz.pdp.appsecurityforme.exceptions.RestException;
import uz.pdp.appsecurityforme.repository.UserRepository;
import uz.pdp.appsecurityforme.security.JWTProvider;
import uz.pdp.appsecurityforme.security.UserPrincipal;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository,
                           @Lazy AuthenticationManager authenticationManager,
                           JWTProvider jwtProvider,
                           @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserPrincipal(userRepository.findByEmail(username)
                .orElseThrow(() -> RestException.exception("Username not found")));
    }

    @Override
    public Optional<User> findUserById(String userId) {
        if (userId == null)
            return Optional.empty();
        return userRepository.findById(Long.valueOf(userId));
    }

    @Override
    public TokenDTO login(LoginDTO loginDTO) {
        UserPrincipal principal = checkCredential(loginDTO.getEmail(), loginDTO.getPassword());

        return generateTokenDTO(principal);
    }


    public UserDTO getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> RestException.exception("User not found"));

        return mapToUserDTOFromUser(user);
    }

    public List<UserDTO> getAll() {
        List<User> all = userRepository.findAll();

        return all.stream()
                .map(this::mapToUserDTOFromUser)
                .toList();
    }

    public UserDTO changePassword(Long id, ChangePasswordDTO changePasswordDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> RestException.exception("User not found"));

        if (!passwordEncoder.matches(changePasswordDTO.getCurrentPassword(), user.getPassword()))
            throw RestException.exception("Wrong password entered");

        checkPassword(changePasswordDTO);
        user.setPassword(changePasswordDTO.getNewPassword());

        return mapToUserDTOFromUser(user);
    }

    private void checkPassword(ChangePasswordDTO changePasswordDTO) {
        if (!Objects.equals(changePasswordDTO.getNewPassword(), changePasswordDTO.getConfirmPassword()))
            throw RestException.exception("Password don't match");
        //todo (Check password regex)
    }


    private TokenDTO generateTokenDTO(UserPrincipal principal) {
        String id = principal.user().getId().toString();
        return TokenDTO.builder()
                .accessToken(jwtProvider.createAccessToken(id))
                .refreshToken(jwtProvider.createRefreshToken(id))
                .build();
    }

    public UserPrincipal checkCredential(String username, String password) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        return (UserPrincipal) authentication.getPrincipal();
    }

    private UserDTO mapToUserDTOFromUser(User user) {
        return UserDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

}
