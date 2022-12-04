package subway.ui;

import java.util.List;

public class OutputView {
    private static final String PRE_FIX = "[INFO] ";

    public static void showMain() {
        System.out.println("## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
    }

    public static void askFunction() {
        printEmptyLine();
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public static void askDomain() {
        printEmptyLine();
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
    }

    public static void askStart() {
        printEmptyLine();
        System.out.println("## 출발역을 입력하세요.");
    }

    public static void askDestination() {
        printEmptyLine();
        System.out.println("## 도착역을 입력하세요.");
    }

    public static void printResult(List<String> results) {
        System.out.println(PRE_FIX + "---");
        System.out.println(PRE_FIX + "총 거리: " + results.get(results.size()-2) + "km");
        System.out.println(PRE_FIX + "총 소요 시간: " + results.get(results.size()-1) + "분");
        System.out.println(PRE_FIX + "---");
        List<String> stationNames = results.subList(0, results.size() - 2);
        stationNames.forEach(name -> System.out.println(PRE_FIX + name));
    }

    private static void printEmptyLine() {
        System.out.println(" ");
    }
}
