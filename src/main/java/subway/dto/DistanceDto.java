package subway.dto;

public class DistanceDto {

    private int distance;
    private int time;

    public DistanceDto(int distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
