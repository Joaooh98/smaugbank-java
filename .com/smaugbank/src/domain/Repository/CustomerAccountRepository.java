package domain.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import domain.entities.Customer;
import domain.entities.CustomerAccount;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;

public class CustomerAccountRepository {

    List<CustomerAccount> listCustomerAccounts = new ArrayList<>();

    public void addCustomerAccount(Customer customer, EnumCoinType coinType, String agencia, String conta,
            EnumBank bank) {

        var newCustomerAccount = new CustomerAccount.CustomerAccountBuilder()
                .Customer(customer)
                .userClient(customer.getUser())
                .passwordClient(customer.getPassword())
                .account(conta)
                .agency(agencia)
                .bank(bank)
                .coitType(coinType)
                .currentBalance(BigDecimal.ZERO)
                .build();

        listCustomerAccounts.add(newCustomerAccount);
    }

    public CustomerAccount getAccount() {
        var accountCustomer = listCustomerAccounts.iterator().next();
        return accountCustomer;
    }
}
