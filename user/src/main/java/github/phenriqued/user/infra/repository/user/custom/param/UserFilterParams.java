package github.phenriqued.user.infra.repository.user.custom.param;

import lombok.Data;

@Data
public class UserFilterParams {

    private String name;
    private String cpf;
    private Integer age;

}
