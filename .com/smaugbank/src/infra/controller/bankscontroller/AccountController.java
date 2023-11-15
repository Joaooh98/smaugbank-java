package infra.controller.bankscontroller;

import javax.swing.JOptionPane;

import domain.entities.CustomerAccount;
import domain.entities.Deposit;
import domain.entities.Withdraw;
import domain.enums.EnumBank;
import domain.enums.EnumCoinType;
import domain.repository.CustomerRepository;
import infra.factory.BankFactory;
import service.OperationsAccount;
import usecase.LoginUseCase;
import usecase.OptionsBankUsecase;
import usecase.OptionsCoinsUsecase;
import usecase.ShowOperationsUseCase;

@SuppressWarnings("all")
public class AccountController {
    public static void main(String[] args) throws Exception {
        var operationsAccount = new OperationsAccount();
        var loginUseCase = new LoginUseCase();
        var operationsUseCase = new ShowOperationsUseCase();
        var optionsCoinsUsecase = new OptionsCoinsUsecase();
        var optionsBankUsecase = new OptionsBankUsecase();

        String name = JOptionPane.showInputDialog(null, "Digite seu nome", "customer", JOptionPane.QUESTION_MESSAGE);
        String user = JOptionPane.showInputDialog(null, "Insira seu apelido", "customer", JOptionPane.QUESTION_MESSAGE);
        String password = JOptionPane.showInputDialog(null, "Escolha uma senha", "customer", JOptionPane.QUESTION_MESSAGE);
        String document = JOptionPane.showInputDialog(null, "Informe o seu CPF", "customer", JOptionPane.QUESTION_MESSAGE);

        var customerRepository = new CustomerRepository();
        customerRepository.addCustumer(name, user, password, document);
        var customer = customerRepository.getCustomers();

        EnumCoinType coinType = optionsCoinsUsecase.showOptionsCoins();

        EnumBank bank = optionsBankUsecase.showOptionsBanks(coinType);

        CustomerAccount account = BankFactory.createAccountCustumer(coinType, customer, bank);

        loginUseCase.loginAccount(account);

        boolean validEntry = true;

        while (validEntry) {
            int option = 0;
            int opcao = operationsUseCase.showOperations(account);
            switch (opcao) {
                case 1:
                    validEntry = true;
                    Deposit depositAmount = operationsAccount.createdDeposit(account);
                    break;
                case 2:
                    validEntry = true;
                    operationsAccount.consultBalance(account);
                    break;
                case 3:
                    validEntry = true;
                    Withdraw makeWithdrawal = operationsAccount.makeWithdrawal(account);
                    break;
                default:
                    validEntry = false;
                    break;
            }
        }
        JOptionPane.showMessageDialog(null, "Programa Finalizado, obrigado por utilizar os servico da smaugBank🐉",
                "Adeus!", JOptionPane.INFORMATION_MESSAGE);
    }
}

// Criação, configuração e implementação de projeto javaapplicationconfigurado.
// Aplicação de gerencia de banco com procedimentos básicos como
// informaçãodeusuário(nome, sobrenome e CPF), e procedimentos bancários como
// consulta de saldo, depósito e retirada e interrupção da execução do código,
// contendo uma mensagem de despedida.