package utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    private final String format = "dd-MM-yyyy";
    private DateConverter(){

    }
    public String convertDateToString(Date d){
        if (d == null) return "";
        DateFormat df = new SimpleDateFormat(format);
        return df.format(d);
    }

    public Date convertStringToDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date);
    }
}
