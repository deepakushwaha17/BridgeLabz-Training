package jsonData;

import org.json.JSONArray;
import org.json.JSONObject;

public class Student {

	public static void main(String[] args) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", "Deepa");
		jsonObj.put("age", 22);
		
		JSONArray subjects = new JSONArray();
		subjects.put("Math");
		subjects.put("Science");
		subjects.put("Computer");
		
		jsonObj.put("subjects", subjects);
		
		System.out.println(jsonObj.toString(2));

	}

}
