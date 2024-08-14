package com.example.wallet.exception;

import lombok.Getter;

@Getter
public class WalletException extends Exception {
    private final String message;

    public WalletException(WalletAmountErrors errorType) {
        this.message = errorType.getMessage();
    }

}
