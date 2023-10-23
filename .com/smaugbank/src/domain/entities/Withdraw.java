package domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import domain.utils.DateUtil;

public class Withdraw {

    private BigDecimal amount;

    private LocalDateTime dateWithdraw;

    private CustomerAccount customerAccount;

    private Withdraw(BigDecimal amount, LocalDateTime dateWithdraw, CustomerAccount customerAccount) {
        this.amount = amount;
        this.dateWithdraw = dateWithdraw;
        this.customerAccount = customerAccount;
    }

    public static class WithdrawBuilder {
        private BigDecimal amount;
        private LocalDateTime dateWithdraw;
        private CustomerAccount customerAccount;

        public WithdrawBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public WithdrawBuilder dateWithdraw(LocalDateTime dateWithdraw) {
            this.dateWithdraw = dateWithdraw;
            return this;
        }

        public WithdrawBuilder customerAccount(CustomerAccount customerAccount) {
            this.customerAccount = customerAccount;
            return this;
        }

        public Withdraw build() {
            var withdraw = new Withdraw(amount, dateWithdraw, customerAccount);
            return withdraw;
        }
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateWithdraw() {
        return dateWithdraw;
    }

    public void setDateWithdraw(LocalDateTime dateWithdraw) {
        this.dateWithdraw = dateWithdraw;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }

    @Override
    public String toString() {
        return "DATE: " + DateUtil.formatLocalDate(dateWithdraw)+ "\n CUSTOMER ACCOUNT\n" + "NAME: "+ customerAccount.getCustomer().getName()
                + "\n"+"CPF: "+customerAccount.getCustomer().getDocument();
    }

}
