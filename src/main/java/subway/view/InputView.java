package subway.view;

import java.util.Scanner;

public class InputView {
    public String readInputFeature(Scanner scanner){
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextLine().trim();
    }

    public String readStationStart(Scanner scanner){
        System.out.println("## 출발역을 입력하세요.");
        return scanner.nextLine().trim();
    }

    public String readStationEnd(Scanner scanner){
        System.out.println("## 도착역을 입력하세요.");
        return scanner.nextLine().trim();
    }
}
