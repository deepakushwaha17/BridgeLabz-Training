package annotations;
import java.lang.reflect.Field;

public class User {
	
	@MaxLength(10)
	String username;
	
	public User(String username) {
		Field[] fields = this.getClass().getDeclaredFields();
		for(Field field : fields) {
			if(field.isAnnotationPresent(MaxLength.class)) {
				MaxLength maxLength = field.getAnnotation(MaxLength.class);
				if(field.getName().equals("username")) {
					if(username.length() > maxLength.value()) {
						throw new IllegalArgumentException("Username length should not exceed " + maxLength.value());
					}
				}
			}
		}
		this.username = username;
	}

	public static void main(String[] args) {
		User u1 = new User("Deepa123");
		System.out.println("User created: " + u1.username);
        User u2 = new User("LongUsername12345667");
        System.out.println("User created: " + u2.username);
	}
}