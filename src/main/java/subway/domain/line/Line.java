package subway.domain.line;

import subway.domain.station.Station;

import java.util.List;

public class Line {
    private String name;
    private List<Station> stations;

    public Line(String name, List<Station> stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    // 추가 기능 구현
}
