package com.example.wallet.controller;

import com.example.wallet.model.WalletOperationBody;
import com.example.wallet.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor

//TODO add throw exceptions
public class WalletController {

    private final WalletService service;

    @GetMapping("wallets/{id}")
    Integer getWalletAmount(@PathVariable Integer id) {

        return service.getWalletAmount(id);
    }

    @PostMapping("wallet")
    void updateWallet(@RequestBody WalletOperationBody body) {

        if (body.getAmount() > 0) {
            service.updateWallet(body);
        }
    }

}


