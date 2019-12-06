package br.com.o2junior.springdto.service;

import br.com.o2junior.springdto.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> get(long id);
    List<User> listUser();
    boolean existUser(long id);
    boolean existUserByEmail(String email);
    User save(User user);
}
