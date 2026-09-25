package universitymanagement;

import java.util.Stack;

public class ActionStack {

    private final Stack<String> actions;

    public ActionStack() {
        this.actions = new Stack<>();
    }

    public void pushAction(String action) {
        actions.push(action);
    }

    public String popAction() {
        if (actions.isEmpty()) {
            return "No actions available";
        }

        return actions.pop();
    }

    public String peekAction() {
        if (actions.isEmpty()) {
            return "No actions available";
        }

        return actions.peek();
    }

    public void displayActions() {
        if (actions.isEmpty()) {
            System.out.println("No actions available.");
            return;
        }

        System.out.println("Recent Actions:");

        for (String action : actions) {
            System.out.println(action);
        }
    }
}