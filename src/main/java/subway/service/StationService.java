package subway.service;

import subway.repository.StationRepository;

public class StationService {
    private final StationRepository stationRepository = StationRepository.getInstance();

    public void addStation(String stationName) {
        if (stationRepository.findStationByName(stationName).isPresent()) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 역입니다.");
        }
        stationRepository.addStation(stationName);
    }

    public boolean isExistsStation(String stationName) {
        if (stationRepository.findStationByName(stationName).isEmpty()){
            return false;
        }
        return true;
    }

    public void init() {
        stationRepository.deleteAll();
        addStation("교대역");
        addStation("강남역");
        addStation("역삼역");
        addStation("남부터미널역");
        addStation("양재역");
        addStation("양재시민의숲역");
        addStation("매봉역");
    }
}