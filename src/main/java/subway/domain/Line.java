package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final String name;
    private List<Edge> edges = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
