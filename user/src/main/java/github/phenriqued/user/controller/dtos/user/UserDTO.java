package github.phenriqued.user.controller.dtos.user;

import github.phenriqued.user.domain.user.UserEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(

    @NotBlank @NotNull
    String cpf,
    @NotBlank
    String name,
    @NotNull
    Integer age

) {
    public UserDTO(@NotNull UserEntity entity){
        this(entity.getCpf(), entity.getName(), entity.getAge());
    }
}
