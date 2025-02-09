package com.example.demospringapp.service;

import com.example.demospringapp.model.MyUser;
import com.example.demospringapp.model.UserPrincipal;
import com.example.demospringapp.repo.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private final MyUserRepo myUserRepo;

    public MyUserDetailsService(MyUserRepo myUserRepo) {
        this.myUserRepo = myUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserRepo.findByUsername(username);
        if (myUser == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return new UserPrincipal(myUser);
    }
}
