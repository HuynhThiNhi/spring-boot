package com.example.springdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //    HttpSecurity listen all of request and filter
//    method configure dinh nghia domian can dang nhap va khong

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //  super.configure(http); // bỏ
//        http.authorizeRequests() //always have
//                .antMatchers("/").permitAll()
//                .anyRequest().authenticated() // all request later must be authenticated or permitted -> be loaded
//                .and() // always need to continue
//                .formLogin() // allow user authenticate by login form
//                .loginPage("/home").permitAll() // don't want to use default login page of web security
//                .and()
//                .logout().permitAll();

//        http
//                .authorizeRequests()
//                .antMatchers("/home").permitAll() // Cho phép tất cả mọi người truy cập vào 2 địa chỉ này
//                .anyRequest().authenticated() // Tất cả các request khác đều cần phải xác thực mới được truy cập
//                .and()
//                .formLogin() // Cho phép người dùng xác thực bằng form login
//                .defaultSuccessUrl("/")
//                //.failureUrl("/failed")
//                .permitAll() // Tất cả đều được truy cập vào địa chỉ này
//                .and()
//                .logout().logoutUrl("/logout") // Cho phép logout
//                .permitAll();

        http
                // ...
                .csrf().disable(); //giai quyet van de status 403??
        http.authorizeRequests()
                .antMatchers("/home").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .defaultSuccessUrl("/success")
             //   .permitAll()
                .failureUrl("/fail")
                .permitAll()
                .loginProcessingUrl("/j_spring_security_check")

        ;


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // use for spring security version >= 5
//        auth.inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder().encode("123"))
//                .authorities("ROLE_USER");
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}123")  // use in spring security version < 5
                .authorities("ROLE_USER");
    }
}
