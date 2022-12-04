package subway.ui;

import subway.Application;
import subway.domain.DomainInput;
import subway.domain.MainInput;

import java.util.Scanner;

public class InputView {

    public static MainInput insertMain(Scanner scanner) {
        return MainInput.from(scanner.nextLine());
    }

    public static DomainInput insertFunction(Scanner scanner) {
        return DomainInput.from(scanner.nextLine());
    }

    public static String insertStart(Scanner scanner) {
        return scanner.nextLine();
    }

    public static String insertDestination(Scanner scanner) {
        return scanner.nextLine();
    }

}