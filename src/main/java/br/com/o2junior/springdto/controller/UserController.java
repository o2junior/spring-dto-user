package br.com.o2junior.springdto.controller;

import br.com.o2junior.springdto.dto.UserCreateDTO;
import br.com.o2junior.springdto.dto.UserResponseDTO;
import br.com.o2junior.springdto.service.UserService;
import com.google.gson.Gson;
import br.com.o2junior.springdto.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@RequestMapping("/v1/api/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    private static final Gson gson = new Gson();

    /*TODO
        Backlog, new features:
            1.is_admin
            2.update_user
            3.include cpf
            4.actuator
     */

    @ApiOperation(value="Create user. ")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody @Valid UserCreateDTO dto) {
        User user = userService.save(dto.toUser());
        return (isNull(user))
                ? new ResponseEntity(gson.toJson("Invalid user"), HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(UserResponseDTO.toUserResponseDTO(user), HttpStatus.CREATED);
    }

    @ApiOperation(value="List users. ")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserResponseDTO>> listUser() {
        List<User> list = userService.listUser();
            List<UserResponseDTO> listDto = list.stream()
                    .map(obj -> UserResponseDTO.toUserResponseDTO(obj))
                    .collect(Collectors.toList());
            return ResponseEntity.ok().body(listDto);
    }

    @ApiOperation(value="Get user by id. ")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable("id") long id) {
        Optional<User> user = userService.get(id);
        return (user.isPresent())
                ? new ResponseEntity<>(UserResponseDTO.toUserResponseDTO(user.get()), HttpStatus.OK)
                : ResponseEntity.notFound().build();
    }

    @ApiOperation(value="Verify if user exists, by id or email.")
    @GetMapping(value = "/exists")
    public ResponseEntity existsUser(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "email", required = false) String email){
        if(!isNull(id)){
            return (userService.existUser(id))
                    ? ResponseEntity.ok().build()
                    : ResponseEntity.notFound().build();
        }else if(!isNull(email)){
            return (userService.existUserByEmail(email))
                    ? ResponseEntity.ok().build()
                    : ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
