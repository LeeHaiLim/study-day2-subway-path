package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class Line {
    private String name;
    private StationInfo stationInfo;

    public Line(String name, StationInfo stationInfo) {
        this.name = name;
        this.stationInfo = stationInfo;
    }

    public String getName() {
        return name;
    }

    public void setGraphByDistance(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        stationInfo.setGraphByDistance(graph);
    }

    // 추가 기능 구현
}
