package exceptions;

import java.io.*;
import java.io.IOException;

public class CheckedException {

	public static void main(String[] args){
		// throw an IOException if file doesn't exist 
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
			String line;
			while((line = reader.readLine()) != null) {
				System.out.print(line);
			}
			reader.close();
		}catch(IOException e) {
			System.out.println("File not found.");
		}
	}
}
