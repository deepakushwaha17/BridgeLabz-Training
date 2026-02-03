package jsonData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvToJson {

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Path.of("src/main/resources/students.csv"));

            String[] headers = lines.get(0).split("\t");

            JSONArray jsonArray = new JSONArray();

            for (int i = 1; i < lines.size(); i++) {
                String[] values = lines.get(i).split("\t");
                JSONObject obj = new JSONObject();

                for (int j = 0; j < headers.length; j++) {
                    obj.put(headers[j], values[j]);
                }

                jsonArray.put(obj);
            }

            System.out.println(jsonArray.toString(2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
