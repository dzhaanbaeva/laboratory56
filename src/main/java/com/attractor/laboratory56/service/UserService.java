package com.attractor.laboratory56.service;

import com.attractor.laboratory56.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private  final UserRepository userRepo;


    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
}
