package streams;
import java.io.*;

public class UserInputToFile {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName = "D:\\Eclipse-Java-Worksapce\\collectionPractice\\src\\streams\\UserInformation.txt";
		
		try {
			// User input
			System.out.print("Enter name: ");
			String name = reader.readLine();
			
			System.out.print("Enter age: ");
			String age = reader.readLine();
			
			System.out.print("Enter your favorite programming language: ");
			String language = reader.readLine();
			
			FileWriter fw = new FileWriter(fileName,true); // it append the file not overwrite
			fw.write("Name: " + name +"\n");
			fw.write("Age: " + age +"\n");
			fw.write("Favorite Programming Language: " + language +"\n");
			fw.close();
			
			System.out.println("User information saved successfully in file UserInformation.txt");
		}
		catch(IOException e) {
			System.out.println("Error occurred: " + e.getMessage());
		}
	}

}
