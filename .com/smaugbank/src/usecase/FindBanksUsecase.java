package usecase;

import java.util.List;

import javax.swing.JOptionPane;

import domain.ienum.EnumBank;

public class FindBanksUsecase {

    public static EnumBank findBanks(List<EnumBank> list) {
        var optionsCoins = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            var banks = list.get(i).getKey();
            optionsCoins = optionsCoins.append(i + " " + banks + "\n");
        }
        
        String incoming = JOptionPane.showInputDialog("Escolha um banco\n" + optionsCoins);

        Integer opcao = Integer.parseInt(incoming);

        for (EnumBank enumBank : list) {
            if (enumBank.getId().equals(opcao)) {
                return enumBank;
            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida", "atencao!", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Invalid option", "attention!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return null;
    }
}
