/*Create a program to display a calendar for a given month and year. The program should take the month and year as input from 
the user and display the calendar for that month.*/

import java.util.Scanner;

public class CalendarDisplay {

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysInMonth(int month, int year) {
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }

    public static String getMonthName(int month) {
        String[] months = { "January", "February", "March", "April", "May", "June",
                            "July", "August", "September", "October", "November", "December" };
        return months[month - 1];
    }

    public static int getFirstDay(int month, int year) {
		int d = 1;

		int y0 = year - (14 - month) / 12;
		int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
		int m0 = month + 12 * ((14 - month) / 12) - 2;
		int d0 = (d + x + (31 * m0) / 12) % 7;

		return d0; // 0 = Sunday, 1 = Monday, ..., 6 = Saturday
	}


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();
        System.out.print("Enter year: ");
        int year = input.nextInt();

        String monthName = getMonthName(month);
        int daysInMonth = getDaysInMonth(month, year);
        int firstDay = getFirstDay(month, year);

		System.out.println("     " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= daysInMonth; day++) {
			System.out.print(String.format("%3d ", day));
            // Move to next line after Saturday
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
    }
}
