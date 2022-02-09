package pl.lotto.resultchecker;

import pl.lotto.lottonumbergenerator.LottoNumberGeneratorConfiguration;
import pl.lotto.lottonumbergenerator.LottoNumberGeneratorFacade;
import pl.lotto.numberreceiver.NumberReceiverConfiguration;
import pl.lotto.numberreceiver.NumberReceiverFacade;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ResultCheckerFacade {

    //private static ResultCheckerFacade instance;
    private final WinnersRepository winnersRepository;
    private final NumberReceiverFacade numberReceiverFacade;
    private final LottoNumberGeneratorFacade lottoNumberGenerator;

    public ResultCheckerFacade(WinnersRepository winnersRepository,
                                NumberReceiverFacade numberReceiverFacade,
                                LottoNumberGeneratorFacade lottoNumberGenerator) {
        this.winnersRepository = winnersRepository;
        this.numberReceiverFacade = numberReceiverFacade;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    /*public static ResultCheckerFacade getInstance() {
        if (instance == null) {
            instance = new ResultCheckerFacade(
                    new InMemoryWinnersRepository(),
                    new NumberReceiverConfiguration().numberReceiverFacade(),
                    new LottoNumberGeneratorConfiguration().lottoNumberGeneratorFacade());
        }
        return instance;
    }*/

    public Set<String> getWinners() {
        return winnersRepository.getAllWinners();
    }

    public void checkResult() {
        Map<String, Set<Integer>> usersNumbers = numberReceiverFacade.allNumbersFromUsers();
        Set<Integer> winningNumbers = lottoNumberGenerator.winningNumbers();
        Set<String> winners = new HashSet<>();
        usersNumbers.forEach((key, value) -> {
            if (value.equals(winningNumbers)) winners.add(key);
        });
        winnersRepository.saveWinners(winners);
    }
}
