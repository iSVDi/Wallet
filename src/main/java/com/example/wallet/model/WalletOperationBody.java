package com.example.wallet.model;


import lombok.Getter;

@Getter
public class WalletOperationBody {
    private Integer walletID;
    private Boolean operationType;
    private Integer amount;
}
