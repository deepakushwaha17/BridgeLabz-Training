package dsaProblems;

import java.util.*;

class PetrolPump {
    int petrol;
    int distance;

    PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTourProblem {
	
	 public static int findStartPump(PetrolPump[] pumps) {
	        int n = pumps.length;
	        Queue<Integer> queue = new LinkedList<>();

	        // Enqueue all pump indices
	        for (int i = 0; i < n; i++) {
	            queue.add(i);
	        }

	        int tried = 0; // number of pumps tried
	        while (tried < n) {
	            int start = queue.peek();
	            int currentPetrol = 0;
	            boolean canComplete = true;

	            for (int i = 0; i < n; i++) {
	                int index = (start + i) % n;
	                currentPetrol += pumps[index].petrol - pumps[index].distance;
	                if (currentPetrol < 0) {
	                    // Cannot start from this pump
	                    canComplete = false;
	                    break;
	                }
	            }

	            if (canComplete) {
	                return start;
	            } else {
	                // Move front pump to back and try next
	                queue.add(queue.poll());
	                tried++;
	            }
	        }

	        return -1;
	    }

	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);

	        System.out.print("Enter number of petrol pumps: ");
	        int n = input.nextInt();
	        PetrolPump[] pumps = new PetrolPump[n];

	        System.out.println("Enter petrol and distance to next pump for each pump:");
	        for (int i = 0; i < n; i++) {
	            int petrol = input.nextInt();
	            int distance = input.nextInt();
	            pumps[i] = new PetrolPump(petrol, distance);
	        }

	        int startIndex = findStartPump(pumps);
	        if (startIndex == -1) {
	            System.out.println("No possible starting pump.");
	        } else {
	            System.out.println("Start at pump index: " + startIndex);
	        }

	        input.close();
	    }

}
