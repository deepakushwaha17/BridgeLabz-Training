package collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student{
	String name;
	char grade;
	public Student(String name, char grade) {
		this.name = name;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public char getGrade() {
		return grade;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
public class StudentResultGrouping {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new Student("Deepa",'A'),new Student("Mahi",'A'),
				new Student("Rahul",'A'),new Student("Amit",'B'),
				new Student("Aarav",'B'),(new Student("Sahil",'C')));
		
		Map<Character, List<Student>> groupedByGrade = students.stream()
				.collect(Collectors.groupingBy(Student::getGrade));
		System.out.println("Students group by grade level:\n" +groupedByGrade);

	}

}
