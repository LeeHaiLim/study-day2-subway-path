package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SectionTest {

    Section section;

    @BeforeEach
    void setUp() {
        Station station1 = new Station("길음역");
        Station station2 = new Station("성신여대입구역");
        section = new Section(
                station1,
                station2,
                new Line("4호선", List.of(station1, station2)),
                5, 10);
    }

    @Test
    void getTimeTest() {
        Assertions.assertThat(section.getTime()).isEqualTo(5);
    }

    @Test
    void getDistanceTest() {
        Assertions.assertThat(section.getDistance()).isEqualTo(10);
    }
}
