package usecase;

import java.util.List;
import java.util.Random;

import domain.Customer;
import domain.CustomerAccount;
import domain.Repository.CustomerAccountRepository;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;
import domain.ienum.utils.EnumUtil;
import service.CreatedAccount;

public class CreatedNationAccountUseCase implements CreatedAccount {

    @Override
    public CustomerAccount create(EnumCoinType coinType, Customer customer, EnumBank bank) {
        Validate(coinType, bank);
        var created = new CustomerAccountRepository();

        String agency = accountNumberGenerator();

        created.addCustomerAccount(customer, coinType, agency, "0001", bank);

        List<CustomerAccount> accounts = created.getAccount();

        var account = accounts.iterator().next();

        System.out.println("conta criada com sucesso");

        return account;

    }

    public String accountNumberGenerator() {
        Random random = new Random();
        StringBuilder sequenceRandom = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int digitRandom = random.nextInt(10);
            sequenceRandom.append(digitRandom);
        }

        return sequenceRandom.toString();
    }

    public void Validate(EnumCoinType coinType, EnumBank bank) {
        if (EnumUtil.isNull(coinType)) {
            throw new IllegalArgumentException("coinType e obrigatorio");
        }
        if (EnumUtil.isNull(bank)) {
            throw new IllegalArgumentException("Bank e obrigatorio");
        }

    }
}
