package subway.domain.model;


import java.util.List;

public class Line {
    private String name;
    private List<Station> stations;

    public Line(String name) {
        this.name = name;
    }

    public Line(String name, Station... stations) {
        this.name = name;
        for(Station station : stations) {
            this.stations.add(station);
        }
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
