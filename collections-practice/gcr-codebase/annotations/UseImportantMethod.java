package annotations;

import java.lang.reflect.Method;

public class UseImportantMethod {
	
	@ImportantMethod(level = "MEDIUM")
	public void levelMedium() {
		System.out.println("Level is medium.");
	}
	
	@ImportantMethod
	public void defaultLevel() {
		System.out.println("Default Level is high.");
	}

	public static void main(String[] args)throws Exception {
		Method[] methods = UseImportantMethod.class.getDeclaredMethods();
		
		for(Method m : methods) {
			if(m.isAnnotationPresent(ImportantMethod.class)) {
				ImportantMethod imp = m.getAnnotation(ImportantMethod.class);
				System.out.println("Method name: " + m.getName()+ " , " + "Level: " + imp.level());
			}
		}
	}
}
