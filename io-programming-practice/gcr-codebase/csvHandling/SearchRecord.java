package csvHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {
	public static void main(String[] args) {
		String fileName = "D:\\Eclipse-Java-Worksapce\\ioProgramming\\src\\csvHandling\\employees.csv";
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line;
			while((line =  br.readLine()) != null) {
				String[] columns = line.split(",");
				if(columns[1].equalsIgnoreCase("Rahul")) {
					System.out.println(columns[2] + "\t" + columns[3]);
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}