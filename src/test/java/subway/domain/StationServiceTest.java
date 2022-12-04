package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.station.StationRepository;
import subway.domain.station.StationService;

import java.util.Arrays;
import java.util.List;

class StationServiceTest {

    StationService stationService;

    @BeforeEach
    void setUp() {
        StationRepository.deleteAll();
        stationService = new StationService();
    }

    @DisplayName("역 저장 테스트")
    @Test
    void saveStationsTest() {
        List<String> stationNames = Arrays.asList("미아역", "길음역", "월곡역");
        stationService.createStations(stationNames);

        Assertions.assertThat(StationRepository.stations().size()).isEqualTo(3);
    }


}
