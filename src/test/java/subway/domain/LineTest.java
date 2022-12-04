package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LineTest {

    @ParameterizedTest(name = "createLineTest Case : {0}")
    @CsvSource(value = {"1호선", "분당선"})
    void createStationTest_NormalCase(String name) {
        Line line = new Line(name, mock(StationInfo.class));

        assertThat(line.getName()).isEqualTo(name);
    }

    @ParameterizedTest(name = "createLineTest Case : {0}")
    @CsvSource(value = {"8호", "선"})
    void createStationTest_ErrorCase(String name) {
        assertThrows(IllegalArgumentException.class,
                () -> new Line(name, mock(StationInfo.class)));
    }
}
