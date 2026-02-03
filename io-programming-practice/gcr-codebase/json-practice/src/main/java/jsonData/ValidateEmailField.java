package jsonData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class ValidateEmailField {

	public static void main(String[] args) throws Exception{
		
		String records = "[{\"name\" : \"Deepa\" , \"email\" : \"deepa123@gmail.com\"},{\"name\" : \"Mahi\" , \"email\" : \"mahi23@yahoo.com\"},{\"name\" : \"Rahul\" , \"email\" : \"rahul123@gmail\"}]";
		
		ObjectMapper mapper = new ObjectMapper();
		
		ArrayNode array = (ArrayNode)mapper.readTree(records);
		ArrayNode filtered = mapper.createArrayNode();
		
		// regex to validate email
		String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);    
		
		for(JsonNode node : array) {
			
			// validate the email field
			Matcher matcher = pattern.matcher(node.get("email").asText());
			if(matcher.matches()) {
				filtered.add(node);
			}
		}
		System.out.println(filtered.toPrettyString());
	}

}
