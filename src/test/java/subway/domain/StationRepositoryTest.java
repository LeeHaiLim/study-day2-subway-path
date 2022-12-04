package subway.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import java.util.List;

public class StationRepositoryTest {

    @Test
    void addStationTest_Exception() {
        Station station = new Station("중복역");
        StationRepository.addStation(station);

        assertThrows(IllegalArgumentException.class, () -> {
            StationRepository.addStation(station);
        });
    }

    @Test
    void addStationsTest_Exception() {
        Station station = new Station("다중중복역");

        assertThrows(IllegalArgumentException.class, () -> {
            StationRepository.addStations(List.of(station, station));
        });
    }

    @Test
    void getStationTest_Exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            StationRepository.getStation("없는역이름");
        });
    }
}
