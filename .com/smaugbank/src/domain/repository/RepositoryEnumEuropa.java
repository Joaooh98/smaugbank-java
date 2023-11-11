package domain.repository;

import java.util.List;

import domain.enums.EnumBank;
import domain.enums.EnumCoinType;

public class RepositoryEnumEuropa {

    public static List<EnumBank> getbanksList() {
        List<EnumBank> enumListReinoUnido = List.of(
                EnumBank.HSBC,
                EnumBank.BARCLAYS,
                EnumBank.STANDARD,
                EnumBank.LLOYDS,
                EnumBank.NATWEST,
                EnumBank.SCOTLAND,
                EnumBank.TSB,
                EnumBank.METRO,
                EnumBank.CYBG);

        return enumListReinoUnido;
    }

    public EnumCoinType getCoin() {
        return EnumCoinType.EUR;
    }

}
