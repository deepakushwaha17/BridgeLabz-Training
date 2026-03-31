package reflection;

import java.lang.reflect.Method;

public class MethodTiming {

    // Method whose execution time we want to measure
    void task() throws InterruptedException {
        Thread.sleep(400); 
        System.out.println("Task completed");
    }

    public static void main(String[] args) throws Exception {

        MethodTiming obj = new MethodTiming();

        //Get method using Reflection
        Method method = MethodTiming.class.getDeclaredMethod("task");

        //Measure execution time
        long start = System.nanoTime();
        method.invoke(obj);
        long end = System.nanoTime();

        System.out.println("Execution Time (ms): " + (end - start) / 1_000_000);
    }
}
