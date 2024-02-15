package com.example.voucher_app.users.repository;

import com.example.voucher_app.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
}
