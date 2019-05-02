package com.example.libtest.clazz;


import timber.log.Timber;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by nidhal.saoud on 18/08/2016.
 */
public class TimeUtils {
    static private String TAG = "TimeUtils";
//    final static String ISO8601DATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static String FORMAT_ISO_DATE = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public final static long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
    /**
     * Ge tcurrent time stap string.
     *
     * @return the string
     */
    public static String geTcurrentTimeStap() {
        Long tsLong = System.currentTimeMillis() / 1000;
        return tsLong.toString();

    }

//    public static Date getDate(String formattedDate) {
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat(ISO8601DATEFORMAT);
//        try {
//            cal.setTime(sdf.parse(formattedDate));// all done
//            return cal.getTime();
//        } catch (Exception e) {
//            Timber.d(TAG, e.getMessage());
//            return null;
//        }
//    }

    /**
     * Format string to date date.
     *
     * @param date the date
     * @return the date
     */
    public static Date formatStringToDateWithTimeZone(String date, String timezoneId) {
        DateFormat format = new SimpleDateFormat(FORMAT_ISO_DATE, Locale.FRENCH);
        if (timezoneId != null && !timezoneId.isEmpty()) {
            try {
                format.setTimeZone(TimeZone.getTimeZone(timezoneId));
            } catch (Exception e) {
                Timber.e(TAG, e.toString());
            }
        }

        try {
            return format.parse(date);
        } catch (Exception e) {
            Timber.d(TAG, e);
            return null;
        }

    }

    public static boolean isMoreOldThan24Hours(String formattedDate, String timezoneId) {
        Long nowInMillis = Calendar.getInstance().getTime().getTime();
        Date date = formatStringToDateWithTimeZone(formattedDate,timezoneId);
        Long dateInMillis = date!=null?date.getTime():null;
        if (dateInMillis!=null) {
            Timber.d(TAG, " days ticket old is :"+Math.abs((nowInMillis - dateInMillis)/MILLIS_PER_DAY));
            return nowInMillis - dateInMillis > MILLIS_PER_DAY;
        } else {
            return false;
        }
    }

    public static Date parseIsoDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat(FORMAT_ISO_DATE);
        return format.parse(date);
    }
}
