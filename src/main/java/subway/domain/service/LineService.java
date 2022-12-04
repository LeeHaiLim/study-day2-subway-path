package subway.domain.service;

import subway.domain.model.Line;
import subway.domain.repository.LineRepository;

import java.util.List;

public class LineService {

    public void registerLine(String name) {

        if(LineRepository.findByName(name) != null) {
            throw new IllegalArgumentException("[ERROR] 입력한 노선은 이미 등록되어있습니다.");
        }
        LineRepository.addLine(new Line(name));
    }

    public void deleteLine(String name) {
        if(LineRepository.findByName(name) == null) {
            throw new IllegalArgumentException("[ERROR] 입력하신 노선은 존재하지 않습니다.");
        }
        LineRepository.deleteLineByName(name);
    }

    public List<Line> findAll() {
        return LineRepository.lines();
    }

    public Line findByName(String name) {
        return LineRepository.findByName(name);
    }

    public void deleteAll() {
        LineRepository.deleteAll();
    }
}
