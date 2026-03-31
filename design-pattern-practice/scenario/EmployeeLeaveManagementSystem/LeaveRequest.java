package scenario.EmployeeLeaveManagementSystem;

public class LeaveRequest {
    private String employeeID;
    private int days;
    private String status; // Pending, Approved, Rejected

    public LeaveRequest(String employeeID, int days) {
        this.employeeID = employeeID;
        this.days = days;
        this.status = "Pending";
    }

    public String getEmployeeID() { return employeeID; }
    public int getDays() { return days; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}