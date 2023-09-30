package usecase;

import java.util.Scanner;

import domain.Balance;
import domain.Repository.RepositoryEnumAmerica;
import domain.Repository.RepositoryEnumBrazil;
import domain.Repository.RepositoryEnumCoinType;
import domain.Repository.RepositoryEnumEuropa;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;

@SuppressWarnings("all")
public class OperationsAccountUseCase {
    
    public void deposit(){

    }

    public Balance consultBalance(){
        return null;

    }

    public void showFunctions(){

    }

    public void showAccountData(){
        
    }

    public static EnumCoinType showOptionsCoins(Scanner input) {
        var coinList = RepositoryEnumCoinType.getCoinList();

        for (int i = 0; i < coinList.size(); i++) {
            var currency = coinList.get(i).getKey();
            System.out.println(i + " " + currency);
        }

        int inputOptionCoin = input.nextInt();

        int opcao = inputOptionCoin;
        EnumCoinType coinType;

        switch (opcao) {
            case 0:
                return coinType = EnumCoinType.EUR;
            case 1:
                return coinType = EnumCoinType.US;
            case 2:
                return coinType = EnumCoinType.REAL;
            default:
                throw new IllegalArgumentException("Opção inválida");
        }
    }

    public static EnumBank showOptionsBanks(EnumCoinType coinType, Scanner input) {

        if (coinType.equals(EnumCoinType.EUR)) {
            var listReinoUnido = new RepositoryEnumEuropa();
            return listReinoUnido.findBanks(listReinoUnido.getbanksList(), input);
        }

        if (coinType.equals(EnumCoinType.US)) {
            var listAmericBanks = new RepositoryEnumAmerica();
            return listAmericBanks.findBanks(listAmericBanks.getbanksList(), input);
        }
        if (coinType.equals(EnumCoinType.REAL)) {
            var listBrazilBanks = new RepositoryEnumBrazil();
            return listBrazilBanks.findBanks(listBrazilBanks.getbanksList(), input);
        } else {
            System.out.println("Opção inválida");
        }

        return null;
    }
}
