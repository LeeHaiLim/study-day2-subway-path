package subway;

import subway.domain.controller.SubwayPathController;
import subway.domain.line.LineService;
import subway.domain.section.SectionService;
import subway.domain.station.StationService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayPathController subwayPathController = new SubwayPathController(
                new LineService(), new StationService(), new SectionService()
        );
        subwayPathController.run();
        subwayPathController.runMain(scanner);
    }
}
