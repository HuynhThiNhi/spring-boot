package com.example.springdemo.validation_mapper_exception;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
//    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq") // generatot giong voi name trong @SequenceGenerator
    private Long id;
    private String name;
    @NotBlank(message = "username is mandatory")
    private String username;
    @NotBlank(message = "password is mandatory")
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles  = new ArrayList<>();
    public User(String name,String username, String password)
    {
        this.name = name;
        this.username = username;
        this.password = password;
    }
//    public User(long id,String name,String username, String password)
//    {
//        this.id = id;
//        this.name = name;
//        this.username = username;
//        this.password = password;
//    }
}
