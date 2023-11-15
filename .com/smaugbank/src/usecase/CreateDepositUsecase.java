package usecase;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

import domain.repository.DepositRepository;
import domain.entities.CustomerAccount;
import domain.entities.Deposit;

public class CreateDepositUsecase {

    public static Deposit createDeposit(CustomerAccount customerAccount) {

        String amount = JOptionPane.showInputDialog(null,
                "Qual o valor do DEPOSITO?\n deve ser inserido o valor nesse formato(123.45)", "DEPOSITO",
                JOptionPane.QUESTION_MESSAGE);

        BigDecimal valorBigDecimal = new BigDecimal(amount);

        var depositRepository = new DepositRepository();
        depositRepository.addDeposit(valorBigDecimal, customerAccount);
        Deposit Deposit = depositRepository.getDeposit();

        if (validateMovimentBalance(customerAccount, valorBigDecimal)) {
            String checking = checking(Deposit);
            JOptionPane.showMessageDialog(null, checking +
                    "\nValor depositado: R$ " + customerAccount.getCurrentBalance(),
                    "DEPOSITO REALIZADO", JOptionPane.INFORMATION_MESSAGE);

            return Deposit;
        }

        return Deposit;

    }

    private static String checking(Deposit Deposit) {
        return Deposit.toString();
    }

    private static boolean validateMovimentBalance(CustomerAccount account, BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) >= 0) {
            account.setCurrentBalance(account.getCurrentBalance().add(amount));
            return true;
        }

        JOptionPane.showMessageDialog(null, "O valor não deve ser negativo. Refaça a operação!",
                "DEPOSITO",
                JOptionPane.INFORMATION_MESSAGE);

        return false;
    }
}
