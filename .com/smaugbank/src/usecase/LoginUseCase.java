package usecase;

import java.util.Scanner;

import javax.swing.JOptionPane;

import domain.entities.CustomerAccount;

public class LoginUseCase {

    public static void loginAccount(CustomerAccount account) {
        try (var loginInput = new Scanner(System.in)) {
            boolean authorized = false;

            while (!authorized) {
                String userCli = JOptionPane.showInputDialog("Qual é o seu usuário:");

                if (userCli.equals(account.getUserClient())) {
                    String password = JOptionPane.showInputDialog("Qual é a sua senha: ");

                    if (password.equals(account.getPasswordClient())) {
                        authorized = true;
                        JOptionPane.showMessageDialog(null, "Logado com sucesso!\n", "LOGIN",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Senha incorreta, tente novamente!\n", "LOGIN",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário incorreto, tente novamente!\n", "LOGIN",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}
