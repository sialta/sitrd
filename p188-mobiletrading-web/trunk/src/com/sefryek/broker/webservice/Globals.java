package com.sefryek.broker.webservice;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: Mahta
 * Date: Jul 20, 2011
 * Time: 9:38:27 AM
 */
public abstract class Globals {


    public static BigDecimal SafeBigDecimal(int text, double defaultValue) {
        try {
            return BigDecimal.valueOf(text);

        } catch (Exception e) {
            return BigDecimal.valueOf(defaultValue);
        }
    }

    public static int SafeInt(String text, int defaultValue) {
        try {
            return Integer.valueOf(text);

        } catch (NumberFormatException e) {
            /* no need to do anything here */
        }

        return defaultValue;
    }

    public static long SafeLong(String text, long defaultValue)
    {
        try {
            return Long.valueOf(text);

        } catch (NumberFormatException e) {
            /* no need to do anything here */
        }

        return defaultValue;
    }

    public static String SafePersianEncode(String str){
        if (str == null || !str.trim().isEmpty())
            return "";

        str = str.replaceAll("ي", "ی");
        str = str.replaceAll("ك", "ک");
        return str;
    }

    public static String SafeString(Object text, String defaultValue) {
        if (text != null && !text.toString().isEmpty()) {
            try {
                return text.toString();

            } catch (Exception e) {
                /* no need to do anything here */
            }
        }

        return defaultValue;
    }


}
