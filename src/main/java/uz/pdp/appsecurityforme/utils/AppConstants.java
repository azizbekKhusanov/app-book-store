package uz.pdp.appsecurityforme.utils;

public interface AppConstants {

    String[] OPEN_PAGES = {"/swagger-ui/**", "/api/auth/**", "/v3/api-docs/**", "api/home", "api/books"};
    String BEARER_TYPE = "Bearer";
    String BASIC_TYPE = "Basic";
    String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()]).{8,}$";

    String AUTHORIZATION_KEY = "Authorization";

    String[] DEFAULT_ROLE = {"USER"};
}
