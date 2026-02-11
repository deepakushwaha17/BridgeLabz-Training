package scenario.EmployeeLeaveManagementSystem;

public class InsufficientLeaveBalanceException extends Exception {
    public InsufficientLeaveBalanceException(String message) {
        super(message);
    }
}