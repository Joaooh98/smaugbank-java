package domain.entities;

import java.math.BigDecimal;
import java.text.ParseException;

import domain.CreatedVO;
import domain.utils.DateUtil;
import domain.utils.StringUtil;

public class BankSlip {

    private BigDecimal amount;

    private String barCode;

    private CreatedVO bankSlipDueDate;

    private String payer;

    private String bankCode;

    private String currencyCode;

    private String ourNumber;

    private String lineDigitable;

    private CustomerAccount customerAccount;

    private BankSlip(BigDecimal amount, String barCode, CreatedVO bankSlipDueDate, String payer, String bankCode,
            String currencyCode, String ourNumber, String lineDigitable, CustomerAccount customerAccount) {
        this.amount = amount;
        this.barCode = barCode;
        this.bankSlipDueDate = bankSlipDueDate;
        this.payer = payer;
        this.bankCode = bankCode;
        this.currencyCode = currencyCode;
        this.ourNumber = ourNumber;
        this.lineDigitable = lineDigitable;
        this.customerAccount = customerAccount;
    }

    public static class BankSlipBuilder {

        private BigDecimal amount;
        private String barCode;
        private CreatedVO bankSlipDueDate;
        private String payer;
        private String bankCode;
        private String currencyCode;
        private String ourNumber;
        private String lineDigitable;
        private CustomerAccount customerAccount;

        public BankSlipBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public BankSlipBuilder barCode(String barCode) {
            this.barCode = barCode;
            return this;
        }

        public BankSlipBuilder bankSlipDueDate(CreatedVO bankSlipDueDate) {
            this.bankSlipDueDate = bankSlipDueDate;
            return this;
        }

        public BankSlipBuilder payer(String payer) {
            this.payer = payer;
            return this;
        }

        public BankSlipBuilder bankCode(String bankCode) {
            this.bankCode = bankCode;
            return this;
        }

        public BankSlipBuilder currencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        public BankSlipBuilder ourNumber(String ourNumber) {
            this.ourNumber = ourNumber;
            return this;
        }

        public BankSlipBuilder lineDigitable(String lineDigitable) {
            this.lineDigitable = lineDigitable;
            return this;
        }

        public BankSlipBuilder customerAccount(CustomerAccount customerAccount) {
            this.customerAccount = customerAccount;
            return this;
        }

        public BankSlip build() {
            var bankSlip = new BankSlip(amount, barCode, bankSlipDueDate, payer, bankCode, currencyCode, ourNumber,
                    lineDigitable, customerAccount);
            String line = genereteLineDigitable(bankSlip);

            bankSlip.setLineDigitable(line);
            return bankSlip;
        }

    }

    public static String genereteLineDigitable(BankSlip bankSlip) {
        try {

            StringBuilder lineDigit = new StringBuilder();
            var codeBank = bankSlip.getCustomerAccount().getBank().getId();
            var account = bankSlip.getCustomerAccount().getAccount();
            var currencyCode = bankSlip.getCurrencyCode();
            var agency = bankSlip.getCustomerAccount().getAgency();
            var ourNumber = StringUtil.numberGenerator(8);
            var amountBig = bankSlip.getAmount();
            String amount = amountBig.toString();
            var dueDate = bankSlip.bankSlipDueDate.getValue();
            String dateFactor = DateUtil.calculateDateFactor(dueDate);
            lineDigit.append("00" + codeBank + currencyCode + "." + agency + account
                    + ourNumber + "-" + "0" + dateFactor + amount);

            var line = lineDigit.toString();

            return line;

        } catch (ParseException e) {
            throw new IllegalArgumentException(
                    "data nao esta no formato esperado para gerar o boleto yyyy-MM-dd, ou algum campo nao foi informado verifique novamente");
        }
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public CreatedVO getBankSlipDueDate() {
        return bankSlipDueDate;
    }

    public void setBankSlipDueDate(CreatedVO bankSlipDueDate) {
        this.bankSlipDueDate = bankSlipDueDate;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getOurNumber() {
        return ourNumber;
    }

    public void setOurNumber(String ourNumber) {
        this.ourNumber = ourNumber;
    }

    public String getLineDigitable() {
        return lineDigitable;
    }

    public void setLineDigitable(String lineDigitable) {
        this.lineDigitable = lineDigitable;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }

}
