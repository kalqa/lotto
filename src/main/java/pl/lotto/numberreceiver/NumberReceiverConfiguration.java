package pl.lotto.numberreceiver;

import pl.lotto.numberreceiver.validation.NumberValidatorImpl;

public class NumberReceiverConfiguration {

    public NumberReceiverFacade numberReceiverFacade() {
        return new NumberReceiverFacade(new NumberValidatorImpl());
    }
}
