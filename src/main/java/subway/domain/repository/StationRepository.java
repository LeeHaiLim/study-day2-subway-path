package subway.domain.repository;

import subway.domain.model.Station;

import java.util.*;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static Station findByName(String name) {
        return stations.stream()
                .filter(station -> name.equals(station.getName()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력된 이름의 역이 존재하지 않습니다."));
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }
}
