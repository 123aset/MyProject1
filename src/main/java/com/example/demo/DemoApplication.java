package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class DemoApplication {
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
