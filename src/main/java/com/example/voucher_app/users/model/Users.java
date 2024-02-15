package com.example.voucher_app.users.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;
    @Column
    private String fname;
    @Column
    private String lname;
    @Column
    private String email;
    @Column
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "userRoles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> userRoles;


}
