package com.sefryek.broker.utils;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jun 7, 2011
 * Time: 4:38:46 PM
 */
public class BankUtil {
    private static boolean ECD(String id) {
           String intY, intZ;
           int intSum = 0, intCD, pubCD;
           int intRest, i = 2;
           pubCD = Integer.parseInt(id.substring(id.length() - 1));
           intZ = id.substring(0, id.length() - 1);
           while (intZ.length() > 0) {
               intY = intZ.substring(intZ.length() - 1);
               intZ = intZ.substring(0, intZ.length() - 1);
               if (i < 8) {
                   intSum += Integer.parseInt(intY) * i;
                   i++;
               } else {
                   i = 2;
                   intSum += Integer.parseInt(intY) * i;
                   i++;
               }
           }
           intRest = intSum % 11;
           if (intRest < 2) {
               intCD = 0;
           } else {
               intCD = 11 - intRest;
           }
           return (intCD == pubCD);
       }

       public static boolean isValidBillId(String billId, String payId) {
           return ECD(billId) & ECD(payId.substring(0, payId.length() - 1)) & ECD(billId + payId);
       }

       public static String[] extractSign(String Amount) {
           long amount = Long.parseLong(Amount);
           String[] exAmount = new String[2];
           if (amount < 0) {
               exAmount[0] = "1";
               exAmount[1] = String.valueOf(-1 * amount);
           } else {
               exAmount[0] = "0";
               exAmount[1] = Amount;
           }
           return exAmount;
       }

       public static boolean isInAccountNumberFormat(String s) {
           boolean ret = false;
           if (s != null && !s.equals("")) {
               for(int i = 0; i < s.length(); i++) {
                   char ch = s.charAt(i);
                   if(ch < '0' || ch > '9') {
                       if(ch == '\u0020' && i > 0 && i == s.length() - 3) {
                           ret = true;
                       } else {
                           ret = false;
                           break;
                       }
                   }
               }
           }
           return ret;
       }

       public static boolean hasValue(String s) {
           return s != null && !s.equals("");
       }

       public static boolean isActivate(String serviceType, int gbs) {
           int service = Integer.parseInt(serviceType);
           int binary = (int) MathUtil.pow(2, service);
           return (gbs & binary) > 0;
       }

       public static long mergeSign(String sign, String amount) {
           long amnt = Long.parseLong(amount);
           if (sign.equals("1")) {
               amnt = -1 * amnt;
           }
           return amnt;
       }

       public static String insertComma(String amount) {
           StringBuffer buf = new StringBuffer();
           int counter = 0;
           for(int i = amount.length() - 1; i >= 0; i--) {
               if(counter == 3) {
                   counter = 0;
                   buf.append(',');
               }
               buf.append(amount.charAt(i));
               counter++;
           }
           return buf.reverse().toString();
       }


   }
