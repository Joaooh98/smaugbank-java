package domain;

import java.math.BigDecimal;

public class BankSlip {
    private BigDecimal amount;

    private String barCode;

    private CreatedVO bankSlipDueDate;

    private String Issuer;

    private String payer;

    public BankSlip(BigDecimal amount, String barCode, CreatedVO vencimento, String issuer, String payer) {
        this.amount = amount;
        this.barCode = barCode;
        this.bankSlipDueDate = vencimento;
        Issuer = issuer;
        this.payer = payer;
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

    public void setBankSlipDueDate(CreatedVO vencimento) {
        this.bankSlipDueDate = vencimento;
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
