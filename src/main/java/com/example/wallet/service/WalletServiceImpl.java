package com.example.wallet.service;

import com.example.wallet.model.OperationType;
import com.example.wallet.model.WalletOperationBody;
import com.example.wallet.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository repository;

    @Override
    public boolean isWalletExistById(String id) {
        return repository.existsById(id);
    }

    @Override
    public Integer getWalletAmount(String id) {
        return repository.getReferenceById(id).getAmount();
    }

    @Override
    public void updateWallet(WalletOperationBody body) {

        var wallet = repository.getReferenceById(body.getWalletID());
        var currentAmount = wallet.getAmount();
        int newAmount = 0;

        if (body.getOperationType().equals(OperationType.DEPOSIT.toString()))
            newAmount = currentAmount + body.getAmount();
        else
            newAmount = currentAmount - body.getAmount();

        wallet.setAmount(newAmount);
        repository.save(wallet);
    }

}
