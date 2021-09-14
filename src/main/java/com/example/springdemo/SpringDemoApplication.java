package com.example.springdemo;

import com.example.springdemo.validation_mapper_exception.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService)
    {

        return args -> {
         //  userService.saveRole(new Role("USER_ROLE"));
//            userService.saveRole(new Role(null, "USER_ROLE"));
//            userService.saveRole(new Role(null, "USER_MANAGER"));
//            userService.saveRole(new Role(null, "USER_ADMIN"));
//            userService.saveRole(new Role(null, "USER_SUPER_ADMIN"));
//
          //  userService.saveUser(new User(null, "Will Smith", "will", "1234", new ArrayList<>()));
          //  userService.saveUser(new User( "Arnold", "arnold", "1234"));


//            userService.addRoleToUser("will", "USER_MANAGER");
//            userService.addRoleToUser("will", "USER_ADMIN");
//            userService.addRoleToUser("john", "USER_MANAGER");
//            userService.addRoleToUser("john", "USER_ROLE");






        };
    }

}
