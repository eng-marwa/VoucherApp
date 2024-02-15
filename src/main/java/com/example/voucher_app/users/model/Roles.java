package com.example.voucher_app.users.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Roles implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int roleId;
    @Column
    private String name;
    @ManyToMany(mappedBy = "userRoles")
    private Set<Users> users;

    @Override
    public String getAuthority() {
        return name;
    }
}
