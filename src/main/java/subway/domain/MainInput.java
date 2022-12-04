package subway.domain;

import java.util.Arrays;

public enum MainInput {
    START("1"),
    END("Q");

    private final String mainInput;

    MainInput(String mainInput) {
        this.mainInput = mainInput;
    }

    public static MainInput from(String mainInput) {
        return Arrays.stream(MainInput.values())
                .filter(main -> main.mainInput.equals(mainInput))
                .findAny().orElseThrow(() -> new IllegalArgumentException("[ERROR] "));
    }
}
