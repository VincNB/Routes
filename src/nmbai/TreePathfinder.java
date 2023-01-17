package nmbai;


import java.util.*;

public class TreePathfinder {
    private final Deque<Station> path = new ArrayDeque<>(); //need pure stack implementation
    private final Set<Station> visited = new HashSet<>();
    private final Map<Station, Deque<Station>> connectionMap = new HashMap<>();
    private final Station start;
    private final Station end;

    public TreePathfinder(Station start, Station end) {
        this.start = start;
        this.end = end;
    }

    public Deque<Station> find() {
        path.push(end);
        visited.add(end);
        boolean pathFound = false;
        while (!path.isEmpty() && !pathFound) {
            if (path.peek() == start) {
                pathFound = true;
            } else {
                Deque<Station> currentConnections = getConnections(path.peek());
                if (!currentConnections.isEmpty()) {
                    Station next = currentConnections.pop();
                    if (visited.add(next)) {
                        path.push(next);
                    }
                } else {
                    path.pop();
                }
            }
        }
        return path;
    }

    private Deque<Station> getConnections(Station station) {
        Deque<Station> connections;
        if (connectionMap.containsKey(station)) {
            connections = connectionMap.get(station);
        } else {
            connections = new ArrayDeque<>();
            connectionMap.put(station, connections);
            for (Station conn : station.getConnections()) {
                connections.push(conn);
            }
        }
        return connections;
    }
}
