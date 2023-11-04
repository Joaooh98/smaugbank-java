package service;

import java.math.BigDecimal;
import java.util.Scanner;

import javax.swing.JOptionPane;

import domain.entities.CustomerAccount;
import domain.entities.Deposit;
import domain.entities.Withdraw;
import usecase.CreateDepositUsecase;
import usecase.CreatedWithdrawUseCase;

@SuppressWarnings("all")
public class OperationsAccount {

    public Deposit createdDeposit(CustomerAccount account) {
        var createDepositUsecase = new CreateDepositUsecase();
        var deposit = createDepositUsecase.createDeposit(account);
        return deposit;
    }

    public void consultBalance(CustomerAccount account) {

        JOptionPane.showMessageDialog(null,
        "\nSaldo em conta:  " +account.getCoitType().getValue()+" "+ account.getCurrentBalance(),
        "SALDO", JOptionPane.INFORMATION_MESSAGE);
    }

    public Withdraw makeWithdrawal(CustomerAccount account) {
        var withdrawUseCase = new CreatedWithdrawUseCase();
        var withdraw = withdrawUseCase.createWithdraw(account);
        return withdraw;
    }

}
