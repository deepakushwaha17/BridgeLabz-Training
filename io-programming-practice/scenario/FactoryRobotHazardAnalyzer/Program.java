package scenario.FactoryRobotHazardAnalyzer;
import java.util.*;

public class Program {

	public static void main(String[] args) {
		
		try {
			Scanner input = new Scanner(System.in);
			RobotHazardAuditor auditor = new RobotHazardAuditor();
			
			System.out.println("Enter Arm Precision (0.0 - 1.0):");
			double armPrecision = input.nextDouble();
			System.out.println("Enter Worker Density (1 - 20):");
			int workerDensity = input.nextInt();
			input.nextLine();
			System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
			String machineryState = input.next();
			
			double result = auditor.calculateHazardRisk(armPrecision, workerDensity, machineryState);
			System.out.println("Robot Hazard Risk Score: " + result);
			
			input.close();
		}
		catch(RobotSafetyException e) {
			System.out.println(e.getMessage());
		}
	}

}
