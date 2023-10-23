package domain.ienum;

import domain.utils.EnumUtil;

public enum EnumBank implements Ienum{
    
    HSBC("HSBC HOLDINGS PLC", "REINO UNIDO",null),
    BARCLAYS("BARCLAYS", "REINO UNIDO",null),
    STANDARD("STANDARD CHARTERED PLC", "REINO UNIDO",null),
    LLOYDS("LLOYDS BANKING GROUP", "REINO UNIDO",null),
    NATWEST("NATWEST GROUP PLC", "REINO UNIDO",null),
    CYBG("CYBG PLC", "REINO UNIDO",null),
    SCOTLAND("BANK OF SCOTLAND", "REINO UNIDO",null),
    TSB("TSB BANKING GROUP PLC", "REINO UNIDO",null),
    METRO("METRO BANK PLC", "REINO UNIDO",null),

    BANCODOBRASIL("BANCO DO BRASIL", "BRAZIL",null),
    CAIXA("CAIXA ECONÔMICA FEDERAL", "BRAZIL",null),
    UNIBANCO("ITAÚ UNIBANCO", "BRAZIL",null),
    BRADESCO("BANCO BRADESCO", "BRAZIL",null),
    SANTANDERBRASIL("SANTANDER BRASIL", "BRAZIL",null),
    VOTORANTIM("BANCO VOTORANTIM", "BRAZIL",null),
    BTG("BANCO BTG PACTUAL", "BRAZIL",null),
    BANRISUL("BANRISUL", "BRAZIL",null),
    SAFRA("BANCO SAFRA", "BRAZIL",null),
    INTER("BANCO INTER", "BRAZIL",null),    

    AMERICA("BANK OF AMERICA", "ESTADOS UNIDOS",null),
    FARGO("WELLS FARGO & CO.", "ESTADOS UNIDOS",null),
    CITIGROUP("CITIGROUP INC.", "ESTADOS UNIDOS",null),
    GOLDMAN("GOLDMAN SACHS GROUP, INC.", "ESTADOS UNIDOS",null),
    MORGAN("MORGAN STANLEY", "ESTADOS UNIDOS",null),
    MELLON("THE BANK OF NEW YORK MELLON CORPORATION", "ESTADOS UNIDOS",null),
    BANCORP("U.S. BANCORP",  "ESTADOS UNIDOS",null),
    PNC("PNC FINANCIAL SERVICES GROUP",  "ESTADOS UNIDOS",null);
    
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
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public boolean containsInEnum(String key) {
        return parseByKey(key) != null;
    }

    public static EnumBank parseByKey(String key) {
        return EnumUtil.parseByKey(EnumBank.class, key);
    }

}
