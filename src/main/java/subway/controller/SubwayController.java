package subway.controller;

import subway.domain.Menu.MainMenu;
import subway.domain.Menu.PathMenu;
import subway.domain.dto.PathDto;
import subway.service.SubwayService;
import subway.view.InputMessage;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class SubwayController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final SubwayService subwayService = new SubwayService();
    private final Scanner scanner;

    public SubwayController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        MainMenu menu = null;
        while (menu != MainMenu.QUIT) {
            try {
                InputMessage.showMainMenu();
                menu = MainMenu.from(inputView.readMenu(scanner));
                runService(menu);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void runService(MainMenu menu) {
        if (menu == MainMenu.ROUTE_INFO) {
            choiceService();
        }
    }

    private void choiceService() {
        while (true) {
            try {
                InputMessage.showPathMenu();
                PathMenu pathMenu = PathMenu.from(inputView.readMenu(scanner));
                findMenu(pathMenu);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void findMenu(PathMenu pathMenu) {
        if (pathMenu == PathMenu.SHORTEST_DISTANCE) {
            // runShortestDistance();
        }
        if (pathMenu == PathMenu.MINIMUM_TIME) {
            // runMinimumTime();
        }
    }
}