package com.example.wallet.controller;

import com.example.wallet.exception.WalletException;
import com.example.wallet.model.WalletOperationBody;
import com.example.wallet.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor

// TODO add handling errors
public class WalletController {

    private final WalletService service;

    @GetMapping("wallets/{id}")
    Integer getWalletAmount(@PathVariable String id) throws WalletException {
        return service.getWalletAmount(id);
    }

    @PostMapping("wallet")
    void updateWallet(@RequestBody WalletOperationBody body) throws WalletException {
        service.updateWallet(body);
    }

}


