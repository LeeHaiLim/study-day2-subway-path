package subway.domain;

import java.util.List;

public class StationService {

    public void registerStation(String name) {
        if(StationRepository.findByName(name) != null) {
            throw new IllegalArgumentException("[ERROR] 입력한 역은 이미 등록되어있습니다.");
        }
        StationRepository.addStation(new Station(name));
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
