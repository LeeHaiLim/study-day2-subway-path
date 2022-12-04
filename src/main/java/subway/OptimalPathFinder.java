package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.model.Path;
import subway.domain.model.Section;
import subway.domain.model.Station;
import subway.domain.repository.SectionRepository;
import subway.domain.repository.StationRepository;

import java.util.List;

public class OptimalPathFinder {

    public static final WeightedMultigraph<Station, DefaultWeightedEdge> shortestDistanceGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    public static final WeightedMultigraph<Station, DefaultWeightedEdge> minimunTimeGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public void init() {
        for (int i = 0; i < StationRepository.stations().size(); i++) {
            shortestDistanceGraph.addVertex(StationRepository.stations().get(i));
            minimunTimeGraph.addVertex(StationRepository.stations().get(i));
        }

        for (int i = 0; i < SectionRepository.sections().size(); i++) {
            Section section = SectionRepository.sections().get(i);
            shortestDistanceGraph.setEdgeWeight(shortestDistanceGraph.addEdge(section.getUpBoundStation(),
                    section.getDownBoundStation()), section.getDistance());
            minimunTimeGraph.setEdgeWeight(minimunTimeGraph.addEdge(section.getUpBoundStation(),
                    section.getDownBoundStation()), section.getTime());
        }
    }

    public Path getPath(Station startStation, Station endStation, String command) {
        List<Station> stations = findStations(startStation, endStation, command);
        int distance = getDistance(stations);
        int time = getTime(stations);
        return new Path(time, distance, stations);
    }

    private List<Station> findStations(Station startStation, Station endStation, String command) {
        DijkstraShortestPath dijkstraShortestPath = null;
        if (command.equals("1")) {
            dijkstraShortestPath = new DijkstraShortestPath(shortestDistanceGraph);
        }
        if (command.equals("2")) {
            dijkstraShortestPath = new DijkstraShortestPath(minimunTimeGraph);

        }
        try {
            return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        }catch (NullPointerException e) {
            throw new NullPointerException("[ERROR] 경로가 없습니다.");
        }

    }

    public int getDistance(List<Station> stations) {
        int distance = 0;
        for(int i = 0; i < stations.size() - 1; i++) {
            distance += shortestDistanceGraph.getEdgeWeight(shortestDistanceGraph.getEdge(stations.get(i), stations.get(i + 1)));
        }
        return distance;
    }

    public int getTime(List<Station> stations) {
        int time = 0;
        for(int i = 0; i < stations.size() - 1; i++) {
            time += minimunTimeGraph.getEdgeWeight(minimunTimeGraph.getEdge(stations.get(i), stations.get(i + 1)));
        }
        return time;
    }

}
