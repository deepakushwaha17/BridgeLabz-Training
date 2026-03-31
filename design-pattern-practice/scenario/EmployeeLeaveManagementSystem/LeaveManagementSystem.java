package scenario.EmployeeLeaveManagementSystem;

import java.util.*;

public class LeaveManagementSystem {
    private Map<String, Employee> employees = new HashMap<>();
    private List<LeaveRequest> leaveRequests = new ArrayList<>();

    public void addEmployee(Employee emp) {
        employees.put(emp.getEmployeeID(), emp);
    }

    public void requestLeave(String employeeID, int days) {
        leaveRequests.add(new LeaveRequest(employeeID, days));
        System.out.println("Leave requested for " + employeeID + " for " + days + " days.");
    }

    public void processLeave() {
        for (LeaveRequest lr : leaveRequests) {
            if (lr.getStatus().equals("Pending")) {
                Employee emp = employees.get(lr.getEmployeeID());
                try {
                    emp.deductLeave(lr.getDays());
                    lr.setStatus("Approved");
                    System.out.println("Leave approved for " + emp.getName());
                } catch (InsufficientLeaveBalanceException e) {
                    lr.setStatus("Rejected");
                    System.out.println("Leave rejected for " + emp.getName() + ": " + e.getMessage());
                }
            }
        }
    }

    public void showLeaveRequests() {
        for (LeaveRequest lr : leaveRequests) {
            System.out.println("EmployeeID: " + lr.getEmployeeID() + ", Days: " + lr.getDays() + ", Status: " + lr.getStatus());
        }
    }
}