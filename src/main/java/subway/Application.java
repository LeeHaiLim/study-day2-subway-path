package subway;

import subway.dto.PathDto;
import subway.exception.ErrorMessage;
import subway.service.SubwayService;
import subway.view.input.InputView;
import subway.view.output.OutputView;
import subway.view.output.View;
import java.util.Arrays;
import java.util.Scanner;

public class Application {

    private final static String FIRST = "1";
    private final static String SECOND = "2";
    private final static String QUIT = "Q";
    private final static String BACK = "B";

    private static InputView inputView;
    private static OutputView outputView;
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        initializeView(scanner);
        readRepeatWhenThrow(() -> run());
    }

    private static void initializeView(Scanner scanner) {
        inputView = new InputView(scanner);
        outputView = new OutputView();
    }

    private static void run() {
        String functionKey;
        do {
            outputView.printView(View.MAIN);
            functionKey = inputView.readFunction();
            validateFunctionKey(functionKey, FIRST, QUIT);
            if (functionKey.equals(FIRST)) {
                readRepeatWhenThrow(() -> findRoute());
            }
        } while (!functionKey.equals(QUIT));
    }

    private static void findRoute() {
        outputView.printView(View.PATH_STANDARD);
        String functionKey = inputView.readFunction();
        validateFunctionKey(functionKey, FIRST, SECOND, BACK);

        if (functionKey.equals(FIRST)) {
            findRouteByDistance();
        }
        if (functionKey.equals(SECOND)) {
            findRouteByTime();
        }
    }

    private static void findRouteByDistance() {
        String startStation = inputView.readStartStation();
        String endStation = inputView.readEndStation();

        PathDto result = SubwayService.getPathByDistance(startStation, endStation);
        outputView.printPathDto(result);
    }

    private static void findRouteByTime() {
        String startStation = inputView.readStartStation();
        String endStation = inputView.readEndStation();

        PathDto result = SubwayService.getPathByTime(startStation, endStation);
        outputView.printPathDto(result);
    }

    private static void validateFunctionKey(String input, String... keys) {
        if (!isCorrectInput(input, keys)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_CORRECT_KEY.getMessage());
        }
    }

    private static boolean isCorrectInput(String input, String... keys) {
        return Arrays.stream(keys)
                .map(key -> input.equals(key))
                .reduce(false, Boolean::logicalOr);
    }

    private static void readRepeatWhenThrow(Runnable method) {
        while (true) {
            try {
                method.run();
                return;
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }
}
