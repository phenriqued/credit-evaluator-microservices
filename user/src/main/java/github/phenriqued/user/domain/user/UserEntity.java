package github.phenriqued.user.domain.user;


import github.phenriqued.user.controller.dtos.user.UserDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_user")

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 11, unique = true, nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer age;

    public UserEntity(UserDTO dto) {
        this.cpf = dto.cpf();
        this.name = dto.name();
        this.age = dto.age();
    }

}
