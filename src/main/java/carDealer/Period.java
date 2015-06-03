package carDealer;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by employee on 5/25/15.
 */
public class Period {

    private Calendar start;
    private Calendar end;

    public Period() {
        System.out.println("Enter first date: ");
        this.start = getTheCalendar();

        System.out.println("Enter second date: ");
        this.end = getTheCalendar();

    }

    public Calendar getStart() {
        return start;
    }

    public Calendar getEnd() {
        return end;
    }

    public boolean includes(Date time) {
        return start.getTime().before(time) && end.getTime().after(time);
    }

    private Calendar getTheCalendar() {
        int year = Integer.valueOf(keyboard("year: "));
        int month = Integer.valueOf(keyboard("month: "));
        int day = Integer.valueOf(keyboard("day: "));
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar;
    }

    private String keyboard(String message) {
        System.out.print(message + " ");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

}
