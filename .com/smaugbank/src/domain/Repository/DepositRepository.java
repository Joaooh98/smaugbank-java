package domain.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import domain.entities.CustomerAccount;
import domain.entities.Deposit;

public class DepositRepository {

    List<Deposit> Deposits = new ArrayList<>();

    public void addDeposit(BigDecimal amount, CustomerAccount customerAccount) {

        var Deposit = new Deposit
        .DepositBuilder()
        .amount(amount)
        .dateOfPayment(LocalDateTime.now())
        .customerAccount(customerAccount)
        .build();

        Deposits.add(Deposit);
    }

    public Deposit getDeposit() {
        return Deposits.iterator().next();
    }
}
