package nmbai;

import java.util.HashMap;
import java.util.Map;

public class TrainSystem {
    private final Map<String, Station> stations = new HashMap<>();

    public void addStation(Station station) {
        stations.putIfAbsent(station.getName(), station);
    }

    public Station getStation(String name) {
        return stations.get(name);
    }

    public void formRoute(String[] stationNames) {
        for (int i = 1; i < stationNames.length; i++) {
            stations.get(stationNames[i]).connectStation(stations.get(stationNames[i - 1]));
        }
    }
}
