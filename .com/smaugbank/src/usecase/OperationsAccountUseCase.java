package usecase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import domain.Customer;
import domain.CustomerAccount;
import domain.Withdraw;
import domain.BankSlip;
import domain.CreatedVO;
import domain.Repository.RepositoryEnumAmerica;
import domain.Repository.RepositoryEnumBrazil;
import domain.Repository.RepositoryEnumCoinType;
import domain.Repository.RepositoryEnumEuropa;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;

@SuppressWarnings("all")
public class OperationsAccountUseCase {

    public void deposit(CustomerAccount account, BigDecimal amountInput) {
        account.setCurrentBalance(amountInput);
    }

    public BigDecimal consultBalance(CustomerAccount account) {
        return account.getCurrentBalance();

    }

    public BankSlip consultBankSlip(BankSlip bankSlip) {
        return bankSlip;
    }
    
    public BankSlip createdBankSlip(BigDecimal amount, String Issuer, String payer, CreatedVO bankSlipDueDate) {
        String barCode = "";
        
        BankSlip bankSlip = new BankSlip(amount, barCode, bankSlipDueDate, Issuer, payer);
        return bankSlip;
    }

    public Withdraw makeWithdrawal(Withdraw withdraw) {
        return withdraw;
    }

    public static int showOperations(Scanner input) {

        boolean validEntry = false;
        int option = 0;
        String incoming;

        while (!validEntry) {

            System.out.println("Digite a opcao desejada");
            System.out.println("1. deseja realizar o deposito?");
            System.out.println("2. consultar saldo?");
            System.out.println("3. gerar boleto?");
            System.out.println("4. consultar dados do boleto?");
            System.out.println("5. deseja realizar um saque?");
            System.out.println("6. encerrar operacoes na conta");
            System.out.println("\noptions in English\n");
            System.out.println("Enter the desired option");
            System.out.println("1. Do you want to make the deposit?");
            System.out.println("2. check balance?");
            System.out.println("3. generate bank slip?");
            System.out.println("4. consult bank slip data?");
            System.out.println("5. make a withdrawal?");
            System.out.println("6. close account operations?");
            

            try {

                incoming = input.nextLine();
                option = Integer.parseInt(incoming);

                if (option >= 0 && option <= 5) {
                    validEntry = true;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("entrada invalida escolha um numero de 1 a 5 \n");
                System.out.println("invalid entry choose a number from 1 to 5 \n");
            }
        }
        return option;
    }

    public String showAccountData(CustomerAccount account) {
        return account.toString();
    }

    public boolean loginAccount(String user, String password, Customer customer) {

        if (user.equals(customer.getUser())) {
            if (password.equals(customer.getPassword())) {
                return true;
            }
        }
        return false;
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
