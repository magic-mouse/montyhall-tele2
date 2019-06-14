package se.regent.kodtest.montyhall.simulator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WinType {

    SWITCHED(0), STAYED(1), LOST(2);

    private final int value;
}
