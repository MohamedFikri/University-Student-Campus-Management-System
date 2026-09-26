package universitymanagement;

import java.util.Scanner;

public class Main {

    private static final StudentLinkedList studentList
            = new StudentLinkedList();

    private static final StudentBST studentTree
            = new StudentBST();

    private static final StudentHashTable studentHashTable
            = new StudentHashTable();

    private static final ActionStack recentActions
            = new ActionStack();

    private static final ServiceQueue requestQueue
            = new ServiceQueue();

    private static final CampusGraph campusGraph
            = new CampusGraph();

    private static final Scanner scanner
            = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println(
                " UNIVERSITY STUDENT AND CAMPUS MANAGEMENT SYSTEM");
        System.out.println("===============================================");

        int choice;

        do {
            printMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    updateStudent();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    studentList.displayAllStudents();
                    break;

                case 5:
                    addServiceRequest();
                    break;

                case 6:
                    processServiceRequest();
                    break;

                case 7:
                    recentActions.displayActions();
                    break;

                case 8:
                    studentTree.displayInOrder();
                    break;

                case 9:
                    searchStudentUsingHashing();
                    break;

                case 10:
                    addCampusLocation();
                    break;

                case 11:
                    removeCampusLocation();
                    break;

                case 12:
                    addCampusRoad();
                    break;

                case 13:
                    removeCampusRoad();
                    break;

                case 14:
                    campusGraph.displayGraph();
                    break;

                case 15:
                    traverseCampus();
                    break;

                case 16:
                    System.out.println(
                            "Exiting the system. Thank you!");
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Enter a number from 1 to 16.");
            }

            System.out.println();

        } while (choice != 16);

        scanner.close();
    }

    private static void printMenu() {

        System.out.println("========== MAIN MENU ==========");
        System.out.println("1. Add Student Record");
        System.out.println("2. Update Student Record");
        System.out.println("3. Delete Student Record");
        System.out.println(
                "4. Display All Records using Linked List");
        System.out.println(
                "5. Add Service Request to Queue");
        System.out.println(
                "6. Process Next Service Request");
        System.out.println(
                "7. Display Recent Actions using Stack");
        System.out.println(
                "8. Display Students using BST");
        System.out.println(
                "9. Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println(
                "12. Add Campus Connection/Road");
        System.out.println(
                "13. Remove Campus Connection/Road");
        System.out.println(
                "14. Display Campus Connections");
        System.out.println(
                "15. Traverse Campus Locations using BFS");
        System.out.println("16. Exit");
    }

    private static void addStudent() {

        System.out.println("\n--- Add Student Record ---");

        String studentId = readNonEmpty(
                "Enter Student ID: ");

        if (studentList.searchStudent(studentId) != null) {
            System.out.println(
                    "A student with this ID already exists.");
            return;
        }

        String name = readNonEmpty(
                "Enter Name: ");

        String programme = readNonEmpty(
                "Enter Programme: ");

        double marks = readMarks(
                "Enter Marks (0-100): ");

        Student student = new Student(
                studentId.trim(),
                name.trim(),
                programme.trim(),
                marks);

        boolean listAdded
                = studentList.addStudent(student);

        boolean treeAdded
                = studentTree.insertStudent(student);

        boolean hashAdded
                = studentHashTable.addStudent(student);

        if (listAdded && treeAdded && hashAdded) {
            System.out.println(
                    "Student added successfully.");

            recentActions.pushAction(
                    "Added student: "
                    + student.getStudentId());
        } else {
            System.out.println(
                    "Student could not be added.");
        }
    }

    private static void updateStudent() {

        System.out.println("\n--- Update Student Record ---");

        String studentId = readNonEmpty(
                "Enter Student ID: ");

        Student student
                = studentList.searchStudent(studentId);

        if (student == null) {
            System.out.println(
                    "Student record not found.");
            return;
        }

        System.out.println(
                "Current record: " + student);

        String newName = readNonEmpty(
                "Enter New Name: ");

        String newProgramme = readNonEmpty(
                "Enter New Programme: ");

        double newMarks = readMarks(
                "Enter New Marks (0-100): ");

        boolean updated = studentList.updateStudent(
                studentId,
                newName.trim(),
                newProgramme.trim(),
                newMarks);

        if (updated) {
            studentHashTable.updateStudent(student);

            System.out.println(
                    "Student updated successfully.");

            recentActions.pushAction(
                    "Updated student: "
                    + student.getStudentId());
        } else {
            System.out.println(
                    "Student could not be updated.");
        }
    }

    private static void deleteStudent() {

        System.out.println("\n--- Delete Student Record ---");

        String studentId = readNonEmpty(
                "Enter Student ID: ");

        Student deletedStudent
                = studentList.deleteStudent(studentId);

        if (deletedStudent == null) {
            System.out.println(
                    "Student record not found.");
            return;
        }

        studentTree.deleteStudent(studentId);
        studentHashTable.removeStudent(studentId);

        System.out.println(
                "Student deleted successfully.");

        recentActions.pushAction(
                "Deleted student: "
                + deletedStudent.getStudentId());
    }

    private static void addServiceRequest() {

        System.out.println("\n--- Add Service Request ---");

        String studentId = readNonEmpty(
                "Enter Student ID: ");

        if (studentHashTable.searchStudent(studentId)
                == null) {

            System.out.println(
                    "Student record not found. "
                    + "Add the student first.");
            return;
        }

        String requestType = readNonEmpty(
                "Enter Request Type "
                + "(ID Card, Transcript, etc.): ");

        requestQueue.enqueue(
                new ServiceRequest(
                        studentId.trim(),
                        requestType.trim()));

        recentActions.pushAction(
                "Added service request for: "
                + studentId.trim());
    }

    private static void processServiceRequest() {

        System.out.println(
                "\n--- Process Next Service Request ---");

        ServiceRequest processedRequest
                = requestQueue.processNext();

        if (processedRequest != null) {
            recentActions.pushAction(
                    "Processed service request for: "
                    + processedRequest.getStudentId());
        }
    }

    private static void searchStudentUsingHashing() {

        System.out.println(
                "\n--- Search Student using Hashing ---");

        String studentId = readNonEmpty(
                "Enter Student ID: ");

        Student student
                = studentHashTable.searchStudent(studentId);

        if (student == null) {
            System.out.println(
                    "Student record not found.");
        } else {
            System.out.println("Student found:");
            System.out.println(student);

            recentActions.pushAction(
                    "Searched student: "
                    + student.getStudentId());
        }
    }

    private static void addCampusLocation() {

        System.out.println(
                "\n--- Add Campus Location ---");

        String location = readNonEmpty(
                "Enter Location Name: ");

        campusGraph.addLocation(location.trim());
    }

    private static void removeCampusLocation() {

        System.out.println(
                "\n--- Remove Campus Location ---");

        String location = readNonEmpty(
                "Enter Location Name: ");

        campusGraph.removeLocation(location.trim());
    }

    private static void addCampusRoad() {

        System.out.println(
                "\n--- Add Campus Connection/Road ---");

        String location1 = readNonEmpty(
                "Enter First Location: ");

        String location2 = readNonEmpty(
                "Enter Second Location: ");

        campusGraph.addRoad(
                location1.trim(),
                location2.trim());
    }

    private static void removeCampusRoad() {

        System.out.println(
                "\n--- Remove Campus Connection/Road ---");

        String location1 = readNonEmpty(
                "Enter First Location: ");

        String location2 = readNonEmpty(
                "Enter Second Location: ");

        campusGraph.removeRoad(
                location1.trim(),
                location2.trim());
    }

    private static void traverseCampus() {

        System.out.println(
                "\n--- BFS Campus Traversal ---");

        String startLocation = readNonEmpty(
                "Enter Starting Location: ");

        campusGraph.bfs(startLocation.trim());
    }

    private static int readInt(String prompt) {

        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println(
                        "Invalid input. "
                        + "Please enter a whole number.");
            }
        }
    }

    private static double readMarks(String prompt) {

        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                double marks = Double.parseDouble(input);

                if (marks >= 0 && marks <= 100) {
                    return marks;
                }

                System.out.println(
                        "Marks must be between 0 and 100.");

            } catch (NumberFormatException exception) {
                System.out.println(
                        "Invalid marks. Please enter a number.");
            }
        }
    }

    private static String readNonEmpty(String prompt) {

        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println(
                    "Input cannot be empty. Please try again.");
        }
    }
}