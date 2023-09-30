package domain.Repository;

import java.util.List;
import java.util.Scanner;

import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;

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
