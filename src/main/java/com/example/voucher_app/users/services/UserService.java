package com.example.voucher_app.users.services;


import com.example.voucher_app.users.dto.RoleDTO;
import com.example.voucher_app.users.dto.UserDTO;
import com.example.voucher_app.users.model.Roles;
import com.example.voucher_app.users.model.Users;
import com.example.voucher_app.users.repository.RoleRepository;
import com.example.voucher_app.users.repository.UserRepository;
import com.example.voucher_app.utils.UserRoles;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ModelMapper modelMapper;

     Users createUser(Users users){
        return userRepository.save(users);
    }
    @Transactional
    public Users findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public Users findByEmailWithRoles(String email){
        Users users = userRepository.findByEmail(email);
        System.out.println(users.getUserRoles().size());
        return users;
    }

    @Transactional
    public Users saveUserWithRoles(UserDTO userDTO) {
        // Fetch and attach Roles entities

        Set<Roles> roles = new HashSet<>();
        for (RoleDTO roleDTO : userDTO.getUserRoles()) {
            Optional<Roles> roleOptional = roleRepository.findById(roleDTO.getRoleId());
            roleOptional.ifPresent(roles::add);
        }
        Users users = modelMapper.map(userDTO, Users.class);
        users.setUserRoles(roles);

        // Persist the Users entity
     return userRepository.save(users);
    }

    public List<Users> findAll() {
        return userRepository.findAll();
    }
}
