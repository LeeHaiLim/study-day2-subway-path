package subway.view;

import java.util.Scanner;

public class InputView {

    public String readMenu(Scanner scanner) {
        System.out.println("\n## 원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

    public String readStation(Scanner scanner) {
        return scanner.nextLine();
    }

}
