package com.example.wallet.exception;

public enum WalletAmountErrors {

    ID_LESS_ONE,
    ID_DOESNT_EXIST,
    AMOUNT_LESS_OR_EQUAL_ZERO,
    WITHDRAW_AMOUNT_MORE_THAN_WALLET;


    public String getMessage() {
        return switch (this) {
            case ID_LESS_ONE -> "Id cannot be less 1";
            case ID_DOESNT_EXIST -> "Wallet with such id isn't exist";
            case AMOUNT_LESS_OR_EQUAL_ZERO -> "Amount should be more than 0";
            case WITHDRAW_AMOUNT_MORE_THAN_WALLET -> "Withdraw amount more than wallet's";
        };
    }


}
