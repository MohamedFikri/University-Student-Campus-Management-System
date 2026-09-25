package universitymanagement;

/**
 * ServiceQueue.java
 * Author: Asheem
 *
 * Custom Queue (FIFO) implementation using a singly linked list.
 * Holds ServiceRequest objects and processes them in the order they arrive.
 *
 * Menu options this supports (from Main.java):
 *   5. Add Service Request
 *   6. Process Service Request
 */
public class ServiceQueue {

    // Internal node for the queue (holds one ServiceRequest)
    private static class Node {
        ServiceRequest request;
        Node next;

        Node(ServiceRequest request) {
            this.request = request;
        }
    }

    private Node front;  // next request to be processed
    private Node rear;   // last request added
    private int size;

    public ServiceQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * Add a new service request to the end of the queue.
     * Used by Main.java menu option 5.
     */
    public void enqueue(ServiceRequest request) {
        Node newNode = new Node(request);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Request added: " + request);
    }

    /**
     * Process (remove) the request at the front of the queue.
     * Used by Main.java menu option 6.
     * Returns null if there is nothing to process.
     */
    public ServiceRequest processNext() {
        if (isEmpty()) {
            System.out.println("No pending service requests.");
            return null;
        }
        ServiceRequest processed = front.request;
        front = front.next;
        if (front == null) {
            rear = null; // queue became empty
        }
        size--;
        System.out.println("Processed: " + processed);
        return processed;
    }

    /**
     * Look at the next request to be processed without removing it.
     */
    public ServiceRequest peekNext() {
        if (isEmpty()) {
            return null;
        }
        return front.request;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    /**
     * Display all pending requests in the order they will be processed.
     */
    public void displayAllRequests() {
        if (isEmpty()) {
            System.out.println("No pending service requests.");
            return;
        }
        System.out.println("----- Pending Service Requests (front to rear) -----");
        Node current = front;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.request);
            current = current.next;
            count++;
        }
        System.out.println("-----------------------------------------------------");
    }
}