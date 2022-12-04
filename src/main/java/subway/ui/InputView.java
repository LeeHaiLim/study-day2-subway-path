package subway.ui;

import subway.Application;
import subway.domain.DomainInput;
import subway.domain.MainInput;

import java.util.Scanner;

public class InputView {
    public static MainInput insertMain(Scanner scanner) {
        return MainInput.from(scanner.nextLine());
    }

    public static DomainInput insertFunction() {
        return null;
    }

    public static String insertStart() {
        return null;
    }

    public static String insertDestination() {
        return null;
    }

}
