package github.phenriqued.user.controller;

import github.phenriqued.user.controller.dtos.user.UserDTO;
import github.phenriqued.user.infra.repository.user.custom.param.UserFilterParams;
import github.phenriqued.user.service.user.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("user")

@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO createDTO){
        var userCreated = userService.createUser(createDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{cpf}").buildAndExpand(userCreated.cpf()).toUri();
        return ResponseEntity.created(uri).body(userCreated);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUser(UserFilterParams params){
        return ResponseEntity.ok(userService.getAllUserByParam(params));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

}
