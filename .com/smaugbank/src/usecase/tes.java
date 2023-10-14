package usecase;

import java.util.Scanner;

import domain.Repository.CustomerRepository;
import domain.entities.CustomerAccount;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;

public class tes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CreatedNationAccountUseCase createdNationAccountUseCase = new CreatedNationAccountUseCase();
        var operations = new OperationsAccountUseCase();
        System.out.println("Digite seu nome: ");
        String name = input.nextLine();
        System.out.println("Informe um usuario: ");
        String user = input.nextLine();
        System.out.println("escolha uma senha: ");
        String password = input.nextLine();

        var customerRepository = new CustomerRepository();
        customerRepository.addCustumer(name, user, password);
        var customer = customerRepository.getCustomers();

        CustomerAccount create = createdNationAccountUseCase.create(EnumCoinType.EUR, customer, EnumBank.AMERICA);
        operations.loginAccount(input, create);
        
    }
}
