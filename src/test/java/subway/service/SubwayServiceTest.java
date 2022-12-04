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


    @DisplayName("최단 거리 기준 조회 순방향")
    @Test
    void getShortestDistancePathTest() {
        List<String> path = subwayService.getShortestDistancePath("교대역", "양재역");
        Assertions.assertThat(path).isEqualTo(List.of("교대역", "강남역", "양재역"));
    }

    @DisplayName("최소 시간 기준 조회 순방향")
    @Test
    void getMinimumTimePathTest() {
        List<String> path = subwayService.getMinimumTimePath("교대역", "양재역");
        Assertions.assertThat(path).isEqualTo(List.of("교대역", "남부터미널역", "양재역"));
    }

    @DisplayName("최단 거리 기준 조회 역방향")
    @Test
    void getShortestDistancePathTest2() {
        List<String> path = subwayService.getShortestDistancePath("양재역", "교대역");
        Assertions.assertThat(path).isEqualTo(List.of("양재역", "강남역", "교대역"));
    }

    @DisplayName("최소 시간 기준 조회 역방향")
    @Test
    void getMinimumTimePathTest2() {
        List<String> path = subwayService.getMinimumTimePath("양재역", "교대역");
        Assertions.assertThat(path).isEqualTo(List.of("양재역", "남부터미널역", "교대역"));
    }
}