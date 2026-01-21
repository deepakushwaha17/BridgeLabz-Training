package generics.CourseManagementSystem;

import java.util.List;

public class CourseUtil {

	public static void displayCourseTypes(List<? extends CourseType> types) {
		System.out.println("\n---- Course List ----");
		for(CourseType type : types) {
			System.out.println(type.getCourseType());
		}
		System.out.println("-----------------------");
	}
	
}
