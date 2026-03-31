package functionalInterface;

// interface
interface SmartDevice{
	void turnOn();
	void turnOff();
}

// multiple classes implementing interface
class Lights implements SmartDevice{
	@Override
	public void turnOn(){
		System.out.println("Lights are turned on.") ;	
	}
	
	@Override
	public void turnOff(){
		System.out.println("Lights are turned off.") ;	
	}
	
}

class AC implements SmartDevice{
	@Override
	public void turnOn(){
		System.out.println("AC is turned on.") ;	
	}
	
	@Override
	public void turnOff(){
		System.out.println("AC is turned off.") ;	
	}
	
}

class TV implements SmartDevice{
	@Override
	public void turnOn(){
		System.out.println("TV is turned on.") ;	
	}
	
	@Override
	public void turnOff(){
		System.out.println("TV is turned off.") ;	
	}
	
}

public class SmartDeviceControl {

	public static void main(String[] args) {
		 Lights lights = new Lights();
		 lights.turnOn();
		 lights.turnOff();
		 
		 AC ac = new AC();
		 ac.turnOn();
		 ac.turnOff();
		 
		 TV tv = new TV();
		 tv.turnOn();
		 tv.turnOff();
	}

}