/*Create a program to find the bonus of 10 employees based on their years of service as well as the 
total bonus amount the 10-year-old company Zara has to pay as a bonus, along with the old and new salary. */

public class BonusCalculator {
  
    // Generate salary and years of service using Math.random()
    public static double[][] generateEmployeeData() {

        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {

            // 5-digit salary between 10000 and 99999
            data[i][0] = 10000 + (int)(Math.random() * 90000);

            // Years of service between 1 and 10
            data[i][1] = 1 + (int)(Math.random() * 10);
        }
        return data;
    }

    // Calculate bonus and new salary
    public static double[][] calculateBonus(double[][] employeeData) {

        double[][] result = new double[10][2];

        for (int i = 0; i < 10; i++) {

            double salary = employeeData[i][0];
            double years  = employeeData[i][1];
            double bonus;

            if (years > 5) {
                bonus = salary * 0.05;
            } else {
                bonus = salary * 0.02;
            }

            result[i][0] = salary + bonus; // New Salary
            result[i][1] = bonus;          // Bonus
        }
        return result;
    }

    // Calculate totals and display in tabular format
    public static int calculateAndDisplayTotals(
            double[][] employeeData, double[][] salaryBonusData) {

        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus     = 0;

        System.out.println("\nZARA EMPLOYEE BONUS DETAILS");
        System.out.println("Emp\tOld Salary\tYears\tBonus\t\tNew Salary");

        for (int i = 0; i < 10; i++) {

            double oldSalary = employeeData[i][0];
            double years     = employeeData[i][1];
            double bonus     = salaryBonusData[i][1];
            double newSalary = salaryBonusData[i][0];

            totalOldSalary += oldSalary;
            totalBonus     += bonus;
            totalNewSalary += newSalary;

            System.out.printf("%d\t%.0f\t\t%.0f\t%.2f\t\t%.2f\n",
                    (i + 1), oldSalary, years, bonus, newSalary);
        }
        System.out.printf("TOTAL\t%.2f\t\t%.2f\t%.2f\n",
                totalOldSalary, totalBonus, totalNewSalary);

        return 1;
    }
    public static void main(String[] args) {

        double[][] employeeData = generateEmployeeData();
        double[][] salaryBonusData = calculateBonus(employeeData);

        calculateAndDisplayTotals(employeeData, salaryBonusData);
    }

}