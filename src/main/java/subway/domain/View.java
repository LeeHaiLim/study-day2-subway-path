package subway.domain;

import java.util.Scanner;

public class View {

    private static final String SELECT_FEATURE = "## 원하는 기능을 선택하세요.";
    private static final String MAIN_SCREEN = "## 메인화면\n" +
                                                "1. 경로조회\n" +
                                                "Q. 종료\n";
    private static final String PATH_CRITERIA = "## 경로 기준\n" +
                                                "1. 최단 거리\n" +
                                                "2. 최소 시간\n" +
                                                "B. 돌아가기\n";
    private static final String ENTER_START_POINT = "## 출발역을 입력하세요.";
    private static final String ENTER_END_POINT = "## 도착역을 입력하세요.";
    private static final String INQUIRY_RESULT = "## 조회 결과";

    public String selectFeature(Scanner sc) {
        System.out.println(SELECT_FEATURE);
        return sc.nextLine();
    }

    public String enterStartPoint(Scanner sc) {
        System.out.println(ENTER_START_POINT);
        return sc.nextLine();
    }

    public String enterEndPoint(Scanner sc) {
        System.out.println(ENTER_END_POINT);
        return sc.nextLine();
    }

    public void printMainScreen() {
        System.out.println(MAIN_SCREEN);
    }

    public void printPathCriteria() {
        System.out.println(PATH_CRITERIA);
    }

    public void printInquiryResult() {

    }
}
