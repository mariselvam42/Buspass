package com.example.management.Service;

import com.example.management.Entity.User;
import com.example.management.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    UserRepository repo;

    public User register(User user) {
        user.setRole("USER");
        return repo.save(user);
    }

    public User login(String email, String password) {
        User user = repo.findByEmail(email);
        if(user != null && user.getPassword().equals(password))
            return user;
        return null;
    }
}