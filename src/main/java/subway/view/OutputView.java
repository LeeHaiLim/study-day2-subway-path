package subway.view;

public class OutputView {
    public void printMainMenu() {
        System.out.println("## 메인 화면\n"
                + "1. 경로 조회\n"
                + "Q. 종료");
    }

    public void printPathMenu() {
        System.out.println("## 경로 기준\n"
                + "1. 최단 거리\n"
                + "2. 최소 시간\n"
                + "B. 돌아가기");
    }
}
