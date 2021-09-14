package com.example.springdemo.validation_mapper_exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j   //@Transaction giup khi them role den user khong can save lai user
public class UserImpl implements UserService, UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
//    @Autowired
    private final UserMapper userMapper;

    @Override
    public User saveUser(User user) {
        log.info("Saving user {} to db", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving role {} to db", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);

        user.getRoles().add(role);

    }

    @Override
    public User getUser(String username) {
        log.info("Getting user {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<UserDTO> getUsers() {

        log.info("Fetching all users");


       return userRepo.findAll().stream().map(userMapper::userToUserDTO).collect(Collectors.toList());

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            log.error("User not found in db");
            throw new UsernameNotFoundException("User not found in db");

        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
//        userdetail chua thong tin cua nguoi dung, convert user -> userdetail
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
