package domain.Repository;

import java.util.List;
import java.util.Scanner;

import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;

public class RepositoryEnumBrazil {

    public static List<EnumBank> getbanksList() {
        List<EnumBank> enumListBrazil = List.of(
                EnumBank.BANCODOBRASIL,
                EnumBank.CAIXA,
                EnumBank.UNIBANCO,
                EnumBank.BRADESCO,
                EnumBank.SANTANDERBRASIL,
                EnumBank.VOTORANTIM,
                EnumBank.BTG,
                EnumBank.BANRISUL,
                EnumBank.SAFRA);

        return enumListBrazil;
    }

    public static EnumCoinType getCoin() {
        return EnumCoinType.REAL;
    }

}
