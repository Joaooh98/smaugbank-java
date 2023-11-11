package domain.utils;

import domain.enums.IEnum;

@SuppressWarnings("all")
public class EnumUtil {

    public static boolean isEquals(Enum one, Enum another) {
        if (one == null && another == null) {
            return true;
        } else if (one != null && another != null) {
            return one.name().equals(another.name());
        } else {
            return false;
        }
    }

    public static boolean isNull(Enum one) {
        if (one == null) {
            return true;
        }
        return false;
    }

    public static boolean contains(Enum one, Enum... others) {
        if (others != null) {
            for (Enum en : others) {
                if (isEquals(one, en)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static <T extends IEnum> T parseByKey(Class<T> enumValue, String key) {
        try {
            if (key != null && !key.trim().isEmpty()) {
                for (var value : enumValue.getEnumConstants()) {
                    if (value.getKey().equalsIgnoreCase(key.toLowerCase())) {
                        return value;
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }

        return null;
    }

    public static <T extends IEnum> T parseByValue(Class<T> enumValue, String value) {
        try {
            if (value != null && !value.trim().isEmpty()) {
                for (var enumVal : enumValue.getEnumConstants()) {
                    if (enumVal.getValue().equalsIgnoreCase(value)) {
                        return enumVal;
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }

        return null;
    }
}
