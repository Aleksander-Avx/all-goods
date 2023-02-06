package com.avx.allgoods.controller;


import com.avx.allgoods.entity.UserEntity;
import com.avx.allgoods.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(UserEntity userEntity, Model model) {
        if (!userService.createUser(userEntity)) {
          model.addAttribute("errorMessage", "Пользователь с таким email: " + userEntity.getEmail() + " уже существует");
        return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/hello")
    public String securityUrl(){
        return "hello";
    }
}
