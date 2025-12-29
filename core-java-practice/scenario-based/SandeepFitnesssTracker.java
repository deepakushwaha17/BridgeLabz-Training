/*Sandeep’s Fitness Challenge Tracker ️‍♂️
Each day Sandeep completes a number of push-ups.
● Store counts for a week.
● Use for-each to calculate total and average.
● Use continue to skip rest days.*/

import java.util.Scanner;

public class SandeepFitnesssTracker{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] days = {"Monday" ,"Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        int[] eachDayPushups = new int[7];
        for(int i = 0; i < 7; i++){
            System.out.print("Enter push-ups on " + days[i] + " (0 if rest day) : ");
            int count = input.nextInt();

            if(count == 0){
                System.out.println(days[i] + " is the rest day.");
                continue;
            }

            eachDayPushups[i] = count;
        }

        int totalPushUps = 0;
        int totalWorkOutDay = 0;
        for(int counts : eachDayPushups){
            totalPushUps += counts;
            if(counts > 0){
                totalWorkOutDay++;
            }
        }
        double averagePushUp = (double)totalPushUps/totalWorkOutDay;
        System.out.println("\nTotal Push-ups completed in a week is " + totalPushUps);
        System.out.println("Average Push-ups for active day is " + averagePushUp);
        input.close();

    }
}