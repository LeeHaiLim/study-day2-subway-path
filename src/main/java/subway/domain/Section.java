package subway.domain;

public class Section {
    private final Station start;
    private final Station end;
    private final Line line;
    private final int time;
    private final int distance;

    public Section(Station start, Station end, Line line, int time, int distance) {
        this.start = start;
        this.end = end;
        this.line = line;
        this.time = time;
        this.distance = distance;
    }

    public int getTime() {
        return this.time;
    }

    public int getDistance() {
        return this.distance;
    }

    public Station getStart() {
        return start;
    }

    public Station getEnd() {
        return end;
    }
}
