package subway.domain;

public class SectionService {
    private final SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public void createSection() {

    }

    public Station getSectionStart() {
        return null;
    }

    public Station getSectionEnd() {
        return null;
    }

    public int getSectionTime() {
        return 0;
    }

    public int getSectionDistance() {
        return 0;
    }
}
