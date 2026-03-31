package csvHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateData {

	public static void main(String[] args) {
		String fileName = "D:\\Eclipse-Java-Worksapce\\ioProgramming\\src\\csvHandling\\data.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line = br.readLine();
			
			String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
			Pattern emailPattern = Pattern.compile(emailRegex);
			String phoneRegex = "^([6-9])[0-9]{9}";
			Pattern phonePattern = Pattern.compile(phoneRegex);
			
			while((line = br.readLine()) != null) {
				String[] columns = line.split("\t");
				Matcher emailMatcher = emailPattern.matcher(columns[2]);
				Matcher phoneMatcher = phonePattern.matcher(columns[3]);
				if(!emailMatcher.matches() && !phoneMatcher.matches()) {
					System.out.println("Invalid email or phone number: " + columns[0]+"\t"+columns[1]+"\t"+columns[2]+"\t"+columns[3]);
				}
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
