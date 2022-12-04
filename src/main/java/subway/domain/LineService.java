package subway.domain;

import java.util.List;

public class LineService {
    private final LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public void createLines() {

    }

    public List<Line> getLinesByStationName() {
        return null;
    }
}
