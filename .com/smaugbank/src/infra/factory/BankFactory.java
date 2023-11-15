package infra.factory;

import domain.entities.Customer;
import domain.entities.CustomerAccount;
import domain.enums.EnumBank;
import domain.enums.EnumCoinType;
import usecase.CreatedNationAccountUseCase;

public class BankFactory {
    public static CustomerAccount createAccountCustumer(EnumCoinType coin, Customer customer, EnumBank bank) {
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
