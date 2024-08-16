package com.example.wallet.service;

import com.example.wallet.model.Wallet;
import com.example.wallet.model.WalletOperationBody;

import java.util.List;

public interface WalletService {
    boolean isWalletExistById(String id);

    Integer getWalletAmount(String id);

    void updateWallet(WalletOperationBody body);

    List<Wallet> getAllWallets();
}
