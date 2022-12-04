package subway.domain.section;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;

import java.util.List;

public class SectionService {

    public void createSection(String startName, String endName, String lineName, int time, int distance) {
        Station start = StationRepository.findByName(startName);
        Station end = StationRepository.findByName(endName);
        Line line = LineRepository.findByName(lineName);
        SectionRepository.save(new Section(start,end,line,time,distance));
        SectionRepository.save(new Section(end,start,line,time,distance));
    }

    public List<Section> getSectionStart(String stationName) {
        return SectionRepository.findSectionsByStart(stationName);
    }

    public List<Section> getSectionEnd(String stationName) {
        return SectionRepository.findSectionsByEnd(stationName);
    }

    public int getSectionTime(Section section) {
        return section.getTime();
    }

    public int getSectionDistance(Section section) {
        return section.getDistance();
    }

    public List<Section> getSectionsByLine(String lineName) {
        return SectionRepository.findSectionsByLineName(lineName);
    }
}
