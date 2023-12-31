package domain.repository;

import java.util.List;

import domain.enums.EnumBank;
import domain.enums.EnumCoinType;

public class RepositoryEnumAmerica {

    public static List<EnumBank> getbanksList() {
        List<EnumBank> enumListAmerica = List.of(
                EnumBank.AMERICA,
                EnumBank.FARGO,
                EnumBank.CITIGROUP,
                EnumBank.GOLDMAN,
                EnumBank.MORGAN,
                EnumBank.MELLON,
                EnumBank.BANCORP,
                EnumBank.PNC);

        return enumListAmerica;
    }

    public static EnumCoinType getCoin() {
        return EnumCoinType.US;
    }
}
