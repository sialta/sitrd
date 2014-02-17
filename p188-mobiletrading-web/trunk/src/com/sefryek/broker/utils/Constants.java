package com.sefryek.broker.utils;


import java.io.StringWriter;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: Mahta
 * Date: Jul 19, 2011
 * Time: 10:19:10 AM
 */
public abstract class Constants {
    public final static short ERROR_RESPONCE_RECEIVE_TOO_LATE = 68;
    public final static short NO_ERROR = 1;

    public final static Integer COMPANIES_PAGE_SIZE = 100;

    private final static StringWriter sw = new StringWriter();
    private final static PrintWriter pw = new PrintWriter(sw, true);

    public final static String COMPANIES_DELEIMITER = "\n";
    public final static String COMPANY_ITEM_DELEIMITER = ";";

    public static String getStackTrace(Throwable t) {
        t.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.toString();
    }
}
