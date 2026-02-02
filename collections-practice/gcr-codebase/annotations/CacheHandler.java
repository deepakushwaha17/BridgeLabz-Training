package annotations;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheHandler {

    // Cache: methodName+args -> result
    private Map<String, Object> cache = new HashMap<>();

    @CacheResult
    public int factorial(int n) {
        System.out.println("Computing factorial for " + n);
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Invoke method with caching
    public Object invoke(String methodName, Object... args) throws Exception {
        Method method = null;

        for (Method m : this.getClass().getDeclaredMethods()) {
            if (m.getName().equals(methodName)) {
                method = m;
                break;
            }
        }

        if (method == null) {
            throw new NoSuchMethodException(methodName);
        }

        String key = methodName + "-" + java.util.Arrays.deepToString(args);

        if (method.isAnnotationPresent(CacheResult.class) && cache.containsKey(key)) {
            System.out.println("Returning cached result for " + key);
            return cache.get(key);
        }

        Object result = method.invoke(this, args);

        if (method.isAnnotationPresent(CacheResult.class)) {
            cache.put(key, result);
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        CacheHandler handler = new CacheHandler();

        System.out.println("Result: " + handler.invoke("factorial", 5)); 
        System.out.println("Result: " + handler.invoke("factorial", 5)); 
        System.out.println("Result: " + handler.invoke("factorial", 6)); 
        System.out.println("Result: " + handler.invoke("factorial", 5)); 
    }
}
