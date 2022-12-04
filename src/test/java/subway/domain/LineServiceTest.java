package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.line.LineService;
import subway.domain.station.Station;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LineServiceTest {
    LineService lineService;

    @BeforeEach
    void setUp() {
        LineRepository.deleteAll();
        lineService = new LineService();
        List<Station> firstLine = Arrays.asList(new Station("미아역"), new Station("길음역"));
        List<Station> secondLine = Arrays.asList(new Station("길음역"), new Station("월곡역"));
        List<Station> thirdLine = Arrays.asList(new Station("성신여대입구역"), new Station("종각역"));
        List<List<Station>> stations = new ArrayList<>();
        stations.add(firstLine);
        stations.add(secondLine);
        stations.add(thirdLine);

        lineService.createLines(stations, Arrays.asList("1호선", "2호선", "3호선"));
    }

    @DisplayName("노선 저장 테스트")
    @Test
    void saveStationsTest() {
        Assertions.assertThat(LineRepository.lines().size()).isEqualTo(3);
    }

    @DisplayName("역 이름으로 노선 조회 테스트")
    @Test
    void getLinesByStationNameTest() {
        List<Line> lines = lineService.getLinesByStationName("길음역");
        Assertions.assertThat(lines.size()).isEqualTo(2);
    }
}
