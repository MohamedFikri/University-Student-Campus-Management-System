package universitymanagement;

public class ActionStack {

    private static class Node {
        private String action;
        private Node next;

        public Node(String action) {
            this.action = action;
            this.next = null;
        }
    }

    private Node top;
    private int size;

    public ActionStack() {
        top = null;
        size = 0;
    }

    // Add an action to the top of the stack
    public void pushAction(String action) {
        Node newNode = new Node(action);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Remove and return the latest action
    public String popAction() {
        if (isEmpty()) {
            return "No actions available";
        }

        String removedAction = top.action;
        top = top.next;
        size--;

        return removedAction;
    }

    // View the latest action without removing it
    public String peekAction() {
        if (isEmpty()) {
            return "No actions available";
        }

        return top.action;
    }

    // Display actions from latest to oldest
    public void displayActions() {
        if (isEmpty()) {
            System.out.println("No actions available.");
            return;
        }

        System.out.println("Recent Actions (Latest First):");

        Node current = top;
        int number = 1;

        while (current != null) {
            System.out.println(number + ". " + current.action);
            current = current.next;
            number++;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }
}