package domain.entities;

import java.math.BigDecimal;

import domain.CreatedVO;

public class Withdraw {

    private Integer id;

    private BigDecimal amount;

    private CreatedVO dateWithdraw;

    private CustomerAccount customerAccount;

    private Withdraw(Integer id, BigDecimal amount, CreatedVO dateWithdraw, CustomerAccount customerAccount) {
        this.id = id;
        this.amount = amount;
        this.dateWithdraw = dateWithdraw;
        this.customerAccount = customerAccount;
    }

    public static class DepositBuilder {
        private Integer id;
        private BigDecimal amount;
        private CreatedVO dateWithdraw;
        private CustomerAccount customerAccount;

        public DepositBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public DepositBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public DepositBuilder dateWithdraw(CreatedVO dateWithdraw) {
            this.dateWithdraw = dateWithdraw;
            return this;
        }

        public DepositBuilder customerAccount(CustomerAccount customerAccount) {
            this.customerAccount = customerAccount;
            return this;
        }

        public Withdraw build() {
            var withdraw = new Withdraw(id, amount, dateWithdraw, customerAccount);
            return withdraw;
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

    public CreatedVO getDateWithdraw() {
        return dateWithdraw;
    }

    public void setDateWithdraw(CreatedVO dateWithdraw) {
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
        return "Withdraw [id=" + id + ", amount=" + amount + ", dateWithdraw=" + dateWithdraw + ", customerAccount="
                + customerAccount + "]";
    }

}
