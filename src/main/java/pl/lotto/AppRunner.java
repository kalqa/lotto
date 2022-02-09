package pl.lotto;

import pl.lotto.numberreceiver.NumberReceiverConfiguration;
import pl.lotto.numberreceiver.ResultMessage;
import pl.lotto.resultannouncer.ResultAnnouncerConfiguration;
import pl.lotto.resultchecker.ResultCheckerConfiguration;

import java.util.Set;

public class AppRunner {

    public static void main(String[] args) {
        ResultMessage resultMessage = new NumberReceiverConfiguration()
                .numberReceiverFacade()
                .inputNumbers(Set.of(1, 2, 3, 4, 5, 6));
        String hashReceived = resultMessage.getHash();
        System.out.println(resultMessage.getMessage() + ", hash: " + hashReceived);

        new ResultCheckerConfiguration().resultCheckerFacade().checkResult();

        String winnerOrLoser = new ResultAnnouncerConfiguration()
                .resultAnnouncerFacade()
                .checkResult(hashReceived);
        System.out.println(winnerOrLoser);
    }
}
