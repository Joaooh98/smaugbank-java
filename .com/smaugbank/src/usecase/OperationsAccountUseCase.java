package usecase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import domain.CreatedVO;
import domain.Repository.RepositoryEnumAmerica;
import domain.Repository.RepositoryEnumBrazil;
import domain.Repository.RepositoryEnumCoinType;
import domain.Repository.RepositoryEnumEuropa;
import domain.entities.BankSlip;
import domain.entities.Customer;
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

    public BankSlip createdBankSlip(BigDecimal amount, String Issuer, CreatedVO bankSlipDueDate) {
        String barCode = "";
        String payer = "test";

        BankSlip bankSlip = new BankSlip.BankSlipBuilder().build();
        return bankSlip;
    }

    public Withdraw makeWithdrawal(Withdraw withdraw) {
        return withdraw;
    }

    public static int showOperations(Scanner input, CustomerAccount account) {

        boolean validEntry = false;
        int option = 0;


        while (!validEntry) {

            if (account.getCoitType().equals(EnumCoinType.REAL)) {
                
                System.out.println("Digite a opcao desejada");
                System.out.println("1. deseja realizar o deposito?");
                System.out.println("2. consultar saldo?");
                System.out.println("3. gerar boleto?");
                System.out.println("4. consultar dados do boleto?");
                System.out.println("5. deseja realizar um saque?");
                System.out.println("6. encerrar operacoes na conta");
            }

            System.out.println("\noptions in English\n");

            System.out.println("Enter the desired option");
            System.out.println("1. Do you want to make the deposit?");
            System.out.println("2. check balance?");
            System.out.println("3. generate bank slip?");
            System.out.println("4. consult bank slip data?");
            System.out.println("5. make a withdrawal?");
            System.out.println("6. close account operations?");

            String incoming = input.nextLine();
            option = Integer.parseInt(incoming);

            if (option >= 0 && option <= 7) {
                validEntry = true;
            } else {
                System.out.println("entrada invalida escolha um numero de 1 a 6 \n");
                System.out.println("invalid entry choose a number from 1 to 6 \n");
            }
        }
        return option;
    }

    public void showAccountData(CustomerAccount account) {
        account.toString();
    }

    public static void loginAccount(Scanner input, Customer customer) {
        boolean authorized = false;
        
        while (!authorized) {

            System.out.print("Qual é o seu usuário: ");
            String userC = input.nextLine();
    
            if (userC.equals(customer.getUser())) {
                System.out.print("Qual é a sua senha: ");
                String password = input.nextLine();
    
                if (password.equals(customer.getPassword())) {
                    authorized = true;
                    System.out.println("Logado com sucesso!\n");
                } else {
                    System.out.println("Senha incorreta, tente novamente!");
                }
            } else {
                System.out.println("Usuário incorreto, tente novamente!");
            }
        }
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
