package infra.controller.bankscontroller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import domain.Customer;
import domain.CustomerAccount;
import domain.Repository.CustomerRepository;
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

        var customerRepository = new CustomerRepository();
        customerRepository.addCustumer(name, user, password);
        var customer = customerRepository.getCustomers();

        System.out.println("em qual moeda deseja abrir a conta\n");

        EnumCoinType coinType = operations.showOptionsCoins(input);

        System.out.println("escolha um banco\n");

        EnumBank bank = operations.showOptionsBanks(coinType, input);
        CustomerAccount account = BankFactory.findBank(coinType, customer, bank);
        operations.loginAccount(input, customer);

        int opcao = operations.showOperations(input);

        while (opcao != 6) {
            switch (opcao) {
                case 1:
                    BigDecimal depositAmount = operations.deposit(account, input);
                    System.out.println("valor depositado :" + depositAmount);
                    break;
                case 2:
                    BigDecimal balance = operations.consultBalance(account);
                    System.out.println("seu saldo atual e:" + balance + " " + account.getCoitType().getValue());
                    break;
                case 3:
                    operations.createdBankSlip(null, null, null);
                    break;
                case 4:
                    operations.consultBankSlip(null);
                    break;
                case 5:
                    operations.makeWithdrawal(null);
                    break;
                default:
                    break;
            }
            opcao = operations.showOperations(input);
        }
        System.out.println("Programa encerrado");
    }
}

// Criação, configuração e implementação de projeto javaapplicationconfigurado.
// Aplicação de gerencia de banco com procedimentos básicos como
// informaçãodeusuário(nome, sobrenome e CPF), e procedimentos bancários como
// consulta de saldo, depósito e retirada e interrupção da execução do código,
// contendo uma mensagem de despedida.