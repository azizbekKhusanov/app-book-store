package uz.pdp.appsecurityforme.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BookDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    private String description;

    @NotBlank
    private int quantity;

    @NotBlank
    private double price;
}
