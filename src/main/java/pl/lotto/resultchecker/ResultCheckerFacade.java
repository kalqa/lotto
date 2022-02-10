package pl.lotto.resultchecker;

import pl.lotto.lottonumbergenerator.LottoNumberGeneratorFacade;
import pl.lotto.numberreceiver.NumberReceiverFacade;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ResultCheckerFacade {

    private static ResultCheckerFacade instance;
    private final WinnersRepository winnersRepository;
    private final NumberReceiverFacade numberReceiverFacade;
    private final LottoNumberGeneratorFacade lottoNumberGeneratorFacade;

    ResultCheckerFacade(WinnersRepository winnersRepository,
                                NumberReceiverFacade numberReceiverFacade,
                                LottoNumberGeneratorFacade lottoNumberGeneratorFacade) {
        this.winnersRepository = winnersRepository;
        this.numberReceiverFacade = numberReceiverFacade;
        this.lottoNumberGeneratorFacade = lottoNumberGeneratorFacade;
        instance = this;
    }

    public static ResultCheckerFacade getInstance() {
        return instance;
    }

    public Set<String> getWinners() {
        return winnersRepository.getAllWinners();
    }

    public void checkWinners() {
        Map<String, Set<Integer>> usersNumbers = numberReceiverFacade.allNumbersFromUsers();
        Set<Integer> winningNumbers = lottoNumberGeneratorFacade.winningNumbers();
        System.out.println("Wewnątrz implementacji metody checkWinners(): " + lottoNumberGeneratorFacade.winningNumbers());
        Set<String> winners = new HashSet<>();
        usersNumbers.forEach((key, value) -> {
            if (value.equals(winningNumbers)) winners.add(key);
        });
        winnersRepository.saveWinners(winners);
    }
}
