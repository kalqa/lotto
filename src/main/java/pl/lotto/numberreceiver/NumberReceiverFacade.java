package pl.lotto.numberreceiver;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class NumberReceiverFacade {

    private final NumberValidator numberValidator;
    private final NumberRepository numberRepository;

    public NumberReceiverFacade(NumberValidator numbersValidator, NumberRepository numberRepository) {
        this.numberValidator = numbersValidator;
        this.numberRepository = numberRepository;
    }

    public ResultMessage inputNumbers(Set<Integer> numbers) {
        if (numberValidator.numbersAreValid(numbers)) {
            String hash = UUID.randomUUID().toString();
            numberRepository.save(hash, numbers);
            return new ResultMessage("Accepted", hash);
        } else {
            return new ResultMessage("Not accepted", "False");
        }
    }

    public Map<String, Set<Integer>> allNumbersFromUsers() {
        return null;
    }
}
