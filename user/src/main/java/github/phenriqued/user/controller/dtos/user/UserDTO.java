package github.phenriqued.user.controller.dtos.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserCreateDTO(

    @NotBlank @NotNull
    String cpf,
    @NotBlank
    String name,
    Integer age

) {
}
