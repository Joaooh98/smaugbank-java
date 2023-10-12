package service;

import domain.entities.Customer;
import domain.entities.CustomerAccount;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;

public interface CreatedAccount {
    
    CustomerAccount create(EnumCoinType coin, Customer customer, EnumBank bank);
}
