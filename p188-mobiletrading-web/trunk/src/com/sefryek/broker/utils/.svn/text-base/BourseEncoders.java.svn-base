package com.sefryek.broker.utils;

import com.sefryek.broker.UTFToUnicode;

/**
 * Created by IntelliJ IDEA.
 * User: Mahta
 * Date: Jul 20, 2011
 * Time: 11:34:00 AM
 */
public class BourseEncoders {


    public static byte[] convertBourseCodeToByte(String bourseCode) {
      byte[] bourseCodeBytes = new byte[6];
        bourseCode = UTFToUnicode.getUnicodeOfUTF(bourseCode);
        char[] stringArray = bourseCode.toCharArray();

        //get char and set in bourseCdeBytes
        // first byte
        bourseCodeBytes[5] = (byte) (CharacterMap.getCharIndex(stringArray[0]));   // char

        //second byte
        bourseCodeBytes[4] = (byte) (CharacterMap.getCharIndex(stringArray[1]));   // char

        //third byte
        bourseCodeBytes[3] = (byte) (CharacterMap.getCharIndex(stringArray[2]));   // char

        //get num1 & num2  and set in bourseCode
        byte temp = (byte) (stringArray[7] & 0x0F);
        byte temp1 = (byte) ((stringArray[6] & 0x0F) << 4);
        bourseCodeBytes[2] = (byte) (temp1 | temp);

        //get num3 & num4 and set in bourseCode
        temp = (byte) (stringArray[5] & 0x0F);
        temp1 = (byte) ((stringArray[4] & 0x0F) << 4);
        bourseCodeBytes[1] = (byte) (temp1 | temp);

        bourseCodeBytes[0] = (byte) (stringArray[3] & 15);
        return bourseCodeBytes;
    }

    public static String convertBourseCodeToString(byte[] bourseCodeByte) {

        // first character
        char char1 = CharacterMap.getChar(bourseCodeByte[5]);

        // second character
        char char2 = CharacterMap.getChar(bourseCodeByte[4]);

        // third character
        char char3 = CharacterMap.getChar(bourseCodeByte[3]);

        //num 1
        int num1 = ByteUtil.getLowerSectionOfByte(bourseCodeByte[2]);

        //num 2
        int num2 = ByteUtil.getUpperSectionOfByte(bourseCodeByte[2]);

        //num3
        int num3 = ByteUtil.getLowerSectionOfByte(bourseCodeByte[1]);

        //num4
        int num4 = ByteUtil.getUpperSectionOfByte(bourseCodeByte[1]);

        //num5
        int num5 = ByteUtil.getLowerSectionOfByte(bourseCodeByte[0]);


//        return String.valueOf(num5) + String.valueOf(num4) + String.valueOf(num3) + String.valueOf(num2) + String.valueOf(num1) + String.valueOf(char3) + String.valueOf(char2) + String.valueOf(char1);
        return String.valueOf(char1) + String.valueOf(char2) + String.valueOf(char3) + String.valueOf(num5) + String.valueOf(num4) + String.valueOf(num3) + String.valueOf(num2) + String.valueOf(num1);
    }

    public static String SafePersianEncode(String str) {

        if (str == null || str.trim().isEmpty())
            return "";

        str = str.replaceAll("ي", "ی");
        str = str.replaceAll("ك", "ک");
        str = str.replaceAll("‍", "");
        str = str.replaceAll("دِ", "د");
        str = str.replaceAll("بِ", "ب");
        str = str.replaceAll("زِ", "ز");
        str = str.replaceAll("ذِ", "ذ");
        str = str.replaceAll("ِشِ", "ش");
        str = str.replaceAll("ِسِ", "س");
        str = str.replaceAll("‌", "");
        str = str.replaceAll("ض", "ض");
        str = str.replaceAll("فِ", "ف");

        return str.trim();
    }

}
