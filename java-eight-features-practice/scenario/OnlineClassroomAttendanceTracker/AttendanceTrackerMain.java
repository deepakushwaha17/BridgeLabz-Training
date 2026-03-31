package scenario.OnlineClassroomAttendanceTracker;

public class AttendanceTrackerMain {

    public static void main(String[] args) {
        AttendanceTracker tracker = new AttendanceTracker();

        try {
            tracker.markAttendance("S101", "STU001");
            tracker.markAttendance("S101", "STU002");
            tracker.markAttendance("S102", "STU003");
            
            // Attempt duplicate
            tracker.markAttendance("S101", "STU001");
        } catch (DuplicateAttendanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        tracker.displayAttendance("S101");
        tracker.displayAttendance("S102");

        tracker.removeAttendance("S101", "STU002");
        tracker.displayAttendance("S101");

        tracker.displayAllAttendance();
    }
}
