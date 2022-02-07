package pl.lotto.numberreceiver;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumberReceiverFacadeSpec {

    final NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacade();
    final String SOME_HASH = "hash";

    @Test
    @DisplayName("module should accept when user gave exactly 6 numbers in range")
    public void receive_six_numbers_and_return_they_are_accepted() {
        // when
        ResultMessage result = numberReceiverFacade.inputNumbers(Set.of(1, 2, 3, 4, 5, 6));

        // then
        ResultMessage accepted = new ResultMessage("Accepted", SOME_HASH);
        assertThat(result).isEqualTo(accepted);
    }

    @Test
    @DisplayName("module should not accept when user gave less than 6 numbers")
    public void receive_5_numbers_and_return_they_are_falsed() {
        // when
        ResultMessage result = numberReceiverFacade.inputNumbers(Set.of(1, 2, 3, 4, 5));

        // then
        ResultMessage not_accepted = new ResultMessage("Not accepted", "False");
        assertThat(result).isEqualTo(not_accepted);
    }

    @Test
    @DisplayName("module should not accept when user gave more than 6 numbers")
    public void receive_7_numbers_and_return_they_are_falsed() {
        // when
        ResultMessage result = numberReceiverFacade.inputNumbers(Set.of(1, 2, 3, 4, 5, 6, 7));

        // then
        ResultMessage not_accepted = new ResultMessage("Not accepted", "False");
        assertThat(result).isEqualTo(not_accepted);
    }

    @Test
    @DisplayName("module should not accept when user gave number out of range")
    public void receive_6_numbers_out_of_range_and_return_they_are_falsed() {
        // when
        ResultMessage result = numberReceiverFacade.inputNumbers(Set.of(1, 2, 3, 4, 5, 100));

        // then
        ResultMessage not_accepted = new ResultMessage("Not accepted", "False");
        assertThat(result).isEqualTo(not_accepted);
    }
}
