package pl.lotto.resultchecker;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ResultCheckerFacade {
    public Map<String, Set<Integer>> checkResult(Map<String, Set<Integer>> usersNumbers, Set<Integer> winningNumbers) {
        usersNumbers.entrySet().removeIf(entry -> !entry.getValue().equals(winningNumbers));
        return usersNumbers;
    }
}
