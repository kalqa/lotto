package pl.lotto.numberreceiver;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

public class NumberReceiverFacade {

    private static NumberReceiverFacade instance;
    private final NumberValidator numberValidator;
    private final NumberRepository numberRepository;

    NumberReceiverFacade(NumberValidator numbersValidator, NumberRepository numberRepository) {
        this.numberValidator = numbersValidator;
        this.numberRepository = numberRepository;
        instance = this;
    }

    public static NumberReceiverFacade getInstance() {
        return instance;
    }

    public ResultMessage inputNumbers(Set<Integer> numbers) {
        if (numberValidator.numbersAreValid(numbers)) {
            String hash = UUID.randomUUID().toString();
            TreeSet<Integer> sortedNumbers = new TreeSet<>(numbers);
            numberRepository.save(hash, sortedNumbers);
            return new ResultMessage("Accepted", hash);
        } else {
            return new ResultMessage("Not accepted", "False");
        }
    }

    public Map<String, Set<Integer>> allNumbersFromUsers() {
        return numberRepository.getAllNumbers();
    }
}
