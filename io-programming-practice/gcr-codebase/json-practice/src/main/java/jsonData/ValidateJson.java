package jsonData;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {
	
	public static boolean isValidJson(String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.readTree(json);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {
		String json1 = "{\"name\" : \"Deepa\" , \"age\" : 22}";
		String json2 = "{\"name\" : \"Deepa\" , \"age\"  22}";
		System.out.println(isValidJson(json1)?json1 + " - Valid Json":json1+" - Invalid Json");
		System.out.println(isValidJson(json2)?json2 + " - Valid Json":json2+" - Invalid Json");

	}

}