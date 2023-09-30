package domain.Repository;

import java.util.List;

import domain.ienum.EnumCoinType;

public class RepositoryEnumCoinType {

    public static List<EnumCoinType> getCoinList() {
        List<EnumCoinType> enumList = List.of(
                EnumCoinType.EUR,
                EnumCoinType.US,
                EnumCoinType.REAL);

        return enumList;
    }

}
