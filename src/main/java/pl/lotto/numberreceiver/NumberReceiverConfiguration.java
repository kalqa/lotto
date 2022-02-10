package pl.lotto.numberreceiver;

public class NumberReceiverConfiguration {

    public NumberReceiverFacade numberReceiverFacade(NumberValidator numberValidator,
                                                     NumberRepository numberRepository) {
        if (NumberReceiverFacade.getInstance() != null)
            return NumberReceiverFacade.getInstance();
        else
            return new NumberReceiverFacade(numberValidator, numberRepository);
    }
}
