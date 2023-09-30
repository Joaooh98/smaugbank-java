package infra.controller.bankscontroller;

import java.util.List;
import java.util.Scanner;

import domain.Customer;
import domain.Repository.RepositoryEnumAmerica;
import domain.Repository.RepositoryEnumBrazil;
import domain.Repository.RepositoryEnumCoinType;
import domain.Repository.RepositoryEnumEuropa;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;
import infra.factory.BankFactory;

@SuppressWarnings("all")
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String name = input.nextLine();
        System.out.println("Informe um usuario: ");
        String user = input.nextLine();
        System.out.println("escolha uma senha: ");
        String password = input.nextLine();

        var customer = new Customer(1, name, user, password);

        System.out.println("em qual moeda deseja abrir a conta");

        EnumCoinType coinType = showOptionsCoins(input);

        System.out.println("escolha um banco");

        String bankInput = input.nextLine();

        EnumBank bank = EnumBank.parseByKey(bankInput);

        BankFactory.findBank(coinType, customer, bank);

    }

    public static EnumCoinType showOptionsCoins(Scanner input) {
        RepositoryEnumEuropa repositoryEnum = new RepositoryEnumEuropa();
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
                throw new IllegalArgumentException("Opção inválida");
        }
    }

    public static EnumBank showOptionsBanks(Scanner input, EnumCoinType coinType) {
        RepositoryEnumEuropa repositoryEnum = new RepositoryEnumEuropa();
        var coinList = RepositoryEnumCoinType.getCoinList();

        for (int i = 0; i < coinList.size(); i++) {
            var currency = coinList.get(i).getKey();
            System.out.println(i + " " + currency);
        }

        int inputOptionCoin = input.nextInt();

        int opcao = inputOptionCoin;
        EnumBank coinTyp;

        switch (coinType) {
            case EUR:
                var listReinoUnido = new RepositoryEnumEuropa();
                findBanks(listReinoUnido);
                return coinTyp = EnumBank.AMERICA;
            case US:
                List<EnumBank> getbanksListAmericBanks = RepositoryEnumAmerica.getbanksList();
                return coinTyp = EnumBank.BANCODOBRASIL;
            case REAL:
                List<EnumBank> getbanksListBrazilBanks = RepositoryEnumBrazil.getbanksList();
                return coinTyp = EnumBank.BANCORP;
            default:
                throw new IllegalArgumentException("Opção inválida");
        }
    }

    private static void findBanks(Object banksRepo) {
    }
}

// Criação, configuração e implementação de projeto javaapplicationconfigurado.
// Aplicação de gerencia de banco com procedimentos básicos como
// informaçãodeusuário(nome, sobrenome e CPF), e procedimentos bancários como
// consulta de saldo, depósito e retirada e interrupção da execução do código,
// contendo uma mensagem de despedida.