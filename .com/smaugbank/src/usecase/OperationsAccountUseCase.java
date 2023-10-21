package usecase;

import java.math.BigDecimal;
import java.util.Scanner;

import domain.Repository.RepositoryEnumAmerica;
import domain.Repository.RepositoryEnumBrazil;
import domain.Repository.RepositoryEnumCoinType;
import domain.Repository.RepositoryEnumEuropa;
import domain.entities.BankSlip;
import domain.entities.CustomerAccount;
import domain.entities.Withdraw;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;

@SuppressWarnings("all")
public class OperationsAccountUseCase {

    public BigDecimal createdDeposit(CustomerAccount account, Scanner input) {
        System.out.println("qual o valor que deseja depositar:");
        var amountInput = input.nextBigDecimal();
        account.setCurrentBalance(amountInput);
        return amountInput;
    }

    public BigDecimal consultBalance(CustomerAccount account) {
        return account.getCurrentBalance();

    }

    public BankSlip consultBankSlip(BankSlip bankSlip) {
        return bankSlip;
    }

    public BankSlip createdBankSlip(CustomerAccount account, Scanner input) {
        System.out.println("qual o valor do deposito?");
        Integer amount = input.nextInt();
        
        System.out.println("qual o nome do cliente?");
        String payer = input.nextLine();

        BankSlip bankSlip = new BankSlip
        .BankSlipBuilder()
        .amount(amount)
        .payer(payer)
        .build();
        return bankSlip;
    }

    public Withdraw makeWithdrawal(Withdraw withdraw) {
        return withdraw;
    }

    public void showAccountData(CustomerAccount account) {
        account.toString();
    }

}
