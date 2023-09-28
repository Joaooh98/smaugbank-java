package infra.factory;

import domain.ienum.EnumCoinType;
import usecase.CreatedNationAccountUseCase;

public class BankFactory {
    public static void findBank(EnumCoinType coin) {
        switch (coin) {
            case EUR:
                new CreatedNationAccountUseCase()
                        .create(coin);
                break;
            case REAL:
                new CreatedNationAccountUseCase()
                        .create(coin);
                break;
            case US:
                new CreatedNationAccountUseCase()
                        .create(coin);
                break;
            default:
                throw new IllegalArgumentException("No currency found for this country");
        }
    }
}
