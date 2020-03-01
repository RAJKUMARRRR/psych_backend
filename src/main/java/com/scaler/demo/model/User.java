package com.scaler.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User extends Auditable{
    @NotBlank
    @Email
    @Getter
    @Setter
    @Column(unique = true)
    private String email;

    @NotBlank
    @Getter
    private String saltedHashedPassword;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roleSet = new HashSet<Role>();

    public void setSaltedHashedPassword(String saltedHashedPassword) {
        this.saltedHashedPassword = new BCryptPasswordEncoder(5).encode(saltedHashedPassword);
    }

    public User(){}

    public User(User user){
        email = user.getEmail();
        saltedHashedPassword = user.getSaltedHashedPassword();
        roleSet = user.getRoleSet();
    }
}
