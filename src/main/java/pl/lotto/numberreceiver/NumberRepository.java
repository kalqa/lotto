package pl.lotto.numberreceiver;

import java.util.Set;

interface NumberRepository {

    void save(String hash, Set<Integer> numbers);
}
