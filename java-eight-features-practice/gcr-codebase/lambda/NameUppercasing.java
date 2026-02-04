package lambda;

import java.util.Arrays;
import java.util.List;

public class NameUppercasing {

	public static void main(String[] args) {
		List<String> employeeNames = Arrays.asList("Deepa","Mahi","Rahul","Aarav");
		employeeNames.stream().map(String::toUpperCase).forEach(System.out::println);
	}

}
