package pl.lotto.resultchecker;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class InMemoryWinnersRepository implements WinnersRepository {

    private Map<String, Set<Integer>> numbers = new HashMap<>();

    @Override
    public void saveWinners(Map<String, Set<Integer>> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Map<String, Set<Integer>> getAllNumbers() {
        return numbers;
    }
}
