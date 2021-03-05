package testing.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TestDateTime {

	public static void main(String[] args) {
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		DateTimeFormatter formater2 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate dt = LocalDate.parse("2019.10.19", formater);

		System.out.println(dt.format(formater2));

		LocalDate d1 = LocalDate.of(2000, 10, 1);
		LocalDate d2 = LocalDate.now();
		long daysBetween = ChronoUnit.DAYS.between(d2, d1);
		long monthsBetween = ChronoUnit.MONTHS.between(d2, d1);
		long yearsBetween = ChronoUnit.YEARS.between(d2, d1);
        LocalDate firstDayOfMonth = LocalDate.of(d2.getYear(), d2.getMonth(), 1);
        LocalDate lastDayOfMonth = LocalDate.of(d2.getYear(), d2.getMonth(), 31);

		System.out.println(daysBetween + "-" + monthsBetween + "-" + yearsBetween);
	}

}
