package subway.exception;

public enum ErrorMessage {
    STATION_NAME_INVALID("역 이름은 2글자 이상이며 \"역\"으로 끝나야 합니다."),

    SERVICE_ERROR("조회 과정에서 에러가 발생했습니다. 관리자에게 문의하세요."),
    INITIALIZE_ERROR("초기 설정 오류입니다. 관리자에게 문의하세요.\n"),

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
