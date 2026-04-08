package br.com.infnet.testcontainers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UserCreateRequest(
        @NotBlank(message = "O nome não pode ser vazio")
        @Size(max = 120, message = "O nome deve possuir no máximo 120 caracteres")
        String name,
        @PastOrPresent(message = "A data não pode ser no futuro")
        @NotNull(message = "A data de nascimento é obrigatória")
        LocalDate dateOfBirth
) {
}
