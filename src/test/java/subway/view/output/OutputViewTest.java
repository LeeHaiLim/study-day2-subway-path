package subway.view.output;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import subway.dto.PathDto;
import java.util.List;

public class OutputViewTest extends PrintTestTool{

    @Test
    void printPathDtoTest() {
        PathDto pathDto = new PathDto(List.of("월곡역","돌곶이역","석계역"),5,10);

        new OutputView().printPathDto(pathDto);

        assertThat(output()).contains(
            "[INFO] 총 거리: 5km", "[INFO] 총 소요 시간: 10분", "[INFO] ---",
                "[INFO] 월곡역", "[INFO] 돌곶이역", "[INFO] 석계역"
        );
    }
}
