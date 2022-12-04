package subway.domain;

import subway.dto.SectionDto;
import subway.exception.ErrorMessage;
import subway.helper.MapInitializer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    static {
        addLines(MapInitializer.getLines());
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLines(List<Line> lines) {
        for (Line line : lines) {
            addLine(line);
        }
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

    public static SectionDto getSectionDto(Station station1, Station station2) {
        for (Line line : lines) {
            SectionDto result = line.getDistanceDto(station1, station2);
            if (result != null) {
                return result;
            }
        }

        throw new IllegalArgumentException(ErrorMessage.SERVICE_ERROR.getMessage());
    }
}
