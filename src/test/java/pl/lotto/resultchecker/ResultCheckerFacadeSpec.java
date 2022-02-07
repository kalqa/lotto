package pl.lotto.resultchecker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.lotto.lottonumbergenerator.LottoNumberGeneratorFacade;
import pl.lotto.numberreceiver.NumberReceiverFacade;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ResultCheckerFacadeSpec {

    private final NumberReceiverFacade numberReceiverFacade =
            mock(NumberReceiverFacade.class);
    private final LottoNumberGeneratorFacade lottoNumberGenerator =
            mock(LottoNumberGeneratorFacade.class);
    ResultCheckerFacade resultCheckerFacade = new ResultCheckerFacade(
            new InMemoryWinnersRepository(),
            numberReceiverFacade,
            lottoNumberGenerator);

    Map<String, Set<Integer>> usersNumbers = new HashMap<>() {{
        put("hash1", Set.of(1, 2, 3, 4, 5, 6));
        put("hash2", Set.of(1, 2, 3, 4, 5, 6));
        put("hash3", Set.of(1, 2, 3, 4, 5, 7));
        put("hash4", Set.of(1, 2, 3, 4, 5, 8));
    }};

    @Test
    @DisplayName("module should give a list of 2 winners")
    public void check_result_and_return_list_with_2_winners() {
        // given
        given(numberReceiverFacade.allNumbersFromUsers())
                .willReturn(usersNumbers);
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        given(lottoNumberGenerator.winningNumbers())
                .willReturn(winningNumbers);

        // when
        resultCheckerFacade.checkResult();
        Map<String, Set<Integer>> winners = resultCheckerFacade.getResults();

        // then
        assertAll(
                () -> assertEquals(2, winners.size())
                //() -> assertThat(winners, hasKey("hash1")),
                //() -> assertThat(winners.keySet(), contains("hash1")),
                //() -> assertThat(winners, hasValue(Set.of(1, 2, 3, 4, 5, 6)))
        );
    }

    @Test
    @DisplayName("module should give an empty list without any winners")
    public void check_result_and_return_empty_list_without_any_winners() {
        // given
        given(numberReceiverFacade.allNumbersFromUsers())
                .willReturn(usersNumbers);
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 99);
        given(lottoNumberGenerator.winningNumbers())
                .willReturn(winningNumbers);

        // when
        resultCheckerFacade.checkResult();
        Map<String, Set<Integer>> winners = resultCheckerFacade.getResults();

        // then
        assertAll(
                () -> assertEquals(0, winners.size())
                //() -> assertThat(winners, hasKey("hash1")),
                //() -> assertThat(winners.keySet(), contains("hash1")),
                //() -> assertThat(winners, hasValue(Set.of(1, 2, 3, 4, 5, 6)))
        );
    }
}