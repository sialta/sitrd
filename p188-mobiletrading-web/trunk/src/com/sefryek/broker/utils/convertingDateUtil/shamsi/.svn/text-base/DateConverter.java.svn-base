package com.sefryek.broker.utils.convertingDateUtil.shamsi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.StringTokenizer;
import java.util.Date;

import com.sefryek.broker.utils.convertingDateUtil.Calendar;
import com.sefryek.broker.utils.DateUtil;

public class DateConverter {
    private static Log log = LogFactory.getLog(DateConverter.class);

    public static String convertMiladiToShamsi(String miladiDate) {
        try {
            StringTokenizer st = new StringTokenizer(miladiDate, "-");
            String year = st.nextToken();
            String month = st.nextToken();
            int intMonth = Integer.parseInt(month);
            intMonth--;
            String day = st.nextToken();

            SimplePersianCalendar c = new SimplePersianCalendar();
            c.set(Integer.parseInt(year), intMonth, Integer.parseInt(day));
            DateFields df = c.getDateFields();

            String persianMonth =  ((df.getMonth() + 1) < 10) ? ("0" + (df.getMonth() + 1)) : String.valueOf(df.getMonth() + 1);
            String cDate = df.getYear() + "-" + persianMonth + "-" + df.getDay();

            return (cDate);
        }
        catch (Exception ex) {
            log.error("Invalid date format : " + miladiDate);
            return "";
        }
    }

    public static String convertShamsiToMiladi(String shamsiDate) {
        try {
            String shamsi = shamsiDate;
            StringTokenizer st = new StringTokenizer(shamsi, "-");
            String year = st.nextToken();
            String month = st.nextToken();
            int intMonth = Integer.parseInt(month);
            String day = st.nextToken();
            intMonth--;
            DateFields df = new DateFields();
            df.setYear(Integer.parseInt(year));
            df.setMonth(intMonth);
            df.setDay(Integer.parseInt(day));
            SimplePersianCalendar c = new SimplePersianCalendar();
            DateFields pdf = c.getGreDateFields(df);

            String cDate = pdf.getYear() + "-" + (pdf.getMonth() + 1) + "-" + pdf.getDay();

            return cDate;
        }
        catch (Exception ex) {
            log.error("Invalid date format : " + shamsiDate);
            return "";
        }
    }

    public static String getDate(String date) {
        if (date != null && !date.equals("")) {
            try {

                StringTokenizer st = new StringTokenizer(date, "/");
                String year = st.nextToken();                
                String month = st.nextToken();
                String day = st.nextToken();
                String cDate = year + "-" + month + "-" + day;
                String nDate = convertShamsiToMiladi(cDate);
                return nDate;
            }
            catch (Exception ex) {
                log.error("Invalid date format : " + date);
                return "";
            }
        }
        return null;
    }

    public static String getDateString(String date) {
        try {
            StringTokenizer st = new StringTokenizer(date, "-");
            String year = st.nextToken();
            String month = st.nextToken();
            if(month.length()<2)
                month = "0"+month;
            String day = st.nextToken();
            if (day.length() < 2)
                day = "0" + day;
            String ret = year + "/" + month + "/" + day;
            return ret;
        }
        catch (Exception ex) {
            log.error("Invalid date format : " + date);
            return "";
        }

    }
}
