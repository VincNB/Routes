package nmbai;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Station {
    private final String name;
    private final Set<Station> connections = new HashSet<>();
    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void connectStation(Station other) {
        connections.add(other);
        other.connections.add(this);
    }

    public Station[] getConnections() {
        return connections.toArray(new Station[0]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return name.equals(station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
