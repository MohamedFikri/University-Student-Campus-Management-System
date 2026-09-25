package universitymanagement;

public class StudentLinkedList {

    private static class Node {
        private Student student;
        private Node next;

        public Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    private Node head;
    private int count;

    public StudentLinkedList() {
        head = null;
        count = 0;
    }

    public boolean addStudent(Student student) {
        if (student == null || searchStudent(student.getStudentId()) != null) {
            return false;
        }

        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        count++;
        return true;
    }

    public Student searchStudent(String studentId) {
        if (studentId == null) {
            return null;
        }

        Node current = head;

        while (current != null) {
            if (current.student.getStudentId()
                    .equalsIgnoreCase(studentId.trim())) {
                return current.student;
            }

            current = current.next;
        }

        return null;
    }

    public boolean updateStudent(
            String studentId,
            String newName,
            String newProgramme,
            double newMarks) {

        Student student = searchStudent(studentId);

        if (student == null) {
            return false;
        }

        student.setName(newName);
        student.setProgramme(newProgramme);
        student.setMarks(newMarks);

        return true;
    }

    public Student deleteStudent(String studentId) {
        if (head == null || studentId == null) {
            return null;
        }

        if (head.student.getStudentId()
                .equalsIgnoreCase(studentId.trim())) {

            Student deletedStudent = head.student;
            head = head.next;
            count--;

            return deletedStudent;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.student.getStudentId()
                    .equalsIgnoreCase(studentId.trim())) {

                Student deletedStudent = current.next.student;
                current.next = current.next.next;
                count--;

                return deletedStudent;
            }

            current = current.next;
        }

        return null;
    }

    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No student records are available.");
            return;
        }

        System.out.println("\n===== ALL STUDENT RECORDS =====");

        Node current = head;
        int number = 1;

        while (current != null) {
            System.out.println(number + ". " + current.student);
            current = current.next;
            number++;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getCount() {
        return count;
    }
}