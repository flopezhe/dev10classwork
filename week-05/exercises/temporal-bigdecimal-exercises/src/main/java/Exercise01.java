import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Exercise01 {

    // LocalDate
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. return today's date
    LocalDate getToday() {
        return LocalDate.now();
    }

    // 2. return December 17, 1903 as a LocalDate
    LocalDate getFirstFlightDate() {
        LocalDate firstFlightDate = LocalDate.of(1903, 12, 17);
        return firstFlightDate;
    }

    // 3. if parameter is in the future, return null.
    // Otherwise, add 5 days to the parameter and return the result.
    LocalDate makeFutureNullShiftThePast(LocalDate date) {
        if (date.isAfter(LocalDate.now())) {
            return null;
        } else {
            date = date.plusDays(5);
        }
        return date;
    }

    // 4. return the fifth Friday from the parameter date.
    // if the date is Friday, don't count it.
    LocalDate fiveFridaysFromDate(LocalDate date) {

        if(date.equals(DayOfWeek.FRIDAY)){
            date = date.plusWeeks(5);
        } else{
            date = date.plusWeeks(4).with(DayOfWeek.FRIDAY);
        }
        return date;
    }

    // 5. given a date and a count,
    // return a list of the next `fridayCount` Fridays after the date.
    // if the date is Friday, don't include it.
    List<LocalDate> getNextFridays(LocalDate date, int fridayCount) {
       List<LocalDate> dt = new ArrayList<>();
       LocalDate current = date.plusDays(1);
        while(dt.size()<fridayCount){
            if(current.getDayOfWeek() == DayOfWeek.FRIDAY){
                dt.add(current);
            }
            current = current.plusDays(1);
        }
        return dt;
    }

    // 6. return the absolute value of the days between two dates.
    // one may be before two, two may be before one, but neither will be null
    int getDaysBetween(LocalDate one, LocalDate two) {
       long daysBetween = ChronoUnit.DAYS.between(one, two);
       int days = (int)daysBetween;
       return Math.abs(days);
    }

}
