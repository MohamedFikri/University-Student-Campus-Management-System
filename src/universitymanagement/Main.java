package universitymanagement;
public class Main {

    public static void main(String[] args) {

        CampusGraph campus = new CampusGraph();

        System.out.println("==========================================");
        System.out.println("   UNIVERSITY CAMPUS ROUTE MANAGEMENT");
        System.out.println("==========================================");

        // Add campus locations
        campus.addLocation("Main Gate");
        campus.addLocation("Library");
        campus.addLocation("Cafeteria");
        campus.addLocation("Laboratory");
        campus.addLocation("Auditorium");

        System.out.println();

        // Add roads
        campus.addRoad("Main Gate", "Library");
        campus.addRoad("Main Gate", "Cafeteria");
        campus.addRoad("Library", "Laboratory");
        campus.addRoad("Cafeteria", "Laboratory");
        campus.addRoad("Laboratory", "Auditorium");

        // Display campus graph
        campus.displayGraph();

        // BFS traversal
        campus.bfs("Main Gate");

        System.out.println("\n==========================================");
        System.out.println("Testing Remove Road");
        System.out.println("==========================================");

        campus.removeRoad("Main Gate", "Cafeteria");

        campus.displayGraph();

        System.out.println("\n==========================================");
        System.out.println("Testing Remove Location");
        System.out.println("==========================================");

        campus.removeLocation("Auditorium");

        campus.displayGraph();

        System.out.println("\n==========================================");
        System.out.println("Graph and BFS testing completed.");
        System.out.println("==========================================");
    }
}