package br.com.o2junior.springdto.dto;

import br.com.o2junior.springdto.model.User;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class UserCreateDTO {

    @NotBlank(message = "{username.not.blank}")
    @Length(max = 200)
    private String username;

    @NotBlank(message = "{fullname.not.blank}")
    @Length(max = 200)
    private String fullname;

    @NotBlank(message = "{document.not.blank}")
    @Length(max = 11)
    private String document;

    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    @Length(max = 200)
    private String email;

    @NotBlank(message = "{password.not.blank}")
    @Length(max = 12)
    private String password;

    public User toUser(){
        return new User(username, fullname, email, document, password);
    }
}
