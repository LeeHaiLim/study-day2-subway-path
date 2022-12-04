package subway.view.output;

import subway.dto.PathDto;

public class OutputView {

    private final static String RESULT_PREFIX = "[INFO] ";
    private final static String DIVIDING_LINE = "---";
    private final static String DISTANCE_FORMAT = "총 거리: %dkm";
    private final static String TIME_FORMAT = "총 소요 시간: %d분";

    public void printView(View view) {
        print(view.getText());
    }

    public void printResultDto(PathDto pathDto) {
        printResult(DIVIDING_LINE);
        printResult(String.format(DISTANCE_FORMAT, pathDto.getTotalDistance()));
        printResult(String.format(TIME_FORMAT, pathDto.getTotalTime()));
        printResult(DIVIDING_LINE);
        for (String station : pathDto.getStations()) {
            printResult(station);
        }
    }

    public void printErrorMessage(Exception exception) {
        print(exception.getMessage());
    }

    public void printResult(String string) {
        print(RESULT_PREFIX + string);
    }

    private void print(String string) {
        System.out.println(string);
    }
}
