package com.example.demospringapp.service;


import com.example.demospringapp.model.MyUser;
import com.example.demospringapp.repo.MyUserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserService {

    private AuthenticationManager authenticationManager;
    private final MyUserRepo myUserRepo;
    private final JwtService jwtService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2A, 10);

    public MyUserService(MyUserRepo myUserRepo, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.myUserRepo = myUserRepo;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public MyUser addUser(MyUser myUser) {
        myUser.setPassword(encoder.encode(myUser.getPassword()));
        return myUserRepo.save(myUser);
    }

    public List<MyUser> getUsers() {
        return myUserRepo.findAll();
    }

    public String verify(MyUser myUser) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(myUser.getUsername(), myUser.getPassword()));
        return authentication.isAuthenticated() ? jwtService.generateJwtToken(myUser) : "Fail";
    }
}
