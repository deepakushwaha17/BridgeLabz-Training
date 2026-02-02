package csvHandling;

import java.io.*;
import java.util.HashMap;

public class MergeCSVFiles {
	public static void main(String[] args) {
		String fileName1 = "D:\\Eclipse-Java-Worksapce\\ioProgramming\\src\\csvHandling\\students1.csv";
		String fileName2 = "D:\\Eclipse-Java-Worksapce\\ioProgramming\\src\\csvHandling\\students2.csv";
		String mergefileName = "D:\\Eclipse-Java-Worksapce\\ioProgramming\\src\\csvHandling\\mergeStudents.csv";
		HashMap<String, String> student = new HashMap<>();
		
		try(BufferedReader br1 = new BufferedReader(new FileReader(fileName1));
				BufferedReader br2 = new BufferedReader(new FileReader(fileName2));
				BufferedWriter bw = new BufferedWriter(new FileWriter(mergefileName))){
			
			String line1 = br1.readLine();
			
			while((line1 =  br1.readLine()) != null) {
				String[] columns = line1.split("\t");
				student.put(columns[0],columns[1]+","+columns[2]);
			}
			
			String line2 = br2.readLine();
			bw.write("ID,Name,Age,Marks,Grade");
			bw.newLine();
			while((line2 = br2.readLine()) != null) {
				String[] columns = line2.split("\t");
				if(student.containsKey(columns[0])) {
					bw.write(columns[0] + "," + student.get(columns[0]) + "," + columns[1] + "," + columns[2]);
					bw.newLine();
				}
			}
			System.out.println("File merged successfully.");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
