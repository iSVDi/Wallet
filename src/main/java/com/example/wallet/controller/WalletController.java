package com.example.wallet.controller;

import com.example.wallet.exception.WalletException;
import com.example.wallet.exception.WalletAmountErrors;
import com.example.wallet.model.WalletOperationBody;
import com.example.wallet.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor

public class WalletController {

    private final WalletService service;

    @GetMapping("wallets/{id}")
    Integer getWalletAmount(@PathVariable Integer id) throws WalletException {
        if (id < 1) {
            throw new WalletException(WalletAmountErrors.ID_LESS_ONE);
        } else if (!service.isWalletExistById(id)) {
            throw new WalletException(WalletAmountErrors.ID_DOESNT_EXIST);
        }
        return service.getWalletAmount(id);
    }

    @PostMapping("wallet")
    void updateWallet(@RequestBody WalletOperationBody body) throws WalletException {

        // if id < 1
        if (body.getWalletID() < 1) {
            throw new WalletException(WalletAmountErrors.ID_LESS_ONE);
        }
        // if id isn't exist
        if (!service.isWalletExistById(body.getWalletID())) {
            throw new WalletException(WalletAmountErrors.ID_DOESNT_EXIST);

        }
        // operation type wrong?
        // amount <=0
        if (body.getAmount() <= 0) {
            throw new WalletException(WalletAmountErrors.AMOUNT_LESS_OR_EQUAL_ZERO);
        }
        // if withdraw and amount > wallet amount
        var walletAmount = getWalletAmount(body.getWalletID());
        if (!body.getOperationType() && walletAmount < body.getAmount()) {
            throw new WalletException(WalletAmountErrors.WITHDRAW_AMOUNT_MORE_THAN_WALLET);
        }
        service.updateWallet(body);
    }

}


