package pl.lotto.numberreceiver.validation;

import java.util.Set;

public interface NumberValidator {

    boolean numbersAreValid(Set<Integer> numbers);
}
