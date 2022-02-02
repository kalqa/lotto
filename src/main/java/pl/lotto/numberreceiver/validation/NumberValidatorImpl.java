package pl.lotto.numberreceiver.validation;

import java.util.Set;

import static pl.lotto.configuration.GameConfiguration.AMOUNT_OF_NUMBERS;

public class NumberValidatorImpl implements NumberValidator {

    public boolean numbersAreValid(Set<Integer> numbers) {
        if (numbers.size() == AMOUNT_OF_NUMBERS) {
            return true;
        } else {
            return false;
        }
    }
}
