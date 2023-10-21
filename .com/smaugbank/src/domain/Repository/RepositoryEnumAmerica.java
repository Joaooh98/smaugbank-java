package domain.Repository;

import java.util.List;

import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;

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
