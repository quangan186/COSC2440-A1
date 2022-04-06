package utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private DateConverter(){

    }

    /**
     * convert Date to String
     * @param d;
     * @return String
     */
    public static String convertDateToString(Date d){
        if (d == null) return "";
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        return df.format(d);
    }

    /**
     * convert String to Date
     * @param date;
     * @return String
     */
    public static Date convertStringToDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false);
        return sdf.parse(date);
    }
}
