package com.example.voucher_app.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long userId;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private List<RoleDTO> userRoles;

}
