package pl.lotto.resultannouncer;

import pl.lotto.resultchecker.ResultCheckerFacade;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class ResultAnnouncerFacade {

    private final ResultCheckerFacade resultCheckerFacade;

    public ResultAnnouncerFacade(ResultCheckerFacade resultCheckerFacade) {
        this.resultCheckerFacade = resultCheckerFacade;
    }

    public String checkResult(String hash) {
        Set<String> winners = resultCheckerFacade.getWinners();
        return winners.stream().anyMatch(e -> e.equals(hash)) ? "Zwycięzca" : "Przegrany";
    }
}
