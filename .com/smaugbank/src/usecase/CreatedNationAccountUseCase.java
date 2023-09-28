package usecase;

import java.util.List;

import domain.Customer;
import domain.CustomerAccount;
import domain.Repository.CustomerAccountRepository;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;
import service.CreatedAccount;

public class CreatedNationAccountUseCase implements CreatedAccount {

    @Override
    public CustomerAccount create(EnumCoinType coinType, Customer customer, EnumBank bank) {

        var created = new CustomerAccountRepository();
        
        created.addCustomerAccount(customer, coinType, null, null, bank);

        List<CustomerAccount> accounts = created.getAccount();

        var account = accounts.iterator().next();

        return account;
    }

}
