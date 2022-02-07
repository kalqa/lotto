package pl.lotto.numberreceiver;

import lombok.Value;

@Value
class ResultMessage {
    String message;
    String hash;
}
