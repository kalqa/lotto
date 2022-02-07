package pl.lotto.numberreceiver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class InMemoryNumberRepository implements NumberRepository {

    private final Map<String, Set<Integer>> numbers = new HashMap<>();

    @Override
    public void save(String hash, Set<Integer> userNumbers) {
        numbers.put(hash, userNumbers);
    }
}