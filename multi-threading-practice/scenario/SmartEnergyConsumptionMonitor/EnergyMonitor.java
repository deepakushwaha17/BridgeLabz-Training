package scenario.SmartEnergyConsumptionMonitor;

import java.util.*;

public class EnergyMonitor {
    private Map<Date, List<Double>> energyData = new HashMap<>();

    public void addReading(Date date, double reading) throws InvalidEnergyReadingException {
        if (reading < 0) {
            throw new InvalidEnergyReadingException("Energy reading cannot be negative!");
        }
        energyData.putIfAbsent(date, new ArrayList<>());
        energyData.get(date).add(reading);
    }

    public void showDailyAverage(Date date) {
        List<Double> readings = energyData.get(date);
        if (readings == null || readings.isEmpty()) {
            System.out.println("No readings for " + date);
            return;
        }
        double avg = readings.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        System.out.println("Average energy usage on " + date + ": " + avg + " kWh");
    }

    public void showMonthlyAverage(int month, int year) {
        double sum = 0;
        int count = 0;
        Calendar cal = Calendar.getInstance();

        for (Date date : energyData.keySet()) {
            cal.setTime(date);
            int dMonth = cal.get(Calendar.MONTH) + 1;
            int dYear = cal.get(Calendar.YEAR);
            if (dMonth == month && dYear == year) {
                for (double val : energyData.get(date)) {
                    sum += val;
                    count++;
                }
            }
        }
        double avg = count == 0 ? 0 : sum / count;
        System.out.println("Average energy usage in " + month + "/" + year + ": " + avg + " kWh");
    }
}