package usecase;

import java.util.Scanner;

import javax.swing.JOptionPane;

import domain.entities.CustomerAccount;
import domain.ienum.EnumCoinType;

public class ShowOperationsUseCase {

    public static int showOperations(CustomerAccount account) {
        // Scanner input = new Scanner(System.in);
        boolean validEntry = false;
        int option = 0;

        while (!validEntry) {

            if (account.getCoitType().equals(EnumCoinType.REAL)) {

                String incoming = JOptionPane.showInputDialog(
                        "Digite a opção desejada:\n1. Deseja realizar um depósito?\n2. Consultar saldo?\n3. Gerar boleto?\n4. Consultar dados do boleto?\n5. Deseja realizar um saque?\n6. Encerrar operações na conta");
                        option = Integer.parseInt(incoming);
            }

            System.out.println("\noptions in English\n");
            System.out.println("Enter the desired option");
            System.out.println("1. Do you want to make the deposit?");
            System.out.println("2. check balance?");
            System.out.println("3. generate bank slip?");
            System.out.println("4. consult bank slip data?");
            System.out.println("5. make a withdrawal?");
            System.out.println("6. close account operations?");
            

            if (option >= 0 && option <= 7) {
                validEntry = true;
            } else {
                System.out.println("entrada invalida escolha um numero de 1 a 6 \n");
                System.out.println("invalid entry choose a number from 1 to 6 \n");
            }
        }
        return option;
    }
}
