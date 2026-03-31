package jsonData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IPLCensorAnalyzer {

    // Utility to mask team names
    private static String maskTeamName(String teamName) {
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            return words[0] + " ***";
        }
        return teamName;
    }

    // JSON Processing
    public static void processJson(String inputPath, String outputPath) {
        try {
            String jsonText = Files.readString(Path.of(inputPath));
            JSONArray matches = new JSONArray(jsonText);

            for (int i = 0; i < matches.length(); i++) {
                JSONObject match = matches.getJSONObject(i);

                // Mask teams
                match.put("team1", maskTeamName(match.getString("team1")));
                match.put("team2", maskTeamName(match.getString("team2")));

                // Mask winner
                match.put("winner", maskTeamName(match.getString("winner")));

                // Redact player of the match
                match.put("player_of_match", "REDACTED");

                // mask scores key names
                JSONObject score = match.getJSONObject("score");
                JSONObject newScore = new JSONObject();
                for (String key : score.keySet()) {
                    newScore.put(maskTeamName(key), score.getInt(key));
                }
                match.put("score", newScore);
            }

            // Write censored JSON
            Files.writeString(Path.of(outputPath), matches.toString(4)); // pretty print
            System.out.println("Censored JSON written to: " + outputPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CSV Processing 
    public static void processCsv(String inputPath, String outputPath) {
        try {
            List<String> lines = Files.readAllLines(Path.of(inputPath));
            List<String> censoredLines = new ArrayList<>();

            // Copy headers
            censoredLines.add(lines.get(0));

            for (int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");

                // Mask teams
                parts[1] = maskTeamName(parts[1]); // team1
                parts[2] = maskTeamName(parts[2]); // team2

                // Mask winner
                parts[5] = maskTeamName(parts[5]);

                // Redact player of match
                parts[6] = "REDACTED";

                censoredLines.add(String.join(",", parts));
            }

            // Write censored CSV
            Files.write(Path.of(outputPath), censoredLines);
            System.out.println("Censored CSV written to: " + outputPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String jsonInput = "src/main/resources/matchJsonInput.json";
        String jsonOutput = "src/main/resources/matchJsonOutput.json";

        String csvInput = "src/main/resources/matchCsvInput.csv";
        String csvOutput = "src/main/resources/matchCsvOutput.csv";

        // Process JSON
        processJson(jsonInput, jsonOutput);

        // Process CSV
        processCsv(csvInput, csvOutput);
    }
}
