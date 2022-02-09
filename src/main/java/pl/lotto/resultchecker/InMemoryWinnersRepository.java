package pl.lotto.resultchecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class InMemoryWinnersRepository implements WinnersRepository {

    private Set<String> winners = new HashSet<>();

    @Override
    public void saveWinners(Set<String> winners) {
        this.winners = winners;
    }

    @Override
    public Set<String> getAllWinners() {
        return winners;
    }
}
