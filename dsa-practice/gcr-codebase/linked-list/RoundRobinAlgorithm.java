package dsaLinkedlist;

public class RoundRobinAlgorithm {
	public static void main(String[] args) {

		RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);

        int timeQuantum = 4; // fixed time quantum

        System.out.println("----Round Robin Scheduling Simulation----");
        scheduler.simulate(timeQuantum);
    }

}

class ProcessNode {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    ProcessNode next;

    ProcessNode(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime; // initially remaining = burst
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    ProcessNode head = null;

    // method to Add process at end
    void addProcess(int pid, int burst, int priority) {
        ProcessNode newNode = new ProcessNode(pid, burst, priority);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            ProcessNode temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // method to Remove process by PID
    void removeProcess(int pid) {
        if (head == null) {
        	return;
        }

        ProcessNode temp = head, prev = null;
        do {
            if (temp.pid == pid) {
                if (prev != null) {
                    prev.next = temp.next;
                } else { 
                	// removing head
                    ProcessNode last = head;
                    while (last.next != head)
                        last = last.next;
                    head = head.next;
                    last.next = head;
                }
                System.out.println("Process completed and removed: " + pid);
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // method to Display processes in circular queue
    void displayProcesses() {
        if (head == null) {
            System.out.println("No processes left.");
            return;
        }
        ProcessNode temp = head;
        System.out.println("\nProcesses in Queue:");
        do {
            System.out.println("PID: " + temp.pid + " | Remaining Burst: " + temp.remainingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // method to Round-robin simulation
    void simulate(int timeQuantum) {
        if (head == null) {
        	return;
        }

        ProcessNode current = head;
        int totalTime = 0;
        int completed = 0;
        int n = countProcesses();

        int[] waitingTime = new int[n + 1];   // PID-based index
        int[] turnAroundTime = new int[n + 1];

        while (completed < n) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, current.remainingTime);
                System.out.println("Process PID " + current.pid + " executing for " + execTime + " units");
                current.remainingTime -= execTime;
                totalTime += execTime;

                // Update waiting time for other processes
                ProcessNode temp = head;
                do {
                    if (temp != current && temp.remainingTime > 0)
                        waitingTime[temp.pid] += execTime;
                    temp = temp.next;
                } while (temp != head);

                if (current.remainingTime == 0) {
                    turnAroundTime[current.pid] = totalTime;
                    completed++;
                    System.out.println("Process PID " + current.pid + " finished");
                }

                displayProcesses();
            }
            current = current.next;
        }

        // Display average times
        double totalWT = 0, totalTAT = 0;
        for (int i = 1; i <= n; i++) {
            totalWT += waitingTime[i];
            totalTAT += turnAroundTime[i];
            System.out.println("PID " + i + ": Waiting Time = " + waitingTime[i] + ", Turnaround Time = " + turnAroundTime[i]);
        }
        System.out.println("\nAverage Waiting Time = " + (totalWT / n));
        System.out.println("Average Turnaround Time = " + (totalTAT / n));
    }

    int countProcesses() {
        if (head == null) return 0;
        int count = 0;
        ProcessNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}
