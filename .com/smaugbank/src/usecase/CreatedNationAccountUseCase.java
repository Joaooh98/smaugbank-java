package usecase;

import java.util.Random;

import domain.Repository.CustomerAccountRepository;
import domain.entities.Customer;
import domain.entities.CustomerAccount;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;
import domain.utils.EnumUtil;
import service.CreatedAccount;

public class CreatedNationAccountUseCase implements CreatedAccount {

    @Override
    public CustomerAccount create(EnumCoinType coinType, Customer customer, EnumBank bank) {
        Validate(coinType, bank, customer);
        var accountRepository = new CustomerAccountRepository();

        String account = numberGenerator(5);

        String agency = numberGenerator(3);

        accountRepository.addCustomerAccount(customer, coinType, agency, account, bank);

        CustomerAccount accountCustomer = accountRepository.getAccount();

        return accountCustomer;

    }

    public String numberGenerator(int e) {
        Random random = new Random();
        int digitRandomUnic = random.nextInt(10);
        StringBuilder sequenceRandom = new StringBuilder();
        
        for (int i = 0; i < e; i++) {
            int digitRandom = random.nextInt(10);
            sequenceRandom.append(digitRandom);
        }
        sequenceRandom = sequenceRandom.append("-"+digitRandomUnic);
        return sequenceRandom.toString();
    }

    public void Validate(EnumCoinType coinType, EnumBank bank, Customer customer) {
        if (EnumUtil.isNull(coinType)) {
            throw new IllegalArgumentException("coinType e obrigatorio");
        }
        
        if (EnumUtil.isNull(bank)) {
            throw new IllegalArgumentException("Bank e obrigatorio");
        }
        
        if (customer.getName() == null) {
            throw new IllegalArgumentException("nome e obrigatorio");
        }

        if (customer.getUser() == null) {
            throw new IllegalArgumentException("user e obrigatorio");
        }

        if (customer.getPassword() == null) {
            throw new IllegalArgumentException("senha e obrigatorio");
        }

    }
}
