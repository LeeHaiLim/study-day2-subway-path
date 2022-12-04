package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StationTest {

    @ParameterizedTest(name = "createStationTest Case : {0}")
    @CsvSource(value = {"매봉역", "삼각지역"})
    void createStationTest_NormalCase(String name) {
        Station station = new Station(name);

        assertThat(station.getName()).isEqualTo(name);
    }

    @ParameterizedTest(name = "createStationTest Case : {0}")
    @CsvSource(value = {"가나", "역"})
    void createStationTest_ErrorCase(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Station(name));
    }
}
