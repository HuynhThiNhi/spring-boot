package com.example.springdemo.swapper;

import lombok.Getter;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@Table
public class Book {
    @Id
    long id;
    String name;
    @NotBlank
    @Size(min = 0, max = 20)
    private String title;

    @NotBlank
    @Size(min = 0, max = 30)
    private String author;

}
