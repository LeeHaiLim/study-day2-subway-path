package subway.domain;

import subway.exception.ErrorMessage;
import subway.helper.MapInitializer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    static {
        addStations(MapInitializer.getStations());
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static Station getStation(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return station;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.STATION_NOT_EXIST.getMessage());
    }

    public static void addStation(Station station) {
        if (isInStationRepository(station)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_IN_STATION_REPOSITORY.getMessage());
        }
        stations.add(station);
    }

    public static void addStations(List<Station> stations) {
        for (Station station : stations) {
            addStation(station);
        }
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    private static boolean isInStationRepository(Station station) {
        for (Station stationInRepository : stations) {
            if (stationInRepository.isEqual(station)) {
                return true;
            }
        }
        return false;
    }
}
