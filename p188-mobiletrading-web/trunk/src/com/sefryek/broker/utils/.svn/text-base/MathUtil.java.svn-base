package com.sefryek.broker.utils;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jun 7, 2011
 * Time: 4:39:08 PM
 */
public class MathUtil {
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random rnd = new Random();

    public static long pow(long base, int exp) {
        int total = 1;
        for(int i = 0; i < exp; i++)
            total *= base;
        return total;
    }

    public static int getRandomNumber(int size){
        Random rand = new Random();
        Long topRange = pow(10, size) - 1;
        Long bottomRange = pow(10, size - 1);
        int num = rand.nextInt(topRange.intValue());
        while (num < bottomRange.intValue()) {
            num += num;
        }

        if(num > topRange.intValue()) {
            num %= topRange;
        }

//        System.out.println("Generated Random Number between 0 to " + topRange.intValue() + " is " + num);
        return num;
    }


    public static String randomString( int len ) {
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }


}
