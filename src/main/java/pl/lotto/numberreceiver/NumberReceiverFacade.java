package pl.lotto.numberreceiver;

import java.util.Set;

public class NumberReceiverFacade {

    private final NumberValidator numbersValidator;

    public NumberReceiverFacade(NumberValidator numbersValidator) {
        this.numbersValidator = numbersValidator;
    }

    public ResultMessage inputNumbers(Set<Integer> numbers) {
        if (numbersValidator.numbersAreValid(numbers)) {
            // mapa <- "hash lsoowy" to "Set<Integer>"
            return new ResultMessage("Accepted", "hash");
        } else {
            return new ResultMessage("Not accepted", "hash");
        }
    }
}
