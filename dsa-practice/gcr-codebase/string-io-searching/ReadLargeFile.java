package dsaProblems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeFile {

	public static void main(String[] args) throws IOException {
		String filePath = "D:\\Eclipse-Java-Worksapce\\dsaPractice\\src\\dsaProblems\\LargeFile.txt";
        long startTime = System.nanoTime();

        long wordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }
        }

        long endTime = System.nanoTime();

        System.out.println("FileReader Word Count: " + wordCount);
        System.out.println("Time Taken (FileReader): " + (endTime - startTime) + " ns");
    }
}
