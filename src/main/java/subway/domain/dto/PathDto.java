package subway.domain.dto;

import java.util.Collections;
import java.util.List;

public class PathDto {
    private final int totalDistance;
    private final int totalTime;
    private final List<String> path;

    public PathDto(List<Integer> totalDiatanceAndTime, List<String> path) {
        this.totalDistance = totalDiatanceAndTime.get(0);
        this.totalTime = totalDiatanceAndTime.get(1);
        this.path = path;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public List<String> getPath() {
        return path;
    }
}
