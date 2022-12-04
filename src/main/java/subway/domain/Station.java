package subway.domain;

import subway.exception.ErrorMessage;

public class Station {
    private String name;

    public Station(String name) {
        validateStation(name);
        this.name = name;
    }

    private void validateStation(String name) {
        if (!name.endsWith("역") || name.length() < 2) {
            throw new IllegalArgumentException(ErrorMessage.STATION_NAME_INVALID.getMessage());
        }
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
}
