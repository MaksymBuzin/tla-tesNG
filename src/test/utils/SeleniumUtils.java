package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SeleniumUtils {

    public static String getTodaysDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");  //get today's date in speciphic format
        Date date = new Date();
        return formatter.format(date);

    }
}
