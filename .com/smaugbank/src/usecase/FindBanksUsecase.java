package usecase;

import java.util.List;

import javax.swing.JOptionPane;

import domain.enums.EnumBank;

public class FindBanksUsecase {

    public static EnumBank findBanks(List<EnumBank> list) {
        var optionsCoins = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            var banks = list.get(i).getKey();
            list.get(i).setId(i);
            int id = list.get(i).getId();
            optionsCoins = optionsCoins.append(id + " " + banks + "\n");
        }
        
        String incoming = JOptionPane.showInputDialog(null, optionsCoins,"Escolha um banco" ,JOptionPane.QUESTION_MESSAGE);

        int opcao = Integer.parseInt(incoming);

        for (EnumBank enumBank : list) {
            if (enumBank.getId().equals(opcao)) {
                return enumBank;
            }
        }
        JOptionPane.showMessageDialog(null, "Opção inválida", "atencao!", JOptionPane.INFORMATION_MESSAGE);
        return null;
    }
}
