package com.sefryek.broker.utils;

import com.sefryek.broker.webservice.Globals;
import com.sefryek.broker.utils.convertingDateUtil.shamsi.DateConverter;
import com.sefryek.broker.utils.convertingDateUtil.DateConvertor;

import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: mahta
 * Date: May 17, 2011
 * Time: 2:51:33 PM
 */
public class DateUtil {
    private static Logger logger = Logger.getLogger(DateUtil.class);

    public static enum Pattern { YYYY_MM_DD, YYYY_MM_DD_HH_MM_SS }

    public static String GetStringTime(Date dt) {
        String strtm;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
//        TimeZone zone = TimeZone.getDefault();
//        calendar.setTimeZone(zone);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minuts = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        if (hours < 10)
            strtm = "0" + String.valueOf(hours);
        else
            strtm = String.valueOf(hours);

        if (minuts < 10)
            strtm += "0" + String.valueOf(minuts);
        else
            strtm += String.valueOf(minuts);

        if (seconds < 10)
            strtm += "0" + String.valueOf(seconds);
        else
            strtm += String.valueOf(seconds);

        return strtm;
    }

    public static byte[] parseJalaliDateToFourByte(String date, String time) {
        byte[] dateByte = { 0, 0, 0, 0 };

        try {
            String[] dateArray = new String[6];

            dateArray[0] = date.substring(0, 4);
            dateArray[1] = date.substring(4, 6);
            dateArray[2] = date.substring(6);
            dateArray[3] = time.substring(0, 2);
            dateArray[4] = time.substring(2, 4);
            if (time.length() > 4)
                dateArray[5] = time.substring(4);
            else
                dateArray[5] = "00";

            byte tmp = (byte)(Globals.SafeInt(dateArray[0], 0) - 1350);
            tmp <<= 2;
            dateByte[0] = tmp;

            tmp = (byte)Integer.parseInt(dateArray[1]);
            if (tmp < 4) {
                tmp <<= 6;
                dateByte[1] = tmp;

            } else {
                tmp <<= 6;
                dateByte[1] = tmp;
                tmp = (byte)Integer.parseInt(dateArray[1]);
                tmp >>= 2;
                dateByte[0] += tmp;
            }


            tmp = (byte)Integer.parseInt(dateArray[2]);
            tmp <<= 1;
            dateByte[1] += tmp;

            tmp = (byte)Integer.parseInt(dateArray[3]);
            if (tmp > 16) {
                dateByte[1] |= 0x01;
                tmp &= 15;
                tmp <<= 4;
                dateByte[2] = tmp;

            } else {
                tmp <<= 4;
                dateByte[2] = tmp;
            }

            tmp = (byte)Integer.parseInt(dateArray[4]);
            tmp >>= 2;
            dateByte[2] += tmp;

            tmp = (byte)Integer.parseInt(dateArray[4]);
            tmp &= 3;
            tmp <<= 6;
            dateByte[3] = tmp;

            tmp = (byte)Integer.parseInt(dateArray[5]);
            dateByte[3] += tmp;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateByte;
    }

    public static Date convertByteArrayToFullMiladiDate(byte[] dateBytes) {
        int sec = dateBytes[3] & 63;
        byte temp = (byte) ((dateBytes[3] >> 6) & 0x03);
        byte temp1 = (byte) (dateBytes[2] & 0x0F);
        temp1 = (byte) (temp1 << 2);
        int min = temp1 | temp;
        temp = (byte) ((dateBytes[2] >> 4) & 0x0F);
        temp1 = (byte) (dateBytes[1] & 0x01);
//        int hour = temp1 == 1 ? temp + 16 : temp;
        int hour = temp | temp1;
        temp1 = (byte) (dateBytes[1] >> 1);
        int day = temp1 & 0x1F;
        temp1 = ((byte) ((dateBytes[1] >> 6) & 0x03));
        temp = (byte) (dateBytes[0] & 0x03);
        temp = (byte) (temp << 2);
        int month = temp | temp1;
        int year = ((dateBytes[0] >> 2) & 0x3F) + 1350;

        String fullPersianDate = (year + "-" + month  + "-" + day + "-" + hour + "-" + min + "-" + sec);
        logger.info("************************** The full persian date and time form mobile is: " + fullPersianDate);
        Date fummJalalianDate = DateConvertor.fullPersianToFullGregorian(fullPersianDate);
        logger.info("************************** The full Gregorian date and time form mobile is: "
                + (DateUtil.getFormattedDate(fummJalalianDate, DateUtil.Pattern.YYYY_MM_DD_HH_MM_SS)));

        return (fummJalalianDate);
    }

    public static String convertByteArrayToFullPersianDate(byte[] dateBytes) {
        int sec = dateBytes[3] & 63;
        byte temp = (byte) ((dateBytes[3] >> 6) & 0x03);
        byte temp1 = (byte) (dateBytes[2] & 0x0F);
        temp1 = (byte) (temp1 << 2);
        int min = temp1 | temp;
        temp = (byte) ((dateBytes[2] >> 4) & 0x0F);
        temp1 = (byte) (dateBytes[1] & 0x01);
//        int hour = temp1 == 1 ? temp + 16 : temp;
        int hour = temp | temp1;
        temp1 = (byte) (dateBytes[1] >> 1);
        int day = temp1 & 0x1F;
        temp1 = ((byte) ((dateBytes[1] >> 6) & 0x03));
        temp = (byte) (dateBytes[0] & 0x03);
        temp = (byte) (temp << 2);
        int month = temp | temp1;
        int year = ((dateBytes[0] >> 2) & 0x3F) + 1350;

        return (year + "-" + month  + "-" + day + "-" + hour + "-" + min + "-" + sec);
    }

    public static Calendar convertByteArrayToCalender(byte[] dateBytes) {
        int sec = dateBytes[3] & 63;
        byte temp = (byte) ((dateBytes[3] >> 6) & 0x03);
        byte temp1 = (byte) (dateBytes[2] & 0x0F);
        temp1 = (byte) (temp1 << 2);
        int min = temp1 | temp;
        temp = (byte) ((dateBytes[2] >> 4) & 0x0F);
        temp1 = (byte) (dateBytes[1] & 0x01);
//        int hour = temp1 == 1 ? temp + 16 : temp;
        int hour = temp | temp1;
        temp1 = (byte) (dateBytes[1] >> 1);
        int day = temp1 & 0x1F;
        temp1 = ((byte) ((dateBytes[1] >> 6) & 0x03));
        temp = (byte) (dateBytes[0] & 0x03);
        temp = (byte) (temp << 2);
        int month = temp | temp1;
        int year = ((dateBytes[0] >> 2) & 0x3F) + 1350;




        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, min);
        cal.set(Calendar.SECOND, sec);


        return cal;
    }

    /*                                                                                                     
     * Give me the hour and minuts based on time zone
     */
    /*public static String getFormattedDateInSpecifiedTimeZone(Date date, String toTimeZoneId, Pattern pattern) {
        Date returnDate = changeTimeZoneOfDateToThisZone(date, toTimeZoneId);
        return getFormattedDate(returnDate, pattern);
    }*/

    public static String getFormattedDate(Date date, Pattern pattern) {
        StringBuffer buf = new StringBuffer();

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        if(Pattern.YYYY_MM_DD.equals(pattern)) {
            buf.append(cal.get(Calendar.YEAR));
            buf.append("-");

            int month = cal.get(Calendar.MONTH) + 1;
            if(month < 10)
                buf.append("0");
            buf.append(month);
            buf.append("-");

            int day = cal.get(Calendar.DAY_OF_MONTH);
            if(day < 10)
                buf.append("0");
            buf.append(day);

        } else if(Pattern.YYYY_MM_DD_HH_MM_SS.equals(pattern)) {
            buf.append(cal.get(Calendar.YEAR));
            buf.append("-");

            int month = cal.get(Calendar.MONTH) + 1;
            if(month < 10)
                buf.append("0");
            buf.append(month);
            buf.append("-");

            int day = cal.get(Calendar.DAY_OF_MONTH);
            if(day < 10)
                buf.append("0");
            buf.append(day);
            buf.append(" ");

            int hour = cal.get(Calendar.HOUR_OF_DAY);
            if(hour < 10)
                buf.append("0");
            buf.append(hour);
            buf.append(":");

            int min = cal.get(Calendar.MINUTE);
            if(min < 10)
                buf.append("0");
            buf.append(min);
            buf.append(":");

            int sec = cal.get(Calendar.SECOND);
            if(sec < 10)
                buf.append("0");
            buf.append(sec);
        }

        return buf.toString();
    }

    public static Date changeTimeZoneOfDateToThisZone(Date date, String toTimeZoneId) {
        return changeTimeZoneOfDate(date, TimeZone.getDefault().getID(), toTimeZoneId);
    }

    public static Date changeTimeZoneOfDateToDefaultZone(Date date, String fromTimeZoneId) {
        return changeTimeZoneOfDate(date, fromTimeZoneId, TimeZone.getDefault().getID());
    }

    public static Date changeTimeZoneOfDate(Date date, String fromTimeZoneId, String toTimeZoneId) {
        TimeZone fromTimeZoneZone = TimeZone.getTimeZone(fromTimeZoneId);
        TimeZone toTimeZoneZone = TimeZone.getTimeZone(toTimeZoneId);

        Date returnDate = new Date();
        returnDate.setTime(date.getTime() +
                (toTimeZoneZone.getRawOffset() - fromTimeZoneZone.getRawOffset()));
        return returnDate;
    }

    public static Date convertStringToDate(String stringDate)
    //DD/MM/YYYY
    {
        String date[];

        if(stringDate.matches( "(20)[0-9][0-9]-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])"))
            date = stringDate.split("-");
        else
            date = stringDate.split("/");
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR , Integer.parseInt(date[0]));
        cal.set(Calendar.MONTH , Integer.parseInt(date[1]) - 1);
        cal.set(Calendar.DAY_OF_MONTH , Integer.parseInt(date[2]));
//        cal.set(Calendar.HOUR_OF_DAY ,0);
//        cal.set(Calendar.MINUTE ,0);
//        cal.set(Calendar.SECOND ,0);
//        cal.set(Calendar.MILLISECOND ,0);
        return cal.getTime();

    }

    public static String getDateToString(Date date, String delimiter) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        StringBuffer buf = new StringBuffer();
        buf.append(cal.get(Calendar.YEAR));

        buf.append(delimiter);
        if((cal.get(Calendar.MONTH) + 1) < 10)
            buf.append("0");
        buf.append(cal.get(Calendar.MONTH) + 1);

        buf.append(delimiter);
        if(cal.get(Calendar.DAY_OF_MONTH) < 10)
            buf.append("0");
        buf.append(cal.get(Calendar.DAY_OF_MONTH));

        return buf.toString();
    }
    public static String getDateTimeToString(Date date, String delimiter) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        StringBuffer buf = new StringBuffer();
        buf.append(cal.get(Calendar.YEAR));

        buf.append(delimiter);
        if((cal.get(Calendar.MONTH) + 1) < 10)
            buf.append("0");
        buf.append(cal.get(Calendar.MONTH) + 1);

        buf.append(delimiter);
        if(cal.get(Calendar.DAY_OF_MONTH) < 10)
            buf.append("0");
        buf.append(cal.get(Calendar.DAY_OF_MONTH));

        buf.append(delimiter);
        buf.append(cal.get(Calendar.HOUR_OF_DAY));

        buf.append(delimiter);
        buf.append(cal.get(Calendar.MINUTE));

        buf.append(delimiter);
        buf.append(cal.get(Calendar.SECOND));

        return buf.toString();
    }

    public static String convertMiladiToShamsi(Date date) {
        String shamsiDate =  DateConverter.convertMiladiToShamsi(DateUtil.getDateTimeToString(date, "-"));
        // 1350/1/1-00:00:00
        return (shamsiDate);
    }

}
