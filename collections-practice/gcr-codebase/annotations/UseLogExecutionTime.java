package annotations;

import java.lang.reflect.Method;

public class UseLogExecutionTime {
	
	@LogExecutionTime
    public void slowMethod() {
		int count = 0;
        for (int i = 0; i < 10000; i++) {
        	count++;
        }
        System.out.println("Slow method executed");
    }

    @LogExecutionTime
    public void fastMethod() {
    	int count = 0;
        for (int i = 0; i < 100; i++) {
        	count++;
        }
        System.out.println("Fast method executed");
    }

    public static void main(String[] args) throws Exception {
    	UseLogExecutionTime obj = new UseLogExecutionTime();
    	Method[] methods = UseLogExecutionTime.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long start = System.nanoTime();
                method.invoke(obj);
                long end = System.nanoTime();

                System.out.println(method.getName() + " execution time: " + (end - start) + " ns");
            }
        }
    }
}
