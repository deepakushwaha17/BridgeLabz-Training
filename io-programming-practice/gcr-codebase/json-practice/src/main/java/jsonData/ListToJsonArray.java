package jsonData;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

class Person{
	public String name;
	public int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
}
public class ListToJsonArray {

	public static void main(String[] args) throws Exception{
		List<Person> list = List.of(new Person("Deepa",22), 
				new Person("Mahi",22));
		
		ObjectMapper mapper = new ObjectMapper();
		System.out.println( mapper.writeValueAsString(list));
	}

}
