package jsonData;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class FilterJson {

	public static void main(String[] args) throws Exception{
		
		String records = "[{\"name\" : \"Deepa\" , \"age\" : 22},{\"name\" : \"Mahi\" , \"age\" : 26},{\"name\" : \"Rahul\" , \"age\" : 28}]";
		
		ObjectMapper mapper = new ObjectMapper();
		
		ArrayNode array = (ArrayNode)mapper.readTree(records);
		ArrayNode filtered = mapper.createArrayNode();
		
		for(JsonNode node : array) {
			if(node.get("age").asInt() > 25) {
				filtered.add(node);
			}
		}
		System.out.println(filtered);
	}
}