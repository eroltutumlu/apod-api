package com.astronomy.nasa.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private DateUtils() {
    }

    public static final long APPROX_MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
    public static final DateFormat DVS_DATE_FORMATTER = new SimpleDateFormat("MM/dd/yyyy");
    public static final String DATE_FORMAT_MMDDYY_HH24MMSS = "MM-dd-yy HH:mm:ss";
    public static final String  DATE_FORMAT_yyyy_MM_ddT = "yyyy-MM-dd'T'HH:mm:ssXXX";
    public static final String DATE_FORMAT_MMDDYYYY = "MM/dd/yyyy";
    public static final String DATE_FORMAT_MMMDD_YYYY = "MMM d,yyyy";
    public static final String DATE_FORMAT_MMMd_yyyy = "MMM d";
    public static final String DATE_FORMAT_MMDDYY = "MM/dd/yy";
    public static final String DATE_FORMAT_YYMMDD = "yyMMdd";
    public static final String DATE_FORMAT_MMMDD = "MMM d";
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String TIMESTAMP_GMT = "GMT";
    public static final String TIMESTAMP_UTC = "UTC";
    public static final String DATE_FORMAT_YYYY = "YYYY";
    public static final String DATE_FORMAT_YY = "yy";
    public static final String XML_TIMESTAMP_FORMAT = "yyyy-MM-dd'T'hh:mm:ss.sss'-'hh:mm";
    public static final String DATE_FORMAT_MMMD = "MMM d";
    public static final String DATE_FORMAT_H_M_A = "h:mm a";
    public static final String DATA_METER_DATE_FORMAT = "MM/dd/yyyy hh:mm a";
    public static final String DATE_FORMAT_MMDDYY_HHMMSS_AMPM = "MM-dd-yy hh:mm:ss a";
    public static final String DATE_FORMAT_MMDDYY_HHMMSS_Z="yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String ATG_GETFEED_DATE_FORMAT = "MM/dd/yyyy";
    public static final String DATE_FORMAT_MMDD = "MM/dd";
    public static final String DATE_FORMAT_MMDDYY_HHMMSS = "yyyy-MM-dd hh:mm:ss";


    public static Date convertStrToDate(String date) {
        return convertStrToDateFormat(date, DATE_FORMAT_MMDDYYYY);
    }

    public static Date convertStrToDateFormat(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date returnDate = null;
        try {
            returnDate = StringUtils.isNullOrEmpty(date) ? null : sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return returnDate;
    }

    public static boolean equalsDate(Calendar date1, Calendar date2) {
        try {
            if (date1 != null && date2 != null) {
                if (date1.get(Calendar.MONTH) == date2.get(Calendar.MONTH)
                        && date1.get(Calendar.DAY_OF_MONTH) == date2.get(Calendar.DAY_OF_MONTH)
                        && date1.get(Calendar.YEAR) == date2.get(Calendar.YEAR)) {
                    return true;

                } else {
                    return false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isSameDate(Date d1, Date d2) {
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        date1.setTime(d1);
        date2.setTime(d2);
        try {
            if (date1 != null && date2 != null) {
                if (date1.get(Calendar.MONTH) == date2.get(Calendar.MONTH)
                        && date1.get(Calendar.DAY_OF_MONTH) == date2.get(Calendar.DAY_OF_MONTH)
                        && date1.get(Calendar.YEAR) == date2.get(Calendar.YEAR)) {
                    return true;

                } else {
                    return false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getCurrentDateFormatted(String pattern){
        try {
            Calendar cal = Calendar.getInstance();
            if (StringUtils.isNullOrEmpty(pattern)) {
                pattern = DATE_FORMAT_YYYY_MM_DD;
            }
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format(cal.getTime());
        } catch (Exception e) {
            return null;
        }
    }


}
