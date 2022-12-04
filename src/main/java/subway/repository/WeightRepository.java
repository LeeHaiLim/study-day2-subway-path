package subway.repository;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.HashMap;
import java.util.List;

public class WeightRepository {
    private static WeightRepository weightRepository;
    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeWeight =
            new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceWeight =
            new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final DijkstraShortestPath dijkstraTimePath =
            new DijkstraShortestPath(timeWeight);
    private static final DijkstraShortestPath dijkstraDistancePath =
            new DijkstraShortestPath(distanceWeight);

    private static final HashMap<List<String>, List<Integer>> weightInfo = new HashMap<>();

    public static WeightRepository getInstance() {
        if (weightRepository == null) {
            weightRepository = new WeightRepository();
        }
        return weightRepository;
    }

    public void addWeight(String station1, String station2, int distanceWeight, int timeWight) {
        addWeightInfo(station1, station2, distanceWeight, timeWight);
        addStation(station1, station2);
        addDistanceWight(station1, station2, distanceWeight);
        addTimeWeight(station1, station2, timeWight);
    }

    private void addStation(String station1, String station2) {
        timeWeight.addVertex(station1);
        distanceWeight.addVertex(station1);
        timeWeight.addVertex(station2);
        distanceWeight.addVertex(station2);
    }

    private void addTimeWeight(String station1, String station2, int weight) {
        timeWeight.setEdgeWeight(timeWeight.addEdge(station1, station2), weight);
    }

    private void addDistanceWight(String station1, String station2, int weight) {
        distanceWeight.setEdgeWeight(distanceWeight.addEdge(station1, station2), weight);
    }

    private void addWeightInfo(String station1, String station2, int distanceWeight, int timeWight) {
        weightInfo.put(List.of(station1, station2), List.of(distanceWeight, timeWight));
    }
    
    public List<String> getShortestDistancePath(String station1, String station2) {
        return dijkstraDistancePath.getPath(station1, station2).getVertexList();
    }

    public List<String> getMinimumTimePath(String station1, String station2) {
        return dijkstraTimePath.getPath(station1, station2).getVertexList();
    }
}
