package com.example.wallet.repository;

import com.example.wallet.model.Wallet;
import com.example.wallet.model.WalletOperationBody;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {

}
