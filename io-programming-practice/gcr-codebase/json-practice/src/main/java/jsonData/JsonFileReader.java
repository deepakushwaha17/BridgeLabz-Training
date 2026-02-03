package jsonData;

import java.nio.file.Files;
import java.nio.file.Path;

import org.json.JSONObject;

public class JsonFileReader {
	
	public static void main(String[] args) throws Exception{
		String jsonText = Files.readString(Path.of("src/main/resources/users.json"));
		JSONObject json = new JSONObject(jsonText);
		
		for(String key : json.keySet())
		System.out.println(key + " : "  +json.get(key));

	}

}
