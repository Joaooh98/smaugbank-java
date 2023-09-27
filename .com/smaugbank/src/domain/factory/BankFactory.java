package domain.factory;

import domain.ienum.EnumBank;
import usecase.AmericaAccount;

public class BankFactory {
    public static void findBank(EnumBank bank) {
        switch (bank) {
            case BANCODOBRASIL:
                    new AmericaAccount().create(bank);
                break;
            case CHASE:
                break;
            case HSBC:
                break;
            default:
                throw new IllegalArgumentException("No currency found for this country");
        }
    }
}
