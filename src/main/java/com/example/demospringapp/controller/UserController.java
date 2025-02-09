package com.example.demospringapp.controller;

import com.example.demospringapp.model.MyUser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private List<MyUser> myUsers = new ArrayList<>(List.of
            (new MyUser(1, "user1", "admin1"),
            new MyUser(2, "user2", "admin2"))
    );

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/users")
    public List<MyUser> getUsers() {
        return myUsers;
    }

    @PostMapping("/users")
    public boolean addUser(@RequestBody MyUser myUser) {
        return myUsers.add(myUser);
    }
}
