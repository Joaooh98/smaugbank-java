package usecase;

import domain.repository.RepositoryEnumAmerica;
import domain.repository.RepositoryEnumBrazil;
import domain.repository.RepositoryEnumEuropa;
import domain.enums.EnumBank;
import domain.enums.EnumCoinType;

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
