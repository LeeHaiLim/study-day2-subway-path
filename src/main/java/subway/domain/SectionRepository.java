package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public static List<Section> findSectionsByStart() {
        return null;
    }

    public static List<Section> findSectionsByEnd() {
        return null;
    }
}
