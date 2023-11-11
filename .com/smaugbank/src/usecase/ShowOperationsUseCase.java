package usecase;

import javax.swing.JOptionPane;

import domain.entities.CustomerAccount;
import domain.enums.EnumCoinType;

public class ShowOperationsUseCase {

    public static int showOperations(CustomerAccount account) {
        boolean validEntry = false;
        int option = 0;

        while (!validEntry) {

            if (account.getCoitType().equals(EnumCoinType.REAL)) {

                String[] optionsInPortugues = {
                        "1. Deseja realizar um depósito?",
                        "2. Consultar saldo?",
                        "3. Deseja realizar um saque?",
                        "4. Encerrar operações na conta?" };

                String incoming = JOptionPane.showInputDialog(null, optionsInPortugues, "Digite a opção desejada",
                        JOptionPane.QUESTION_MESSAGE);
                option = Integer.parseInt(incoming);

            } else {

                String[] optionsInEnglish = {
                        "1. Do you want to make the deposit?",
                        "2. Check balance?",
                        "3. Make a withdrawal?",
                        "4. Close account operations?"
                };

                String incoming = JOptionPane.showInputDialog(null, optionsInEnglish, "Enter the desired option",
                        JOptionPane.QUESTION_MESSAGE);
                option = Integer.parseInt(incoming);
            }

            if (option >= 0 && option <= 4) {
                validEntry = true;
            } else {
                JOptionPane.showMessageDialog(null, "entrada inválida escolha um numero de 1 a 6 \n",
                        "Atenção!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return option;
    }
}
