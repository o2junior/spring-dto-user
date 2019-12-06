package br.com.o2junior.springdto.dto;

import br.com.o2junior.springdto.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserResponseDTO {
    private Long id;
    private String fullname;
    private String email;
    private String document;
    private boolean admin;
    private boolean active;
    private Timestamp createdAt;

    public static UserResponseDTO toUserResponseDTO(User user){
        return new UserResponseDTO(user.getId(), user.getFullname(), user.getEmail(),
        user.getDocument(), user.isAdmin(), user.isAdmin(), user.getCreatedAt());
    }
}