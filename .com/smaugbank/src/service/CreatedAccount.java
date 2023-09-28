package service;

import domain.Customer;
import domain.CustomerAccount;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;

public interface CreatedAccount {
    
    CustomerAccount create(EnumCoinType coin, Customer customer, EnumBank bank);
}
