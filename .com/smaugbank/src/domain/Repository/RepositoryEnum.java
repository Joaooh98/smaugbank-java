package domain.Repository;

import java.util.List;

import domain.ienum.EnumBank;

public class RepositoryEnum {

    public List<EnumBank> getbanksListReinoUnido() {
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

    public List<EnumBank> getbanksListAmerica() {
        List<EnumBank> enumListAmerica = List.of(
                EnumBank.HSBC,
                EnumBank.BARCLAYS,
                EnumBank.STANDARD,
                EnumBank.LLOYDS,
                EnumBank.NATWEST,
                EnumBank.SCOTLAND,
                EnumBank.TSB,
                EnumBank.METRO,
                EnumBank.CYBG);

        return enumListAmerica;
    }

    public List<EnumBank> getbanksListBrazil() {
        List<EnumBank> enumListBrazil = List.of(
                EnumBank.HSBC,
                EnumBank.BARCLAYS,
                EnumBank.STANDARD,
                EnumBank.LLOYDS,
                EnumBank.NATWEST,
                EnumBank.SCOTLAND,
                EnumBank.TSB,
                EnumBank.METRO,
                EnumBank.CYBG);

        return enumListBrazil;
    }

}
