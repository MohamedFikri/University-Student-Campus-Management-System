package universitymanagement;

// Fikri - 23DA2-0681
// Hash Table with separate chaining for student records
public class StudentHashTable {

    private static class HashEntry {
        private String studentId;
        private Student student;
        private HashEntry next;

        public HashEntry(String studentId, Student student) {
            this.studentId = studentId;
            this.student = student;
            this.next = null;
        }
    }

    private final HashEntry[] table;
    private int count;

    public StudentHashTable() {
        this(10);
    }

    public StudentHashTable(int capacity) {
        if (capacity <= 0) {
            capacity = 10;
        }

        table = new HashEntry[capacity];
        count = 0;
    }

    // Generate an array index using Student ID
    private int getHashIndex(String studentId) {
        String key = studentId.trim().toUpperCase();
        int hash = 0;

        for (int i = 0; i < key.length(); i++) {
            hash = (31 * hash + key.charAt(i)) & 0x7fffffff;
        }

        return hash % table.length;
    }

    // Add a student to the hash table
    public boolean addStudent(Student student) {
        if (student == null
                || student.getStudentId() == null
                || student.getStudentId().trim().isEmpty()) {
            return false;
        }

        String studentId = student.getStudentId().trim();
        int index = getHashIndex(studentId);

        HashEntry current = table[index];

        while (current != null) {
            if (current.studentId.equalsIgnoreCase(studentId)) {
                // Duplicate Student ID
                return false;
            }

            current = current.next;
        }

        HashEntry newEntry = new HashEntry(studentId, student);
        newEntry.next = table[index];
        table[index] = newEntry;

        count++;
        return true;
    }

    // Search for a student using Student ID
    public Student searchStudent(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            return null;
        }

        String searchId = studentId.trim();
        int index = getHashIndex(searchId);

        HashEntry current = table[index];

        while (current != null) {
            if (current.studentId.equalsIgnoreCase(searchId)) {
                return current.student;
            }

            current = current.next;
        }

        return null;
    }

    // Update an existing student record
    public boolean updateStudent(Student updatedStudent) {
        if (updatedStudent == null
                || updatedStudent.getStudentId() == null
                || updatedStudent.getStudentId().trim().isEmpty()) {
            return false;
        }

        String studentId = updatedStudent.getStudentId().trim();
        int index = getHashIndex(studentId);

        HashEntry current = table[index];

        while (current != null) {
            if (current.studentId.equalsIgnoreCase(studentId)) {
                current.student = updatedStudent;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Remove a student using Student ID
    public Student removeStudent(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            return null;
        }

        String searchId = studentId.trim();
        int index = getHashIndex(searchId);

        HashEntry current = table[index];
        HashEntry previous = null;

        while (current != null) {
            if (current.studentId.equalsIgnoreCase(searchId)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }

                count--;
                return current.student;
            }

            previous = current;
            current = current.next;
        }

        return null;
    }

    // Display every bucket and its student records
    public void displayHashTable() {
        if (count == 0) {
            System.out.println("Hash table is empty.");
            return;
        }

        System.out.println("\n===== STUDENT HASH TABLE =====");

        for (int i = 0; i < table.length; i++) {
            System.out.print("Bucket " + i + ": ");

            HashEntry current = table[i];

            if (current == null) {
                System.out.println("Empty");
                continue;
            }

            while (current != null) {
                System.out.print(
                        "[" + current.studentId
                        + " - " + current.student.getName() + "]");

                if (current.next != null) {
                    System.out.print(" -> ");
                }

                current = current.next;
            }

            System.out.println();
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return table.length;
    }
}