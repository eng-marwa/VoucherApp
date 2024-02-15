package com.example.voucher_app.voucher.controller;

import com.example.voucher_app.voucher.model.Voucher;
import com.example.voucher_app.voucher.services.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/voucher")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    @PostMapping("/create")
    public Voucher create(@RequestBody Voucher voucher) {
        return voucherService.createNewVoucher(voucher);
    }

    @GetMapping("/find/{code}")
    public Voucher getVoucher(@PathVariable("code") String code) {
        return voucherService.getVoucherByCode(code);
    }
}
