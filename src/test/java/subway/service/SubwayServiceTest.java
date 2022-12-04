package subway.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubwayServiceTest {

    private SubwayService subwayService = new SubwayService();

    @DisplayName("존재하지 않는 역을 입력할 경우 예외처리 한다.")
    @Test
    void isNotExistsStation() {
        Assertions.assertThatThrownBy(
                () -> subwayService.getShortestDistancePath("잠실역", "강남역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 존재하지 않는 역입니다.");
    }

    @DisplayName("같은 역을 입력할 경우 예외처리 한다.")
    @Test
    void isSameStation() {
        Assertions.assertThatThrownBy(
                        () -> subwayService.getShortestDistancePath("강남역", "강남역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 출발역과 도착역이 동일합니다.");
    }
}