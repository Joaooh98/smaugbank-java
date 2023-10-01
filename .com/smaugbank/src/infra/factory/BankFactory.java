package infra.factory;

import domain.Customer;
import domain.CustomerAccount;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;
import usecase.CreatedNationAccountUseCase;

public class BankFactory {
    public static CustomerAccount findBank(EnumCoinType coin, Customer customer, EnumBank bank) {
        switch (coin) {
            case EUR:
                return new CreatedNationAccountUseCase()
                        .create(coin, customer, bank);
            case REAL:
                return new CreatedNationAccountUseCase()
                        .create(coin, customer, bank);
            case US:
                return new CreatedNationAccountUseCase()
                        .create(coin, customer, bank);
            default:
                throw new IllegalArgumentException("No currency found for this country");
        }
    }
}
