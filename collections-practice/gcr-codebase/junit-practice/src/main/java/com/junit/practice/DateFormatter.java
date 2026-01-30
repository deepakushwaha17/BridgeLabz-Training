package com.junit.practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    public String formatDate(String inputDate) {
        // Input date format (example: 2026-01-30)
        DateTimeFormatter inputFormatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Output date format (dd-MM-yyyy)
        DateTimeFormatter outputFormatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date = LocalDate.parse(inputDate, inputFormatter);
        return date.format(outputFormatter);
    }
}
