package com.example.demospringapp.service;

import com.example.demospringapp.model.User;
import com.example.demospringapp.model.UserPrincipal;
import com.example.demospringapp.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public UsersDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        return Optional.ofNullable(user)
                .map(UserPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }
}
