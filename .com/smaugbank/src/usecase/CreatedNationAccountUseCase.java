package usecase;

import java.util.Random;

import javax.swing.JOptionPane;

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

        String agency = numberGenerator(4);

        accountRepository.addCustomerAccount(customer, coinType, agency, account, bank);

        CustomerAccount accountCustomer = accountRepository.getAccount();

        JOptionPane.showMessageDialog(null, accountCustomer.toString(), "informacoes da conta!", JOptionPane.INFORMATION_MESSAGE);

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
        sequenceRandom = sequenceRandom.append("-" + digitRandomUnic);
        return sequenceRandom.toString();
    }

    public void Validate(EnumCoinType coinType, EnumBank bank, Customer customer) {

        if (EnumUtil.isNull(coinType)) {
            JOptionPane.showMessageDialog(null, "coinType e obrigatorio", "Atencao!", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("coinType e obrigatorio");
        }
        
        if (EnumUtil.isNull(bank)) {
            JOptionPane.showMessageDialog(null, "Bank e obrigatorio", "Atencao!", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Bank e obrigatorio");
        }
        
        if (customer.getName() == null) {
            JOptionPane.showMessageDialog(null, "nome e obrigatorio", "Atencao!", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("nome e obrigatorio");
        }
        
        if (customer.getUser() == null) {
            JOptionPane.showMessageDialog(null, "user e obrigatorio", "Atencao!", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("user e obrigatorio");
        }
        
        if (customer.getPassword() == null) {
            JOptionPane.showMessageDialog(null, "senha e obrigatorio", "Atencao!", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("senha e obrigatorio");
        }

    }
}
