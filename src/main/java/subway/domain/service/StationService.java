package subway.domain.service;

import subway.domain.model.Station;
import subway.domain.repository.StationRepository;

import java.util.List;

public class StationService {

    public void registerStation(String name) {
        validateStationNameLength(name);
        validateStationDuplication(name);
        StationRepository.addStation(new Station(name));
    }

    private void validateStationNameLength(String name) {
        if(name.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 역의 이름은 2글자 이상이어야 합니다.");
        }
    }

    private void validateStationDuplication(String name) {
        if(StationRepository.findByName(name) != null) {
            throw new IllegalArgumentException("[ERROR] 입력한 역은 이미 등록되어있습니다.");
        }
    }

    public void deleteStation(String name) {
        if(StationRepository.findByName(name) == null) {
            throw new IllegalArgumentException("[ERROR] 입력하신 역은 존재하지 않습니다.");
        }
        StationRepository.deleteStation(name);
    }

    public List<Station> findAll() {
        return StationRepository.stations();
    }

    public Station findByName(String name) {
        return StationRepository.findByName(name);
    }

    public void deleteAll() {
        StationRepository.deleteAll();
    }

}
