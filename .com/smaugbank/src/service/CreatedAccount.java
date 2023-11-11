package service;

import domain.entities.Customer;
import domain.entities.CustomerAccount;
import domain.enums.EnumBank;
import domain.enums.EnumCoinType;

public interface CreatedAccount {
    
    CustomerAccount create(EnumCoinType coin, Customer customer, EnumBank bank);
    
}
