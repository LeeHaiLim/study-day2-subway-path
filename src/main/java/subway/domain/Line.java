package subway.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private String name;
    private List<Station> stations;

    private Line(String name, List<Station> stations) {
        this.name = name;
        this.stations = stations;
    }

    public static Line of(String name, List<Station> stations) {
        return new Line(name, stations);
    }



    public String getName() {
        return name;
    }

    public List<String> findStationNamesByLine() {
        return stations.stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }
}