package m1Practice;

import java.util.*;
import java.util.regex.*;

public class EmailAccessControl {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n : ");
		int n = sc.nextInt();
		sc.nextLine();

		String regex = "^[a-z]{3,}\\.[a-z]{3,}\\d{4,}@(sales|marketing|IT|product)\\.company\\.com$";
		Pattern pattern = Pattern.compile(regex);

		for (int i = 0; i < n; i++) {

			String email = sc.nextLine();
			Matcher matcher = pattern.matcher(email);

			if (matcher.matches())
				System.out.println("Access Granted");
			else
				System.out.println("Access Denied");
		}
		sc.close();
	}
}
