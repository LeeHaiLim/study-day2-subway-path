package subway.domain.controller;

import subway.domain.line.LineService;
import subway.domain.section.SectionService;
import subway.domain.station.Station;
import subway.domain.station.StationService;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SubwayPathController {
    private final LineService lineService;
    private final StationService stationService;
    private final SectionService sectionService;

    public SubwayPathController(LineService lineService, StationService stationService, SectionService sectionService) {
        this.lineService = lineService;
        this.stationService = stationService;
        this.sectionService = sectionService;
    }

    public void run() {
        init();
    }

    private void init() {
        initStation();
        initLine();
        initSection();
    }

    private void initStation() {
        List<String> stationNames = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        stationService.createStations(stationNames);
    }

    private void initLine() {
        List<Station> secondLineStations = Arrays.asList(
                new Station("교대역"), new Station("강남역"), new Station("역삼역"));
        List<Station> thirdLineStations = Arrays.asList(new Station("교대역"),
                new Station("남부터미널역"), new Station("양재역"), new Station("매봉역"));
        List<Station> newLineStations = Arrays.asList(
                new Station("강남역"), new Station("양재역"), new Station("양재시민의숲역"));

        List<List<Station>> stations = Arrays.asList(secondLineStations, thirdLineStations, newLineStations);
        List<String> lineNames = Arrays.asList("2호선", "3호선", "신분당선");
        lineService.createLines(stations, lineNames);
    }

    private void initSection() {
        sectionService.createSection("교대역", "강남역", "2호선", 3, 2);
        sectionService.createSection("강남역", "역삼역", "2호선", 3, 2);
        sectionService.createSection("교대역", "남부터미널역", "3호선", 2, 3);
        sectionService.createSection("남부터미널역", "양재역", "3호선", 5, 6);
        sectionService.createSection("양재역", "매봉역", "3호선", 1, 1);
        sectionService.createSection("강남역", "양재역", "신분당선", 8, 2);
        sectionService.createSection("양재역", "양재시민의숲역", "신분당선", 3, 10);
    }

    public static <T> T retryUntilSuccess(Supplier<T> supplier) {
        while(true){
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
