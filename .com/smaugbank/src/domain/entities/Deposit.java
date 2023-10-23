package domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import domain.utils.DateUtil;

public class Deposit {

    private BigDecimal amount;

    private LocalDateTime dateOfPayment;

    private CustomerAccount customerAccount;

    private Deposit(BigDecimal amount, LocalDateTime dateOfPayment, CustomerAccount customerAccount) {
        this.amount = amount;
        this.dateOfPayment = dateOfPayment;
        this.customerAccount = customerAccount;

    }

    public static class DepositBuilder {
        private BigDecimal amount;
        private LocalDateTime dateOfPayment;
        private CustomerAccount customerAccount;

        public DepositBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public DepositBuilder dateOfPayment(LocalDateTime dateOfPayment) {
            this.dateOfPayment = dateOfPayment;
            return this;
        }

        public DepositBuilder customerAccount(CustomerAccount customerAccount) {
            this.customerAccount = customerAccount;
            return this;
        }

        public Deposit build() {
            var deposit = new Deposit(amount, dateOfPayment, customerAccount);
            return deposit;
        }
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDateTime dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }

    @Override
    public String toString() {
        return "amount: r$ " + amount + "\n date: " + DateUtil.formatLocalDate(dateOfPayment) + "\n customer Account\n" + "name: "+ customerAccount.getCustomer().getName()
                + "\n"+"document: "+customerAccount.getCustomer().getDocument();
    }
}
