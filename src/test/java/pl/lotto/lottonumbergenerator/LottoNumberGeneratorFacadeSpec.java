package pl.lotto.lottonumbergenerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static pl.lotto.configuration.GameConfiguration.AMOUNT_OF_NUMBERS;

class LottoNumberGeneratorFacadeSpec {

    final LottoNumberGeneratorFacade lottoNumberGeneratorFacade =
            new LottoNumberGeneratorConfiguration().lottoNumberGeneratorFacade();

    @Test
    @DisplayName("module should draw numbers and return collection with them")
    public void module_should_draw_numbers_and_return_collection_with_proper_amount_of_numbers() {
        // given
        // when
        Set<Integer> winningNumbers = lottoNumberGeneratorFacade.winningNumbers();

        // then
        assertAll(
                () -> assertNotNull(winningNumbers),
                () -> assertEquals(AMOUNT_OF_NUMBERS, winningNumbers.size())
        );
    }
}