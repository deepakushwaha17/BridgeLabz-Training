package inheritance;

public class SmartHomeDevice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thermostat thermo = new Thermostat("D001","ON","High");
		thermo.displayStatus();

	}

}

//Superclass
class Device{
	String deviceId;
	String status;
	
	Device(String deviceId , String status){
		this.deviceId = deviceId;
		this.status = status;
	}
}

//Subclass
class Thermostat extends Device{
	
	String temperatureSetting;
	
	Thermostat(String deviceId, String status, String temperatureSetting){
		super(deviceId,status);
		this.temperatureSetting = temperatureSetting;
	}
	
	void displayStatus() {
		System.out.println("Device ID : " +deviceId);
		System.out.println("Device Status : " +status);
		System.out.println("Temperature Settings : " +temperatureSetting);

	}
	
}