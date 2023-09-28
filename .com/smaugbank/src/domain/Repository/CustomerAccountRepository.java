package domain.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import domain.Customer;
import domain.CustomerAccount;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;

public class CustomerAccountRepository {

    List<CustomerAccount> listCustomerAccounts = new ArrayList<>();

    public void addCustomerAccount(Customer customer, EnumCoinType coinType, String agencia, String conta, EnumBank bank) {
        
        var newCustomerAccount = new CustomerAccount(customer, agencia, conta, customer.getUser(),
                customer.getPassword(), bank, coinType, BigDecimal.ZERO);

        listCustomerAccounts.add(newCustomerAccount);
    }

    public List<CustomerAccount> getAccount() {
        return listCustomerAccounts;
    }
}
