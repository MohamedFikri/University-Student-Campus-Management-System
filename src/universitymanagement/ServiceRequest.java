package universitymanagement;

/**
 * ServiceRequest.java
 * Author: Asheem
 *
 * Simple model class representing a single student service request,
 * e.g.:
 *   ST001 - ID card request
 *   ST002 - Transcript request
 *
 * Used by ServiceQueue.java to process requests in the order they arrive.
 */
public class ServiceRequest {

    private String studentId;
    private String requestType;

    public ServiceRequest(String studentId, String requestType) {
        this.studentId = studentId;
        this.requestType = requestType;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    @Override
    public String toString() {
        return studentId + " - " + requestType;
    }
}