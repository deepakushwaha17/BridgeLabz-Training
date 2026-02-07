package scenario.OceanFleet;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VesselUtil vesselUtil = new VesselUtil();
		
		System.out.println("Enter number of vessels: ");
		int n = sc.nextInt();
		sc.nextLine();

		// Add vessel
		System.out.println("Enter vessel details:");
		for(int i = 0; i < n; i++) {	
			String[] input = sc.nextLine().split(":");
			
			String vesselId = input[0];
	        String vesselName = input[1];
	        double averageSpeed = Double.parseDouble(input[2]);
	        String vesselType = input[3];
	        
	        Vessel vessel = new Vessel(vesselId, vesselName, averageSpeed, vesselType);
	        vesselUtil.addVesselPerformance(vessel);
		}
		
		// Retrieve vessel by Id
		System.out.println("Enter the Vessel Id to check speed:");
        String searchId = sc.nextLine();
        Vessel foundVessel = vesselUtil.getVesselById(searchId);
        
        if (foundVessel != null) {
            System.out.printf("%s | %s | %s | %.1f knots%n",
                    foundVessel.getVesselId(),
                    foundVessel.getVesselName(),
                    foundVessel.getVesselType(),
                    foundVessel.getAverageSpeed());
        } else {
            System.out.println("Vessel Id " + searchId + " not found");
        }
        
        // Display high-performance vessels
        System.out.println("High performance vessels are:");
        List<Vessel> highPerformers = vesselUtil.getHighPerformanceVessels();
        for (Vessel v : highPerformers) {
            System.out.printf("%s | %s | %s | %.1f knots%n",
                    v.getVesselId(),
                    v.getVesselName(),
                    v.getVesselType(),
                    v.getAverageSpeed());
        }

        sc.close();
	}

}
