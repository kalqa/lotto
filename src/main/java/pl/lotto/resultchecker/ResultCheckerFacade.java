package pl.lotto.resultchecker;

import pl.lotto.lottonumbergenerator.LottoNumberGeneratorFacade;
import pl.lotto.numberreceiver.NumberReceiverFacade;

import java.util.Map;
import java.util.Set;

public class ResultCheckerFacade {

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

    public Map<String, Set<Integer>> getResults() {
        return winnersRepository.getAllNumbers();
    }

    public void checkResult() {
        Map<String, Set<Integer>> usersNumbers = numberReceiverFacade.allNumbersFromUsers();
        Set<Integer> winningNumbers = lottoNumberGenerator.winningNumbers();
        usersNumbers.entrySet().removeIf(
                entry -> !entry.getValue().equals(winningNumbers));
        winnersRepository.saveWinners(usersNumbers);
        for (Map.Entry<String, Set<Integer>> entry : usersNumbers.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }


}
