package domain;

import java.math.BigDecimal;

import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;

public class CustomerAccount {

    private Customer customer;

    private String agencia;

    private String conta;

    private String userClient;

    private String passwordClient;

    private EnumBank bank;

    private EnumCoinType coitType;

    private BigDecimal currentBalance;
    

    public CustomerAccount(Customer customer, String agencia, String conta, String userClient, String passwordClient,
            EnumBank bank, EnumCoinType coitType, BigDecimal currentBalance) {
        this.customer = customer;
        this.agencia = agencia;
        this.conta = conta;
        this.userClient = userClient;
        this.passwordClient = passwordClient;
        this.bank = bank;
        this.coitType = coitType;
        this.currentBalance = currentBalance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
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

    
}
