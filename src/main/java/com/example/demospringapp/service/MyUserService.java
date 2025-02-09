package com.example.demospringapp.service;


import com.example.demospringapp.model.MyUser;
import com.example.demospringapp.repo.MyUserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserService {

    private final MyUserRepo myUserRepo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2A, 10);

    public MyUserService(MyUserRepo myUserRepo) {
        this.myUserRepo = myUserRepo;
    }

    public MyUser addUser(MyUser myUser) {
        myUser.setPassword(encoder.encode(myUser.getPassword()));
        return myUserRepo.save(myUser);
    }

    public List<MyUser> getUsers() {
        return myUserRepo.findAll();
    }
}
