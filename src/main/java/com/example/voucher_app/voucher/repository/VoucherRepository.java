package com.example.voucher_app.voucher.repository;

import com.example.voucher_app.voucher.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher,Long> {
    Voucher findByCode(String code);
}
