package github.phenriqued.user.infra.repository.user.custom;

import github.phenriqued.user.domain.user.UserEntity;
import github.phenriqued.user.infra.repository.user.custom.param.UserFilterParams;

import java.util.List;

public interface UserRepositoryCustom {

    List<UserEntity> getWithFilter(UserFilterParams params);

}
