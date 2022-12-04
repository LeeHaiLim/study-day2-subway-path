package subway.service;

import subway.repository.WeightRepository;

public class SubwayService {
    private final WeightRepository weightRepository = WeightRepository.getInstance();
    private final StationService stationService = new StationService();
    private final LineService lineService = new LineService();


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