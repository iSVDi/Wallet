package com.example.wallet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Wallet {

    @Id()
    private String id;

    @Setter
    private Integer amount;


}
