package com.example.wallet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Wallet {
    @Id
    private String id;

    @Getter
    @Setter
    private Integer amount;
}
