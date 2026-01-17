package dsaProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountFileWordOccurrence {
	
	public static void main(String[] args) {
		String filePath = "D:\\Eclipse-Java-Worksapce\\dsaPractice\\src\\dsaProblems\\SampleFile.txt";
		int count = 0;
		String target = "hello";
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while((line = reader.readLine()) != null) {
				String[] words = line.split("\\W+");
				for(String word : words) {
					if(word.equalsIgnoreCase(target)) {
						count++;
					}
				}
			}
			System.out.println("Number of times \"hello\" occurred is " + count + " times.");
		}
		catch(IOException e) {
			System.out.println("An error occurred : " + e.getMessage());
		}
	}
}