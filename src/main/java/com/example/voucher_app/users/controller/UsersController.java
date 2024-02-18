package com.example.voucher_app.users.controller;

import com.example.voucher_app.users.dto.UserDTO;
import com.example.voucher_app.users.model.Roles;
import com.example.voucher_app.users.model.Users;
import com.example.voucher_app.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    Users createUser(@RequestBody UserDTO users){
        return userService.saveUserWithRoles(users);
    }

    @GetMapping("/find/{email}")
    Users findUserByEmail(@PathVariable("email") String email){
        return userService.findUserByEmail(email);
    }
  @GetMapping("/all")
  List<Users> findAll(){
        return userService.findAll();
    }


}
