package com.example.wallet.exception;

public enum WalletAmountErrors {
    ID_DOESNT_EXIST,
    WITHDRAW_AMOUNT_MORE_THAN_WALLET;

    public String getMessage() {
        return switch (this) {
            case ID_DOESNT_EXIST -> "Wallet with such id isn't exist";
            case WITHDRAW_AMOUNT_MORE_THAN_WALLET -> "Withdraw amount more than wallet's";
        };
    }
}
