package com.example.wallet.service;

import com.example.wallet.model.WalletOperationBody;

public interface WalletService {
    boolean isWalletExistById(String id);
    Integer getWalletAmount(String id);
    void updateWallet(WalletOperationBody body);


}
