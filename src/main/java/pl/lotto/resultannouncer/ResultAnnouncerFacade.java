package pl.lotto.resultannouncer;

import pl.lotto.resultchecker.ResultCheckerFacade;

import java.util.Set;

public class ResultAnnouncerFacade {

    private final ResultCheckerFacade resultCheckerFacade;

    public ResultAnnouncerFacade(ResultCheckerFacade resultCheckerFacade) {
        this.resultCheckerFacade = resultCheckerFacade;
    }

    public String checkResult(String hash) {
        resultCheckerFacade.checkWinners();
        Set<String> winners = resultCheckerFacade.getWinners();
        return winners.stream().anyMatch(e -> e.equals(hash)) ? "Winner" : "Loser";
    }
}
