package usecase;

import domain.Repository.RepositoryEnumAmerica;
import domain.Repository.RepositoryEnumBrazil;
import domain.Repository.RepositoryEnumEuropa;
import domain.ienum.EnumBank;
import domain.ienum.EnumCoinType;

@SuppressWarnings("all")
public class OptionsBankUsecase {

    public static EnumBank showOptionsBanks(EnumCoinType coinType) {
        
        FindBanksUsecase findBanksUsecase = new FindBanksUsecase();

        if (coinType.equals(EnumCoinType.EUR)) {
            var listReinoUnido = new RepositoryEnumEuropa();
            return findBanksUsecase.findBanks(listReinoUnido.getbanksList());
        }

        if (coinType.equals(EnumCoinType.US)) {
            var listAmericBanks = new RepositoryEnumAmerica();
            return findBanksUsecase.findBanks(listAmericBanks.getbanksList());
        }

        if (coinType.equals(EnumCoinType.REAL)) {
            var listBrazilBanks = new RepositoryEnumBrazil();
            return findBanksUsecase.findBanks(listBrazilBanks.getbanksList());
        } 

        return null;
    }
    
}
