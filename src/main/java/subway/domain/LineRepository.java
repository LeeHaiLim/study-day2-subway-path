package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void addAllLine(List<Line> lines) {
        LineRepository.lines.addAll(lines);
    }

    public static void addAllLineByName(List<String> lines) {
        addAllLine(lines.stream().map(Line::new).collect(Collectors.toList()));
    }

    public static void addEdgeByName(String name, Edge edge) {
        getLine(name).addEdge(edge);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    public static Line getLine(String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
