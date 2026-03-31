package csvHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
	public static void main(String[] args) {
		String fileName = "D:\\Eclipse-Java-Worksapce\\ioProgramming\\src\\csvHandling\\Students.csv";
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line = br.readLine();
			System.out.println(line);
			while((line =  br.readLine()) != null) {
				String[] columns = line.split("\t");
				if(Integer.parseInt(columns[3]) > 80) {
					System.out.println(columns[0] + "\t"+ columns[1] + "\t"+ columns[2] + "\t" + columns[3]);
				}		
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}


}
