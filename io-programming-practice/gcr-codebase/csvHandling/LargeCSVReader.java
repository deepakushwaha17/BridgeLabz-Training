package csvHandling;

import java.io.*;

public class LargeCSVReader {

    public static void main(String[] args) {
        String filePath = "students_large.csv";
        int chunkSize = 100;  // process 100 lines at a time
        int recordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineCounter = 0;

            String header = br.readLine();
            System.out.println("Header: " + header);

            String[] chunk = new String[chunkSize];

            while ((line = br.readLine()) != null) {
                chunk[lineCounter] = line;
                lineCounter++;
                recordCount++;

                // When chunk is full, process it
                if (lineCounter == chunkSize) {
                    processChunk(chunk, lineCounter);
                    lineCounter = 0;  // reset for next chunk
                }
            }

            // Process remaining lines
            if (lineCounter > 0) {
                processChunk(chunk, lineCounter);
            }

            System.out.println("Total records processed: " + recordCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processChunk(String[] chunk, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(chunk[i]);
        }
        System.out.println("Processed a chunk of " + size + " records\n");
    }
}
