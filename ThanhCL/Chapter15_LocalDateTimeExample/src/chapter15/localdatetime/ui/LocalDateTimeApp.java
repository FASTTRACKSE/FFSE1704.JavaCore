package chapter15.localdatetime.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocalDateTimeApp {

	public static void main(String[] args) {
		LocalDateTime d1 = LocalDateTime.now();
		
		

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter dtfShow = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		String currentDateTimeFormatted = dtfShow.format(LocalDate.parse("13/06/2019", dtf));
		
		System.out.println(currentDateTimeFormatted);
	}

}
