package com.sefryek.broker.utils;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jun 22, 2011
 * Time: 8:25:01 AM
 */
public class MobileNumberUtil {

    public static String getStandardMobileNumber(String mobileNumber) {
        if(mobileNumber == null)
            return "";

        mobileNumber = mobileNumber.trim();
        if(mobileNumber.startsWith("00")) {
            mobileNumber = mobileNumber.substring(2, mobileNumber.length());

        } else if(mobileNumber.startsWith("0")) {
            mobileNumber = mobileNumber.substring(1, mobileNumber.length());
            mobileNumber = "98" + mobileNumber;

        } else if(!mobileNumber.startsWith("98") && mobileNumber.length() == 10) {
            mobileNumber = "98" + mobileNumber;
        }
        return mobileNumber;
    }

    public static String removeCountryCodeAndZero(String mobileNumber) {
        if(mobileNumber == null)
            return "";

        mobileNumber = mobileNumber.trim();
        if(mobileNumber.startsWith("0098")) {
            mobileNumber = mobileNumber.substring(4, mobileNumber.length());

        } else if(mobileNumber.startsWith("00")) {
            mobileNumber = mobileNumber.substring(2, mobileNumber.length());

        } else if(mobileNumber.startsWith("0")) {
            mobileNumber = mobileNumber.substring(1, mobileNumber.length());

        } else if(mobileNumber.startsWith("98")) {
            mobileNumber = mobileNumber.substring(2, mobileNumber.length());
        }

        return mobileNumber;
    }

}
