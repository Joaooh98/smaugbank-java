package infra.controller.bankscontroller;

import java.util.Scanner;

import domain.Customer;
import domain.Repository.RepositoryEnum;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;
import domain.ienum.utils.EnumUtil;
import usecase.CreatedNationAccountUseCase;

@SuppressWarnings("all")
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String keybord = input.nextLine();

        String name = input.nextLine();
        String user = input.nextLine();
        String password = input.nextLine();

        var customer = new Customer(1, name, user, password);

        System.out.println("em qual moeda deseja abrir a conta");
        
        String coin = input.nextLine();
        
        System.out.println("escolha um banco");

        String bankInput = input.nextLine();
        
        EnumCoinType coinType = EnumCoinType.parseByKey(coin);
        EnumBank bank = EnumBank.parseByKey(bankInput);

        new CreatedNationAccountUseCase().create(coinType, customer, bank);

    }
}

// Criação, configuração e implementação de projeto javaapplicationconfigurado.
// Aplicação de gerencia de banco com procedimentos básicos como
// informaçãodeusuário(nome, sobrenome e CPF), e procedimentos bancários como
// consulta de saldo, depósito e retirada e interrupção da execução do código,
// contendo uma mensagem de despedida.