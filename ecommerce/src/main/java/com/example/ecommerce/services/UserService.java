package com.example.ecommerce.services;

import com.example.ecommerce.models.User;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

//    public List<User> getUsers(){
//        return repository.findAll();
//    }
}
