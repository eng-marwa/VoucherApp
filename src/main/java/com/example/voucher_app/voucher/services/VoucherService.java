package com.example.voucher_app.voucher.services;

import com.example.voucher_app.voucher.model.Voucher;
import com.example.voucher_app.voucher.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherService  {
    @Autowired
    private VoucherRepository voucherRepository;

    public Voucher createNewVoucher(Voucher voucher){
        return voucherRepository.save(voucher);
    }

    public Voucher getVoucherByCode(String code){
        return voucherRepository.findByCode(code);
    }
}
