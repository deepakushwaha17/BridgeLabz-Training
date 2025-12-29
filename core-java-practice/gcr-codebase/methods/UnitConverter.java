/*Extend or Create a UnitConvertor utility class similar to the one shown in the notes to do the following.  
Please define static methods for all the UnitConvertor class methods. */

import java.util.Scanner;

public class UnitConverter {

    // Distance Conversions
     public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    public static double convertInchesToCm(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    // Temperature Conversions
    public static double convertFahrenheitToCelsius(double f) {
        double f2c = (f - 32) * 5 / 9;
        return f2c;
    }

    public static double convertCelsiusToFahrenheit(double c) {
        double c2f = (c * 9 / 5) + 32;
        return c2f;
    }

    // Weight Conversions
    public static double convertPoundsToKg(double pounds) {
        double pounds2kg = 0.453592;
        return pounds * pounds2kg;
    }

    public static double convertKgToPounds(double kg) {
        double kg2pounds = 2.20462;
        return kg * kg2pounds;
    }

    // Volume Conversions
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Measurement Converter!");
        System.out.println("Choose conversion type:");
        System.out.println("1. Km to Miles");
        System.out.println("2. Miles to Km");
        System.out.println("3. Meters to Feet");
        System.out.println("4. Feet to Meters");
        System.out.println("5. Yards to Feet");
        System.out.println("6. Feet to Yards");
        System.out.println("7. Meters to Inches");
        System.out.println("8. Inches to Meters");
        System.out.println("9. Inches to Centimeters");
        System.out.println("10. Fahrenheit to Celsius");
        System.out.println("11. Celsius to Fahrenheit");
        System.out.println("12. Pounds to Kilograms");
        System.out.println("13. Kilograms to Pounds");
        System.out.println("14. Gallons to Liters");
        System.out.println("15. Liters to Gallons");
        System.out.print("Enter your choice (1-15): ");
        int choice = input.nextInt();

        System.out.print("Enter the value to convert: ");
        double value = input.nextDouble();
        double result = 0;

        switch(choice) {
            case 1: 
                result = convertKmToMiles(value); 
                break;
            case 2: 
                result = convertMilesToKm(value); 
                break;
            case 3: 
                result = convertMetersToFeet(value); 
                break;
            case 4: 
                result = convertFeetToMeters(value); 
                break;
            case 5: 
                result = convertYardsToFeet(value); 
                break;
            case 6: 
                result = convertFeetToYards(value); 
                break;
            case 7: 
                result = convertMetersToInches(value); 
                break;
            case 8: 
                result = convertInchesToMeters(value); 
                break;
            case 9: 
                result = convertInchesToCm(value); 
                break;
            case 10: 
                result = convertFahrenheitToCelsius(value); 
                break;
            case 11: 
                result = convertCelsiusToFahrenheit(value); 
                break;
            case 12: 
                result = convertPoundsToKg(value); 
                break;
            case 13: 
                result = convertKgToPounds(value); 
                break;
            case 14: 
                result = convertGallonsToLiters(value); 
                break;
            case 15: 
                result = convertLitersToGallons(value); 
                break;
            default: 
                System.out.println("Invalid choice!"); 
                input.close(); 
                System.exit(0);
        }
        System.out.println("Converted value: " + result);
        input.close();
    }
}
