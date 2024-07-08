package com.example.CodeGuardian.Controller;

import com.example.CodeGuardian.Config.MyUserDetailsService;
import com.example.CodeGuardian.Entity.task;

import com.example.CodeGuardian.repository.UserRepo;
import com.example.CodeGuardian.repository.taskRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("test/")
@AllArgsConstructor
public class TestController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private taskRepo TaskRepo;

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
    public String registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        userService.registerNewUser(username, password, email);
        return "redirect:/test/users"; // Перенаправление на приветственную страницу после успешной регистрации
    }
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/test/logout";
    }







    @GetMapping("/tasks")
    public String getTasks(Map<String, Object> model) {
        Iterable<task> tasks = TaskRepo.findAll();
        model.put("tasks", tasks);
        return "page2";
    }

    @PostMapping("/addTask")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String addTask(@RequestParam String text) {
        task taskText = new task(text);
        TaskRepo.save(taskText);
        return "redirect:/test/tasks";
    }

    @PostMapping("/deleteTask")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String deleteTask(@RequestParam Long id) {
        TaskRepo.deleteById(id);
        return "redirect:/test/tasks";
    }
}