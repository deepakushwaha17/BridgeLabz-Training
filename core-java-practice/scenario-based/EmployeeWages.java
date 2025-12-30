public class EmployeeWages {

    static final int IS_PRESENT = 1;
    static final int IS_PART_TIME = 1;
    static final int IS_FULL_IME = 2;
    static final int WAGE_PER_HOUR = 20;
    static final int FULL_DAY_HOURS = 8;
    static final int PART_TIME_HOURS = 4;
    static final int WORKING_DAYS = 20;
    static final int MAX_HOURS = 100;

    // UC 1: Check Employee Attendance
    public static void checkAttendance() {
        int attendance = (int) (Math.random() * 2);

        if (attendance == IS_PRESENT) {
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }
    }

    // UC 2: Calculate Daily Employee Wage
    public static void calculateDailyWage() {
        int attendance = (int) (Math.random() * 2);
        int dailyWage = 0;

        if (attendance == IS_PRESENT) {
            dailyWage = FULL_DAY_HOURS * WAGE_PER_HOUR;
        }

        System.out.println("Daily Employee Wage : " + dailyWage);
    }

    // UC 3: Add Part Time Employee & Wage
    public static void addPartTimeWage() {
        int empCheck = (int) (Math.random()*2) + 1;
        int empHrs = 0;
        if(empCheck == IS_PART_TIME){
            empHrs = 4;
        } else if(empCheck == IS_FULL_IME){
            empHrs = 8;
        }
        int empTimeWage = empHrs * WAGE_PER_HOUR;
        System.out.println("Employee Wage : " + empTimeWage);
    }

    // UC4 : Calculate wage using switch case
    public static void calculateWageUsingSwitch(){
        int empCheck = (int) (Math.random()*2) + 1;
        int empHrs = 0;
        switch (empCheck) {
            case IS_PART_TIME :
                empHrs = 4;
                break;
            case IS_FULL_IME :
                empHrs = 8;
                break;
            default:
                empHrs = 0;
        }
        
        int empTimeWage = empHrs * WAGE_PER_HOUR;
        System.out.println("Employee Wage using switch : " + empTimeWage);
    }

    // UC5: Calculate Monthly Wages
    public static void calculateMonthlyWage() {
        int monthlyWage = WORKING_DAYS * FULL_DAY_HOURS * WAGE_PER_HOUR;
        System.out.println("Monthly Employee Wage : " + monthlyWage);
    }

    // UC 6: Calculate Wage Till Condition (Hours or Days)
    public static void calculateWageTillCondition() {
        int totalHours = 0;
        int totalDays = 0;

        while (totalHours < MAX_HOURS && totalDays < WORKING_DAYS) {
            totalDays++;
            int attendance = (int) (Math.random() * 2);

            if (attendance == IS_PRESENT) {
                totalHours += FULL_DAY_HOURS;
            }
        }

        int totalWage = totalHours * WAGE_PER_HOUR;
        System.out.println("Total Wage till Condition Reached : " + totalWage);
        System.out.println("Total Days Worked : " + totalDays);
        System.out.println("Total Hours Worked : " + totalHours);
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program !");
        checkAttendance();
        calculateDailyWage();
        addPartTimeWage();
        calculateWageUsingSwitch();
        calculateMonthlyWage();
        calculateWageTillCondition();
                
    }
    
}
