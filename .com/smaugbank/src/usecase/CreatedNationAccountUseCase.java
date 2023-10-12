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
        Validate(coinType, bank);
        var accountRepository = new CustomerAccountRepository();

        String account = numberGenerator(5);

        String agency = numberGenerator(2);

        accountRepository.addCustomerAccount(customer, coinType, agency, account, bank);

        CustomerAccount accountCustomer = accountRepository.getAccount();

        System.out.println("conta criada com sucesso");

        return accountCustomer;

    }

    public String numberGenerator(int e) {
        Random random = new Random();
        int digitRandom = random.nextInt(10);
        StringBuilder sequenceRandom = new StringBuilder();

        for (int i = 0; i < e; i++) {
            sequenceRandom.append(digitRandom);
        }
        sequenceRandom = sequenceRandom.append("-"+digitRandom);
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
