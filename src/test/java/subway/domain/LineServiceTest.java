package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineServiceTest {
    LineService lineService;

    @BeforeEach
    void setUp() {
        lineService = new LineService();
    }

    @DisplayName("노선 저장 테스트")
    @Test
    void saveStationsTest() {
        List<Station> firstLine = Arrays.asList(new Station("미아역"), new Station("길음역"));
        List<Station> secondLine = Arrays.asList(new Station("길음역"), new Station("월곡역"));
        List<Station> thirdLine = Arrays.asList(new Station("성신여대입구역"), new Station("종각역"));
        List<List<Station>> stations = new ArrayList<>();
        stations.add(firstLine);
        stations.add(secondLine);
        stations.add(thirdLine);

        lineService.createLines(stations,Arrays.asList("1호선","2호선","3호선"));

        Assertions.assertThat(LineRepository.lines().size()).isEqualTo(3);
    }

}
