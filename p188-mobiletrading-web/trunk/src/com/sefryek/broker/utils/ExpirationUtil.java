package com.sefryek.broker.utils;

import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jul 11, 2011
 * Time: 2:59:25 PM
 */
public class ExpirationUtil {

    public static void checkExpiration() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2011);
        calendar.set(Calendar.MONTH, 9);
        calendar.set(Calendar.DAY_OF_MONTH, 22);

        if(Calendar.getInstance().getTimeInMillis() >= calendar.getTimeInMillis()) {
            System.exit(1);
        }
    }

}
