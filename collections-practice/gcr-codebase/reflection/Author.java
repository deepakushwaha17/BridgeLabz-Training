package reflection;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Author {

	  String name();
}
