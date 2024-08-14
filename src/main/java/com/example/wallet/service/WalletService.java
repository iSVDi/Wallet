package com.example.wallet.service;

import com.example.wallet.model.WalletOperationBody;

public interface WalletService {
    boolean isWalletExistById(Integer id);
    Integer getWalletAmount(Integer id);
    void updateWallet(WalletOperationBody body);


}
