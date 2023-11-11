package usecase;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

import domain.repository.WithdrawRepository;
import domain.entities.CustomerAccount;
import domain.entities.Withdraw;

public class CreatedWithdrawUseCase {

    public static Withdraw createWithdraw(CustomerAccount customerAccount) {

        String amount = JOptionPane.showInputDialog(null,
                "Qual o valor do saque?\n deve ser inserido o valor nesse formato(123.45)", "SAQUE",
                JOptionPane.QUESTION_MESSAGE);

        BigDecimal valorBigDecimal = new BigDecimal(amount);

        var withdrawRepository = new WithdrawRepository();
        withdrawRepository.addwithdraw(valorBigDecimal, customerAccount);
        Withdraw withdraw = withdrawRepository.getwithdraw();

        if (validateMovimentBalance(customerAccount, valorBigDecimal)) {
            String checking = checking(withdraw);
            JOptionPane.showMessageDialog(null,checking+
                    "\nPor favor retire seu deinheiro: R$ " + valorBigDecimal,
                    "SAQUE REALIZADO", JOptionPane.INFORMATION_MESSAGE);
                    
            return withdraw;
        }

        return withdraw;

    }

    private static String checking(Withdraw withdraw){
        return withdraw.toString();
    }

    private static boolean validateMovimentBalance(CustomerAccount account, BigDecimal amount) {

        if ((account.getCurrentBalance().compareTo(BigDecimal.ZERO) == 0)) {
            JOptionPane.showMessageDialog(null, "Voce nao possui Saldo!",
                    "ATENÇÃO",
                    JOptionPane.INFORMATION_MESSAGE);

            return false;
        }

        if (amount.compareTo(BigDecimal.ZERO) >= 0) {
            account.setCurrentBalance(account.getCurrentBalance().subtract(amount));
            return true;
        }

        JOptionPane.showMessageDialog(null, "O valor não deve ser negativo. Refaça a operação!",
                "SAQUE",
                JOptionPane.INFORMATION_MESSAGE);

        return false;
    }

}
