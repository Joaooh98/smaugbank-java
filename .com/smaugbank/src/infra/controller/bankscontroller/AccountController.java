package infra.controller.bankscontroller;

import java.util.List;
import java.util.Scanner;

import domain.Customer;
import domain.CustomerAccount;
import domain.Repository.RepositoryEnumAmerica;
import domain.Repository.RepositoryEnumBrazil;
import domain.Repository.RepositoryEnumCoinType;
import domain.Repository.RepositoryEnumEuropa;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;
import infra.factory.BankFactory;
import usecase.OperationsAccountUseCase;

@SuppressWarnings("all")
public class AccountController {
    public static void main(String[] args) throws Exception {
        var operations = new OperationsAccountUseCase();
        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String name = input.nextLine();
        System.out.println("Informe um usuario: ");
        String user = input.nextLine();
        System.out.println("escolha uma senha: ");
        String password = input.nextLine();

        var customer = new Customer(1, name, user, password);

        System.out.println("em qual moeda deseja abrir a conta\n");

        EnumCoinType coinType = operations.showOptionsCoins(input);

        System.out.println("escolha um banco\n");

        EnumBank bank = operations.showOptionsBanks(coinType, input);
        CustomerAccount account = BankFactory.findBank(coinType, customer, bank);

        operations.showAccountData(account);

        int opcao = 0;
        while (opcao != 6) {
            boolean loginAccount = operations.loginAccount(user, password, customer);
            for (int i = 0; i < 3; i++) {
                if (loginAccount == true) {
                    opcao = operations.showOperations(input);
                    switch (opcao) {
                        case 1:
                            operations.deposit(account, null);
                            break;
                        case 2:
                            operations.consultBalance(account);
                            break;
                        case 3:
                            operations.consultBankSlip(null);
                            break;
                        case 4:
                            operations.consultBalance(account);
                            break;
                        case 5:
                            operations.consultBalance(account);
                            break;
                        case 6:
                            System.out.println("progama encerrado");
                            break;
                        default:
                            break;
                    }
                } else {
                    System.out.println("senha incorreta vc possui mais" + i + "tentativas");
                }
            }
        }
    }
}
// Criação, configuração e implementação de projeto javaapplicationconfigurado.
// Aplicação de gerencia de banco com procedimentos básicos como
// informaçãodeusuário(nome, sobrenome e CPF), e procedimentos bancários como
// consulta de saldo, depósito e retirada e interrupção da execução do código,
// contendo uma mensagem de despedida.