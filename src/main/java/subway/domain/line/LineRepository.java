package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static void saveAll(List<Line> createdLines) {
        lines.addAll(createdLines);
    }

    public static Line findByName(String lineName) {
        return lines.stream()
                .filter(line -> line.getName().equals(lineName))
                .findAny().orElseThrow(() -> new IllegalArgumentException("[ERROR]"));
    }

    public static List<Line> findLinesByStationName(String stationName) {
        return lines().stream()
                .filter(line -> line.getStations().stream()
                        .map(Station::getName)
                        .collect(Collectors.toList()).contains(stationName))
                .collect(Collectors.toList());
    }
}
