package pl.lotto.numberreceiver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumberReceiverFacadeSpec {

    NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacade();

    @Test
    @DisplayName("should receive 6 numbers and return they are accepted")
    public void a() {
        // when
        ResultMessageDto result = numberReceiverFacade.inputNumbers(asList(1, 2, 3, 4, 5, 6));

        // then
        ResultMessageDto not_good_job = new ResultMessageDto("all good", "jaamn");
        assertThat(result).isEqualTo(not_good_job);
    }

    @Test
    @DisplayName("should receive 6 numbers and return they are falsed")
    public void ba() {
        // when
        ResultMessageDto result = numberReceiverFacade.inputNumbers(asList(1, 2, 3, 4, 5));

        // then
        ResultMessageDto not_good_job = new ResultMessageDto("not good", "jaamn");
        assertThat(result).isEqualTo(not_good_job);
    }

}
