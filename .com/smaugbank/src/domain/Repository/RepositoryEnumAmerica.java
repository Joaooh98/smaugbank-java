package domain.Repository;

import java.util.List;
import java.util.Scanner;

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
