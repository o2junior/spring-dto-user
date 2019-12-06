package br.com.o2junior.springdto.service;

import br.com.o2junior.springdto.model.User;
import br.com.o2junior.springdto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public IUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> get(long id){
        try{
            return userRepository.findById(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<User> listUser(){
        try{
            return (List<User>) userRepository.findAll();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean existUser(long id) {
        return userRepository.existsById(id);
    }

    @Override
    public boolean existUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
