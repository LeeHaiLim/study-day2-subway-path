package subway.domain.model;

public class Line {
    private String name;

    public Line(String name) {
        validateLineNameLength(name);
        this.name = name;
    }

    private void validateLineNameLength(String name) {
        if(name.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 노선의 이름은 2글자 이상이어야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
