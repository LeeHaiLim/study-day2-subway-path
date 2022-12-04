package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isEqual(Station station) {
        return name.equals(station.getName());
    }

    public boolean isEqual(String stationName) {
        return name.equals(stationName);
    }

    // 추가 기능 구현
}
