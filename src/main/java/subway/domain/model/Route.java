package subway.domain.model;

import java.util.List;

public class Route {

    private int time;
    private int distance;
    private List<Station> stationsOnTheRoute;

    public Route(int time, int distance, List<Station> stationsOnTheRoute) {
        this.time = time;
        this.distance = distance;
        this.stationsOnTheRoute = stationsOnTheRoute;
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }

    public List<Station> getStationsOnTheRoute() {
        return stationsOnTheRoute;
    }
}