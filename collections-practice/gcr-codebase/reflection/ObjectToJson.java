package reflection;
import java.lang.reflect.*;

class Person {
    public String name = "Deepa";
    public int age = 22;
}

public class ObjectToJson {
    public static String toJson(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder("{");
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            json.append("\"").append(fields[i].getName()).append("\": ");
            json.append("\"").append(fields[i].get(obj)).append("\"");
            if (i < fields.length - 1) json.append(", ");
        }
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        Person p = new Person();
        System.out.println(toJson(p));
    }
}

