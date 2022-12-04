package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class DistanceWeightPath {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceWeight =
            new WeightedMultigraph(DefaultWeightedEdge.class);

    private static final DijkstraShortestPath dijkstraDistancePath =
            new DijkstraShortestPath(distanceWeight);

    
    public void addDistanceWeight(String station1, String station2, int weight) {
        addStation(station1, station2);
        distanceWeight.setEdgeWeight(distanceWeight.addEdge(station1, station2), weight);
    }
    
    private void addStation(String station1, String station2) {
        distanceWeight.addVertex(station1);
        distanceWeight.addVertex(station2);
    }


    public List<String> getShortestDistancePath(String station1, String station2) {
        try {
            return dijkstraDistancePath.getPath(station1, station2).getVertexList();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("[ERROR] 출발역과 도착역이 연결되어있지 않습니다.");
        }
    }



}
