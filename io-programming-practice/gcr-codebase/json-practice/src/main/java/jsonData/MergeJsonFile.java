package jsonData;

import java.nio.file.Files;
import java.nio.file.Path;

import org.json.JSONObject;

public class MergeJsonFile {
	
	public static void mergeJson(JSONObject jsonObj1, JSONObject jsonObj2) {
		
		JSONObject merge = new JSONObject(jsonObj1.toString());
		
		for(String key : jsonObj2.keySet()) {
			merge.put(key, jsonObj2.get(key));
		}
		System.out.println(merge.toString(2));
	}

	public static void main(String[] args) throws Exception{
		String filePath1 = Files.readString(Path.of("src/main/resources/users.json"));
		JSONObject jsonObj1 = new JSONObject(filePath1);
		String filePath2 = Files.readString(Path.of("src/main/resources/userInfo.json"));
		JSONObject jsonObj2 = new JSONObject(filePath2);
		mergeJson(jsonObj1,jsonObj2);
	}

}
