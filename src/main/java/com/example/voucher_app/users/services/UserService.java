package com.example.voucher_app.users.services;


import com.example.voucher_app.users.model.Users;
import com.example.voucher_app.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Users createUser(Users users){
        return userRepository.save(users);
    }

    public Users findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
