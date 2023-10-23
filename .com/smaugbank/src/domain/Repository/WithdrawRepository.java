package domain.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import domain.entities.CustomerAccount;
import domain.entities.Withdraw;

public class WithdrawRepository {

    List<Withdraw> withdraws = new ArrayList<>();

    public void addwithdraw(BigDecimal amount, CustomerAccount customerAccount) {

        var withdraw = new Withdraw
        .WithdrawBuilder()
        .amount(amount)
        .dateWithdraw(LocalDateTime.now())
        .customerAccount(customerAccount)
        .build();

        withdraws.add(withdraw);
    }

    public Withdraw getwithdraw() {
        return withdraws.iterator().next();
    }
}
