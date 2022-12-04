package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.controller.SubwayPathController;
import subway.domain.line.LineRepository;
import subway.domain.line.LineService;
import subway.domain.section.SectionRepository;
import subway.domain.section.SectionService;
import subway.domain.station.StationRepository;
import subway.domain.station.StationService;

class SubwayPathControllerTest {
    SubwayPathController subwayPathController;

    @BeforeEach
    void setUp() {
        LineRepository.deleteAll();
        SectionRepository.deleteAll();
        StationRepository.deleteAll();
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
