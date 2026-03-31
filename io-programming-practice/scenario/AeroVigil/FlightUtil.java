package scenario.AeroVigil;

import java.util.*;

public class FlightUtil {

    // Validate Flight Number
    public boolean validateFlightNumber(String flightNumber)
            throws InvalidFlightException {

        if (!flightNumber.matches("FL-[1-9][0-9]{3}")) {
            throw new InvalidFlightException(
                "The flight number " + flightNumber + " is invalid"
            );
        }
        return true;
    }

    // Validate Flight Name
    public boolean validateFlightName(String flightName)
            throws InvalidFlightException {

        List<String> validNames = Arrays.asList(
            "SpiceJet", "Vistara", "IndiGo", "Air Arabia"
        );

        boolean isValid = validNames.stream()
                .anyMatch(name -> name.equalsIgnoreCase(flightName));

        if (!isValid) {
            throw new InvalidFlightException(
                "The flight name " + flightName + " is invalid"
            );
        }
        return true;
    }

    // Validate Passenger Count
    public boolean validatePassengerCount(int passengerCount, String flightName)
            throws InvalidFlightException {

        Map<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("SpiceJet", 396);
        capacityMap.put("Vistara", 615);
        capacityMap.put("IndiGo", 230);
        capacityMap.put("Air Arabia", 130);

        int maxCapacity = capacityMap.get(flightName);

        if (passengerCount <= 0 || passengerCount > maxCapacity) {
            throw new InvalidFlightException(
                "The passenger count " + passengerCount +
                " is invalid for " + flightName
            );
        }
        return true;
    }

    // Calculate Fuel to Fill Tank
    public double calculateFuelToFillTank(String flightName, double currentFuelLevel)
            throws InvalidFlightException {

        Map<String, Double> fuelCapacity = new HashMap<>();
        fuelCapacity.put("SpiceJet", 200000.0);
        fuelCapacity.put("Vistara", 300000.0);
        fuelCapacity.put("IndiGo", 250000.0);
        fuelCapacity.put("Air Arabia", 150000.0);

        double maxFuel = fuelCapacity.get(flightName);

        if (currentFuelLevel < 0 || currentFuelLevel > maxFuel) {
            throw new InvalidFlightException(
                "Invalid fuel level for " + flightName
            );
        }

        return maxFuel - currentFuelLevel;
    }
}
