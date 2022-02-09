package pl.lotto.resultchecker;

import pl.lotto.lottonumbergenerator.LottoNumberGeneratorConfiguration;
import pl.lotto.numberreceiver.NumberReceiverConfiguration;

public class ResultCheckerConfiguration {

    public ResultCheckerFacade resultCheckerFacade() {
        //return ResultCheckerFacade.getInstance();
        return new ResultCheckerFacade(new InMemoryWinnersRepository(),
                new NumberReceiverConfiguration().numberReceiverFacade(),
                new LottoNumberGeneratorConfiguration().lottoNumberGeneratorFacade());
    }
}
