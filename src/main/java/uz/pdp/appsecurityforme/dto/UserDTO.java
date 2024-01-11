package uz.pdp.appsecurityforme.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @JsonIgnore
    @NotBlank
    private String password;

    @NotBlank
    private String role;
}
