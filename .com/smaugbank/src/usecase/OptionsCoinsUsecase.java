package usecase;

import java.util.Scanner;

import javax.swing.JOptionPane;

import domain.Repository.RepositoryEnumCoinType;
import domain.ienum.EnumCoinType;

@SuppressWarnings("all")
public class OptionsCoinsUsecase {
    public static EnumCoinType showOptionsCoins() {
        var optionsCoins = new StringBuilder();
        var coinList = RepositoryEnumCoinType.getCoinList();

        for (int i = 0; i < coinList.size(); i++) {
            var currency = coinList.get(i).getKey();
            optionsCoins = optionsCoins.append(i + " " + currency+"\n");
        }

        String incoming = JOptionPane.showInputDialog(null, "Qual moeda deseja abrir a conta\n"+optionsCoins,"COIN", JOptionPane.QUESTION_MESSAGE);

        Integer opcao = Integer.parseInt(incoming);
        EnumCoinType coinType;

        switch (opcao) {
            case 0:
                return coinType = EnumCoinType.EUR;
            case 1:
                return coinType = EnumCoinType.US;
            case 2:
                return coinType = EnumCoinType.REAL;
            default:
                throw new IllegalArgumentException("Opção inválida\n Invalid option");
        }
    }
}
