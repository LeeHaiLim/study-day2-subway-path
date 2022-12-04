package subway;

import java.util.Arrays;

public enum PathMenu {
    DISTANCE("1","최단 거리"),
    TIME("2","최단 시간"),
    BACK("B","돌아가기");

    private final String flag;
    private final String menu;

    PathMenu(String flag, String menu) {
        this.flag = flag;
        this.menu = menu;
    }

    public static PathMenu findMenu(String flag) {
        return Arrays.stream(PathMenu.values())
                .filter(pathMenu -> pathMenu.flag.equals(flag))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("%s, %s, %s 중 하나를 입력해야 합니다.", DISTANCE.flag, TIME.flag, BACK.flag)));
    }

    public String flag() {
        return flag;
    }

    public String menu() {
        return menu;
    }

    public boolean isBack() {
        return this.equals(BACK);
    }
}
