package infra.factory;

import domain.Customer;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;
import usecase.CreatedNationAccountUseCase;

public class BankFactory {
    public static void findBank(EnumCoinType coin, Customer customer, EnumBank bank) {
        switch (coin) {
            case EUR:
                new CreatedNationAccountUseCase()
                        .create(coin, customer, bank);
                break;
            case REAL:
                new CreatedNationAccountUseCase()
                        .create(coin, customer, bank);
                break;
            case US:
                new CreatedNationAccountUseCase()
                        .create(coin, customer, bank);
                break;
            default:
                throw new IllegalArgumentException("No currency found for this country");
        }
    }
}
