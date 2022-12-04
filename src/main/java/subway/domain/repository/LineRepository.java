package subway.domain.repository;

import subway.domain.model.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    public static Line findByName(String name) {
        return lines.stream()
                .filter(line -> name.equals(line.getName()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력된 이름의 노선이 존재하지 않습니다."));
    }
}
