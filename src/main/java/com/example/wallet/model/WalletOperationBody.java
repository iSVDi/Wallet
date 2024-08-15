package com.example.wallet.model;
import lombok.Getter;

@Getter
public class WalletOperationBody {
    private String walletID;
    private Boolean operationType;
    private Integer amount;
}
