package subway.domain.section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static void save(Section section) {
        sections.add(section);
    }

    public static void deleteAll() {
        sections.clear();
    }

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static List<Section> findSectionsByStart(String stationName) {
        return sections.stream()
                .filter(section -> section.getStart().getName().equals(stationName))
                .collect(Collectors.toList());
    }

    public static List<Section> findSectionsByEnd(String stationName) {
        return sections.stream()
                .filter(section -> section.getEnd().getName().equals(stationName))
                .collect(Collectors.toList());
    }
}
