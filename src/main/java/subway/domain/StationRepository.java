package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static void addAllStation(List<Station> stations) {
        StationRepository.stations.addAll(stations);
    }

    public static void addAllStationByName(List<String> stations) {
        addAllStation(stations.stream().map(Station::new).collect(Collectors.toList()));
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    public static Station getStation(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
