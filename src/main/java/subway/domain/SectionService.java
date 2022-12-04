package subway.domain;

public class SectionService {

    public void createSection(String startName, String endName, String lineName, int time, int distance) {
        Station start = StationRepository.findByName(startName);
        Station end = StationRepository.findByName(endName);
        Line line = LineRepository.findByName(lineName);
        SectionRepository.save(new Section(start,end,line,time,distance));
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
