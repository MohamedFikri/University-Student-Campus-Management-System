package universitymanagement;

// Fikri - 23DA2-0681
// Binary Search Tree for student records
public class StudentBST {

    private static class TreeNode {
        private Student student;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(Student student) {
            this.student = student;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;
    private int count;

    public StudentBST() {
        root = null;
        count = 0;
    }

    // Insert a student using Student ID
    public boolean insertStudent(Student student) {
        if (student == null
                || student.getStudentId() == null
                || student.getStudentId().trim().isEmpty()) {
            return false;
        }

        TreeNode newNode = new TreeNode(student);

        if (root == null) {
            root = newNode;
            count++;
            return true;
        }

        TreeNode current = root;
        TreeNode parent = null;

        while (current != null) {
            parent = current;

            int comparison = student.getStudentId().trim()
                    .compareToIgnoreCase(
                            current.student.getStudentId().trim());

            if (comparison < 0) {
                current = current.left;
            } else if (comparison > 0) {
                current = current.right;
            } else {
                // Duplicate Student ID
                return false;
            }
        }

        int comparison = student.getStudentId().trim()
                .compareToIgnoreCase(
                        parent.student.getStudentId().trim());

        if (comparison < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        count++;
        return true;
    }

    // Search for a student using Student ID
    public Student searchStudent(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            return null;
        }

        TreeNode current = root;
        String searchId = studentId.trim();

        while (current != null) {
            int comparison = searchId.compareToIgnoreCase(
                    current.student.getStudentId().trim());

            if (comparison == 0) {
                return current.student;
            } else if (comparison < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    // Delete a student using Student ID
    public boolean deleteStudent(String studentId) {
        if (searchStudent(studentId) == null) {
            return false;
        }

        root = deleteRecursive(root, studentId.trim());
        count--;
        return true;
    }

    private TreeNode deleteRecursive(
            TreeNode node,
            String studentId) {

        if (node == null) {
            return null;
        }

        int comparison = studentId.compareToIgnoreCase(
                node.student.getStudentId().trim());

        if (comparison < 0) {
            node.left = deleteRecursive(node.left, studentId);
        } else if (comparison > 0) {
            node.right = deleteRecursive(node.right, studentId);
        } else {
            // Node with no child
            if (node.left == null && node.right == null) {
                return null;
            }

            // Node with only right child
            if (node.left == null) {
                return node.right;
            }

            // Node with only left child
            if (node.right == null) {
                return node.left;
            }

            // Node with two children
            TreeNode successor = findSmallestNode(node.right);
            node.student = successor.student;

            node.right = deleteRecursive(
                    node.right,
                    successor.student.getStudentId());
        }

        return node;
    }

    private TreeNode findSmallestNode(TreeNode node) {
        TreeNode current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // Display students in ascending Student ID order
    public void displayInOrder() {
        if (root == null) {
            System.out.println("BST is empty.");
            return;
        }

        System.out.println(
                "\n===== STUDENTS SORTED BY ID (BST) =====");

        displayInOrderRecursive(root);
    }

    private void displayInOrderRecursive(TreeNode node) {
        if (node != null) {
            displayInOrderRecursive(node.left);
            System.out.println(node.student);
            displayInOrderRecursive(node.right);
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getCount() {
        return count;
    }
}