package subway.dto;

public class SectionDto {

    private int distance;
    private int time;

    public SectionDto(int distance, int time) {
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
