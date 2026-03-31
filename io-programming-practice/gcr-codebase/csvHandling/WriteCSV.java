package csvHandling;

import java.io.*;

public class WriteCSV {

	public static void main(String[] args) {
		String fileName = "D:\\Eclipse-Java-Worksapce\\ioProgramming\\src\\csvHandling\\employees.csv";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
			bw.write("ID,Name,Department,Salary\n");
			bw.write("101,Deepa,IT,33000\n");
			bw.write("102,Mahi,CSE,34000\n");
			bw.write("103,Rahul,IT,35000\n");
			bw.write("104,Sumit,CA,32000\n");
			bw.write("105,Aditya,ITI,31000\n");
			bw.write("106,Gaurav,IT,35000\n");
			System.out.println("Data written successfully.");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
