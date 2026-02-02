package annotations;

import java.lang.reflect.Field;

public class JSONUser {
	@JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public JSONUser(String username, int age) {
        this.username = username;
        this.age = age;
    }
    
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder();
        json.append("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                if (!first) json.append(", ");
                json.append("\"").append(annotation.name()).append("\": ");

                Object value = field.get(obj);
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }
                first = false;
            }
        }

        json.append("}");
        return json.toString();
    }
    
    public static void main(String[] args) throws IllegalAccessException {
    	JSONUser user = new JSONUser("Deepa", 22);
        String json = JSONUser.toJson(user);
        System.out.println(json);
    }
    
}


