package jsonData;

import org.json.JSONObject;

public class MergeJsonObject {
	
	public static void mergeJson(JSONObject jsonObj1, JSONObject jsonObj2) {
		
		JSONObject merge = new JSONObject(jsonObj1.toString());
		
		for(String key : jsonObj2.keySet()) {
			merge.put(key, jsonObj2.get(key));
		}
		System.out.println(merge.toString(2));
	}

	public static void main(String[] args) {
		JSONObject jsonObj1 = new JSONObject();
		jsonObj1.put("name", "Deepa");
		jsonObj1.put("age", 22);

		JSONObject jsonObj2 = new JSONObject();
		jsonObj2.put("address", "Deoria");
		jsonObj2.put("pincode", 274509);
		
		mergeJson(jsonObj1,jsonObj2);
	}

}
