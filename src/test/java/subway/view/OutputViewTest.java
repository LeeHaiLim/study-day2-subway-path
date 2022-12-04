package subway.view;

import org.junit.jupiter.api.Test;
import subway.domain.dto.PathDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void printResult() {
        PathDto pathDto = new PathDto(List.of(4, 11), List.of("교대역", "강남역", "양재역"));
        OutputView outputView = new OutputView();
        outputView.printResult(pathDto);
    }
}