package domain.ienum;

import domain.ienum.utils.EnumUtil;

public enum EnumBank implements Ienum{
    
    HSBC("HSBC HOLDINGS PLC", "1", "REINO UNIDO"),
    BARCLAYS("BARCLAYS", "2", "REINO UNIDO"),
    STANDARD("STANDARD CHARTERED PLC", "3", "REINO UNIDO"),
    LLOYDS("LLOYDS BANKING GROUP", "4", "REINO UNIDO"),
    NATWEST("NATWEST GROUP PLC", "5", "REINO UNIDO"),
    CYBG("CYBG PLC", "6", "REINO UNIDO"),
    SCOTLAND("BANK OF SCOTLAND", "7", "REINO UNIDO"),
    TSB("TSB BANKING GROUP PLC", "8", "REINO UNIDO"),
    METRO("METRO BANK PLC", "9", "REINO UNIDO"),

    BANCODOBRASIL("BANCO DO BRASIL", "Brasil", "BRAZIL"),
    CAIXA("CAIXA ECONÔMICA FEDERAL", "Brasil", "BRAZIL"),
    UNIBANCO("ITAÚ UNIBANCO", "Brasil", "BRAZIL"),
    BRADESCO("BANCO BRADESCO", "Brasil", "BRAZIL"),
    SANTANDERBRASIL("SANTANDER BRASIL", "Brasil", "BRAZIL"),
    VOTORANTIM("BANCO VOTORANTIM", "Brasil", "BRAZIL"),
    BTG("BANCO BTG PACTUAL", "Brasil", "BRAZIL"),
    BANRISUL("BANRISUL", "Brasil", "BRAZIL"),
    SAFRA("BANCO SAFRA", "Brasil", "BRAZIL"),
    INTER("BANCO INTER", "Brasil", "BRAZIL"),
    
    AMERICA("BANK OF AMERICA", "America", "ESTADOS UNIDOS"),
    FARGO("WELLS FARGO & CO.", "America", "ESTADOS UNIDOS"),
    CITIGROUP("CITIGROUP INC.", "America", "ESTADOS UNIDOS"),
    GOLDMAN("GOLDMAN SACHS GROUP, INC.", "America", "ESTADOS UNIDOS"),
    MORGAN("MORGAN STANLEY", "America", "ESTADOS UNIDOS"),
    MELLON("THE BANK OF NEW YORK MELLON CORPORATION", "America", "ESTADOS UNIDOS"),
    BANCORP("U.S. BANCORP", "America", "ESTADOS UNIDOS"),
    PNC("PNC FINANCIAL SERVICES GROUP", "America", "ESTADOS UNIDOS");
    
    private String key;

    private String value;

    private String valueTwo;

    private EnumBank(String key, String value, String valueTwo) {
        this.key = key;
        this.value = value;
        this.valueTwo = valueTwo;
    }   
    

    @Override
    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getValueTwo() {
        return valueTwo;
    }

    @Override
    public boolean containsInEnum(String key) {
        return parseByKey(key) != null;
    }

    public static EnumBank parseByKey(String key) {
        return EnumUtil.parseByKey(EnumBank.class, key);
    }

}
