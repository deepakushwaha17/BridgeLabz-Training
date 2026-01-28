package scenario;
import java.util.*;

// Custom Exception
class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String message) {
        super(message);
    }
}

// BackuoTask implements Comparable
class BackupTask implements Comparable<BackupTask> {
    String path;
    int priority; // higher number - higher priority
    String scheduledTime;

    public BackupTask(String path, int priority, String scheduledTime) {
        this.path = path;
        this.priority = priority;
        this.scheduledTime = scheduledTime;
    }

    @Override
    public int compareTo(BackupTask other) {
        // Higher priority tasks come first
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return "BackupTask[path=" + path + ", priority=" + priority + ", time=" + scheduledTime + "]";
    }
}

// BackupScheduler class to perform backup and exceution
class BackupScheduler {

    PriorityQueue<BackupTask> tasks = new PriorityQueue<>();

    // Add a backup task
    void addTask(String path, int priority, String time) throws InvalidBackupPathException {
        if (path == null || path.isEmpty()) {
            throw new InvalidBackupPathException("Invalid backup path!");
        }
        tasks.add(new BackupTask(path, priority, time));
        System.out.println("Task added: " + path);
    }

    // Execute all tasks in priority order
    void executeTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to execute.");
            return;
        }
        System.out.println("Executing backup tasks in priority order:");
        while (!tasks.isEmpty()) {
            BackupTask task = tasks.poll();
            System.out.println("Backing up: " + task.path + " at " + task.scheduledTime + " (Priority: " + task.priority + ")");
        }
    }
}


public class FileBackupScheduler {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BackupScheduler scheduler = new BackupScheduler();

        while (true) {
            System.out.println("\n=== File Backup Scheduler Menu ===");
            System.out.println("1. Add Backup Task");
            System.out.println("2. Execute All Tasks");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Backup Path: ");
                    String path = input.nextLine();
                    System.out.print("Enter Priority (higher number = higher priority): ");
                    int priority = input.nextInt();
                    input.nextLine(); // consume newline
                    System.out.print("Enter Scheduled Time (e.g., 10:00AM): ");
                    String time = input.nextLine();

                    try {
                        scheduler.addTask(path, priority, time);
                    } catch (InvalidBackupPathException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    scheduler.executeTasks();
                    break;

                case 3:
                    System.out.println("Exiting Backup Scheduler....");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
