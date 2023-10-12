package domain.entities;

import java.math.BigDecimal;

import domain.CreatedVO;

public class Deposit {

    private Integer id;

    private BigDecimal amount;

    private CreatedVO dateOfPayment;

    private CustomerAccount customerAccount;

    private Deposit(Integer id, BigDecimal amount, CreatedVO dateOfPayment, CustomerAccount customerAccount) {
        this.id = id;
        this.amount = amount;
        this.dateOfPayment = dateOfPayment;
        this.customerAccount = customerAccount;

    }

    public static class DepositBuilder {
        private Integer id;
        private BigDecimal amount;
        private CreatedVO dateOfPayment;
        private CustomerAccount customerAccount;

        public DepositBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public DepositBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public DepositBuilder dateOfPayment(CreatedVO dateOfPayment) {
            this.dateOfPayment = dateOfPayment;
            return this;
        }

        public DepositBuilder customerAccount(CustomerAccount customerAccount) {
            this.customerAccount = customerAccount;
            return this;
        }

        public Deposit build() {
            var deposit = new Deposit(id, amount, dateOfPayment, customerAccount);
            return deposit;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CreatedVO getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(CreatedVO dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }

}
