package com.sefryek.broker.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by IntelliJ IDEA.
 * User: mahta
 * Date: May 25, 2011
 * Time: 12:18:59 PM
 */
public class DoubleUtil {
    public static String bigeDecimalString(String amount){
        BigDecimal decimal = new BigDecimal(amount);
        return decimal.setScale(2, RoundingMode.HALF_UP).toString();
    }

    public static double bigDecimal(String amount){
        BigDecimal decimal = new BigDecimal(amount);
        return Double.parseDouble(decimal.setScale(2, RoundingMode.HALF_UP).toString());
    }

    public static double bigDecimal(Double amount){
        BigDecimal decimal = new BigDecimal(amount);
        return Double.parseDouble(decimal.setScale(2, RoundingMode.HALF_UP).toString());
    }

    public static String bigeDecimalString(Double amount){
        BigDecimal decimal = new BigDecimal(amount);
        return decimal.setScale(2, RoundingMode.HALF_UP).toString();
    }
//
//    public static String bigeDecimalStringWithComma(Double amount){
//        BigDecimal decimal = new BigDecimal(amount);
//        return StringUtil.insertComma(decimal.setScale(2, RoundingMode.HALF_UP).toString());
//    }

    public static String bigeDecimalZiro(Double amount){
        BigDecimal decimal = new BigDecimal(amount);
        return decimal.setScale(0, RoundingMode.HALF_UP).toString();
    }

    public static double round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
