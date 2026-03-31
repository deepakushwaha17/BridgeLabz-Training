package annotations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Todo {
	String task();
	String assignedTo();
	String priority() default "MEDIUM";
}