package annotations;
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Repeatable(RepeatableAnnotation.class)
@Retention(RetentionPolicy.RUNTIME)

public @interface BugReport {

	String description();
}
