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

    public static EnumBank findBanks(List<EnumBank> list, Scanner input) {
        for (int i = 0; i < list.size(); i++) {
            var currency = list.get(i).getKey();
            System.out.println(i + " " + currency);
        }

        Integer opcao = input.nextInt();

        for (EnumBank enumBank : list) {
            if (enumBank.getId().equals(opcao)) {
                return enumBank;
            }
        }
        return null;
    }
}
