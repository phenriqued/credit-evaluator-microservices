package github.phenriqued.user.service.user;

import github.phenriqued.user.controller.dtos.user.UserDTO;
import github.phenriqued.user.domain.user.UserEntity;
import github.phenriqued.user.infra.repository.user.UserRepository;
import github.phenriqued.user.infra.repository.user.custom.param.UserFilterParams;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserDTO createUser(UserDTO userDTO){
        return new UserDTO(repository.save(new UserEntity(userDTO)));
    }

    public List<UserDTO> getAllUserByParam(UserFilterParams params){
        return repository.getWithFilter(params).stream().map(UserDTO::new).toList();
    }
    public UserDTO getById(Long id){
        return new UserDTO(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found")));
    }

}
