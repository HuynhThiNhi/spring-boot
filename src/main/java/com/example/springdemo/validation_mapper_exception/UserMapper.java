package com.example.springdemo.validation_mapper_exception;

import org.mapstruct.Mapper;


@Mapper
public interface UserMapper {
    UserDTO userToUserDTO(User user);
}
