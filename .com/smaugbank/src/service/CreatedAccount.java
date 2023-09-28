package service;

import domain.CustomerAccount;
import domain.ienum.EnumCoinType;

public interface CreatedAccount {
    
    CustomerAccount create(EnumCoinType banck);
}
