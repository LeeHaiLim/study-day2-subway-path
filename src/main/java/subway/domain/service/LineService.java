package subway.domain.service;

import subway.domain.model.Line;
import subway.domain.repository.LineRepository;

import java.util.List;

public class LineService {

    public void registerLine(String name) {
        validateLineNameLength(name);
        validateLineDuplication(name);
        LineRepository.addLine(new Line(name));
    }

    private void validateLineNameLength(String name) {
        if(name.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 노선의 이름은 2글자 이상이어야 합니다.");
        }
    }

    private void validateLineDuplication(String name) {
        if(LineRepository.findByName(name) != null) {
            throw new IllegalArgumentException("[ERROR] 입력한 노선은 이미 등록되어있습니다.");
        }
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
