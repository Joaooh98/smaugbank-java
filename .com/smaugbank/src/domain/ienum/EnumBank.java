package domain.ienum;

import domain.ienum.utils.EnumUtil;

public enum EnumBank implements Ienum{
    
    HSBC("HSBC HOLDINGS PLC", "REINO UNIDO",0),
    BARCLAYS("BARCLAYS", "REINO UNIDO",2),
    STANDARD("STANDARD CHARTERED PLC", "REINO UNIDO",3),
    LLOYDS("LLOYDS BANKING GROUP", "REINO UNIDO",4),
    NATWEST("NATWEST GROUP PLC", "REINO UNIDO",5),
    CYBG("CYBG PLC", "REINO UNIDO",6),
    SCOTLAND("BANK OF SCOTLAND", "REINO UNIDO",7),
    TSB("TSB BANKING GROUP PLC", "REINO UNIDO",8),
    METRO("METRO BANK PLC", "REINO UNIDO",9),

    BANCODOBRASIL("BANCO DO BRASIL", "BRAZIL",0),
    CAIXA("CAIXA ECONÔMICA FEDERAL", "BRAZIL",1),
    UNIBANCO("ITAÚ UNIBANCO", "BRAZIL",2),
    BRADESCO("BANCO BRADESCO", "BRAZIL",3),
    SANTANDERBRASIL("SANTANDER BRASIL", "BRAZIL",4),
    VOTORANTIM("BANCO VOTORANTIM", "BRAZIL",5),
    BTG("BANCO BTG PACTUAL", "BRAZIL",6),
    BANRISUL("BANRISUL", "BRAZIL",7),
    SAFRA("BANCO SAFRA", "BRAZIL",8),
    INTER("BANCO INTER", "BRAZIL",9),
    
    AMERICA("BANK OF AMERICA", "ESTADOS UNIDOS",0),
    FARGO("WELLS FARGO & CO.", "ESTADOS UNIDOS",1),
    CITIGROUP("CITIGROUP INC.", "ESTADOS UNIDOS",2),
    GOLDMAN("GOLDMAN SACHS GROUP, INC.", "ESTADOS UNIDOS",3),
    MORGAN("MORGAN STANLEY", "ESTADOS UNIDOS",4),
    MELLON("THE BANK OF NEW YORK MELLON CORPORATION", "ESTADOS UNIDOS",5),
    BANCORP("U.S. BANCORP",  "ESTADOS UNIDOS",6),
    PNC("PNC FINANCIAL SERVICES GROUP",  "ESTADOS UNIDOS",7);
    
    private String key;

    private String value;

    private Integer id;

    
    
    private EnumBank(String key, String value, Integer id) {
        this.key = key;
        this.value = value;
        this.id = id;
    }   
    
    
    @Override
    public String getKey() {
        return key;
    }
    
    public String getValue() {
        return value;
    }
    
    public Integer getId() {
        return id;
    }

    @Override
    public boolean containsInEnum(String key) {
        return parseByKey(key) != null;
    }

    public static EnumBank parseByKey(String key) {
        return EnumUtil.parseByKey(EnumBank.class, key);
    }

}
