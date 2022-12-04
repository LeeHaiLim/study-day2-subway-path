package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StationServiceTest {

    StationService stationService;

    @BeforeEach
    void setUp() {
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
