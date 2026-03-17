package m1Practice;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DynamicProcessTemplate {

	public static String processTemplate(String input) {
		String regex = "\\$\\{([^:]+):([^}]+)\\}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);

		StringBuffer result = new StringBuffer();

		while (matcher.find()) {
			String type = matcher.group(1);
			String value = matcher.group(2);

			String replacement = "INVALID";
			switch (type) {
			case "UPPER":
				replacement = value.toUpperCase();
				break;

			case "LOWER":
				replacement = value.toLowerCase();
				break;

			case "REPEAT":
				try {
					String[] parts = value.split(",");
					String word = parts[0];
					int count = Integer.parseInt(parts[1]);

					StringBuilder sb = new StringBuilder();
					for (int j = 0; j < count; j++)
						sb.append(word);

					replacement = sb.toString();
				} catch (Exception e) {
					replacement = "INVALID";
				}
				break;

			case "DATE":
				try {
					String[] d = value.split("-");
					int day = Integer.parseInt(d[0]);
					int month = Integer.parseInt(d[1]);
					int year = Integer.parseInt(d[2]);

					LocalDate date = LocalDate.of(year, month, day);
					replacement = String.format("%04d/%02d/%02d", year, month, day);

				} catch (Exception e) {
					replacement = "INVALID";
				}
				break;
			}

			matcher.appendReplacement(result, replacement);
		}

		matcher.appendTail(result);
		return result.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n : ");
		int n = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			String processed = processTemplate(line);
			System.out.println(processed);
		}
	}
}