package scenario.OnlineClassroomAttendanceTracker;
import java.util.*;

public class AttendanceTracker {
    // Map of SessionID to Set of StudentIDs
    private Map<String, Set<String>> attendanceMap;

    public AttendanceTracker() {
        attendanceMap = new HashMap<>();
    }

    // Mark attendance
    public void markAttendance(String sessionId, String studentId) throws DuplicateAttendanceException {
        Set<String> students = attendanceMap.getOrDefault(sessionId, new HashSet<>());
        if (students.contains(studentId)) {
            throw new DuplicateAttendanceException("Student " + studentId + " is already marked present for session " + sessionId);
        }
        students.add(studentId);
        attendanceMap.put(sessionId, students);
        System.out.println("Attendance marked for student " + studentId + " in session " + sessionId);
    }

    // Remove attendance
    public void removeAttendance(String sessionId, String studentId) {
        Set<String> students = attendanceMap.get(sessionId);
        if (students != null && students.remove(studentId)) {
            System.out.println("Attendance removed for student " + studentId + " from session " + sessionId);
        } else {
            System.out.println("No attendance found for student " + studentId + " in session " + sessionId);
        }
    }

    // Display attendance for a session
    public void displayAttendance(String sessionId) {
        Set<String> students = attendanceMap.get(sessionId);
        if (students == null || students.isEmpty()) {
            System.out.println("No attendance for session " + sessionId);
        } else {
            System.out.println("Attendance for session " + sessionId + ": " + students);
        }
    }

    // Display all attendance records
    public void displayAllAttendance() {
        if (attendanceMap.isEmpty()) {
            System.out.println("No attendance records found.");
            return;
        }
        for (String sessionId : attendanceMap.keySet()) {
            displayAttendance(sessionId);
        }
    }
}
