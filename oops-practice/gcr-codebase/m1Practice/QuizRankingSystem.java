package m1Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
	String name;
	String department;
	int q1, q2, q3;

	public Student(String name, String department, int q1, int q2, int q3) {
		this.name = name;
		this.department = department;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
	}

	public int total() {
		return q1 + q2 + q3;
	}
}

public class QuizRankingSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n : ");
		int n = Integer.parseInt(sc.nextLine());

		List<Student> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			String[] parts = line.split(" ");

			if (parts[0].equals("Record")) {
				String name = parts[1];
				String dept = parts[2];
				int q1 = Integer.parseInt(parts[3]);
				int q2 = Integer.parseInt(parts[4]);
				int q3 = Integer.parseInt(parts[5]);

				list.add(new Student(name, dept, q1, q2, q3));
				System.out.println("Record Added: " + name);
			} 
			else if (parts[0].equals("Top")) {
				if (list.isEmpty()) {
					System.out.println("No Records Available");
					continue;
				}

				String key = parts[1];
				if (!key.startsWith("Q")) {
					int max = -1;
					boolean found = false;

					for (Student s : list) {
						if (s.department.equals(key)) {
							found = true;
							max = Math.max(max, s.total());
						}
					}
					if (!found) {
						System.out.println("Department not found");
						continue;
					}
					for (Student s : list) {
						if (s.department.equals(key) && s.total() == max) {
							System.out.println(s.name + " " + max);
						}
					}
				} 
				else {
					int max = -1;

					for (Student s : list) {
						if (key.equals("Q1"))
							max = Math.max(max, s.q1);
						if (key.equals("Q2"))
							max = Math.max(max, s.q2);
						if (key.equals("Q3"))
							max = Math.max(max, s.q3);
					}

					for (Student s : list) {
						if (key.equals("Q1") && s.q1 == max)
							System.out.println(s.name + " " + max);

						if (key.equals("Q2") && s.q2 == max)
							System.out.println(s.name + " " + max);

						if (key.equals("Q3") && s.q3 == max)
							System.out.println(s.name + " " + max);
					}
				}
			}
		}
	}
}