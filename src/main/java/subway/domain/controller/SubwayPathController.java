package subway.domain.controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.DomainInput;
import subway.domain.MainInput;
import subway.domain.line.Line;
import subway.domain.line.LineService;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;
import subway.domain.section.SectionService;
import subway.domain.station.Station;
import subway.domain.station.StationService;
import subway.ui.InputView;
import subway.ui.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static subway.domain.MainInput.END;
import static subway.domain.MainInput.START;

public class SubwayPathController {
    private final LineService lineService;
    private final StationService stationService;
    private final SectionService sectionService;
    private final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
    private final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
    private final DijkstraShortestPath dijkstraShortestTimePath = new DijkstraShortestPath(timeGraph);
    private final DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);

    public SubwayPathController(LineService lineService, StationService stationService, SectionService sectionService) {
        this.lineService = lineService;
        this.stationService = stationService;
        this.sectionService = sectionService;
        setTimeGraph(timeGraph);
        setDistanceGraph(distanceGraph);
    }

    public void runMain(Scanner scanner) {
        do {
            OutputView.showMain();
            OutputView.askFunction();
            MainInput mainInput = retryUntilSuccess(() -> InputView.insertMain(scanner));
            if (mainInput.equals(END)) {
                return;
            }
            OutputView.askDomain();
            OutputView.askFunction();
            DomainInput domainInput = retryUntilSuccess(() -> InputView.insertFunction(scanner));
            navigate(domainInput, scanner);
        } while (true);
    }

    private void navigate(DomainInput domainInput, Scanner scanner) {
        if (domainInput.equals(DomainInput.GO_BACK)) {
            return;
        }
        String start = getStart(scanner);
        String destination = getDestination(scanner);
        List<String> result = new ArrayList<>();
        if (domainInput.equals(DomainInput.TIME_DOMAIN)) {
            result = getTimeDomainResult(start, destination);
        }
        if (domainInput.equals(DomainInput.DISTANCE_DOMAIN)) {
            result = getDistanceDomainResult(start, destination);
        }
        OutputView.printResult(result);
    }

    public void run() {
        init();
    }

    public List<String> getTimeDomainResult(String start, String destination) {
        List<String> shortestTimePath = dijkstraShortestTimePath.getPath(start, destination).getVertexList();
        int distance = 0;
        for (int i = 0; i < shortestTimePath.size() - 2; i++) {
            distance += dijkstraShortestPath.getPath(shortestTimePath.get(i), shortestTimePath.get(i + 1)).getWeight();
        }
        shortestTimePath.add(String.valueOf(distance));
        shortestTimePath.add(String.valueOf(dijkstraShortestTimePath.getPath(start, destination).getWeight()));
        return shortestTimePath;
    }

    public List<String> getDistanceDomainResult(String start,String destination) {
        List<String> shortestPath = dijkstraShortestPath.getPath(start, destination).getVertexList();
        shortestPath.add(String.valueOf(dijkstraShortestPath.getPath(start, destination).getWeight()));
        int time = 0;
        for (int i = 0; i < shortestPath.size() - 2; i++) {
            time += dijkstraShortestTimePath.getPath(shortestPath.get(i), shortestPath.get(i + 1)).getWeight();
        }
        shortestPath.add(String.valueOf(time));
        return shortestPath;
    }

    private void setTimeGraph(WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        List<String> stationNames = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        for (String stationName : stationNames) {
            graph.addVertex(stationName);
        }
        graph.setEdgeWeight(graph.addEdge("교대역", "강남역"), 3);
        graph.setEdgeWeight(graph.addEdge("강남역", "역삼역"), 3);
        graph.setEdgeWeight(graph.addEdge("교대역", "남부터미널역"), 2);
        graph.setEdgeWeight(graph.addEdge("남부터미널역", "양재역"), 5);
        graph.setEdgeWeight(graph.addEdge("양재역", "매봉역"), 1);
        graph.setEdgeWeight(graph.addEdge("강남역", "양재역"), 8);
        graph.setEdgeWeight(graph.addEdge("양재역", "양재시민의숲역"), 3);
    }

    private void setDistanceGraph(WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        List<String> stationNames = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        for (String stationName : stationNames) {
            graph.addVertex(stationName);
        }
        graph.setEdgeWeight(graph.addEdge("교대역", "강남역"), 2);
        graph.setEdgeWeight(graph.addEdge("강남역", "역삼역"), 2);
        graph.setEdgeWeight(graph.addEdge("교대역", "남부터미널역"), 3);
        graph.setEdgeWeight(graph.addEdge("남부터미널역", "양재역"), 6);
        graph.setEdgeWeight(graph.addEdge("양재역", "매봉역"), 1);
        graph.setEdgeWeight(graph.addEdge("강남역", "양재역"), 2);
        graph.setEdgeWeight(graph.addEdge("양재역", "양재시민의숲역"), 10);
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

    private String getDestination(Scanner scanner) {
        OutputView.askDestination();
        return InputView.insertDestination(scanner);
    }

    private String getStart(Scanner scanner) {
        OutputView.askStart();
        return InputView.insertStart(scanner);
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
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
