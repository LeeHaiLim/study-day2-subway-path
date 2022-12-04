package subway.domain;

public class StationService {


    public void registerStation(String name) {
        if(StationRepository.findByName(name) != null) {
            throw new IllegalArgumentException("[ERROR] 입력한 역은 이미 등록되어있습니다.");
        }
        StationRepository.addStation(new Station(name));
    }


}
