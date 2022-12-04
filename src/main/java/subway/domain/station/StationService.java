package subway.domain.station;

import java.util.List;
import java.util.stream.Collectors;

public class StationService {

    public void createStations(List<String> stationNames) {
        List<Station> stations = stationNames.stream()
                .map(Station::new)
                .collect(Collectors.toList());
        StationRepository.saveAll(stations);
    }
}
