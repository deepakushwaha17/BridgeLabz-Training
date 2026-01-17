package dsaProblems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFineLineByLine {
	
	
	public static void main(String[] args) {
		String filePath = "D:\\Eclipse-Java-Worksapce\\dsaPractice\\src\\dsaProblems\\SampleFile.txt";
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
		catch(IOException e) {
			System.out.println("An error occurred : " + e.getMessage());
		}
	}
}