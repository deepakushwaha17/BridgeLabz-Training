package csvHandling;
import java.io.*;

public class ReadCSV {

	public static void main(String[] args) {
		String fileName = "D:\\Eclipse-Java-Worksapce\\ioProgramming\\src\\csvHandling\\Students.csv";
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line;
			while((line =  br.readLine()) != null) {
				String[] columns = line.split("\t");
				System.out.println(columns[0] + "\t"+ columns[1] + "\t"+ columns[2] + "\t" + columns[3]);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
