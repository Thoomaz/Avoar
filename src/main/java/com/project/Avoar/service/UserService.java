package com.project.Avoar.service;

import com.project.Avoar.entity.User;
import com.project.Avoar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User create(User user){
        return repository.save(user);
    }
}
