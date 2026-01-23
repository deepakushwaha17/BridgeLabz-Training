package collections.queue;

import java.util.*;

public class HospitalTriageSystem {

	public static void main(String[] args) {

        // PriorityQueue: higher severity first
        PriorityQueue<Patient> pq = new PriorityQueue<>(
            (p1, p2) -> p2.severity - p1.severity
        );

        // Adding patients
        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));

        System.out.println("Treatment Order:");

        // Treat patients based on priority
        while (!pq.isEmpty()) {
            Patient p = pq.poll();
            System.out.println(p.name);
        }
    }
}

class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}