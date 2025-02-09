package com.example.demospringapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String greet(HttpServletRequest http) {
        var text = """
                Hello welcome!
                Your session id: %s
                """;
        return String.format(text, http.getSession().getId());
    }
}
