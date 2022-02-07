package pl.lotto.resultchecker;

import java.util.Map;
import java.util.Set;

interface WinnersRepository {

    void saveWinners(Map<String, Set<Integer>> numbers);
    Map<String, Set<Integer>> getAllNumbers();
}
