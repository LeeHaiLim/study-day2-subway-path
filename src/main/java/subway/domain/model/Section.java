package subway.domain.model;

public class Section {
    private String upBoundStation;
    private String downBoundStation;
    private int time;
    private int distance;

    public Section(String upBoundStation, String downBoundStation, int time, int distance) {
        this.upBoundStation = upBoundStation;
        this.downBoundStation = downBoundStation;
        this.time = time;
        this.distance = distance;
    }

    public String getUpBoundStation() {
        return upBoundStation;
    }

    public String getDownBoundStation() {
        return downBoundStation;
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }
}
