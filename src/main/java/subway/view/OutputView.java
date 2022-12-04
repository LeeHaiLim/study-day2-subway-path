package subway.view;

import subway.domain.dto.PathDto;

import java.util.List;

public class OutputView {
    private static final String PREFIX = "[INFO] ";

    public void printResult(PathDto dto) {
        System.out.println("## 조회 결과");
        System.out.println(PREFIX+"---");
        System.out.println(PREFIX+"총 거리: "+dto.getTotalDistance()+"km");
        System.out.println(PREFIX+"총 소요시간: "+dto.getTotalTime()+"분");
        System.out.println(PREFIX+"---");
        List<String> paths = dto.getPath();
        paths.stream().forEach(path -> System.out.println(PREFIX+path));
    }
}
