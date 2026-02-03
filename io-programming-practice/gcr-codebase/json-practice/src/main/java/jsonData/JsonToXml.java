package jsonData;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXml {

    public static void main(String[] args) {
        // Create JSON object
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "Deepa");
        jsonObj.put("age", 22);

        jsonObj.put("subjects", new String[] {"Math", "Science", "Computer"});

        // Convert JSON to XML
        String xml = "<root>" + XML.toString(jsonObj) + "</root>";

        // Print XML
        System.out.println(xml);
    }
}
