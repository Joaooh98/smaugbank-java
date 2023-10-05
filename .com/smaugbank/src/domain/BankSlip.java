package domain;

import java.math.BigDecimal;

public class BankSlip {
    private BigDecimal amount;

    private String barCode;

    private CreatedVO bankSlipDueDate;

    private String Issuer;

    private String payer;

    private BankSlip(BigDecimal amount, String barCode, CreatedVO vencimento, String issuer, String payer) {
        this.amount = amount;
        this.barCode = barCode;
        this.bankSlipDueDate = vencimento;
        this.Issuer = issuer;
        this.payer = payer;
    }

    public static class BankSlipBuilder {
        private BigDecimal amount;
        private String barCode;
        private CreatedVO bankSlipDueDate;
        private String Issuer;
        private String payer;

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

        public BankSlip build() {
            var bankSlip = new BankSlip(amount, barCode, bankSlipDueDate, Issuer, payer);
            return bankSlip;
        }

    }

    public static void validate(BankSlip bankSlip) {
        var stringBuilder = new StringBuilder();
        var amount = bankSlip.getAmount();
        var issuer = bankSlip.getIssuer();
        var payer = bankSlip.getPayer();
        var dueDate = bankSlip.bankSlipDueDate.getValue();
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

    
}
