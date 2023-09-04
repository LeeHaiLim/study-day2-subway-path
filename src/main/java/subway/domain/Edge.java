package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;

public class Edge extends DefaultWeightedEdge{
    private final Station source;
    private final Station target;
    private final int distance;
    private final int time;

    public Edge(Station source, Station target, int distance, int time) {
        this.source = source;
        this.target = target;
        this.distance = distance;
        this.time = time;
    }

    public Edge(String source, String target, int distance, int time) {
        this.source = StationRepository.getStation(source);
        this.target = StationRepository.getStation(target);
        this.distance = distance;
        this.time = time;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public Station getSource() {
        return source;
    }

    public Station getTarget() {
        return target;
    }

}
