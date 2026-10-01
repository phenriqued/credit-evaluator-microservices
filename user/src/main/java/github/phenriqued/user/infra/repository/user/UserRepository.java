package github.phenriqued.user.infra.repository.user;

import github.phenriqued.user.domain.user.UserEntity;
import github.phenriqued.user.infra.repository.user.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom {
}
