package reflection;

import java.lang.reflect.*;
import java.util.*;

class Students {
    public String name;
    public int age;
}

public class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();
        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);
            if (properties.containsKey(f.getName())) f.set(obj, properties.get(f.getName()));
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "Deepa");
        properties.put("age", 22);

        Students s = toObject(Students.class, properties);
        System.out.println(s.name + ", " + s.age);
    }
}
