package com.example.demo;

import com.example.demo.entity.Role;
import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.tools.jar.CommandLine;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication extends CommandLine {
    @Autowired
    UsersRepository usersRepository;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
//    @PostConstruct
//    public void init(){
//        Set<Role> roles = new HashSet<>();
//        roles.add(Role.ADMIN);
//        roles.add(Role.USER);
//        usersRepository.save(new Users("admin","123","123",roles,"12@mail.ru",true));
//    }
}
