package subway.exception;

public enum ErrorMessage {
    SERVICE_ERROR("조회 과정에서 에러가 발생했습니다. 관리자에게 문의하세요.");

    ErrorMessage(String message) {
        this.message = message;
    }

    private static final String PREFIX = "[ERROR] ";

    private String message;

    public String getMessage() {
        return PREFIX + message;
    }
}
