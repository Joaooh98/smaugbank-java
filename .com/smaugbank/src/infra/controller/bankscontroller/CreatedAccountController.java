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
public class CreatedAccountController {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String name = input.nextLine();
        System.out.println("Informe um usuario: ");
        String user = input.nextLine();
        System.out.println("escolha uma senha: ");
        String password = input.nextLine();

        var customer = new Customer(1, name, user, password);

        System.out.println("em qual moeda deseja abrir a conta\n");

        EnumCoinType coinType = showOptionsCoins(input);

        System.out.println("escolha um banco\n");

        EnumBank bank = showOptionsBanks(coinType, input);
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
        }

        return null;
    }
}

// Criação, configuração e implementação de projeto javaapplicationconfigurado.
// Aplicação de gerencia de banco com procedimentos básicos como
// informaçãodeusuário(nome, sobrenome e CPF), e procedimentos bancários como
// consulta de saldo, depósito e retirada e interrupção da execução do código,
// contendo uma mensagem de despedida.