package com.example.wallet.model;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class WalletOperationBody {
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[0-9a-z]{8}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{12}+$")
    private String walletID;

    @NotNull
    @Pattern(regexp = "^(DEPOSIT|WITHDRAW)$", message = "must match \"DEPOSIT\" or \"WITHDRAW\"")
    private String operationType;

    @Min(1)
    @NotNull
    private Integer amount;
}
