package subway.domain;

import java.util.List;

public class SectionService {

    public void createSection(String startName, String endName, String lineName, int time, int distance) {
        Station start = StationRepository.findByName(startName);
        Station end = StationRepository.findByName(endName);
        Line line = LineRepository.findByName(lineName);
        SectionRepository.save(new Section(start,end,line,time,distance));
    }

    public List<Section> getSectionStart(String stationName) {
        return SectionRepository.findSectionsByStart(stationName);
    }

    public List<Section> getSectionEnd(String stationName) {
        return SectionRepository.findSectionsByEnd(stationName);
    }

    public int getSectionTime() {
        return 0;
    }

    public int getSectionDistance() {
        return 0;
    }
}
