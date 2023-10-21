package domain.entities;

import java.math.BigDecimal;

import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;

public class CustomerAccount {

    private Customer customer;

    private String agency;

    private String account;

    private String userClient;

    private String passwordClient;

    private EnumBank bank;

    private EnumCoinType coitType;

    private BigDecimal currentBalance;

    private CustomerAccount(Customer customer, String agency, String account, String userClient, String passwordClient,
            EnumBank bank, EnumCoinType coitType, BigDecimal currentBalance) {
        this.customer = customer;
        this.agency = agency;
        this.account = account;
        this.userClient = userClient;
        this.passwordClient = passwordClient;
        this.bank = bank;
        this.coitType = coitType;
        this.currentBalance = currentBalance;
    }

    public static class CustomerAccountBuilder {
        private Customer customer;
        private String agency;
        private String account;
        private String userClient;
        private String passwordClient;
        private EnumBank bank;
        private EnumCoinType coitType;
        private BigDecimal currentBalance;

        public CustomerAccountBuilder Customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public CustomerAccountBuilder agency(String agency) {
            this.agency = agency;
            return this;
        }

        public CustomerAccountBuilder account(String account) {
            this.account = account;
            return this;
        }

        public CustomerAccountBuilder userClient(String userClient) {
            this.userClient = userClient;
            return this;
        }

        public CustomerAccountBuilder passwordClient(String passwordClient) {
            this.passwordClient = passwordClient;
            return this;
        }

        public CustomerAccountBuilder bank(EnumBank bank) {
            this.bank = bank;
            return this;
        }

        public CustomerAccountBuilder coitType(EnumCoinType coitType) {
            this.coitType = coitType;
            return this;
        }

        public CustomerAccountBuilder currentBalance(BigDecimal currentBalance) {
            this.currentBalance = currentBalance;
            return this;
        }

        public CustomerAccount build() {
            var customerAccount = new CustomerAccount(customer, agency, account, userClient, passwordClient, bank, coitType, currentBalance);
            return customerAccount;
        }

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserClient() {
        return userClient;
    }

    public void setUserClient(String userClient) {
        this.userClient = userClient;
    }

    public String getPasswordClient() {
        return passwordClient;
    }

    public void setPasswordClient(String passwordClient) {
        this.passwordClient = passwordClient;
    }

    public EnumBank getBank() {
        return bank;
    }

    public void setBank(EnumBank bank) {
        this.bank = bank;
    }

    public EnumCoinType getCoitType() {
        return coitType;
    }

    public void setCoitType(EnumCoinType coitType) {
        this.coitType = coitType;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    @Override
    public String toString() {
        return "Account holder: " + customer + "\n agency: " + agency + "\n account: " + account + "\n user: "
                + userClient + "\n password: " + passwordClient + "\n bank: " + bank + "\n coitType: " + coitType
                + "\n Balance: " + currentBalance + "";
    }
    
}
