package github.phenriqued.user.infra.repository.user.param;

import lombok.Data;

@Data
public class UserFilterParams {

    private String name;
    private String cpf;
    private Integer age;

}
