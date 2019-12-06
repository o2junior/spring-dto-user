package br.com.o2junior.springdto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "user", schema="springdto")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "username", unique = true, length=200)
    private String username;

    @NotNull
    @Column(name = "full_name", length=200)
    private String fullname;

    @NotNull
    @Column(name = "email", unique = true, length=200)
    private String email;

    @NotNull
    @Column(name = "document", unique = true, length=11)
    private String document;

    @NotNull
    @Column(name = "pwd", length=12)
    private String password;

    @Column(name = "is_admin")
    private boolean admin = false;

    @NotNull
    @Column(name = "is_active")
    private boolean active = true;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    private Timestamp deletedAt;

    public User(@NotNull String username, @NotNull String fullname,
                @NotNull String email, @NotNull String document,
                @NotNull String password) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.document = document;
        this.password = password;
    }
}
