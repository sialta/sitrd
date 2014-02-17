package com.sefryek.broker;

public class UTFToUnicode {


    private final static char[] UTF = {
            '\u0621',   // Hamza
            '\u0622',   // Alef with Madda
            '\u0627',   // Alef
            '\u0628',   // Beh
            '\u067E',   // Peh
            '\u062A',   // Teh
            '\u062B',   // Theh
            '\u062C',   // Jeem
            '\u0686',   // Tcheh
            '\u062D',   // Hah
            '\u062E',   // Khah
            '\u062F',   // Dal
            '\u0630',   // Thal
            '\u0631',   // Reh
            '\u0632',   // Zain
            '\u0698',   // Jeh
            '\u0633',   // Seen
            '\u0634',   // Sheen
            '\u0635',   // Sad
            '\u0636',   // Dad
            '\u0637',   // Tah
            '\u0638',   // Zah
            '\u0639',   // Ain
            '\u063A',   // Ghain
            '\u0641',   // Feh
            '\u0642',   // Qaf
            '\u0643',   // Kaf
            '\u06A9',   // Keheh
            '\u06AF',   // Gaf
            '\u0644',   // Lam
            '\u0645',   // Meem
            '\u0646',   // Noon
            '\u0647',   // Heh
            '\u0648',   // Waw
            '\u064A',   // Yeh
            '\u06CC',   // Yeh Farsi
            '\u0626',   // Yeh with Hamza
            '\u0649',   // Yeh Alef Maksura
            '\u0030',   // 0
            '\u0031',   // 1
            '\u0032',   // 2
            '\u0033',   // 3
            '\u0034',   // 4
            '\u0035',   // 5
            '\u0036',   // 6
            '\u0037',   // 7
            '\u0038',   // 8
            '\u0039',   // 9
    };

    private final static boolean[] UTF_MIXABLE_WITH_AFTER = {
            false,   // Hamza
            false,   // Alef with Madda
            false,   // Alef
            true,   // Beh
            true,   // Peh
            true,   // Teh
            true,   // Theh
            true,   // Jeem
            true,   // Tcheh
            true,   // Hah
            true,   // Khah
            false,   // Dal
            false,   // Thal
            false,   // Reh
            false,   // Zain
            false,   // Jeh
            true,   // Seen
            true,   // Sheen
            true,   // Sad
            true,   // Dad
            true,   // Tah
            true,   // Zah
            true,   // Ain
            true,   // Ghain
            true,   // Feh
            true,   // Qaf
            true,   // Kaf
            true,   // Keheh
            true,   // Gaf
            true,   // Lam
            true,   // Meem
            true,   // Noon
            true,   // Heh
            false,    // Waw
            true,   // Yeh
            true,   // Yeh Farsi
            true,   // Yeh with Hamza
            true,   // Yeh Alef Maksura
            false,   // 0
            false,   // 1
            false,   // 2
            false,   // 3
            false,   // 4
            false,   // 5
            false,   // 6
            false,   // 7
            false,   // 8
            false,   // 9
    };

    private final static char[][] UNICODE = {
            // {isolated,  initial,   medial,    final}
            {'\uFE80', '\uFE80', '\uFE80', '\uFE80'},   //'\u0622'   // Hamza
            {'\uFE81', '\uFE81', '\uFE82', '\uFE82'},   //'\u0622'   // Alef with Madda
            {'\uFE8D', '\uFE8D', '\uFE8E', '\uFE8E'},   //'\u0627'   // Alef
            {'\uFE8F', '\uFE91', '\uFE92', '\uFE90'},   //'\u0628'   // Beh
            {'\uFB56', '\uFB58', '\uFB59', '\uFB57'},   //'\u067E'   // Peh
            {'\uFE95', '\uFE97', '\uFE98', '\uFE96'},   //'\u062A'   // Teh
            {'\uFE99', '\uFE9B', '\uFE9C', '\uFE9A'},   //'\u062B'   // Theh
            {'\uFE9D', '\uFE9F', '\uFEA0', '\uFE9E'},   //'\u062C'   // Jeem
            {'\uFB7A', '\uFB7C', '\uFB7D', '\uFB7B'},   //'\u0686'   // Tcheh
            {'\uFEA1', '\uFEA3', '\uFEA4', '\uFEA2'},   //'\u062D'   // Hah
            {'\uFEA5', '\uFEA7', '\uFEA8', '\uFEA6'},   //'\u062E'   // Khah
            {'\uFEA9', '\uFEA9', '\uFEAA', '\uFEAA'},   //'\u062F'   // Dal
            {'\uFEAB', '\uFEAB', '\uFEAC', '\uFEAC'},   //'\u0630'   // Thal
            {'\uFEAD', '\uFEAD', '\uFEAE', '\uFEAE'},   //'\u0631'   // Reh
            {'\uFEAF', '\uFEAF', '\uFEB0', '\uFEB0'},   //'\u0632'   // Zain
            {'\uFB8A', '\uFB8A', '\uFB8B', '\uFB8B'},   //'\u0698'   // Jeh
            {'\uFEB1', '\uFEB3', '\uFEB4', '\uFEB2'},   //'\u0633'   // Seen
            {'\uFEB5', '\uFEB7', '\uFEB8', '\uFEB6'},   //'\u0634'   // Sheen
            {'\uFEB9', '\uFEBB', '\uFEBC', '\uFEBA'},   //'\u0635'   // Sad
            {'\uFEBD', '\uFEBF', '\uFEC0', '\uFEBE'},   //'\u0636'   // Dad
            {'\uFEC1', '\uFEC3', '\uFEC4', '\uFEC2'},   //'\u0637'   // Tah
            {'\uFEC5', '\uFEC7', '\uFEC8', '\uFEC6'},   //'\u0638'   // Zah
            {'\uFEC9', '\uFECB', '\uFECC', '\uFECA'},   //'\u0639'   // Ain
            {'\uFECD', '\uFECF', '\uFED0', '\uFECE'},   //'\u063A'   // Ghain
            {'\uFED1', '\uFED3', '\uFED4', '\uFED2'},   //'\u0641'   // Feh
            {'\uFED5', '\uFED7', '\uFED8', '\uFED6'},   //'\u0642'   // Qaf
            {'\uFED9', '\uFEDB', '\uFEDC', '\uFEDA'},   //'\u0643'   // Kaf
            {'\uFB8E', '\uFB90', '\uFB91', '\uFB8F'},   //'\u06A9'   // Keheh
            {'\uFB92', '\uFB94', '\uFB95', '\uFB93'},   //'\u06AF'   // Gaf
            {'\uFEDD', '\uFEDF', '\uFEE0', '\uFEDE'},   //'\u0644'   // Lam
            {'\uFEE1', '\uFEE3', '\uFEE4', '\uFEE2'},   //'\u0645'   // Meem
            {'\uFEE5', '\uFEE7', '\uFEE8', '\uFEE6'},   //'\u0646'   // Noon
            {'\uFEE9', '\uFEEB', '\uFEEC', '\uFEEA'},   //'\u0647'   // Heh
            {'\uFEED', '\uFEED', '\uFEEE', '\uFEEE'},   //'\u0648'   // Waw
            {'\uFBFC', '\uFEF3', '\uFEF4', '\uFBFD'},   //'\u0649'   // Yeh
            {'\uFBFC', '\uFEF3', '\uFEF4', '\uFBFD'},   //'\u0649'   // Yeh Farsi
            {'\uFE89', '\uFE8B', '\uFE8C', '\uFE8A'},   //'\u0649'   // Yeh with Hamza
            {'\uFEEF', '\uFEF3', '\uFEF4', '\uFEF0'},   //'\u0649'   // Yeh Alef Maksura
            /*{'\uFEF1', '\uFEF3', '\uFEF4', '\uFEF2'},   //'\u0649'   // Yeh
            {'\uFBFC', '\uFBFE', '\uFBFF', '\uFBFD'},   //'\u0649'   // Yeh Farsi
            {'\uFE89', '\uFE8B', '\uFE8C', '\uFE8A'},   //'\u0649'   // Yeh with Hamza
            {'\uFEEF', '\uFEF3', '\uFEF4', '\uFEF0'},   //'\u0649'   // Yeh Alef Maksura*/
            {'\u0660', '\u0660', '\u0660', '\u0660'},   //'\u0030'   // 0
            {'\u0661', '\u0661', '\u0661', '\u0661'},   //'\u0031'   // 1
            {'\u0662', '\u0662', '\u0662', '\u0662'},   //'\u0032'   // 2
            {'\u0663', '\u0663', '\u0663', '\u0663'},   //'\u0033'   // 3
            {'\u0664', '\u0664', '\u0664', '\u0664'},   //'\u0034'   // 4
            {'\u0665', '\u0665', '\u0665', '\u0665'},   //'\u0035'   // 5
            {'\u0666', '\u0666', '\u0666', '\u0666'},   //'\u0036'   // 6
            {'\u0667', '\u0667', '\u0667', '\u0667'},   //'\u0037'   // 7
            {'\u0668', '\u0668', '\u0668', '\u0668'},   //'\u0038'   // 8
            {'\u0669', '\u0669', '\u0669', '\u0669'},   //'\u0039'   // 9
    };


    private static int getIndexOfUTF(char ch) {
        for(int i = 0; i < UTF.length; i++) {
            if(ch == UTF[i])
                return i;
        }
        return -1;
    }



    public static String getUnicodeOfUTF(String utfString) {
        int ISOLATED = 0;
        int INITIAL = 1;
        int MEDIAL = 2;
        int FINAL = 3;
        if(utfString == null || utfString.length() == 0)
            return "";

        StringBuffer buf = new StringBuffer();
        StringBuffer numBuf = new StringBuffer();
        int spaceNum = 0;

        for(int j = 0; j < utfString.length(); j++) {
            char ch = utfString.charAt(j);
            int i = getIndexOfUTF(ch);
            if(i != -1) {
                if(i > 37) {
                     buf.append(ch);

                } else {


                    boolean preSpace = true;
                    if(j > 0) {
                        char preChar = utfString.charAt(j - 1);
                        int k = getIndexOfUTF(preChar);
                        if(k >= 0 && k <= 37 && UTF_MIXABLE_WITH_AFTER[k])
                            preSpace = false;
                    }

                    boolean postSpace = true;
                    if(j < utfString.length() - 1) {
                        char postChar = utfString.charAt(j + 1);
                        int tempIndex = getIndexOfUTF(postChar);
                        if(tempIndex >= 0 && tempIndex <= 37)
                            postSpace = false;
                    }

                    if(preSpace && postSpace)
                        buf.append(UNICODE[i][ISOLATED]);
                    else if(preSpace)
                        buf.append(UNICODE[i][INITIAL]);
                    else if(postSpace)
                        buf.append(UNICODE[i][FINAL]);
                    else
                        buf.append(UNICODE[i][MEDIAL]);
                }
            }
        }

        return buf.toString();
    }



}