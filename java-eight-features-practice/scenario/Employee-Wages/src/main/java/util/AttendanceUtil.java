package util;

public class AttendanceUtil {
	public static final int ABSENT = 0;
	public static final int FULL_TIME = 1;
	public static final int PART_TIME = 2;

	// UC1 - Check Employee is Present or Absent
	public static int getAttendance() {
		return (int) (Math.random() * 3);
	}
	
	// UC3 - Add Part time Employee 
	public static int getWorkingHours(int attendance) {
		// UC4 - Solving using Switch Case Statement
		return switch(attendance) {
		case FULL_TIME -> 8;
		case PART_TIME -> 4;
		default -> 0;
		};
	}
}