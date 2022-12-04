package subway.domain;

import subway.domain.model.Line;
import subway.domain.model.Section;
import subway.domain.model.Station;
import subway.domain.repository.LineRepository;
import subway.domain.repository.SectionRepository;
import subway.domain.repository.StationRepository;

public class Initializer {

    private static final String[] stations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private static final String[] lines = {"2호선", "3호선", "신분당선"};

    public static void init() {
        initStations();
        initLines();
        initSections();
    }

    public static void initStations() {
        for(String name : stations) {
            StationRepository.addStation(new Station(name));
        }
    }

    public static void initLines() {
        for(String name : lines) {
            LineRepository.addLine(new Line(name));
        }
    }

    public static void initSections() {
        SectionRepository.addSection(new Section(StationRepository.findByName("교대역"),
                StationRepository.findByName("강남역"), 3, 2));
        SectionRepository.addSection(new Section(StationRepository.findByName("강남역"),
                StationRepository.findByName("역삼역"), 3, 2));
        SectionRepository.addSection(new Section(StationRepository.findByName("교대역"),
                StationRepository.findByName("남부터미널역"), 2, 3));
        SectionRepository.addSection(new Section(StationRepository.findByName("남부터미널역"),
                StationRepository.findByName("양재역"), 5, 6));
        SectionRepository.addSection(new Section(StationRepository.findByName("양재역"),
                StationRepository.findByName("매봉역"), 1, 1));
        SectionRepository.addSection(new Section(StationRepository.findByName("강남역"),
                StationRepository.findByName("양재역"), 8, 2));
        SectionRepository.addSection(new Section(StationRepository.findByName("양재역"),
                StationRepository.findByName("양재시민의숲역"), 3, 10));
    }

}
