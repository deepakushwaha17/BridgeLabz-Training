package reflection;

import java.lang.reflect.*;

public class Configuration {
    private static String API_KEY = "OLD_KEY";

    public static void main(String[] args) throws Exception {
        Field apiField = Configuration.class.getDeclaredField("API_KEY");
        apiField.setAccessible(true);
        apiField.set(null, "NEW_KEY"); // null for static field
        System.out.println("API_KEY: " + apiField.get(null));
    }
}
