package com.example.wallet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Entity
public class Wallet {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "serial")
    private Integer id;

    @Getter
    @Setter
    @Column(nullable = false)
    private Integer amount;
}
