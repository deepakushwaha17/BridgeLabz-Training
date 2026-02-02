package csvHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {

	public static void main(String[] args) {
		String fileName = "D:\\Eclipse-Java-Worksapce\\ioProgramming\\src\\csvHandling\\Students.csv";
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			br.readLine();
			int count = 0;
			while((br.readLine()) != null) {
				count++;
			}
			System.out.println("Number of rows: " + count);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
