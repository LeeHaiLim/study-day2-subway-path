package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.dto.SectionDto;
import subway.exception.ErrorMessage;
import java.util.List;

public class StationInfo {

    private List<Station> stations;
    private List<Integer> distance;
    private List<Integer> time;

    public StationInfo(List<Station> stations, List<Integer> distance, List<Integer> time) {
        validateData(stations, distance);
        validateData(stations, time);
        this.stations = stations;
        this.distance = distance;
        this.time = time;
    }

    private void validateData(List<Station> stations, List<Integer> data) {
        if (stations.size() - 1 != data.size() || isPositiveIntegers(data)) {
            throw new IllegalArgumentException(ErrorMessage.STATION_FORM_INVALID.getMessage());
        }
    }

    private boolean isPositiveIntegers(List<Integer> integers) {
        for (int integer : integers) {
            if (integer <= 0) {
                return false;
            }
        }
        return true;
    }

    public void setGraphByDistance(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        addVertex(graph);
        setWeightByDistance(graph);
    }

    public void setGraphByTime(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        addVertex(graph);
        setWeightByTime(graph);
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

    private void setWeightByTime(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        for (int index = 0; index < distance.size(); index++) {

            Station beforeStation = stations.get(index);
            Station afterStation = stations.get(index +1);
            int time = this.time.get(index);

            graph.setEdgeWeight(graph.addEdge(beforeStation, afterStation), time);
        }
    }

    public boolean isExistNextTo(Station station1, Station station2) {
        for (int index = 0; index < stations.size()-1; index++) {
            if (isMatched(station1, station2, index)) {
                return true;
            }
        }
        return false;
    }

    public SectionDto getDistanceDto(Station station1, Station station2) {
        for (int index = 0; index < stations.size()-1; index++) {
            if (isMatched(station1, station2, index)) {
                return new SectionDto(distance.get(index), time.get(index));
            }
        }
        return null;
    }

    private boolean isMatched(Station station1, Station station2, int index) {
        return stations.get(index).isEqual(station1)
                && stations.get(index+1).isEqual(station2)
                || stations.get(index).isEqual(station2)
                && stations.get(index+1).isEqual(station1);
    }


}
