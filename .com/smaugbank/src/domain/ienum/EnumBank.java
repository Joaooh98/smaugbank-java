package domain.ienum;

import domain.ienum.utils.EnumUtil;

public enum EnumBank implements Ienum{

    HSBC("HSBC", "Inglatera"),
    CHASE("JPMorgan", "America"),
    BANCODOBRASIL("BB", "Brasil");
    
    private String key;

    private String value;

    private EnumBank(String key, String value) {
        this.key = key;
        this.value = value;
    }   
    

    @Override
    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean containsInEnum(String key) {
        return parseByKey(key) != null;
    }

    public static EnumBank parseByKey(String key) {
        return EnumUtil.parseByKey(EnumBank.class, key);
    }

}
