package domain.enums;

import domain.utils.EnumUtil;

public enum EnumCoinType implements IEnum {

    US("DOLLAR", "$"),
    EUR("EURO", "€"),
    REAL("REAL", "R$");

    private String key;

    private String value;

    private EnumCoinType(String key, String value) {
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

    public static EnumCoinType parseByKey(String key) {
        return EnumUtil.parseByKey(EnumCoinType.class, key);
    }

}
