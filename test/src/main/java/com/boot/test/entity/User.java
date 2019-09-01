package com.boot.test.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private int id;

    @Column
    @Email(message = "Please provide valid email")
    @NotEmpty(message = "Please provide an email")
    private String email;

    @Column
    @Length(min = 5, message = "Your password should be at least 5 characters length")
    @NotEmpty(message = "Please provide a password")
    private String password;

    @Column
    @NotEmpty(message = "Please provide name")
    private String name;

    @Column
    @NotEmpty(message = "Please provide last name")
    private String lastName;

    @Column
    private int active;

    @ManyToMany
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role.id"))
    private Set<Role> roles;
}
