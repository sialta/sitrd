package com.sefryek.broker.utils;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jun 7, 2011
 * Time: 4:39:08 PM
 */
public class RaviMathUtil {

    public static long pow(long base, int exp) {
        int total = 1;
        for(int i = 0; i < exp; i++)
            total *= base;
        return total;
    }
}
