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

    public static EnumCoinType showOptionsCoins(Scanner input) {
        var coinList = RepositoryEnumCoinType.getCoinList();

        for (int i = 0; i < coinList.size(); i++) {
            var currency = coinList.get(i).getKey();
            System.out.println(i + " " + currency);
        }

        int inputOptionCoin = input.nextInt();

        int opcao = inputOptionCoin;
        EnumCoinType coinType;

        switch (opcao) {
            case 0:
                return coinType = EnumCoinType.EUR;
            case 1:
                return coinType = EnumCoinType.US;
            case 2:
                return coinType = EnumCoinType.REAL;
            default:
                throw new IllegalArgumentException("Opção inválida\n Invalid option");
        }
    }

    public static EnumBank showOptionsBanks(EnumCoinType coinType, Scanner input) {

        if (coinType.equals(EnumCoinType.EUR)) {
            var listReinoUnido = new RepositoryEnumEuropa();
            return listReinoUnido.findBanks(listReinoUnido.getbanksList(), input);
        }

        if (coinType.equals(EnumCoinType.US)) {
            var listAmericBanks = new RepositoryEnumAmerica();
            return listAmericBanks.findBanks(listAmericBanks.getbanksList(), input);
        }
        if (coinType.equals(EnumCoinType.REAL)) {
            var listBrazilBanks = new RepositoryEnumBrazil();
            return listBrazilBanks.findBanks(listBrazilBanks.getbanksList(), input);
        } else {
            System.out.println("Opção inválida");
            System.out.println("Invalid option");
        }

        return null;
    }
}
