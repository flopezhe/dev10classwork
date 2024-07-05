import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class DayOne {
    public static void main(String[] args) {
        LocalDate juneFirst = LocalDate.of(2024,6,1);
        LocalDate julyTwelfth = LocalDate.of(2024, Month.JULY,12 );
        LocalDate today = LocalDate.now();
//
//        System.out.println(juneFirst);
//        System.out.println(julyTwelfth + " is coming up.");
//        System.out.println(today);

//        System.out.println(julyTwelfth.getYear());
//        System.out.println(julyTwelfth.getDayOfWeek());
//
//        BigDecimal incomePerDay = new BigDecimal(140);
//        BigDecimal businessDaysPerWeek = new BigDecimal(5);
//
//        BigDecimal incomePerWeek = incomePerDay.multiply(businessDaysPerWeek);
//
//        System.out.println(incomePerWeek);
//
//        System.out.println(today.minusDays(7));
//        System.out.println(today.minusDays(-7));
//        LocalDateTime now = LocalDateTime.now();
//
//        System.out.println(now);

//        LocalDateTime rightNow = LocalDateTime.of(2024, 7, 1,  12, 56);
//
//        DateTimeFormatter fourDigitYear = DateTimeFormatter.ofPattern("yyyy");
//        DateTimeFormatter twoDigitYear = DateTimeFormatter.ofPattern("yy");
//        DateTimeFormatter oneDigitMonth = DateTimeFormatter.ofPattern("M");
//        System.out.println(rightNow.format(fourDigitYear));
//        System.out.println(rightNow.format(twoDigitYear));
//        System.out.println(rightNow.format(oneDigitMonth));

        Scanner console = new Scanner(System.in);

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mma");

        System.out.print("Enter a date in month/day/year format:");
        LocalDate date = LocalDate.parse(console.nextLine(), dateFormat);
        System.out.println(date); // default format

        System.out.print("Enter a time in twelve hour:minute format:");
        LocalTime time = LocalTime.parse(console.nextLine(), timeFormat);
        System.out.println(time); // default format





    }
}
