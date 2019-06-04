package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            @Valid Users users,
            BindingResult bindingResult,
            Model model
    ) {
        if (users.getPassword() != null && !users.getPassword().equals(users.getPassword2())) {
            model.addAttribute("passwordError", "Пароли совпадают!");
            return "registration";
        }
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "registration";
        }
        if (!userService.addUser(users)) {
            model.addAttribute("usernameError", "User exists!");
            return "registration";
        }
        model.addAttribute("message", "Активационный код выслан вам на email!");
        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(
            Model model,
            @PathVariable String code
    ) {
        boolean isActivated = userService.activateUser(code);
        if (isActivated)
            model.addAttribute("message", "Пользователь активирован!");
        else
            model.addAttribute("message", "Активационный код не найден!");
        return "login";
    }
}
