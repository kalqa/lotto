package pl.lotto.numberreceiver;

import java.util.List;

public class NumberReceiverFacade {

    ResultMessageDto inputNumbers(List<Integer> numbers) {
        return new ResultMessageDto("all good", "jaamn");
    }
}
