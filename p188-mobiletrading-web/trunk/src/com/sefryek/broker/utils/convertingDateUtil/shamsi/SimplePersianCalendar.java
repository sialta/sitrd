/*
 * In the name of God
 * SimplePersianCalendar.java
 * © Ghasem Kiani
 * 24/09/2003 02:56:36 PM
 * ghasemkiani@yahoo.com
 */

/*
        This program is free software; you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation; either version 2 of the License, or
        (at your option) any later version.

        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with this program; if not, write to the Free Software
        Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

/*
        HISTORY:
        Version 1.3 2003-12-12:
                Added accessor get methods for "properties" persianMonthName
                and persianWeekDayName. Corrected some errors in the
                documentation.
        Version 1.2 2003-11-17:
                Converted Persian literals to Unicode escape sequences.
        Version 1.1 2003-10-23:
                Added Persian names for months and days of the week.
                Added Javadoc documentation for the API.
        Version 1.0 2003-09-25:
                Started the project.
*/

package com.sefryek.broker.utils.convertingDateUtil.shamsi;

import java.util.GregorianCalendar;

/**
 * This class is a subclass of GregorianCalendar, with the added functionality
 * that it can set/get date in the Persian calendar system.
 * <p/>
 * The algorithms for conversion between Persian and Gregorian calendar systems
 * are taken from the <a href="http://couprie.docspages.com/calmath/">
 * "Calendar Math Add-In for Excel"</a> by <a href="mailto:kees@couprie.org">Kees Couprie</a>.
 * As Couprie states, <a href="mailto:mtahani@noornet.net">Mohammad Tahani</a> from the
 * <a href="http://www.noorsoft.org/">Computer Research Center
 * of Islamic Sciences (CRCIS)</a> of I.R. Iran has contributed to
 * the development of the Persian calendar in that package.
 * Their efforts are gratefully acknowledged.
 *
 * @author <a href="mailto:ghasemkiani@yahoo.com">Ghasem Kiani</a>
 * @version 1.3
 */
public class SimplePersianCalendar extends GregorianCalendar {
    public SimplePersianCalendar() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String copyright = "Copyright \u00a9 2003 Ghasem Kiani <ghasemkiani@yahoo.com>. All Rights Reserved.";

    /**
     * Constant for the JDN of 1 Farvardin 1
     *
     * @since 1.1
     */
    public static final long PERSIAN_EPOCH = 1948321;

    /**
     * Constant for Farvardin, the 1st month of the Persian year.
     *
     * @since 1.1
     */
    public static final int FARVARDIN = 0;
    /**
     * Constant for Ordibehesht, the 2nd month of the Persian year.
     *
     * @since 1.1
     */
    public static final int ORDIBEHESHT = 1;
    /**
     * Constant for Khordad, the 3rd month of the Persian year.
     *
     * @since 1.1
     */
    public static final int KHORDAD = 2;
    /**
     * Constant for Tir, the 4th month of the Persian year.
     *
     * @since 1.1
     */
    public static final int TIR = 3;
    /**
     * Constant for Mordad, the 5th month of the Persian year.
     *
     * @since 1.1
     */
    public static final int MORDAD = 4;
    /**
     * Constant for Shahrivar, the 6th month of the Persian year.
     *
     * @since 1.1
     */
    public static final int SHAHRIVAR = 5;
    /**
     * Constant for Mehr, the 7th month of the Persian year.
     *
     * @since 1.1
     */
    public static final int MEHR = 6;
    /**
     * Constant for Aban, the 8th month of the Persian year.
     *
     * @since 1.1
     */
    public static final int ABAN = 7;
    /**
     * Constant for Azar, the 9th month of the Persian year.
     *
     * @since 1.1
     */
    public static final int AZAR = 8;
    /**
     * Constant for Dey, the 10th month of the Persian year.
     *
     * @since 1.1
     */
    public static final int DEY = 9;
    /**
     * Constant for Bahman, the 11th month of the Persian year.
     *
     * @since 1.1
     */
    public static final int BAHMAN = 10;
    /**
     * Constant for Esfand, the 12th month of the Persian year.
     *
     * @since 1.1
     */
    public static final int ESFAND = 11;

    /**
     * Persian month names.
     *
     * @since 1.1
     */
    // Comments are in "windows-1256" encoding, but the code is essentially ASCII.
	/*public static final String[] persianMonths =
	{
		"\u0641\u0631\u0648\u0631\u062F\u064A\u0646", // "�������"
		"\u0627\u0631\u062F\u064A\u200C\u0628\u0647\u0634\u062A", // "����?����"
		"\u062E\u0631\u062F\u0627\u062F", // "�����"
		"\u062A\u064A\u0631", // "���"
		"\u0627\u0645\u0631\u062F\u0627\u062F", // "������"
		"\u0634\u0647\u0631\u064A\u0648\u0631", // "������"
		"\u0645\u0647\u0631", // "���"
		"\u0622\u0628\u0627\u0646", // "����"
		"\u0622\u0630\u0631", // "���"
		"\u062F\u064A", // "��"
		"\u0628\u0647\u0645\u0646", // "����"
		"\u0627\u0633\u0641\u0646\u062F" // "�����"
	};*/
    
	public static final String[] persianMonths =
	{
	    "&#1601;&#1585;&#1608;&#1585;&#1583;&#1740;&#1606",
	    "&#1575;&#1585;&#1583;&#1740;&#1576;&#1607;&#1588;&#1578",
	    "&#1582;&#1585;&#1583;&#1575;&#1583",
	    "&#1578;&#1740;&#1585;",
	    "&#1605;&#1585;&#1583;&#1575;&#1583;",
	    "&#1588;&#1607;&#1585;&#1740;&#1608;&#1585;",
	    "&#1605;&#1607;&#1585;",
	    "&#1570;&#1576;&#1575;&#1606;",
	    "&#1570;&#1584;&#1585;",
	    "&#1583;&#1740;",
	    "&#1576;&#1607;&#1605;&#1606;",
	    "&#1575;&#1587;&#1601;&#1606;&#1583;",
	};

    
    /**
     * Persian week day names.
     *
     * @since 1.1
     */
    // Comments are in "windows-1256" encoding, but the code is essentially ASCII.
    /* public static final String[] persianWeekDays =
            {
                "\u0634\u0646\u0628\u0647", // "ÔäÈå"
                "\u064A\u0643\u0634\u0646\u0628\u0647", // "íßÔäÈå"
                "\u062F\u0648\u0634\u0646\u0628\u0647", // "�?æÔäÈå"
                "\u0633\u0647\u200C\u0634\u0646\u0628\u0647", // "Óå?ÔäÈå"
                "\u0686\u0647\u0627\u0631\u0634\u0646\u0628\u0647", // "?åÇÑÔäÈå"
                "\u067E\u0646\u062C\u0634\u0646\u0628\u0647", // "?äÌÔäÈå"
                "\u062C\u0645\u0639\u0647" // "ÌãÚå"
            }; */

    public static final String[] persianWeekDays =
    {
        "&#1588;&#1606;&#1576;&#1607;", // "ÔäÈå"
        "&#1740;&#1705;&#1588;&#1606;&#1576;&#1607;", // "íßÔäÈå"
        "&#1583;&#1608;&#1588;&#1606;&#1576;&#1607;", // "�?æÔäÈå"
        "&#1587;&#1607; &#1588;&#1606;&#1576;&#1607;", // "Óå?ÔäÈå"
        "&#1670;&#1607;&#1575;&#1585;&#1588;&#1606;&#1576;&#1607;", // "?åÇÑÔäÈå"
        "&#1662;&#1606;&#1580;&#1588;&#1606;&#1576;&#1607;", // "?äÌÔäÈå"
        "&#1580;&#1605;&#1593;&#1607;" // "ÌãÚå"
    };
    
    /**
     * Sets the date of this calendar object to the specified
     * Persian date (year, month, and day fields)
     *
     * @since 1.0
     */
    public void setDateFields(int year, int month, int day) {
        setDateFields(new DateFields(year, month, day));
    }

    /**
     * Sets the date of this calendar object to the specified
     * Persian date fields
     *
     * @since 1.0
     */
    public void setDateFields(DateFields dateFields) {
        DateFields t = convertJdnToGregorian(convertPersianToJdn(dateFields));
        set(YEAR, t.getYear());
        set(MONTH, t.getMonth());
        set(DAY_OF_MONTH, t.getDay());
    }
    /**
     * 
     * Convert Persian date to Gregorian
     */
    public DateFields getGreDateFields(DateFields dateFields) { 
    	DateFields t = convertJdnToGregorian(convertPersianToJdn(dateFields));
        return t;
    }

    /**
     * Retrieves the date of this calendar object as the
     * Persian date fields
     *
     * @since 1.0

     */
    public DateFields getDateFields() {
        if (isSet(YEAR) && isSet(MONTH) && isSet(DAY_OF_MONTH)) {
            return convertJdnToPersian(convertGregorianToJdn(get(YEAR), get(MONTH), get(DAY_OF_MONTH)));
        } else {
            return new DateFields();
        }
    }

    public DateFields getJDNDateFields() {
        if (isSet(YEAR) && isSet(MONTH) && isSet(DAY_OF_MONTH)) {
            return convertJdnToPersian(convertGregorianToJdn(get(YEAR), get(MONTH), get(DAY_OF_MONTH)));
        } else {
            return new DateFields();
        }
    }
    /**
     * Gives the name of the specified Persian month.
     *
     * @since 1.1
     */
    public static String getPersianMonthName(int month) {
        return persianMonths[month];
    }

    /**
     * Gives the name of the current Persian month for this calendar's date.
     *
     * @since 1.3
     */
    public String getPersianMonthName() {
        return getPersianMonthName(getDateFields().getMonth());
    }

    /**
     * Gives the Persian name of the specified day of the week.
     *
     * @since 1.1
     */
    public static String getPersianWeekDayName(int weekDay) {
        switch (weekDay) {
            case SATURDAY:
                return persianWeekDays[0];
            case SUNDAY:
                return persianWeekDays[1];
            case MONDAY:
                return persianWeekDays[2];
            case TUESDAY:
                return persianWeekDays[3];
            case WEDNESDAY:
                return persianWeekDays[4];
            case THURSDAY:
                return persianWeekDays[5];
            case FRIDAY:
                return persianWeekDays[6];
        }
        return "";
    }

    /**
     * Gives the name of the specified day of the month.
     *
     * @since 1.1
     */
    public int getPersianDayOfWeek() {
      return get(DAY_OF_WEEK);
    }
    
    
    /**
     * Gives the day of year of the specified day of the month.
     * input are :
     * 1- day of month in Persian month.
     * 2- month of year in persian year.
     * @since 1.1
     */
    public static int getPersianDayOfYear( int dayOfMonth, int MonthOfYear ) {
      int dayOfYear = 0;
      
      /*
       *    the monthes that begins from '0' ( for farvardin ) is less than
       *    or equal shahrivar.
       */  
      if ( MonthOfYear <= 5 ) 
        if ( MonthOfYear == 0 )
          dayOfYear = dayOfMonth; 
        else 
          if ( MonthOfYear == 1 ) 
            dayOfYear = ( ( MonthOfYear ) * 31 + dayOfMonth );
          else
            dayOfYear = ( ( MonthOfYear-1 ) * 31 + dayOfMonth );
      else 
        if ( MonthOfYear > 5 && MonthOfYear <= 11 ) 
          dayOfYear = ( ( MonthOfYear-6 ) * 30 + 186/* (6*31) */+ dayOfMonth );
        else 
          dayOfYear = 0;
        
      return dayOfYear;
    }


    /**
     * Gives the Week of Month of the specified day of the month.
     * @since 1.1
     */
    public static int getPersianWeekOfMonth( int dayOfMonth, int firstDayOfMonth ) {
      int WeekOfMonth = 1;    
      int top_rownded_quotient = 0; 
      int remainder = 0;
          
      remainder = dayOfMonth % 7;
      top_rownded_quotient = (int) Math.ceil( (double)dayOfMonth/7 );
      
      if ( remainder == 0 )
        if ( firstDayOfMonth != 7 )
          WeekOfMonth = top_rownded_quotient + 1;
        else
          WeekOfMonth = top_rownded_quotient;
        
      if ( remainder != 0) {
        if ( top_rownded_quotient < 5  )
          WeekOfMonth = top_rownded_quotient;
        else 
          if ( top_rownded_quotient >= 5 )
            if ( firstDayOfMonth <= 4 || firstDayOfMonth == 7 )
              WeekOfMonth = 5;
            else 
              WeekOfMonth = 6;
      }      
      return WeekOfMonth;
    }
    
    
    /**
     * Gives the Persian name of the current day of the week for this calendar's date.
     *
     * @since 1.3
     */
    public String getPersianWeekDayName() {
        return getPersianWeekDayName(get(DAY_OF_WEEK));
    }

    // Correspondence between original VB functions and Java methods:
    // ====================
    // VB === Java
    // --------------------
    // int === floor
    // fix === myfloor
    // ceil === myceil
    // ====================

    private static long mysign(double x) {
        return x < 0 ? -1 : (x > 0 ? 1 : 0);
    }

    private static long myfloor(double x) {
        double y = Math.abs(x);
        double f = Math.floor(y);
        return (long) (mysign(x) * f);
    }

    private static long myceil(double x) {
        double y = Math.abs(x) * -1.0;
        double f = Math.floor(y);
        return (long) (-mysign(x) * f);
    }

    /**
     * Is "year" a leap year in the Persian calendar?
     */
    public static boolean leapYear(long year) {
        long lYear = year;

        if (lYear > 0)
            return ((((((lYear - (474)) % 2820) + 474) + 38) * 682) % 2816) < 682;
        else
            return ((((((lYear - (473)) % 2820) + 474) + 38) * 682) % 2816) < 682;
    }

    private static long convertPersianToJdn(DateFields t) {
        return convertPersianToJdn(t.getYear(), t.getMonth(), t.getDay());
    }

    private static long convertPersianToJdn(int iYear, int iMonth, int iDay) {
        long lYear = iYear;
        long lMonth = iMonth + 1; // Calculations assume 1-based months
        long lDay = iDay;

        long epbase, epyear, mdays;
        if (lYear >= 0)
            epbase = lYear - 474;
        else
            epbase = lYear - 473;
        epyear = 474 + (epbase % 2820);
        if (lMonth <= 7)
            mdays = (lMonth - 1) * 31;
        else
            mdays = (lMonth - 1) * 30 + 6;

        long jdn = lDay + mdays + myfloor(((epyear * 682) - 110) /*double*/ / 2816.0) + (epyear - 1) * 365 + myfloor(epbase /*double*/ / 2820.0) * 1029983 + (PERSIAN_EPOCH - 1);
        return jdn;
    }

    private static DateFields convertJdnToPersian(long jdn) {
        long lYear;
        long lMonth;
        long lDay;

        long depoch, cycle, cyear, ycycle, aux1, aux2, yday;
        depoch = jdn - convertPersianToJdn(475, FARVARDIN /*Changed by ghasemkiani*/, 1);
        cycle = myfloor(depoch /*double*/ / 1029983.0);
        cyear = depoch % 1029983;
        if (cyear == 1029982)
            ycycle = 2820;
        else {
            aux1 = myfloor(cyear /*double*/ / 366.0);
            aux2 = cyear % 366;
            ycycle = (long) Math.floor(((2134 * aux1) + (2816 * aux2) + 2815) /*double*/ / 1028522.0) + aux1 + 1;
        }
        lYear = ycycle + (2820 * cycle) + 474;
        if (lYear <= 0) lYear = lYear - 1;
        yday = (jdn - convertPersianToJdn((int) lYear, FARVARDIN /*Changed by ghasemkiani*/, 1)) + 1;
        if (yday <= 186)
            lMonth = myceil(yday /*double*/ / 31.0);
        else
            lMonth = myceil((yday - 6) /*double*/ / 30.0);
        lDay = (jdn - convertPersianToJdn((int) lYear, (int) lMonth - 1 /*Changed by ghasemkiani*/, 1)) + 1;

        DateFields t = new DateFields();
        t.setYear((int) lYear);
        t.setMonth((int) lMonth - 1); // Calculations assume 1-based months
        t.setDay((int) lDay);
        return t;
    }

    static long convertGregorianToJdn(DateFields t) {
        return convertGregorianToJdn(t.getYear(), t.getMonth(), t.getDay());
    }

    private static long convertGregorianToJdn(int iYear, int iMonth, int iDay) {
        long lYear = iYear;
        long lMonth = iMonth + 1; // Calculations assume 1-based months
        long lDay = iDay;

        if ((lYear > 1582) || ((lYear == 1582) && (lMonth > 10)) || ((lYear == 1582) && (lMonth == 10) && (lDay > 14))) {
            return ((1461 * (lYear + 4800 + ((lMonth - 14) /*long*/ / 12))) /*long*/ / 4) + ((367 * (lMonth - 2 - 12 * (((lMonth - 14) /*long*/ / 12)))) /*long*/ / 12) - ((3 * (((lYear + 4900 + ((lMonth - 14) /*long*/ / 12)) /*long*/ / 100))) /*long*/ / 4) + lDay - 32075;
        } else {
            return convertJulianToJdn(iYear, iMonth, iDay);
        }
    }

    private static DateFields convertJdnToGregorian(long jdn) {
        long lYear;
        long lMonth;
        long lDay;

        long l, k, n, i, j;
        if (jdn > 2299160) {
            l = jdn + 68569;
            n = ((4 * l) /*long*/ / 146097);
            l = l - ((146097 * n + 3) /*long*/ / 4);
            i = ((4000 * (l + 1)) /*long*/ / 1461001);
            l = l - ((1461 * i) /*long*/ / 4) + 31;
            j = ((80 * l) /*long*/ / 2447);
            lDay = l - ((2447 * j) /*long*/ / 80);
            l = (j /*long*/ / 11);
            lMonth = j + 2 - 12 * l;
            lYear = 100 * (n - 49) + i + l;

            DateFields t = new DateFields();
            t.setYear((int) lYear);
            t.setMonth((int) lMonth - 1); // Calculations assume 1-based months
            t.setDay((int) lDay);
            return t;
        } else {
            return convertJdnToJulian(jdn);
        }
    }

    private static long convertJulianToJdn(DateFields t) {
        return convertJulianToJdn(t.getYear(), t.getMonth(), t.getDay());
    }

    private static long convertJulianToJdn(int iYear, int iMonth, int iDay) {
        long lYear = iYear;
        long lMonth = iMonth + 1; // Calculations assume 1-based months
        long lDay = iDay;

        return 367 * lYear - ((7 * (lYear + 5001 + ((lMonth - 9) /*long*/ / 7))) /*long*/ / 4) + ((275 * lMonth) /*long*/ / 9) + lDay + 1729777;
    }

    private static DateFields convertJdnToJulian(long jdn) {
        long lYear;
        long lMonth;
        long lDay;

        long l, k, n, i, j;
        j = jdn + 1402;
        k = ((j - 1) /*long*/ / 1461);
        l = j - 1461 * k;
        n = ((l - 1) /*long*/ / 365) - (l /*long*/ / 1461);
        i = l - 365 * n + 30;
        j = ((80 * i) /*long*/ / 2447);
        lDay = i - ((2447 * j) /*long*/ / 80);
        i = (j /*long*/ / 11);
        lMonth = j + 2 - 12 * i;
        lYear = 4 * k + n + i - 4716;

        DateFields t = new DateFields();
        t.setYear((int) lYear);
        t.setMonth((int) lMonth - 1); // Calculations assume 1-based months
        t.setDay((int) lDay);
        return t;
    }
    
    /**
     * Gives the number of days in a month.
     * @since 1.1
     */
    public static int getPersianDaysOfMonth( int monthNumber, int persianYear ) {
      int daysOfMonth = 0;
      
      if ( monthNumber <= 5 )
        daysOfMonth = 31;
      
      else 
        if ( monthNumber > 5  &&  monthNumber < 12 )
          if ( monthNumber == 11 )
            if ( SimplePersianCalendar.leapYear( persianYear ) ) {
              daysOfMonth = 30;
            } 
            else
              daysOfMonth = 29;
          else
            daysOfMonth = 30;
      
      return daysOfMonth;
    }
    
    

    public int dayOfWeek() {
        return 1;
    }

    public int dayOfYear() {
        int thisDayOfYear = 0;
        int dayOfMonth;
        int monthOfYear;

        DateFields tempDate = new DateFields();
        tempDate = getDateFields();

        dayOfMonth = tempDate.getDay();
        monthOfYear = tempDate.getMonth();

        if ( monthOfYear > 6 ) {
          thisDayOfYear += ((monthOfYear-1) * 30) + dayOfMonth;
        }

        return thisDayOfYear;
    }

    public int weekOfMonth() {
        return 1;
    }

    public int weekOfYear() {
        return 1;
    }


    /**
     * A sample application using SimplePersianCalendar.
     * <p/>
     * Please redirect the output to a file if your console
     * does not support Persian characters (Code Page 1256).
     * (The default encoding of your system must be capable
     * of encoding Persian characters, anyway.)
     * For example, write:
     * <pre>java com.ghasemkiani.util.SimplePersianCalendar > output.txt</pre>
     * Then, inspect the file "output.txt" to see the results.
     */
    public static void main(String[] args) {
//        SimplePersianCalendar c = new SimplePersianCalendar();
//        DateFields df = c.getDateFields();
//      //  System.out.println(df);
//        // Comment is in "windows-1256" encoding, but the code is essentially ASCII.
//       // System.out.println("\u0627\u0645\u0631\u0648\u0632: " /* "ÇãÑæÒ: " */ + getPersianWeekDayName(c.get(DAY_OF_WEEK)) + " " + df.getDay() + " " + getPersianMonthName(df.getMonth()) + " " + df.getYear());
//        
//        DateFields df2=new DateFields();
//        df2.setYear(1385);
//        df2.setMonth(10);
//        df2.setDay(28);
//       // c.setDateFields(df2);
//        System.out.println(c.getGreDateFields(df2));
    	
    	DateFields df=new DateFields();
		df.setDay(17);
		df.setYear(2007);
		df.setMonth(3);
		
		SimplePersianCalendar cal=new SimplePersianCalendar();
		cal.set(2007, 3, 25);
		DateFields ndf=cal.getDateFields();
    }

    private void jbInit() throws Exception {
    }

}
