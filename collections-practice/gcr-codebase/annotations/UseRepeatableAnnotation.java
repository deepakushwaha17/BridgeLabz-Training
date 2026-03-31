package annotations;
import java.lang.reflect.Method;
public class UseRepeatableAnnotation {
	
	@BugReport(description = "NullPointerException can occur")
	@BugReport(description = "ArrayIndexOutOfBounds can occur")
	public void getBugReports() {
		System.out.println("Processing user data...");
	}

	public static void main(String[] args) throws Exception{
		Method m = UseRepeatableAnnotation.class.getMethod("getBugReports");
		BugReport[] reports = m.getAnnotationsByType(BugReport.class);
		for(BugReport r : reports) {
			System.out.println("Bug: " + r.description());
		}
	}
}