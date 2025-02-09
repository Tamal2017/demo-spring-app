package com.example.demospringapp.repo;

import com.example.demospringapp.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser, Integer> {
    MyUser findByUsername(String username);
}
