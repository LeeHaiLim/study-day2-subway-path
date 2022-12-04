package subway.helper;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.StationInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapInitializer {

    private static final List<String> stationNames = List.of(
                "교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static final Map<String, Station> initialStation = new HashMap<>();
    private static final List<Line> lines = new ArrayList<>();

    static {
        initializeStation();
        initializeLine();
    }

    private static void initializeStation() {
        for (String stationName : stationNames) {
            initialStation.put(stationName, new Station(stationName));
        }
    }

    private static Station get(String name) {
        return initialStation.get(name);
    }

    private static void initializeLine() {
        lines.add(new Line("2호선", new StationInfo(
                        List.of(get("교대역"), get("강남역"),get("역삼역")),
                        List.of(2,2),
                        List.of(3,3)
                )));
        lines.add(new Line("3호선", new StationInfo(
                List.of(get("교대역"), get("남부터미넣"),get("양재역"),get("매봉역")),
                List.of(3,6,1),
                List.of(2,5,1)
        )));
        lines.add(new Line("2호선", new StationInfo(
                List.of(get("강남역"), get("양재역"),get("양재시민의숲역")),
                List.of(2,10),
                List.of(8,3)
        )));
    }

    public static List<Station> getStations() {
        return initialStation.values().stream()
                .collect(Collectors.toList());
    }

    public static List<Line> getLines() {
        return lines;
    }
}
