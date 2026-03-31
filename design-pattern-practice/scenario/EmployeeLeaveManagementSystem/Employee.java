package scenario.EmployeeLeaveManagementSystem;

public class Employee {
    private String employeeID;
    private String name;
    private int leaveBalance;

    public Employee(String employeeID, String name, int leaveBalance) {
        this.employeeID = employeeID;
        this.name = name;
        this.leaveBalance = leaveBalance;
    }

    public String getEmployeeID() { return employeeID; }
    public String getName() { return name; }
    public int getLeaveBalance() { return leaveBalance; }

    public void deductLeave(int days) throws InsufficientLeaveBalanceException {
        if (days > leaveBalance) {
            throw new InsufficientLeaveBalanceException("Not enough leave balance!");
        }
        leaveBalance -= days;
    }
}
