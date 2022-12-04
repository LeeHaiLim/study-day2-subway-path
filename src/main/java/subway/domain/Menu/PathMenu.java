package subway.domain.Menu;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PathMenu {
    SHORTEST_DISTANCE("1"),
    MINIMUM_TIME("2"),
    BACK("B");

    private final String code;

    PathMenu(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    private static final Map<String, PathMenu> menus =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(PathMenu::getCode, Function.identity())));

    public static PathMenu from(String number) {
        return Optional.ofNullable(menus.get(number)).orElseThrow(
                () -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }
}
