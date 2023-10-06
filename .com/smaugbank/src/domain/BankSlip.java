package domain;

import java.math.BigDecimal;
import java.text.ParseException;

import domain.ienum.utils.DateUtil;

public class BankSlip {
    private BigDecimal amount;

    private String barCode;

    private CreatedVO bankSlipDueDate;

    private String Issuer;

    private String payer;

    private String bankCode;

    private String CurrencyCode;

    private String agency;

    private BankSlip(BigDecimal amount, String barCode, CreatedVO vencimento, String issuer, String payer, String bankCode) {
        this.amount = amount;
        this.barCode = barCode;
        this.bankSlipDueDate = vencimento;
        this.Issuer = issuer;
        this.payer = payer;
        this.bankCode = bankCode;
    }

    public static class BankSlipBuilder {
        private BigDecimal amount;
        private String barCode;
        private CreatedVO bankSlipDueDate;
        private String Issuer;
        private String payer;
        private String bankCode;

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

        public BankSlip build() {
            var bankSlip = new BankSlip(amount, barCode, bankSlipDueDate, Issuer, payer, bankCode);
            return bankSlip;
        }

    }

    public static void validate(BankSlip bankSlip) {
        // Posição 01-03 = identificação do banco (001 = Banco do Brasil)
        // Posição 04-04 = código da moeda (9 = Real)
        // Posição 05-09 = 5 primeiras posições do campo livre (*) = agency
        // Posição 10-10 = dígito verificador do primeiro campo
        // Posição 11-20 = 6ª a 15ª posições do campo livre (*) = account
        // Posição 21-21 = dígito verificador do segundo campo = account
        // Posição 22-31 = 16ª a 25ª posições do campo livre (*) 
        // Posição 32-32 = dígito verificador do terceiro campo
        // Posição 33-33 = dígito verificador geral
        // Posição 34-37 = fator de vencimento (3737 = 31/12/2007) dueDate
        // Posição 38-47 = valor do boleto (100 = R$1,00 amount

        var stringBuilder = new StringBuilder();
        var bankCode = bankSlip.getBankCode();
        var amount = bankSlip.getAmount();
        var issuer = bankSlip.getIssuer();
        var payer = bankSlip.getPayer();
        var dueDate = bankSlip.bankSlipDueDate.getValue().toString();
        try {
            DateUtil.calculateDateFactor(dueDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("data nao esta no formato esperado para gerar o boleto yyyy-MM-dd");
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
        return Issuer;
    }

    public void setIssuer(String issuer) {
        Issuer = issuer;
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

}
