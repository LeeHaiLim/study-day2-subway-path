package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        validateStationNameLength(name);
        this.name = name;
    }

    private void validateStationNameLength(String name) {
        if(name.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 역의 이름은 2글자 이상이어야 합니다.");
        }

    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
