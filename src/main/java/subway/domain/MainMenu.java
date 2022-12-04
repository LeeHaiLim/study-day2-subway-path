package subway.domain;

import java.util.Arrays;

public enum MainMenu {
    PATH("1", "경로 조회"),
    QUIT("Q", "종료");

    private final String flag;
    private final String menu;

    MainMenu(String flag, String menu) {
        this.flag = flag;
        this.menu = menu;
    }

    public static MainMenu findMenu(String flag) {
        return Arrays.stream(MainMenu.values())
                .filter(mainMenu -> mainMenu.flag.equals(flag))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("%s, %s 중 하나를 입력해야 합니다.", PATH.flag, QUIT.flag)));
    }

    public String flag() {
        return flag;
    }

    public String menu() {
        return menu;
    }

    public boolean isQuit() {
        return this.equals(QUIT);
    }
}
