package com.example.springdemo.validation_mapper_exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
//    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Role(String name)
    {
        this.name = name;
    }


}
