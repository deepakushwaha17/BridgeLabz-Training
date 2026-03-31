package scenario.FactoryRobotHazardAnalyzer;

public class RobotHazardAuditor {
	
	public double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState) throws RobotSafetyException{
		if(armPrecision < 0.0 || armPrecision > 1.0) {
			throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
		}
		
		if(workerDensity < 1 || workerDensity > 20) {
			throw new RobotSafetyException("Error: Worker density must be 1-20");
		}
		
		// Computing machine risk factor
		double machineRiskFactor = 0;
		if(machineryState.equals("Worn")) {
			machineRiskFactor = 1.3;
		}else if(machineryState.equals("Faculty")) {
			machineRiskFactor = 2.0;
		}else if(machineryState.equals("Critical")) {
			machineRiskFactor = 3.0;
		}else {
			throw new RobotSafetyException("Error: Unsupported machinery state");
		}
		
		double hazardRisk = ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor);
		return hazardRisk;
	}

}
