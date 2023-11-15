package domain.repository;

import java.util.List;

import domain.enums.EnumBank;
import domain.enums.EnumCoinType;

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
