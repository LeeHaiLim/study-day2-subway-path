package subway;

import java.util.List;
import java.util.Scanner;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.Edge;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.MyGraph;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    private MyGraph graph = new MyGraph();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public static void main(String[] args) {
        Application application = new Application();
        final Scanner scanner = new Scanner(System.in);

        application.run(scanner);
    }

    public Application() {
        StationRepository.addAllStationByName(
                List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));
        LineRepository.addAllLineByName(List.of("2호선", "3호선", "신분당선"));

        LineRepository.addEdgeByName("2호선", new Edge("교대역", "강남역", 2, 3));
        LineRepository.addEdgeByName("2호선", new Edge("교대역", "역삼역", 2, 3));
        LineRepository.addEdgeByName("3호선", new Edge("교대역", "남부터미널역", 3, 2));
        LineRepository.addEdgeByName("3호선", new Edge("남부터미널역", "양재역", 6, 5));
        LineRepository.addEdgeByName("3호선", new Edge("양재역", "매봉역", 1, 1));
        LineRepository.addEdgeByName("신분당선", new Edge("강남역", "양재역", 2, 8));
        LineRepository.addEdgeByName("신분당선", new Edge("양재역", "양재시민의숲역", 10, 3));

        graph.addAllVertex(StationRepository.stations());
        LineRepository.lines().stream().map(Line::getEdges).forEach(graph::addAllEdge);
    }

    public void run(Scanner scanner) {
        while (true) {
            outputView.printMainMenu();
            MainMenu menu = getInputMainMenu(scanner);
            if (menu.isQuit()) {
                break;
            }
            runPath(scanner);
        }
    }

    public void runPath(Scanner scanner) {
        outputView.printPathMenu();
        PathMenu menu = getInputPathMenu(scanner);
        if (menu.equals(PathMenu.BACK)) {
            return;
        }
        Station start = getInputStationStart(scanner);
        Station end = getInputStationEnd(start, scanner);
        if (menu.equals(PathMenu.DISTANCE)) {
            setEdgeWeightByDistance();
            DijkstraShortestPath<Station, Edge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
            outputView.printResult(dijkstraShortestPath.getPath(start, end).getEdgeList(),
                    dijkstraShortestPath.getPath(start, end).getVertexList());
        }
        if (menu.equals(PathMenu.TIME)) {
            setEdgeWeightByTime();
            DijkstraShortestPath<Station, Edge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
            outputView.printResult(dijkstraShortestPath.getPath(start, end).getEdgeList(),
                    dijkstraShortestPath.getPath(start, end).getVertexList());
        }
    }

    public MainMenu getInputMainMenu(Scanner scanner) {
        try {
            return MainMenu.findMenu(inputView.readInputFeature(scanner));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getInputMainMenu(scanner);
        }
    }

    public PathMenu getInputPathMenu(Scanner scanner) {
        try {
            return PathMenu.findMenu(inputView.readInputFeature(scanner));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getInputPathMenu(scanner);
        }
    }

    public Station getInputStationStart(Scanner scanner) {
        try {
            return StationRepository.getStation(inputView.readStationStart(scanner));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getInputStationStart(scanner);
        }
    }

    public Station getInputStationEnd(Station start, Scanner scanner) {
        try {
            Station end = StationRepository.getStation(inputView.readStationEnd(scanner));
            if (start.equals(end)) {
                throw new IllegalArgumentException("출발역과 도착역이 같습니다.");
            }
            return end;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getInputStationEnd(start, scanner);
        }
    }

    public void setEdgeWeightByTime() {
        LineRepository.lines().stream()
                .map(Line::getEdges)
                .forEach(edges -> edges.forEach(graph::setEdgeWeightByTime));
    }

    public void setEdgeWeightByDistance() {
        LineRepository.lines().stream()
                .map(Line::getEdges)
                .forEach(edges -> edges.forEach(graph::setEdgeWeightByDistance));
    }
}
