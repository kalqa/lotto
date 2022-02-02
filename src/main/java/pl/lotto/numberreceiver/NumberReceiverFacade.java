package pl.lotto.numberreceiver;

import pl.lotto.numberreceiver.validation.NumberValidator;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static pl.lotto.configuration.GameConfiguration.AMOUNT_OF_NUMBERS;
import static pl.lotto.configuration.GameConfiguration.HIGHEST_NUMBER;
import static pl.lotto.configuration.GameConfiguration.LOWEST_NUMBER;

public class NumberReceiverFacade {

    private final NumberValidator numbersValidator;

    public NumberReceiverFacade(NumberValidator numbersValidator) {
        this.numbersValidator = numbersValidator;
    }

    ResultMessageDto inputNumbers(Set<Integer> numbers) {
        if ((numbers.size() == AMOUNT_OF_NUMBERS) && isNumberInRange(numbers) ) {
            return new ResultMessageDto("Accepted", UUID.randomUUID().toString());
        } else {
            return new ResultMessageDto("Not accepted", UUID.randomUUID().toString());
        }
    }

    private boolean isNumberInRange(Set<Integer> numbers) {
        Integer max = Collections.max(numbers);
        Integer min = Collections.min(numbers);

        return min >= LOWEST_NUMBER && max <= HIGHEST_NUMBER;
    }
}
