package pl.lotto.numberreceiver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumberReceiverFacadeSpec {

    NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacade();
    String SOME_HASH = "hash";

    @Test
    @DisplayName("should receive 6 numbers and return they are accepted")
    public void receive_six_numbers_and_return_they_are_accepted() {
        // when
        ResultMessageDto result = numberReceiverFacade.inputNumbers(Set.of(1, 2, 3, 4, 5, 6));

        // then
        ResultMessageDto accepted = new ResultMessageDto("Accepted", SOME_HASH);
        assertThat(result.getMessage()).isEqualTo(accepted.getMessage());
    }

    @Test
    @DisplayName("should receive 5 numbers and return they are falsed")
    public void receive_5_numbers_and_return_they_are_falsed() {
        // when
        ResultMessageDto result = numberReceiverFacade.inputNumbers(Set.of(1, 2, 3, 4, 5));

        // then
        ResultMessageDto not_accepted = new ResultMessageDto("Not accepted", SOME_HASH);
        assertThat(result.getMessage()).isEqualTo(not_accepted.getMessage());
    }

    @Test
    @DisplayName("should receive 7 numbers and return they are falsed")
    public void receive_7_numbers_and_return_they_are_falsed() {
        // when
        ResultMessageDto result = numberReceiverFacade.inputNumbers(Set.of(1, 2, 3, 4, 5, 6, 7));

        // then
        ResultMessageDto not_accepted = new ResultMessageDto("Not accepted", SOME_HASH);
        assertThat(result.getMessage()).isEqualTo(not_accepted.getMessage());
    }

    @Test
    @DisplayName("should receive 6 numbers out of range and return they are falsed")
    public void receive_6_numbers_out_of_range_and_return_they_are_falsed() {
        // when
        ResultMessageDto result = numberReceiverFacade.inputNumbers(Set.of(1, 2, 3, 4, 5, 100));

        // then
        ResultMessageDto not_accepted = new ResultMessageDto("Not accepted", SOME_HASH);
        assertThat(result.getMessage()).isEqualTo(not_accepted.getMessage());
    }
}
