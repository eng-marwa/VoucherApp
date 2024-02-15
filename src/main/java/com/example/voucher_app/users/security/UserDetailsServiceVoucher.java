package com.example.voucher_app.users.security;

import com.example.voucher_app.users.model.Users;
import com.example.voucher_app.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceVoucher implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userService.findUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        System.out.println(user.getEmail()+","+ user.getPassword()+","+ user.getUserRoles());
        return new User(user.getEmail(), user.getPassword(), user.getUserRoles());
    }
}
