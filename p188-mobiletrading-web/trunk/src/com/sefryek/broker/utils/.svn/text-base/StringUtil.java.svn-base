package com.sefryek.broker.utils;

/**
 * Created by IntelliJ IDEA.
 * User: mahta
 * Date: May 16, 2011
 * Time: 12:08:36 PM
 */
public class StringUtil {

    public static String remove0FromLeft(String val) {
        int indexOfFirstNonZero = val.length() - 1;
        String resVal = "";
        for (int i = 0; i < val.length(); i++) {
            if (!String.valueOf(val.charAt(i)).equals("0")) {
                indexOfFirstNonZero = i;
                break;
            }
        }
        for (int i = indexOfFirstNonZero; i < val.length(); i++) {
            resVal = resVal + String.valueOf(val.charAt(i));
        }
        return resVal;
    }

    public static String[] reponseSplitor(String string) {
        try {
            string = string.replaceAll("#", "");
            String[] arrayString = string.split("\\]");

            if(arrayString.length >= 1) {
                int j = 0;
                for (String anArrayString : arrayString) {
                    arrayString[j++] = anArrayString.replaceAll("\\[", "");
                }

                return arrayString;
            }

        } catch (Exception e) {
            // nothing to do
        }

        return null;
    }

    /**
     * if a double or long is in scientific mode, alter it to normal mode
     *
     * @param str the String parameter
     * @return the result String
     */
    public static String removeScientificSymbol(String str) {

        int indexOfE = str.indexOf('E');
        int asharNo = 0;
        boolean isAshar = false;

        if (indexOfE != -1) {
            String exponent = str.substring(indexOfE + 1, str.length());
            int exp = Integer.parseInt(exponent);
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) == 'E') {
                    break;

                } else if (str.charAt(i) == '.') {
                    isAshar = true;

                } else {

                    if (isAshar) {
                        asharNo++;
                    }

                    sb.append(str.charAt(i));
                }
            }

            if (asharNo < exp) {

                int diff = exp - asharNo;

                for (int i = 0; i < diff; i++) {
                    sb.append('0');
                }
            }
            return sb.toString();

        } else {
            return str;
        }
    }

    public static String replaceParantezes(String str) {
        str = str.replaceAll("\\(", "\\( ").replaceAll("\\)", " \\)");
        str = str.replaceAll("  ", " ");
        str = str.replaceAll("\\(", "afs1").replaceAll("\\)", "afs2");
        str = str.replaceAll("afs1", "\\)").replaceAll("afs2", "\\(");
        return  str;

    }

}
