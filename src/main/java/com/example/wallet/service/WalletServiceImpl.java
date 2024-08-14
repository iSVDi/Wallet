package com.example.wallet.service;

import com.example.wallet.model.WalletOperationBody;
import com.example.wallet.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository repository;

    @Override
    public Integer getWalletAmount(Integer id) {
        return repository.getReferenceById(id).getAmount();
    }

    @Override
    public void updateWallet(WalletOperationBody body) {
        var wallet = repository.getReferenceById(body.getWalletID());
        var currentAmount = wallet.getAmount();
        int newAmount = 0;

        if (body.getOperationType())
            newAmount = currentAmount + body.getAmount();
        else if (currentAmount >= body.getAmount())
            newAmount = currentAmount - body.getAmount();

        wallet.setAmount(newAmount);
        repository.save(wallet);
    }


}
