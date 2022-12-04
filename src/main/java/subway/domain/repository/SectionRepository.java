package subway.domain.repository;


import subway.domain.model.Section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SectionRepository {

    private static final List<Section> sections = new ArrayList<>();

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void deleteAll() {
        sections.clear();
    }
}
