package universitymanagement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CampusGraph {

    private Map<String, List<String>> graph;

    public CampusGraph() {
        graph = new LinkedHashMap<>();
    }

    // Add a new campus location
    public void addLocation(String location) {

        if (graph.containsKey(location)) {
            System.out.println("Location already exists.");
            return;
        }

        graph.put(location, new ArrayList<>());
        System.out.println(location + " added successfully.");
    }

    // Remove a campus location
    public void removeLocation(String location) {

        if (!graph.containsKey(location)) {
            System.out.println("Location not found.");
            return;
        }

        graph.remove(location);

        for (List<String> neighbours : graph.values()) {
            neighbours.remove(location);
        }

        System.out.println(location + " removed successfully.");
    }

    // Add a road between two locations
    public void addRoad(String location1, String location2) {

        if (!graph.containsKey(location1) || !graph.containsKey(location2)) {
            System.out.println("One or both locations do not exist.");
            return;
        }

        if (location1.equals(location2)) {
            System.out.println("Cannot connect a location to itself.");
            return;
        }

        if (graph.get(location1).contains(location2)) {
            System.out.println("Road already exists.");
            return;
        }

        graph.get(location1).add(location2);
        graph.get(location2).add(location1);

        System.out.println(
                "Road added between " + location1 + " and " + location2
        );
    }

    // Remove a road between two locations
    public void removeRoad(String location1, String location2) {

        if (!graph.containsKey(location1) || !graph.containsKey(location2)) {
            System.out.println("One or both locations do not exist.");
            return;
        }

        if (!graph.get(location1).contains(location2)) {
            System.out.println("Road does not exist.");
            return;
        }

        graph.get(location1).remove(location2);
        graph.get(location2).remove(location1);

        System.out.println(
                "Road removed between " + location1 + " and " + location2
        );
    }

    // Display all campus connections
    public void displayGraph() {

        if (graph.isEmpty()) {
            System.out.println("No campus locations available.");
            return;
        }

        System.out.println("\n--- Campus Connections ---");

        for (String location : graph.keySet()) {

            System.out.print(location + " -> ");

            if (graph.get(location).isEmpty()) {
                System.out.print("No connections");
            } else {
                for (String neighbour : graph.get(location)) {
                    System.out.print(neighbour + " ");
                }
            }

            System.out.println();
        }
    }

    // Breadth First Search traversal
    public void bfs(String startLocation) {

        if (!graph.containsKey(startLocation)) {
            System.out.println("Starting location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(startLocation);
        visited.add(startLocation);

        System.out.println("\n--- BFS Traversal ---");

        while (!queue.isEmpty()) {

            String currentLocation = queue.poll();

            System.out.print(currentLocation);

            for (String neighbour : graph.get(currentLocation)) {

                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }

            if (!queue.isEmpty()) {
                System.out.print(" -> ");
            }
        }

        System.out.println();
    }
}