package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubwayPathControllerTest {
    SubwayPathController subwayPathController;

    @BeforeEach
    void setUp() {
        LineService lineService = new LineService();
        SectionService sectionService = new SectionService();
        StationService stationService = new StationService();
        subwayPathController = new SubwayPathController(lineService, stationService, sectionService);
    }

    @DisplayName("컨트롤러 초기화 테스트")
    @Test
    void initTest() {
        subwayPathController.run();
        Assertions.assertThat(StationRepository.stations().size()).isEqualTo(7);
        Assertions.assertThat(LineRepository.lines().size()).isEqualTo(3);
        Assertions.assertThat(SectionRepository.sections().size()).isEqualTo(14);
    }
}
