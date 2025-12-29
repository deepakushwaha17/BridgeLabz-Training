//Write a program calculate the wind chill temperature given the temperature and wind speed

import java.util.Scanner;

public class WindChillCalculation {

    public static double calculateWindChill(double temperature, double windSpeed) {
        double windChill = 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
        return windChill;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter temperature (°F): ");
        double temperature = input.nextDouble();
        System.out.print("Enter wind speed (mph): ");
        double windSpeed = input.nextDouble();

        double windChill = calculateWindChill(temperature, windSpeed);
        System.out.println("The wind chill temperature is " + windChill);
        input.close();
    }
}
