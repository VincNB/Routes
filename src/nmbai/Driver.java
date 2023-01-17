package nmbai;

import java.util.Deque;
import java.util.Scanner;

public class Driver {
    private final TrainSystem trainSystem = new TrainSystem();
    private final Scanner scanner = new Scanner(System.in);

    public Driver() {
        //empty
    }

    /**
     * Takes two inputs from the user, finds the Station associated with them, and finds a path between them.
     */
    public void run() {
        initialize();
        StringBuilder output = new StringBuilder();
        System.out.print("Enter departure station name...\n>");
        String input = scanner.nextLine();
        Station start = trainSystem.getStation(input);
        if (start == null) {
            output.append(String.format("Departure station %s could not be found.%n", input));
        }
        System.out.print("Enter destination station name...\n>");
        input = scanner.nextLine();
        Station end = trainSystem.getStation(input);
        if (end == null) {
            output.append(String.format("Destination station %s could not be found.%n", input));
        }
        if (output.length() == 0) {
            output.append('\n');
            TreePathfinder treePathfinder = new TreePathfinder(start, end);
            Deque<Station> path = treePathfinder.find();
            while (!path.isEmpty()) {
                output.append(String.format("%s\n", path.pop().getName()));
            }
        }
        System.out.println(output);
    }

    private void initialize() {
        String[] route1 = new String[]{"140", "134", "Unicentro", "100", "30", "R", "Marsella", "Mu", "Bosa",};
        String[] route2 = new String[]{"Germania", "19", "Sabana", "R", "Espec", "F"};
        String[] route3 = new String[]{"Gu", "Santiago", "SENA", "Mu", "Timiza"};
        createRoute(route1);
        createRoute(route2);
        createRoute(route3);
    }

    private void createRoute(String[] route) {
        for (String name : route) {
            trainSystem.addStation(new Station(name));
        }
        trainSystem.formRoute(route);
    }
}
