package subway.view;

public class InputMessage {
    public static void showMainMenu() {
        System.out.println("\n## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
    }

    public static void showPathMenu() {
        System.out.println("\n## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
    }

    public static void showDepartureMessage() {
        System.out.println("## 출발역을 입력하세요.");
    }

    public static void showArrivalMessage() {
        System.out.println("## 도착역을 입력하세요.");
    }
}
