package csvHandling;

import java.io.*;

public class ModifyCSV {
	public static void main(String[] args) {
		String fileName = "D:\\Eclipse-Java-Worksapce\\ioProgramming\\src\\csvHandling\\employees.csv";
		String newFile = "D:\\Eclipse-Java-Worksapce\\ioProgramming\\src\\csvHandling\\employees2.csv";
		try(BufferedReader br = new BufferedReader(new FileReader(fileName));
				BufferedWriter bw = new BufferedWriter(new FileWriter(newFile))){
			String line = br.readLine();
			bw.write(line+"\n");
			while((line =  br.readLine()) != null) {
				String[] columns = line.split(",");
				if(columns[2].equalsIgnoreCase("IT")) {
					double salary = Double.parseDouble(columns[3]);
					double newSalary = (salary * 0.1) + salary;
				    bw.write(columns[0] + "," + columns[1] + "," + columns[2] + "," + newSalary +"\n");
				}
			}
			System.out.print("Data written to new csv file employees2.csv");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
