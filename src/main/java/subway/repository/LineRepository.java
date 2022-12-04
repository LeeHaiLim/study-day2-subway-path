package subway.repository;

import subway.domain.Line;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class LineRepository {
    private static LineRepository lineRepository;
    private static final List<Line> lines = new ArrayList<>();

    public static LineRepository getInstance() {
        if (lineRepository == null) {
            lineRepository = new LineRepository();
        }
        return lineRepository;
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(String lineName, List<Station> stations) {
        lines.add(Line.of(lineName, stations));
    }

    public static void deleteAll() {
        lines.clear();
    }

    public static Optional<Line> findLineByName(String lineName) {
        return lines.stream()
                .filter(line -> line.getName().equals(lineName))
                .findAny();
    }
}