package csvHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ConvertCSVToObject {

	public static void main(String[] args) {
		String fileName = "D:\\Eclipse-Java-Worksapce\\ioProgramming\\src\\csvHandling\\Students.csv";
		ArrayList<Student> students = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line;
			
			while((line =  br.readLine()) != null) {
				String[] columns = line.split("\t");
				students.add(new Student(columns[0],columns[1],columns[2],columns[3]));
			}
			System.out.println("Students data added to list successfully.\n");
			
			for(Student s : students) {
				System.out.println(s.id+"\t"+s.name+"\t"+s.age+"\t"+s.marks);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}

class Student{
	String id;
	String name;
	String age;
	String marks;
	
	public Student(String id, String name, String age, String marks) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.marks = marks;
	}
}