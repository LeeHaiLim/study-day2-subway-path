package subway.repository;

import subway.domain.DistanceWeightPath;
import subway.domain.TimeWeightPath;

import java.util.HashMap;
import java.util.List;

public class WeightRepository {
    private static WeightRepository weightRepository;
    private final DistanceWeightPath distanceWeightPath = new DistanceWeightPath();
    private final TimeWeightPath timeWeightPath = new TimeWeightPath();

    private static final HashMap<List<String>, List<Integer>> weightInfo = new HashMap<>();

    public static WeightRepository getInstance() {
        if (weightRepository == null) {
            weightRepository = new WeightRepository();
        }
        return weightRepository;
    }

    public void addWeight(String station1, String station2, int distanceWeight, int timeWight) {
        addWeightInfo(station1, station2, distanceWeight, timeWight);

        distanceWeightPath.addDistanceWeight(station1, station2, distanceWeight);
        timeWeightPath.addTimeWeight(station1, station2, timeWight);
    }

    private void addWeightInfo(String station1, String station2, int distanceWeight, int timeWight) {
        weightInfo.put(List.of(station1, station2), List.of(distanceWeight, timeWight));
    }

    public List<String> getShortestDistancePath(String station1, String station2) {
        return distanceWeightPath.getShortestDistancePath(station1, station2);
    }

    public List<String> getMinimumTimePath(String station1, String station2) {
        return timeWeightPath.getMinimumTimePath(station1, station2);
    }

    public List<Integer> getWeight(String station1, String station2) {
        List<String> key = weightInfo.keySet().stream()
                .filter(stations -> stations.containsAll(List.of(station1, station2)))
                .findAny()
                .get();
        return weightInfo.get(key);
    }
}
