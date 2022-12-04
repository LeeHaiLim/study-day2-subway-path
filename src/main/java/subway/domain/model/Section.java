package subway.domain.model;

public class Section {
    private Station upBoundStation;
    private Station downBoundStation;
    private int time;
    private int distance;

    public Section(Station upBoundStation, Station downBoundStation, int time, int distance) {
        this.upBoundStation = upBoundStation;
        this.downBoundStation = downBoundStation;
        this.time = time;
        this.distance = distance;
    }

    public Station getUpBoundStation() {
        return upBoundStation;
    }

    public Station getDownBoundStation() {
        return downBoundStation;
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }
}
