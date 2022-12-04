package subway.repository;

import subway.domain.Station;

import java.util.*;

public class StationRepository {
    private static StationRepository stationRepository;
    private static final List<Station> stations = new ArrayList<>();

    public static StationRepository getInstance() {
        if (stationRepository == null) {
            stationRepository = new StationRepository();
        }
        return stationRepository;
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }
    public static void addStation(String stationName) {
        stations.add(Station.from(stationName));
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
    public static void deleteAll() {
        stations.clear();
    }

    public static Optional<Station> findStationByName(String stationName) {
        return stations.stream()
                .filter(station -> station.getName().equals(stationName))
                .findAny();
    }
}