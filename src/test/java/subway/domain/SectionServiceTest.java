package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SectionServiceTest {

    SectionService sectionService;

    @BeforeEach
    void setUp() {
        SectionRepository.deleteAll();
        sectionService = new SectionService();
        LineService lineService = new LineService();
        List<Station> firstLine = Arrays.asList(new Station("미아역"), new Station("길음역"));
        List<Station> secondLine = Arrays.asList(new Station("보문역"), new Station("월곡역"));
        List<Station> thirdLine = Arrays.asList(new Station("성신여대입구역"), new Station("종각역"));
        List<List<Station>> stations = new ArrayList<>();
        StationRepository.saveAll(firstLine);
        StationRepository.saveAll(secondLine);
        StationRepository.saveAll(thirdLine);
        stations.add(firstLine);
        stations.add(secondLine);
        stations.add(thirdLine);
        lineService.createLines(stations, Arrays.asList("1호선", "2호선", "3호선"));
    }

    @DisplayName("구간 생성 테스트")
    @Test
    void createSectionTest() {
        sectionService.createSection("미아역", "길음역", "1호선", 5, 10);
        sectionService.createSection("보문역", "월곡역", "2호선", 5, 10);
        Assertions.assertThat(SectionRepository.sections().size()).isEqualTo(2);
    }

    @DisplayName("시작점 기준 구간 조회 기능 추가")
    @Test
    void getSectionsByStartTest() {
        sectionService.createSection("미아역", "길음역", "1호선", 5, 10);
        sectionService.createSection("보문역", "월곡역", "2호선", 5, 10);
        sectionService.createSection("보문역", "성신여대입구역", "2호선", 5, 10);

        Assertions.assertThat(SectionRepository.findSectionsByStart("보문역").size()).isEqualTo(2);

    }

    @DisplayName("종료점 기준 구간 조회 기능 추가")
    @Test
    void getSectionsByEndTest() {
        sectionService.createSection("미아역", "길음역", "1호선", 5, 10);
        sectionService.createSection("보문역", "월곡역", "2호선", 5, 10);
        sectionService.createSection("보문역", "성신여대입구역", "2호선", 5, 10);

        Assertions.assertThat(SectionRepository.findSectionsByEnd("길음역").size()).isEqualTo(1);
    }
}
