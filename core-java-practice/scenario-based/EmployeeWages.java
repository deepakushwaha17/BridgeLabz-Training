import java.util.Scanner;

public class EmployeeWages {

    static final int IS_PRESENT = 1;
    static final int WAGE_PER_HOUR = 20;
    static final int FULL_DAY_HOURS = 8;
    static final int PART_TIME_HOURS = 8;
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

        System.out.println("Daily Employee Wage: " + dailyWage);
    }

    // UC 3: Add Part Time Employee & Wage
    public static void calculatePartTimeWage() {
        int partTimeWage = PART_TIME_HOURS * WAGE_PER_HOUR;
        System.out.println("Part Time Employee Wage: " + partTimeWage);
    }

    // UC5: Calculate Monthly Wages
    public static void calculateMonthlyWage() {
        int monthlyWage = WORKING_DAYS * FULL_DAY_HOURS * WAGE_PER_HOUR;
        System.out.println("Monthly Employee Wage: " + monthlyWage);
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
        System.out.println("Total Wage till Condition Reached: " + totalWage);
        System.out.println("Total Days Worked: " + totalDays);
        System.out.println("Total Hours Worked: " + totalHours);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Employee Wage Computation Program !");
        System.out.println("1. Check Attendance");
        System.out.println("2. Calculate Daily Wage");
        System.out.println("3. Calculate Part Time Wage");
        System.out.println("4. Calculate Monthly Wage");
        System.out.println("5. Calculate Wage Till Condition");

        System.out.print("Enter your choice: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                checkAttendance();
                break;
            case 2:
                calculateDailyWage();
                break;
            case 3:
                calculatePartTimeWage();
                break;
            case 4:
                calculateMonthlyWage();
                break;
            case 5:
                calculateWageTillCondition();
                break;
            default:
                System.out.println("Invalid Choice");
        }

        input.close();
    }
    
}
