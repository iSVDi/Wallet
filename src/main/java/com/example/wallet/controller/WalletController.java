package com.example.wallet.controller;

import com.example.wallet.exception.WalletAmountErrors;
import com.example.wallet.exception.WalletException;
import com.example.wallet.model.OperationType;
import com.example.wallet.model.Wallet;
import com.example.wallet.model.WalletOperationBody;
import com.example.wallet.service.WalletService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Validated

public class WalletController {

    private final WalletService service;

    @GetMapping("wallets")
    List<Wallet> getAllWallets() {
        return service.getAllWallets();
    }

    @GetMapping("wallets/{id}")
    Integer getWalletAmount(@Pattern(regexp = "^[0-9a-z]{8}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{12}$") @PathVariable String id) {
        checkIsWalletExist(id);
        return service.getWalletAmount(id);
    }

    @PostMapping("wallet")
    void updateWallet(@Valid @RequestBody WalletOperationBody body) {
        checkIsWalletExist(body.getWalletID());

        var isWithDraw = body.getOperationType().equals(OperationType.WITHDRAW.toString());
        var currentAmount = service.getWalletAmount(body.getWalletID());

        if (isWithDraw && currentAmount < body.getAmount())
            throw new WalletException(WalletAmountErrors.WITHDRAW_AMOUNT_MORE_THAN_WALLET);

        service.updateWallet(body);
    }

    private void checkIsWalletExist(String id) {
        if (!service.isWalletExistById(id))
            throw new WalletException(WalletAmountErrors.ID_DOESNT_EXIST);
    }

}
