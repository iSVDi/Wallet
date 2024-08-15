package com.example.wallet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Wallet {
    @Id
    @GeneratedValue
    private String id;

    @Getter
    @Setter
    @Column(nullable = false)
    private Integer amount;
}
