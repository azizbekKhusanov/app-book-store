package uz.pdp.appsecurityforme.dto;

import jakarta.validation.constraints.NotBlank;

public record AddAdminDTO(@NotBlank String email) {

}
