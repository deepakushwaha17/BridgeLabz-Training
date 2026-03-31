package functionalInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

interface DateUtils{
	static String formatDate(LocalDateTime date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}

public class DateFormatter {

	 public static void main(String[] args) {
		 LocalDateTime now = LocalDateTime.now();

		 String format1 = DateUtils.formatDate(now, "dd-MM-yyyy");
		 System.out.println("Format 1: " + format1);
	
		 String format2 = DateUtils.formatDate(now, "MMMM dd, yyyy");
		 System.out.println("Format 2: " + format2);
		 
		 String format3 = DateUtils.formatDate(now, "yyyy/MM/dd HH:mm:ss");
	     System.out.println("Format 3: " + format3);
	 }
}
