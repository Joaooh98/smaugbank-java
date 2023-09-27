package service;

import domain.CustomerAccount;
import domain.ienum.EnumBank;

public interface CreatedAccount {
    
    CustomerAccount create(EnumBank banck);
}
