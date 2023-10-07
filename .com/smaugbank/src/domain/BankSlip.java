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

    private String ourNumber;

    private Integer codeBank;

    private BankSlip(BigDecimal amount, String barCode, CreatedVO bankSlipDueDate, String issuer, String payer,
            String bankCode, String currencyCode, String agency, String ourNumber, Integer codeBank) {
        this.amount = amount;
        this.barCode = barCode;
        this.bankSlipDueDate = bankSlipDueDate;
        this.issuer = issuer;
        this.payer = payer;
        this.bankCode = bankCode;
        this.currencyCode = currencyCode;
        this.agency = agency;
        this.ourNumber = ourNumber;
        this.codeBank = codeBank;
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
        private String ourNumber;
        private Integer codeBank;

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

        public BankSlipBuilder ourNumber(String ourNumber) {
            this.ourNumber = ourNumber;
            return this;
        }

        public BankSlipBuilder codeBank(Integer codeBank) {
            this.codeBank = codeBank;
            return this;
        }

        public BankSlip build() {
            var bankSlip = new BankSlip(amount, barCode, bankSlipDueDate, Issuer, payer, bankCode, currencyCode, agency,
                    ourNumber, codeBank);
            return bankSlip;
        }

    }

    public static void validate(BankSlip bankSlip) {
        // Posição 01-03 = identificação do banco (001 = Banco do Brasil) = codeBank +
        // 00
        // Posição 04-04 = código da moeda (9 = Real)
        // Posição 05-09 = 5 primeiras posições do campo livre (*) = agency
        // Posição 10-10 = dígito verificador do primeiro campo = ultimo digito da
        // agencia
        // Posição 11-20 = 6ª a 15ª posições do campo livre (*) = account
        // Posição 21-21 = dígito verificador do segundo campo = ultimo digito da
        // account
        // Posição 22-31 = 16ª a 25ª posições do campo livre (*) nosso numero
        // Posição 32-32 = dígito verificador do terceiro campo = ourNumber
        // Posição 33-33 = dígito verificador geral ultimo digito ourNumber
        // Posição 34-37 = fator de vencimento (3737 = 31/12/2007) calculateDateFactor
        // Posição 38-47 = valor do boleto (100 = R$1,00 amount

        try {
            StringBuilder lineDigitable = new StringBuilder();

            var stringBuilder = new StringBuilder();
            var bankCode = bankSlip.getBankCode();
            var currencyCode = bankSlip.getCurrencyCode();
            var agency = bankSlip.getAgency();
            var amount = bankSlip.getAmount();
            var issuer = bankSlip.getIssuer();
            var payer = bankSlip.getPayer();
            var dueDate = bankSlip.bankSlipDueDate.getValue();
            String calculateDateFactor = DateUtil.calculateDateFactor(dueDate);

            lineDigitable.append(bankCode + currencyCode+"."+agency+" "+agency);
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

}
