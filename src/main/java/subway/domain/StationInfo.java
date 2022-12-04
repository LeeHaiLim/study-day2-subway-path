package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import java.util.List;

public class StationInfo {

    private List<Station> stations;
    private List<Integer> distance;
    private List<Integer> time;

    StationInfo(List<Station> stations, List<Integer> distance, List<Integer> time) {
        this.stations = stations;
        this.distance = distance;
        this.time = time;
    }

    public void setGraphByDistance(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        addVertex(graph);
        setWeightByDistance(graph);
    }

    private void addVertex(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        for (Station station : stations) {
            graph.addVertex(station);
        }
    }

    private void setWeightByDistance(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        for (int index = 0; index < distance.size(); index++) {

            Station beforeStation = stations.get(index);
            Station afterStation = stations.get(index +1);
            int distance = this.distance.get(index);

            graph.setEdgeWeight(graph.addEdge(beforeStation, afterStation), distance);
        }
    }
}
