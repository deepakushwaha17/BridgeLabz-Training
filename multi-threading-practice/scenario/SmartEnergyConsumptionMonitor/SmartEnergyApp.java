package scenario.SmartEnergyConsumptionMonitor;

import java.util.*;

public class SmartEnergyApp {
    public static void main(String[] args) throws Exception {
        EnergyMonitor monitor = new EnergyMonitor();
        Calendar cal = Calendar.getInstance();

        cal.set(2026, 1, 10); 
        monitor.addReading(cal.getTime(), 5.5);
        monitor.addReading(cal.getTime(), 4.2);

        cal.set(2026, 1, 11); 
        monitor.addReading(cal.getTime(), 6.1);

        monitor.showDailyAverage(cal.getTime()); 
        monitor.showMonthlyAverage(2, 2026);   
    }
}