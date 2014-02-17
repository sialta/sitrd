package com.sefryek.broker.utils.convertingDateUtil;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @version 0.4
 * @since 0.1
 */
public class DateConvertor {

    /**
     * Constant for Unknown remainder in dividing time in milliseconds by 86400000 that is milliseconds in 1 day!
     */
    private static final long EXCESSIVE_MILLISECONDS_AFTER_MIDNIGHT = 70200000;

    /**
     * Constant for indicating milliseconds in an hour.
     */
    private static final long HOUR_IN_MILLISECONDS = 3600000;

    /**
     * Constant for indicating milliseconds in a day.
     */
    private static final long DAY_IN_MILLISECONDS = 86400000;

    /**
     * Constant for persian language
     */
    private static final String PERSIAN_LANGUAGE = "fa";

    public DateConvertor() {
    }

    public static Timestamp createPersianDate(String year, String month, String day) {
        Timestamp timestamp = gregorianToPersianString(year, month, day);
        return timestamp;
    }

    /**
     * This method create a Timestamp object with the given year, month and day properties based on given locale. If the locale is persian then
     * the returned calculated Timestamp object is persian otherwise it is gregorian.
     * @param year String
     * @param month String
     * @param day String
     * @param locale Locale If the locale is persian then the returned calculated Timestamp object is persian otherwise it is gregorian
     * @return Timestamp If the locale is persian then the returned calculated Timestamp object is persian otherwise it is gregorian
     */
    public static Timestamp createDate(String year, String month, String day, Locale locale) {
        if(locale.getLanguage().equalsIgnoreCase(PERSIAN_LANGUAGE)) {
            return createPersianDate(year, month, day);
        } else {
            int intYear = Integer.parseInt(year);
            int intMonth = Integer.parseInt(month);
            int intDay = Integer.parseInt(day);

            GregorianCalendar calendar = new GregorianCalendar(intYear, intMonth, intDay);
            Timestamp gregTimestamp = new Timestamp(calendar.getTime().getTime());
            return gregTimestamp;
        }
    }

    public static Timestamp gregorianToPersianString(String yearStr, String monthStr, String dayStr) {

        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        int day = Integer.parseInt(dayStr);

        JalaliCalendar jCal = new JalaliCalendar();
        jCal.set(year, month - 1, day);

        Timestamp persianTimeStamp = new Timestamp(jCal.getTime().getTime());
        persianTimeStamp.setNanos(0);
        return persianTimeStamp;

    }

    /**
     * Converts gregorian calendar to Persian with left to right arrangment.
     * @param date is timestamp
     * @return persian date
     */
    public static String gregorianToPersianLTR(java.sql.Timestamp date) {
        DateFormat df = DateFormat.getInstance();
        java.util.Calendar cal = df.getCalendar();

        cal.setTimeInMillis(date.getTime() + HOUR_IN_MILLISECONDS);

        java.util.Date dd = cal.getTime();

        JalaliCalendar jCal = new JalaliCalendar();

        jCal.setTime(dd);

        String year = String.valueOf(jCal.get(Calendar.YEAR));
        String month = String.valueOf(jCal.get(Calendar.MONTH) + 1);
        String day = String.valueOf(jCal.get(Calendar.DAY_OF_MONTH));
        if (month.length() < 2)
            month = "0" + month;
        if (day.length() < 2)
            day = "0" + day;

        String farsiDate = year +
                "/" +
                month +
                "/" +
                day;

        return farsiDate;
    }

    public static Date persianToGregorian(String date) {

        StringTokenizer st = new StringTokenizer(date, "-");

        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        JalaliCalendar jCal = new JalaliCalendar();
        jCal.set(year, month, day);
        return jCal.getTime();
    }

    public static Date fullPersianToFullGregorian(String date) {

        StringTokenizer st = new StringTokenizer(date, "-");

        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int hour = Integer.parseInt(st.nextToken());
        int minut = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        JalaliCalendar jCal = new JalaliCalendar();
        System.out.println("FullPersianToFullGregorian: hour: minut: second: " + hour + ":" + minut + ":" + second);
        jCal.set(year, month, day, hour, minut, second);
        return jCal.getTime();
    }

    public static Date persianToGregorian(String date, String delimeter) {

        StringTokenizer st = new StringTokenizer(date, delimeter);

        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        JalaliCalendar jCal = new JalaliCalendar();
        jCal.set(year, month, day);
        return jCal.getTime();
    }

    public static String gregorianToPersian(Date date) {
        DateFormat df = DateFormat.getInstance();
        java.util.Calendar cal = df.getCalendar();

        cal.setTimeInMillis(date.getTime() + HOUR_IN_MILLISECONDS);

        java.util.Date dd = cal.getTime();

        JalaliCalendar jCal = new JalaliCalendar();

        jCal.setTime(dd);

        String farsiDate = jCal.get(Calendar.YEAR) +
            "/" +
            (jCal.get(Calendar.MONTH) + 1) +
            "/" +
            jCal.get(Calendar.DAY_OF_MONTH);

        return farsiDate;
    }

    public static String gregorianToPersian(java.sql.Timestamp date) {
        DateFormat df = DateFormat.getInstance();
        java.util.Calendar cal = df.getCalendar();

        cal.setTimeInMillis(date.getTime() + HOUR_IN_MILLISECONDS);

        java.util.Date dd = cal.getTime();

        JalaliCalendar jCal = new JalaliCalendar();

        jCal.setTime(dd);

        String farsiDate = jCal.get(Calendar.YEAR) +
            "/" +
            (jCal.get(Calendar.MONTH) + 1) +
            "/" +
            jCal.get(Calendar.DAY_OF_MONTH);

        return farsiDate;
    }

    public static String persianToGregorianString(String pDate, String pattern, FieldPosition fPos) {

        java.util.Date gDate = persianToGregorian(pDate);
        StringBuffer auxDate = new StringBuffer();
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        auxDate = dateFormat.format(gDate, auxDate, fPos);

        return auxDate.toString();
    }

    public static String persianToGregorianString(String pDate, String pattern) {

        java.util.Date gDate = persianToGregorian(pDate);
        StringBuffer auxDate = new StringBuffer();
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        FieldPosition fPos = new FieldPosition(DateFormat.YEAR_FIELD);
        auxDate = dateFormat.format(gDate, auxDate, fPos);

        return auxDate.toString();
    }

    public static String persianToGregorianString(String pDate) {

        java.util.Date gDate = persianToGregorian(pDate);
        StringBuffer auxDate = new StringBuffer();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        FieldPosition fPos = new FieldPosition(dateFormat.YEAR_FIELD);
        auxDate = dateFormat.format(gDate, auxDate, fPos);

        return auxDate.toString();
    }

    /**
     * This method returns the current date and sets hour,min and second to zero
     * @return
     */
    public static Timestamp getCurrentDateExcludeTime() {
        GregorianCalendar calendar = new GregorianCalendar();
        GregorianCalendar cal = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH));
        long time = cal.getTimeInMillis();
        Timestamp date = new Timestamp(time);
        return(date);
    }

    /**
     * Gives current time year based on given locale.
     * @param locale Locale, if locale language is "fa" then returend year is a Jalali year otherwise it is a Gregorian year
     * @return int if locale language is "fa" then returend year is a Jalali year otherwise it is a Gregorian year
     */
    public static int getCurrnetTimeYear(Locale locale) {
        if(locale.getLanguage().equalsIgnoreCase(PERSIAN_LANGUAGE)) {
            return getCurrnetTimeJalaliYear();
        } else {
            return getCurrnetTimeGregorianYear();
        }
    }

    /**
     * Gives current time month based on given locale.
     * @param locale Locale, if locale language is "fa" then returend month is a Jalali year otherwise it is a Gregorian month
     * @return int if locale language is "fa" then returend month is a Jalali year otherwise it is a Gregorian month
     */
    public static int getCurrnetTimeMonth(Locale locale) {
        if(locale.getLanguage().equalsIgnoreCase("fa")) {
            return getCurrnetTimeJalaliMonth();
        } else {
            return getCurrnetTimeGregorianMonth();
        }
    }

    /**
     * Gives current time day based on given locale.
     * @param locale Locale, if locale language is "fa" then returend day is a Jalali year otherwise it is a Gregorian day
     * @return int if locale language is "fa" then returend day is a Jalali year otherwise it is a Gregorian day
     */
    public static int getCurrnetTimeDay(Locale locale) {
        if(locale.getLanguage().equalsIgnoreCase("fa")) {
            return getCurrnetTimeJalaliDay();
        } else {
            return getCurrnetTimeGregorianDay();
        }
    }

    /**
     * Gives current time persian year
     * @return int
     */
    public static int getCurrnetTimeJalaliYear() {
        GregorianCalendar cal = new GregorianCalendar();

        java.util.Date dd = cal.getTime();

        JalaliCalendar jCal = new JalaliCalendar();

        jCal.setTime(dd);
        int year = jCal.get(Calendar.YEAR);
        return year;
    }

    /**
     * Gives current time persian month
     * @return int is from 0 to 11
     */
    public static int getCurrnetTimeJalaliMonth() {
        GregorianCalendar cal = new GregorianCalendar();

        java.util.Date dd = cal.getTime();

        JalaliCalendar jCal = new JalaliCalendar();

        jCal.setTime(dd);
        int month = jCal.get(Calendar.MONTH);
        return month;
    }

    /**
     * Gives current time persian year
     * @return int is from 1 to 31
     */
    public static int getCurrnetTimeJalaliDay() {
        GregorianCalendar cal = new GregorianCalendar();

        java.util.Date dd = cal.getTime();

        JalaliCalendar jCal = new JalaliCalendar();

        jCal.setTime(dd);
        int day = jCal.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    /**
     * Gives jalali year of the given Timestamp considering if time is exactly midnight or not in order to prevent date conversion 1 day lag!
     * @param time Timestamp
     * @return int
     */
    public static int getJalaliYear(Timestamp time) {
        long timeInMilli = time.getTime();
        if((timeInMilli % DAY_IN_MILLISECONDS) == EXCESSIVE_MILLISECONDS_AFTER_MIDNIGHT) {
            timeInMilli += HOUR_IN_MILLISECONDS;
        }
        Date date = new Date(timeInMilli);

        JalaliCalendar jCal = new JalaliCalendar();

        jCal.setTime(date);
        int year = jCal.get(Calendar.YEAR);
        return year;
    }

    /**
     * Gives jalali month of the given Timestamp considering if time is exactly midnight or not in order to prevent date conversion 1 day lag!
     * @param time Timestamp
     * @return int
     */
    public static int getJalaliMonth(Timestamp time) {
        long timeInMilli = time.getTime();
        if((timeInMilli % DAY_IN_MILLISECONDS) == EXCESSIVE_MILLISECONDS_AFTER_MIDNIGHT) {
            timeInMilli += HOUR_IN_MILLISECONDS;
        }
        Date date = new Date(timeInMilli);

        JalaliCalendar jCal = new JalaliCalendar();

        jCal.setTime(date);
        int month = jCal.get(Calendar.MONTH);
        return month;
    }

    /**
     * Gives jalali day of the given Timestamp considering if time is exactly midnight or not in order to prevent date conversion 1 day lag!
     * @param time Timestamp
     * @return int
     */
    public static int getJalaliDay(Timestamp time) {
        long timeInMilli = time.getTime();
        if((timeInMilli % DAY_IN_MILLISECONDS) == EXCESSIVE_MILLISECONDS_AFTER_MIDNIGHT) {
            timeInMilli += HOUR_IN_MILLISECONDS;
        }
        Date date = new Date(timeInMilli);

        JalaliCalendar jCal = new JalaliCalendar();

        jCal.setTime(date);
        int day = jCal.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    /**
     * Gives gregorian year of the given Timestamp
     * @param time Timestamp
     * @return int
     */
    public static int getGregorianYear(Timestamp time) {
        Date date = new Date(time.getTime());

        GregorianCalendar cal = new GregorianCalendar();

        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    /**
     * Gives gregorian month of the given Timestamp
     * @param time Timestamp
     * @return int
     */
    public static int getGregorianMonth(Timestamp time) {
        Date date = new Date(time.getTime());

        GregorianCalendar cal = new GregorianCalendar();

        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        return month;
    }

    /**
     * Gives gregorian day of the given Timestamp
     * @param time Timestamp
     * @return int
     */
    public static int getGregorianDay(Timestamp time) {
        Date date = new Date(time.getTime());

        GregorianCalendar cal = new GregorianCalendar();

        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    /**
     * Gives current time gregorian year
     * @return int
     */
    public static int getCurrnetTimeGregorianYear() {
        GregorianCalendar cal = new GregorianCalendar();

        int year = cal.get(Calendar.YEAR);
        return year;
    }

    /**
     * Gives current time gregorian month
     * @return int is from 0 to 11
     */
    public static int getCurrnetTimeGregorianMonth() {
        GregorianCalendar cal = new GregorianCalendar();

        int month = cal.get(Calendar.MONTH);
        return month;
    }

    /**
     * Gives current time gregorian year
     * @return int is from 1 to 31
     */
    public static int getCurrnetTimeGregorianDay() {
        GregorianCalendar cal = new GregorianCalendar();

        int day = cal.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    /**
     * Checks if the given jalali year is leap or not
     * @param year int is a jalali year
     * @return boolean
     */
    public static boolean isJalaliYearLeap(int year) {
        JalaliCalendar jCal = new JalaliCalendar();
        if(jCal.isLeapYear(year)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the given year is leap or not
     * @param year int is year
     * @return boolean
     */
    public static boolean isGregorianYearLeap(int year) {
        GregorianCalendar cal = new GregorianCalendar();
        if(cal.isLeapYear(year)) {
            return true;
        }
        return false;
    }

    /**
     * Excludes time from date i.e. Hour = 0, Minute = 0, Second = 0 and Milisecond = 0
     * @param timestamp
     * @return
     */
    public static Timestamp getMidnightDate(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime((Date) timestamp);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Timestamp midnightDate = new Timestamp(calendar.getTimeInMillis());
        return midnightDate;
    }
}
