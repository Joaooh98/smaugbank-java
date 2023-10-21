package infra.controller.bankscontroller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import domain.Repository.CustomerRepository;
import domain.Repository.RepositoryEnumAmerica;
import domain.Repository.RepositoryEnumBrazil;
import domain.Repository.RepositoryEnumCoinType;
import domain.Repository.RepositoryEnumEuropa;
import domain.entities.Customer;
import domain.entities.CustomerAccount;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;
import infra.factory.BankFactory;
import usecase.LoginUseCase;
import usecase.OperationsAccountUseCase;
import usecase.OptionsBankUsecase;
import usecase.OptionsCoinsUsecase;
import usecase.ShowOperationsUseCase;

@SuppressWarnings("all")
public class AccountController {
    public static void main(String[] args) throws Exception {
        var operations = new OperationsAccountUseCase();
        var loginUseCase = new LoginUseCase();
        var operationsUseCase = new ShowOperationsUseCase();
        var optionsCoins = new OptionsCoinsUsecase();
        var optionsBank = new OptionsBankUsecase();

        String name = JOptionPane.showInputDialog("Digite seu nome");
        String user = JOptionPane.showInputDialog("Informe um usuario");
        String password = JOptionPane.showInputDialog("Escolha uma senha");

        var customerRepository = new CustomerRepository();
        customerRepository.addCustumer(name, user, password);
        var customer = customerRepository.getCustomers();

        EnumCoinType coinType = optionsCoins.showOptionsCoins();

        System.out.println("escolha um banco\n");

        EnumBank bank = optionsBank.showOptionsBanks(coinType);
        
        CustomerAccount account = BankFactory.createAccountCustumer(coinType, customer, null);

        System.out.println("conta criada com sucesso");

        loginUseCase.loginAccount(account);

        int opcao = operationsUseCase.showOperations(account);

        while (opcao != 6) {
            switch (opcao) {
                case 1:
                    BigDecimal depositAmount = operations.createdDeposit(account, null);
                    System.out.println("valor depositado :" + depositAmount);
                    break;
                case 2:
                    BigDecimal balance = operations.consultBalance(account);
                    System.out.println("seu saldo atual e:" + balance + " " + account.getCoitType().getValue());
                    break;
                case 3:
                    operations.createdBankSlip(account, null);
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
        }
        System.out.println("Programa encerrado");
    }
}

// Criação, configuração e implementação de projeto javaapplicationconfigurado.
// Aplicação de gerencia de banco com procedimentos básicos como
// informaçãodeusuário(nome, sobrenome e CPF), e procedimentos bancários como
// consulta de saldo, depósito e retirada e interrupção da execução do código,
// contendo uma mensagem de despedida.