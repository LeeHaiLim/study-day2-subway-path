package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.dto.SectionDto;
import subway.exception.ErrorMessage;

public class Line {
    private String name;
    private StationInfo stationInfo;

    public Line(String name, StationInfo stationInfo) {
        validateName(name);
        this.name = name;
        this.stationInfo = stationInfo;
    }

    private void validateName(String name) {
        if (name.length() < 3 || !name.endsWith("선")) {
            throw new IllegalArgumentException(ErrorMessage.LINE_NAME_INVALID.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void setGraphByDistance(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        stationInfo.setGraphByDistance(graph);
    }

    public void setGraphByTime(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        stationInfo.setGraphByTime(graph);
    }

    public boolean isExistNextTo(Station station1, Station station2) {
        return stationInfo.isExistNextTo(station1, station2);
    }

    public SectionDto getDistanceDto(Station station1, Station station2) {
        return stationInfo.getDistanceDto(station1, station2);
    }
}
