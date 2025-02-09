package com.example.demospringapp.controller;

import com.example.demospringapp.model.MyUser;
import com.example.demospringapp.repo.MyUserRepo;
import com.example.demospringapp.service.MyUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final MyUserService myUserService;

    public UserController(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/users")
    public List<MyUser> getUsers() {
        return myUserService.getUsers();
    }

    @PostMapping("/users")
    public MyUser addUser(@RequestBody MyUser myUser) {
        return myUserService.addUser(myUser);
    }
}
