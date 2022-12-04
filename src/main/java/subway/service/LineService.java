package subway.service;

import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LineService {
    private final StationRepository stationRepository = StationRepository.getInstance();
    private final LineRepository lineRepository = LineRepository.getInstance();

    public void addLine(String lineName, List<String> stationNames) {
        lineRepository.findLineByName(lineName).ifPresent(station -> {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 노선입니다.");
        });
        addStationToLine(lineName, stationNames);
    }

    private void addStationToLine(String lineName, List<String> stationNames) {
        validFirstAndLastStation(stationNames);
        List<Station> stations = new ArrayList<>();
        stationNames.stream()
                .forEach(stationName -> stations.add(getStation(stationName)));
        lineRepository.addLine(lineName, stations);
    }

    private Station getStation(String stationName) {
        Optional<Station> station = stationRepository.findStationByName(stationName);
        if (station.isEmpty()) {
            stationRepository.addStation(stationName);
            return stationRepository.findStationByName(stationName).get();
        }
        return station.get();
    }

    private void validFirstAndLastStation(List<String> stationNames) {
        if (stationNames.stream().distinct().count() != stationNames.size()) {
            throw new IllegalArgumentException("[ERROR] 상행 종점 역과 하행 종점 역은 같을 수 없습니다.");
        }
    }

    public void init() {
        lineRepository.deleteAll();
        addLine("2호선", List.of("교대역", "강남역", "역삼역"));
        addLine("3호선", List.of("교대역", "남부터미널역", "양재역", "매봉역"));
        addLine("신분당선", List.of("강남역","양재역","양재시민의숲역"));
    }

}
