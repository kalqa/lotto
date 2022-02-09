package pl.lotto.numberreceiver;

public class NumberReceiverConfiguration {

    public NumberReceiverFacade numberReceiverFacade() {
        //return NumberReceiverFacade.getInstance();
        return new NumberReceiverFacade(new NumberValidatorImpl(), new InMemoryNumberRepository());
    }
}
