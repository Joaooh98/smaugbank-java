package usecase;

import java.util.Scanner;

import domain.entities.CustomerAccount;

public class LoginUseCase {

    public static void loginAccount(CustomerAccount account) {
        try (var loginInput = new Scanner(System.in)) {
            boolean authorized = false;

            while (!authorized) {

                System.out.print("Qual é o seu usuário: ");
                String userCli = loginInput.nextLine();
                if (userCli.equals(account.getUserClient())) {
                    System.out.print("Qual é a sua senha: ");
                    String password = loginInput.nextLine();

                    if (password.equals(account.getPasswordClient())) {
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
    }
}
