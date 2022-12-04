package subway.domain;

import java.util.Arrays;

public enum DomainInput {
    DISTANCE_DOMAIN("1"),
    TIME_DOMAIN("2"),
    GO_BACK("B");

    private final String domainInput;

    DomainInput(String domainInput) {
        this.domainInput = domainInput;
    }

    public static DomainInput from(String domainInput) {
        return Arrays.stream(DomainInput.values())
                .filter(domain -> domain.domainInput.equals(domainInput))
                .findAny().orElseThrow(() -> new IllegalArgumentException("[ERROR]"));
    }
}
