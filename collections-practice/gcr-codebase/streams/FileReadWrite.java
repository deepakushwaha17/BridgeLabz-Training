package streams;

import java.io.*;

public class FileReadWrite {

	public static void main(String[] args) {
		
		String sourceFile = "D:\\Eclipse-Java-Worksapce\\collectionPractice\\src\\streams\\SourceFile.txt";
		String destinationFile = "D:\\Eclipse-Java-Worksapce\\collectionPractice\\src\\streams\\DestinationFile.txt";
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			// Open source file
			fis = new FileInputStream(sourceFile);
			
			// Open destination file
			fos = new FileOutputStream(destinationFile,true);
			
			int data;
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
			fos.write('\n');
			System.out.println("File copied successfully.");
		}
		catch(FileNotFoundException e) {
			 System.out.println("Source file does not exist.");
		}
		catch (IOException e) {
            System.out.println("An error occurred while reading or writing the file.");
		}
	}
}