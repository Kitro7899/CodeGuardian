package com.example.CodeGuardian.Controller;

import ch.qos.logback.core.model.Model;
import com.example.CodeGuardian.Config.MyUserDetailsService;
import com.example.CodeGuardian.Entity.User;
import com.example.CodeGuardian.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("test/")
@AllArgsConstructor
public class TestController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MyUserDetailsService userService;

    @GetMapping("/welcome")
    public String welcome(){
        return "page1";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String pageForUser(){
        return "page2";
    }


    @GetMapping("/admins")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String pageForAdmins(){
        return "page3";
    }


    @GetMapping("/all")
    public String pageForAll(){
        return "page3";
    }

    @GetMapping("/registration")
    public String regPage(){
        return "registration";
    }
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        userService.registerNewUser(username, password);
        return "redirect:/test/users"; // Перенаправление на приветственную страницу после успешной регистрации
    }
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/test/logout";
    }




}