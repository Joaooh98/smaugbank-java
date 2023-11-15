package domain.repository;

import java.util.List;

import domain.enums.EnumCoinType;

public class RepositoryEnumCoinType {

    public static List<EnumCoinType> getCoinList() {
        List<EnumCoinType> enumList = List.of(
                EnumCoinType.EUR,
                EnumCoinType.US,
                EnumCoinType.REAL);

        return enumList;
    }

}
