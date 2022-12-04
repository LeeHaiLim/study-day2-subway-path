package subway.exception;

public enum ErrorMessage {
    SERVICE_ERROR("조회 과정에서 에러가 발생했습니다. 관리자에게 문의하세요."),
    STATION_NOT_EXIST("해당 역이 존재하지 않습니다."),
    START_END_EQUAL("출발역과 도착역이 동일합니다."),

    NOT_CORRECT_KEY("입력한 값이 올바르지 않습니다."),
    ;

    ErrorMessage(String message) {
        this.message = message;
    }

    private static final String PREFIX = "[ERROR] ";

    private String message;

    public String getMessage() {
        return PREFIX + message;
    }
}
