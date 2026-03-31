package scenario.EmployeeLeaveManagementSystem;

public class LeaveManagementSystemMain {

    public static void main(String[] args) {
        LeaveManagementSystem lms = new LeaveManagementSystem();

        Employee e1 = new Employee("E101", "Deepa", 10);
        Employee e2 = new Employee("E102", "Mahi", 5);

        lms.addEmployee(e1);
        lms.addEmployee(e2);

        lms.requestLeave("E101", 4);
        lms.requestLeave("E102", 6); // Should fail

        lms.processLeave();
        lms.showLeaveRequests();
    }
}