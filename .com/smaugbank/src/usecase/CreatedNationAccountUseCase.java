package usecase;

import domain.CustomerAccount;
import domain.ienum.EnumCoinType;
import service.CreatedAccount;

public class CreatedNationAccountUseCase implements CreatedAccount {

    @Override
    public CustomerAccount create(EnumCoinType coinType) {

        CustomerAccount account = new CustomerAccount(null, null, null, null, null, null, coinType, null, null);

        return account;
    }

}
