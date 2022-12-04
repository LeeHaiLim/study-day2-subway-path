package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class LineService {

    public void createLines(List<List<Station>> stations, List<String> lineNames) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < stations.size(); i++) {
            List<Station> lineStations = stations.get(i);
            String lineName = lineNames.get(i);
            Line line = new Line(lineName, lineStations);
            lines.add(line);
        }
        LineRepository.saveAll(lines);
    }

    public List<Line> getLinesByStationName(String stationName) {
        return LineRepository.findLinesByStationName(stationName);
    }
}
