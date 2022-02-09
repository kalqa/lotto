package pl.lotto.resultannouncer;

import pl.lotto.resultchecker.ResultCheckerConfiguration;
import pl.lotto.resultchecker.ResultCheckerFacade;

public class ResultAnnouncerConfiguration {

    public ResultAnnouncerFacade resultAnnouncerFacade() {
        return new ResultAnnouncerFacade(new ResultCheckerConfiguration().resultCheckerFacade());
    }
}
