package universitymanagement;

import java.util.Scanner;

public class Main {

    static ActionStack recentActions = new ActionStack();
    static ServiceQueue requestQueue = new ServiceQueue();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("University Student and Campus Management System");
        System.out.println("Project setup completed successfully!");

        int choice;

        do {
            printMenu();
            choice = readInt();

            switch (choice) {

                case 1:
                    System.out.println("Add Student - Not implemented yet (Ammar's part).");
                    break;

                case 2:
                    System.out.println("Update Student - Not implemented yet (Ammar's part).");
                    break;

                case 3:
                    System.out.println("Delete Student - Not implemented yet (Ammar's part).");
                    break;

                case 4:
                    System.out.println("Display Students - Not implemented yet (Ammar's part).");
                    break;

                case 5:
                    addServiceRequest();
                    break;

                case 6:
                    requestQueue.processNext();
                    break;

                case 7:
                    recentActions.displayActions();
                    break;

                case 8:
                    System.out.println("Display Students using BST - Not implemented yet (Fikri's part).");
                    break;

                case 9:
                    System.out.println("Search Student using Hashing - Not implemented yet (Fikri's part).");
                    break;

                case 10:
                    System.out.println("Add Campus Location - Not implemented yet (Nuzail's part).");
                    break;

                case 11:
                    System.out.println("Remove Campus Location - Not implemented yet (Nuzail's part).");
                    break;

                case 12:
                    System.out.println("Add Campus Road - Not implemented yet (Nuzail's part).");
                    break;

                case 13:
                    System.out.println("Remove Campus Road - Not implemented yet (Nuzail's part).");
                    break;

                case 14:
                    System.out.println("Display Campus Connections - Not implemented yet (Nuzail's part).");
                    break;

                case 15:
                    System.out.println("BFS Traversal - Not implemented yet (Nuzail's part).");
                    break;

                case 16:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

            System.out.println();

        } while (choice != 16);
    }

    static void printMenu() {

        System.out.println("===== MAIN MENU =====");
        System.out.println("1. Add Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Display Students");
        System.out.println("5. Add Service Request");
        System.out.println("6. Process Service Request");
        System.out.println("7. Display Recent Actions");
        System.out.println("8. Display Students using BST");
        System.out.println("9. Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Road");
        System.out.println("13. Remove Campus Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. BFS Traversal");
        System.out.println("16. Exit");
        System.out.print("Enter your choice: ");
    }

    static int readInt() {

        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            sc.next();
        }

        int value = sc.nextInt();
        sc.nextLine();

        return value;
    }

    static void addServiceRequest() {

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Request Type (e.g. ID card request, Transcript request): ");
        String type = sc.nextLine();

        requestQueue.enqueue(new ServiceRequest(id, type));

        recentActions.pushAction("Service request added for " + id);
    }
}