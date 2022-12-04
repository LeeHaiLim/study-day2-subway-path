package subway.domain;

import subway.OptimalPathFinder;
import subway.domain.model.Path;
import subway.domain.model.Station;

import java.util.Scanner;

public class SubwayController {

    private final View view = new View();
    Scanner scanner;

    public SubwayController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        Initializer.init();
        while(true) {
            view.printMainScreen();
            String input = view.selectFeature(scanner);
            if(input.equals("Q")) {
                break;
            }
            if(input.equals("1")) {
                inquiryPath();
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 올바른 기능이 아닙니다.");
        }
    }

    public void inquiryPath() {
        view.printPathCriteria();
        String input = view.selectFeature(scanner);
        if(input.equals("B")) {
            return;
        }
        if(input.equals("1") || input.equals("2")) {
            enterPath(input);
            return;
        }
        throw new IllegalArgumentException("[ERROR] 올바른 기능이 아닙니다.");
    }

    public void enterPath(String input) {
        // 출발역이랑 도착역 검증해야됨
        Station start = new Station(view.enterStartPoint(scanner));
        Station end = new Station(view.enterEndPoint(scanner));

        // 같은 역인지 검사하고
        checkSameStation(start, end);

        // 1번 or 2번으로 선택했던 걸로메소드에 의해서 어떤 결과물 객체 가져오기 ex) result

        OptimalPathFinder pathFinder = new OptimalPathFinder();
        pathFinder.init();

        Path path = pathFinder.getPath(start, end, input);

        // 그 결과물 객체에 담긴 내용 출력
        view.printInquiryResult(path);
    }

    private void checkSameStation(Station start, Station end) {
        if(start.getName().equals(end.getName())) {
            throw new IllegalArgumentException("[ERROR] 출발역과 도착역이 같습니다.");
        }
    }
}
