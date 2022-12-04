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
        return station.getName().equals(station.getName());
    }

    // 추가 기능 구현
}
