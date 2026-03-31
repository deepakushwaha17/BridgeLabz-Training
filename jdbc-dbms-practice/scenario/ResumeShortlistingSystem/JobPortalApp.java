package scenario.ResumeShortlistingSystem;
import java.util.*;

public class JobPortalApp {
    public static void main(String[] args) throws Exception {
        JobPortal portal = new JobPortal();

        Resume r1 = new Resume("Deepa", new HashSet<>(Arrays.asList("Java", "SQL", "Spring")));
        Resume r2 = new Resume("Mahi", new HashSet<>(Arrays.asList("Java", "Python", "AWS")));
        Resume r3 = new Resume("Rahul", new HashSet<>(Arrays.asList("Python", "Django")));

        portal.addResume(r1);
        portal.addResume(r2);
        portal.addResume(r3);

        Set<String> requiredSkills = new HashSet<>(Arrays.asList("Java", "Spring", "AWS"));
        portal.shortlistResumes(requiredSkills);
    }
}