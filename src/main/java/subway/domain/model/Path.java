package subway.domain.model;

import java.util.List;

public class Path {

    private int time;
    private int distance;
    private List<Station> stationsOnThePath;

    public Path(int time, int distance, List<Station> stationsOnThePath) {
        this.time = time;
        this.distance = distance;
        this.stationsOnThePath = stationsOnThePath;
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }

    public List<Station> getStationsOnThePath() {
        return stationsOnThePath;
    }
}
