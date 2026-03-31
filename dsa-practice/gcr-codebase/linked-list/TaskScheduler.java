package dsaLinkedlist;

public class TaskScheduler {

	public static void main(String[] args) {

        CircularTaskScheduler scheduler = new CircularTaskScheduler();

        scheduler.addAtBeginning(1, "Database Backup", 1, "10-Oct-2026");
        scheduler.addAtEnd(2, "Code Review", 2, "12-Oct-2026");
        scheduler.addAtEnd(3, "Project Submission", 1, "15-Oct-2026");
        scheduler.addAtPosition(2, 4, "Team Meeting", 3, "11-Oct-2026");

        scheduler.displayAllTasks();

        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();

        scheduler.searchByPriority(1);
        scheduler.removeByTaskId(2);

        scheduler.displayAllTasks();
    }
}

class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

class CircularTaskScheduler {
	TaskNode head = null;
	TaskNode current = null;
	
	// method to add at beginning
	void addAtBeginning(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head)
                temp = temp.next;

            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
	}
	
	// method to add at end
	void addAtEnd(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head)
                temp = temp.next;

            temp.next = newNode;
            newNode.next = head;
        }
    }
	
	// method to add at given position
	void addAtPosition(int pos, int id, String name, int priority, String date) {
        if (pos == 1) {
            addAtBeginning(id, name, priority, date);
            return;
        }

        TaskNode newNode = new TaskNode(id, name, priority, date);
        TaskNode temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }
	
	// method to remove by id
	void removeByTaskId(int id) {
        if (head == null) return;

        TaskNode curr = head, prev = null;

        do {
            if (curr.taskId == id) {
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    TaskNode last = head;
                    while (last.next != head)
                        last = last.next;

                    head = head.next;
                    last.next = head;
                }
                System.out.println("Task removed: " + id);
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Task not found");
    }
	
	// method to view current task 
	void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available");
            return;
        }

        System.out.println("Current Task: " +current.taskId + " | " + current.taskName + 
        		" | Priority: " + current.priority + " | Due: " + current.dueDate);
        current = current.next;
    }
	
	// method to display all tasks
	void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        TaskNode temp = head;
        System.out.println("\nAll Tasks:");
        do {
            System.out.println(temp.taskId + " | " + temp.taskName +
                    " | Priority: " + temp.priority + " | Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
	
	// method to search by priority
	void searchByPriority(int priority) {
        if (head == null) {
        	System.out.println("No tasks available");
        	return;
        }

        TaskNode temp = head;
        System.out.println("\nTasks with Priority " + priority + ":");
        do {
            if (temp.priority == priority) {
                System.out.println(temp.taskId + " | " + temp.taskName + " | Due: " + temp.dueDate);
            }
            temp = temp.next;
        } while (temp != head);
	}	       
}