package subway.view.input;

import java.util.Scanner;

public class InputView {

    private final static String REQUEST_FUNCTION = "\n## 원하는 기능을 선택하세요.";
    private final static String REQUEST_START_STATION = "\n## 출발역을 입력하세요.";
    private final static String REQUEST_END_STATION = "\n## 도착역을 입력하세요.";
    private Scanner scanner;

    InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readFunction() {
        print(REQUEST_FUNCTION);
        return read();
    }

    public String readStartStation() {
        print(REQUEST_START_STATION);
        return read();
    }

    public String readEndStation() {
        print(REQUEST_END_STATION);
        return read();
    }

    private void print(String string) {
        System.out.println(string);
    }

    private String read() {
        return scanner.nextLine();
    }
}
