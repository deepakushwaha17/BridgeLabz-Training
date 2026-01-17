package dsaProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;

public class ConvertByteToCharacterStream {

	public static void main(String[] args) {
		String filePath = "D:\\Eclipse-Java-Worksapce\\dsaPractice\\src\\dsaProblems\\SampleFile.txt";
		
		try(FileInputStream fis = new FileInputStream(filePath);
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
			BufferedReader reader = new BufferedReader(isr))
		{
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
