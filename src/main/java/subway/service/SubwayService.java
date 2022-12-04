package subway.service;

import subway.repository.WeightRepository;

import java.util.List;

public class SubwayService {
    private final WeightRepository weightRepository = WeightRepository.getInstance();
    private final StationService stationService = new StationService();
    private final LineService lineService = new LineService();

    public List<String> getShortestDistancePath(String departureStation, String arrivalStation) {
        validDepartureAndArrivalStation(departureStation, arrivalStation);
        return weightRepository.getShortestDistancePath(departureStation, arrivalStation);
    }

    public List<String> getMinimumTimePath(String departureStation, String arrivalStation) {
        validDepartureAndArrivalStation(departureStation, arrivalStation);
        return weightRepository.getMinimumTimePath(departureStation, arrivalStation);
    }

    public List<Integer> getTotalDistanceAndTime(List<String> path) {
        int totalDistance = 0;
        int totalTime = 0;
        for (int idx = 0; idx < path.size() - 1; idx++) {
            List<Integer> weight = weightRepository.getWeight(path.get(idx), path.get(idx + 1));
            totalDistance += weight.get(0);
            totalTime += weight.get(1);
        }
        return List.of(totalDistance, totalTime);
    }

    private void validDepartureAndArrivalStation(String departureStation, String arrivalStation) {
        validStationEquals(departureStation, arrivalStation);
        validExistsStation(departureStation);
        validExistsStation(arrivalStation);
    }

    private void validStationEquals(String departureStation, String arrivalStation) {
        if (departureStation.equals(arrivalStation)) {
            throw new IllegalArgumentException("[ERROR] 출발역과 도착역이 동일합니다.");
        }
    }

    private void validExistsStation(String station) {
        if (!stationService.isExistsStation(station)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다.");
        }
    }

    public void init() {
        stationService.init();
        lineService.init();
        initWeight();
    }

    private void initWeight() {
        weightRepository.addWeight("교대역", "강남역", 2, 3);
        weightRepository.addWeight("강남역", "역삼역", 2, 3);
        weightRepository.addWeight("교대역", "남부터미널역", 3, 2);
        weightRepository.addWeight("남부터미널역", "양재역", 6, 5);
        weightRepository.addWeight("양재역", "매봉역", 1, 1);
        weightRepository.addWeight("강남역", "양재역", 2, 8);
        weightRepository.addWeight("양재역", "양재시민의숲역", 10, 3);
    }
}