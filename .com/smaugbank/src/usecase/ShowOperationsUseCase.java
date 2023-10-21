package usecase;

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

                String[] optionsInPortugues = {
                        "Digite a opção desejada",
                        "1. Deseja realizar um depósito?",
                        "2. Consultar saldo?",
                        "3. Gerar boleto?",
                        "4. Consultar dados do boleto?",
                        "5. Deseja realizar um saque?",
                        "6. Encerrar operações na conta?" };

                String incoming = JOptionPane.showInputDialog(optionsInPortugues);
                option = Integer.parseInt(incoming);

            } else {
                

                String[] optionsInEnglish = {
                        "Enter the desired option",
                        "1. Do you want to make the deposit?",
                        "2. Check balance?",
                        "3. Generate bank slip?",
                        "4. Consult bank slip data?",
                        "5. Make a withdrawal?",
                        "6. Close account operations?"
                };

                String incoming = JOptionPane.showInputDialog(optionsInEnglish);
                option = Integer.parseInt(incoming);
            }

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
