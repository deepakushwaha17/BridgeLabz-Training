package dsaProblems;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadInputAndWrite {
	
	public static void main(String[] args) {
		String filePath = "D:\\Eclipse-Java-Worksapce\\dsaPractice\\src\\dsaProblems\\SampleFile.txt";
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				FileWriter writer = new FileWriter(filePath,true))
		{
			 String input;

			 System.out.println("Enter text (type 'exit' to stop):");
			 while (true) {
				 input = reader.readLine();
				 if (input.equalsIgnoreCase("exit")) {
					 break;
				 }
				 writer.write(input);
	             writer.write(System.lineSeparator()); // new line
			 }
			 System.out.println("Input successfully written to file.");
		}
		catch(IOException e) {
			System.out.println("An error occurred : " + e.getMessage());
		}
	}

}
