package pl.lotto.numberreceiver;

public class NumberReceiverConfiguration {

    public NumberReceiverFacade numberReceiverFacade() {
        return new NumberReceiverFacade();
    }
}
