package exceptions;

import java.io.*;

public class TryWithResources {

	public static void main(String[] args) {
		
		try(BufferedReader reader = new BufferedReader(new FileReader("info.txt"))){
			String line;
			if((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}catch(IOException e) {
			System.out.println("Error reading file.");
		}
	}

}
