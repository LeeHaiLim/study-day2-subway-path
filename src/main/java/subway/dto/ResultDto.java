package subway.dto;

import java.util.List;

public class ResultDto {

    private final List<String> stations;
    private final int totalDistance;
    private final int totalTime;

    public ResultDto(List<String> stations, int totalDistance, int totalTime) {
        this.stations = stations;
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
    }

    public List<String> getStations() {
        return stations;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public int getTotalTime() {
        return totalTime;
    }
}
