package domain;

import java.math.BigDecimal;
import java.text.ParseException;

import domain.ienum.utils.DateUtil;

public class BankSlip {
    private BigDecimal amount;

    private String barCode;

    private CreatedVO bankSlipDueDate;

    private String issuer;

    private String payer;

    private String bankCode;

    private String currencyCode;

    private String agency;

    private String account;

    private String ourNumber;

    private Integer codeBank;

    private String lineDigitable;

    private BankSlip(BigDecimal amount, String barCode, CreatedVO bankSlipDueDate, String issuer, String payer,
            String bankCode, String currencyCode, String agency, String account, String ourNumber, Integer codeBank,
            String lineDigitable) {
        this.amount = amount;
        this.barCode = barCode;
        this.bankSlipDueDate = bankSlipDueDate;
        this.issuer = issuer;
        this.payer = payer;
        this.bankCode = bankCode;
        this.currencyCode = currencyCode;
        this.agency = agency;
        this.account = account;
        this.ourNumber = ourNumber;
        this.codeBank = codeBank;
        this.lineDigitable = lineDigitable;
    }

    public static class BankSlipBuilder {
        private BigDecimal amount;
        private String barCode;
        private CreatedVO bankSlipDueDate;
        private String Issuer;
        private String payer;
        private String bankCode;
        private String currencyCode;
        private String agency;
        private String account;
        private String ourNumber;
        private Integer codeBank;
        private String lineDigitable;

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

        public BankSlipBuilder Issuer(String Issuer) {
            this.Issuer = Issuer;
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

        public BankSlipBuilder agency(String agency) {
            this.agency = agency;
            return this;
        }

        public BankSlipBuilder account(String account) {
            this.account = account;
            return this;
        }

        public BankSlipBuilder ourNumber(String ourNumber) {
            this.ourNumber = ourNumber;
            return this;
        }

        public BankSlipBuilder codeBank(Integer codeBank) {
            this.codeBank = codeBank;
            return this;
        }

        public BankSlipBuilder lineDigitable(String lineDigitable) {
            this.lineDigitable = lineDigitable;
            return this;
        }

        public BankSlip build() {
            var bankSlip = new BankSlip(amount, barCode, bankSlipDueDate, Issuer, payer, bankCode, currencyCode, agency,
                    account, ourNumber, codeBank, lineDigitable);
            String line = genereteLineDigitable(bankSlip);

            bankSlip.setLineDigitable(line);
            return bankSlip;
        }

    }

    public static String genereteLineDigitable(BankSlip bankSlip) {
        try {
            
            StringBuilder lineDigit = new StringBuilder();
            var codeBank = bankSlip.getCodeBank();
            var account = bankSlip.getAccount();
            var currencyCode = bankSlip.getCurrencyCode();
            var agency = bankSlip.getAgency();
            var ourNumber = bankSlip.getOurNumber();
            var amountBig = bankSlip.getAmount();
            String amount = amountBig.toString();
            var dueDate = bankSlip.bankSlipDueDate.getValue();
            String calculateDateFactor = DateUtil.calculateDateFactor(dueDate);
            lineDigit.append("00" + codeBank + currencyCode + "." + agency + "-" + "0" + account + "-" + "0"
                    + ourNumber + "-" + "0" + calculateDateFactor + amount);

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

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
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

    public String getOurNumber() {
        return ourNumber;
    }

    public void setOurNumber(String ourNumber) {
        this.ourNumber = ourNumber;
    }

    public Integer getCodeBank() {
        return codeBank;
    }

    public void setCodeBank(Integer codeBank) {
        this.codeBank = codeBank;
    }

    public String getLineDigitable() {
        return lineDigitable;
    }

    public void setLineDigitable(String lineDigitable) {
        this.lineDigitable = lineDigitable;
    }
}
