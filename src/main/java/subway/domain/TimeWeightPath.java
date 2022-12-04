package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class TimeWeightPath {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeWeight =
            new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final DijkstraShortestPath dijkstraTimePath =
            new DijkstraShortestPath(timeWeight);

    public void addTimeWeight(String station1, String station2, int weight) {
        addStation(station1, station2);
        timeWeight.setEdgeWeight(timeWeight.addEdge(station1, station2), weight);
    }

    private void addStation(String station1, String station2) {
        timeWeight.addVertex(station1);
        timeWeight.addVertex(station2);
    }

    public List<String> getMinimumTimePath(String station1, String station2) {
        try {
            return dijkstraTimePath.getPath(station1, station2).getVertexList();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("[ERROR] 출발역과 도착역이 연결되어있지 않습니다.");
        }
    }
}