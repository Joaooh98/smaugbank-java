package usecase;

import domain.CustomerAccount;
import domain.ienum.EnumBank;
import service.CreatedAccount;

public class AmericaAccount implements CreatedAccount {

    @Override
    public CustomerAccount create(EnumBank banck) {

        CustomerAccount account = new CustomerAccount(null, null, null, null, null, banck, null, null, null);

        return account;
    }

}
