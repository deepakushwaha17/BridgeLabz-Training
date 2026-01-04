/*Scenario: You're analyzing a week’s worth of hourly temperature data stored in a 2D array
(float[7][24]).
Problem:
Write a method to:
 ● Find the hottest and coldest day,
 ● Return average temperature per day.*/

package classandobject;

import java.util.Scanner;

public class TemperatureAnalyzer {

    //calculate daily averages
    public static float[] averageTemperaturePerDay(float[][] temps) {
        float[] dailyAvg = new float[temps.length];

        for (int day = 0; day < temps.length; day++) {
            float sum = 0;
            for (int hour = 0; hour < temps[day].length; hour++) {
                sum += temps[day][hour];
            }
            dailyAvg[day] = sum / temps[day].length;
        }
        return dailyAvg;
    }

    //find hottest and coldest day
    public static void findHottestColdestDay(float[][] temps) {
        float[] dailyAvg = averageTemperaturePerDay(temps);

        int hottestDay = 0;
        int coldestDay = 0;

        for (int i = 1; i < dailyAvg.length; i++) {
            if (dailyAvg[i] > dailyAvg[hottestDay]) hottestDay = i;
            if (dailyAvg[i] < dailyAvg[coldestDay]) coldestDay = i;
        }

        System.out.println("Hottest Day: Day " + (hottestDay + 1) + " with avg temp " + dailyAvg[hottestDay]);
        System.out.println("Coldest Day: Day " + (coldestDay + 1) + " with avg temp " + dailyAvg[coldestDay]);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int days = 7;
        int hours = 24;

        float[][] temps = new float[days][hours];

        System.out.println("Enter temperatures for 7 days (24 hours each):");
        for (int day = 0; day < days; day++) {
            System.out.println("Day " + (day + 1) + ":");
            for (int hour = 0; hour < hours; hour++) {
                while (true) {
                    System.out.print("Hour " + (hour + 1) + ": ");
                    try {
                        temps[day][hour] = Float.parseFloat(input.next());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Enter a number.");
                    }
                }
            }
        }

        findHottestColdestDay(temps);

        float[] dailyAvg = averageTemperaturePerDay(temps);
        for (int i = 0; i < dailyAvg.length; i++) {
            System.out.println("Day " + (i + 1) + " Average: " + dailyAvg[i]);
        }
        
    }
}
