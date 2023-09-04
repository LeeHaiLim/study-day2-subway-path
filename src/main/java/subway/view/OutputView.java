package subway.view;

import java.util.List;
import subway.domain.Edge;
import subway.domain.Station;

public class OutputView {
    public void printMainMenu() {
        System.out.println("## 메인 화면\n"
                + "1. 경로 조회\n"
                + "Q. 종료\n");
    }

    public void printPathMenu() {
        System.out.println("## 경로 기준\n"
                + "1. 최단 거리\n"
                + "2. 최소 시간\n"
                + "B. 돌아가기\n");
    }

    public void printResult(List<Edge> edges, List<Station> stations) {
        int totalTime = edges.stream().mapToInt(Edge::getTime).sum();
        int totalDistance = edges.stream().mapToInt(Edge::getDistance).sum();
        System.out.println("## 조회 결과\n"
                + "[INFO] ---\n"
                + "[INFO] 총 거리: " + totalDistance + "km\n"
                + "[INFO] 총 소요 시간: " + totalTime + "분\n"
                + "[INFO] ---");
        stations.forEach(station -> System.out.println("[INFO]" + station.getName()));
        System.out.println();
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] "+message);
    }
}
