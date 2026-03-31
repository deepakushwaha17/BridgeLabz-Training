package lambda;

@FunctionalInterface
interface LightTrigger{
	void activate();
}

public class SmartLightSystem {
	
	public static void main(String[] args) {
		LightTrigger motionTrigger = () -> System.out.println("Lights ON due to motion detection!");
     
        LightTrigger timeTrigger = () -> System.out.println("Lights dimmed for night mode.");

        LightTrigger voiceTrigger = () -> System.out.println("Lights set to bright mode by voice command.");

        System.out.println("Activating triggers:");
        motionTrigger.activate();
        timeTrigger.activate();
        voiceTrigger.activate();
	}
}