package subway.view.output;

public enum View {
    MAIN("\n## 메인 화면\n" +
            "1. 경로 조회\n" +
            "Q. 종료"),
    PATH_STANDARD("\n## 경로 기준\n" +
            "1. 최단 거리\n" +
            "2. 최소 시간\n" +
            "B. 돌아가기"),
    ;

    private final String text;

    View(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
