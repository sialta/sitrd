package com.sefryek.broker.utils;

import com.sefryek.broker.utils.convertingDateUtil.shamsi.DateConverter;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;

/**
 * Created by IntelliJ IDEA.
 * User: Ramin
 * Date: Mar 6, 2009
 * Time: 12:28:42 AM
 * This util resolves the problem of Iran MCI and Irancell
 */
public class ByteUtil {

    private static final String HEX_STRING = "0123456789ABCDEF";

    public static byte[] encodeBytes(byte[] bytes) {
        int counter = 0;
        for (byte aByte : bytes) {
            if ((aByte >= -127 && aByte <= -97) || aByte == 128 || aByte == -1) {
                counter++;
            }
        }

        int index = 0;
        byte[] encodedBytes = new byte[bytes.length + counter];
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == -1) {
                encodedBytes[index++] = -1;
            } else if ((bytes[i] >= -127 && bytes[i] <= -97)) {
                encodedBytes[index++] = -1;
                bytes[i] += 128;
            } else if (bytes[i] == 128) {
                encodedBytes[index++] = -1;
                bytes[i] -= 128;
            }
            encodedBytes[index++] = bytes[i];
        }
        return encodedBytes;
    }

    public static byte[] decodeBytes(byte[] bytes) {
        int counter = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == -1) {
                counter++;
                i++;
            }
        }

        int index = 0;
        byte[] decodedBytes = new byte[bytes.length - counter];
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == -1) {
                i++;
                if (bytes[i] == 0) {
                    bytes[i] += 128;
                } else if (bytes[i] >= 0 && bytes[i] <= 31) {
                    bytes[i] -= 128;
                }
            }
            decodedBytes[index++] = bytes[i];
        }
        return decodedBytes;
    }

/*
    public static byte[] longToByteArray(int numberOfByte, long value) {
        byte[] b = new byte[numberOfByte];
        for (int i = 0; i < numberOfByte; i++) {
            int offset = (b.length - 1 - i) * 8;
            b[i] = (byte) ((value >>> offset) & 0xFF);
        }
        return b;
    }
*/

    /*static public byte[] intToBytes(int in) {
        byte[] temp = new byte[4];
        temp[3] = (byte) (0xff & (in >> 24));
        temp[2] = (byte) (0xff & (in >> 16));
        temp[1] = (byte) (0xff & (in >> 8));
        temp[0] = (byte) (0xff & in);
        return (temp);
    }*/


    static public int twoBytesToInt(byte[] b) {
        return  (((b[1] & 0xff) << 8) | (b[0] & 0xff));
    }

    static public int fourBytesToInt(byte[] b) {
        return (((b[3] & 0xff) << 24) | ((b[2] & 0xff) << 16) |
                ((b[1] & 0xff) << 8) | (b[0] & 0xff));
    }

    static public byte[] intToFourByte(int in) {
        byte[] temp = new byte[4];
        temp[3] = (byte) (in >> 24);
        temp[2] = (byte) (in >> 16);
        temp[1] = (byte) (in >> 8);
        temp[0] = (byte) in;
        return temp;

    }

    static public byte[] intToTwoByte(int in) {
        byte[] temp = new byte[2];
        temp[1] = (byte) (in >> 8);
        temp[0] = (byte) in;
        return temp;

    }

    static public byte[] intToThreeBytes(int in) {
        byte[] temp = new byte[3];
        temp[2] = (byte) (in >> 16);
        temp[1] = (byte) (in >> 8);
        temp[0] = (byte) in;
        return temp;
    }

    static public byte[] longToFiveByte(long data) {
        return new byte[] {
                (byte)((data) & 0xff),
                (byte)((data >> 8 ) & 0xff),
                (byte)((data >> 16) & 0xff),
                (byte)((data >> 24) & 0xff),
                (byte)((data >> 32) & 0xff),
        };
    }

    public static byte[] longToByteArray(long data) {
        return new byte[] {
                (byte)((data) & 0xff),
                (byte)((data >> 8 ) & 0xff),
                (byte)((data >> 16) & 0xff),
                (byte)((data >> 24) & 0xff),
                (byte)((data >> 32) & 0xff),
                (byte)((data >> 40) & 0xff),
                (byte)((data >> 48) & 0xff),
                (byte)((data >> 56) & 0xff),
        };
    }

    static public long fiveBytesToLong(byte[] b) {
        return (b[4] & 0xffl) << 32 |
                (b[3] & 0xffl) << 24 |
                (b[2] & 0xffl) << 16 |
                (b[1] & 0xffl) << 8 |
                (b[0] & 0xffl);
    }

    static public byte[] shortToBytes(int in) {
        byte[] temp = new byte[2];
        temp[1] = (byte) (in >> 8);
        temp[0] = (byte) in;
        return (temp);
    }

    static public int bytesToShort(byte[] b) {
        return (((b[1] & 0xff) << 8) | (b[0] & 0xff));
    }

    public static int threeBytesToInt(byte[] b) {
        return (((b[2] & 0xff) << 16) | ((b[1] & 0xff) << 8) | (b[0] & 0xff));
    }

    /**
     * Converts a two byte array to an integer
     *
     * @param b a byte array of length 2
     * @return an int representing the unsigned short
     */
    public static int unsignedShortToInt(byte[] b) {
        int i = 0;
        i |= (b[1] & 0xFF);
        i <<= 8;
        i |= (b[0] & 0xFF);
        return i;
    }

    public static int byteArrayToInt(byte[] b) {

        return (b[0] << 24)
                + ((b[1]) << 16)
                + ((b[2]) << 8)
                + (b[3]);
    }

    public static byte[] subArray(byte[] b, int index, int length) {
        byte[] result = new byte[length];
        System.arraycopy(b, index, result, 0, length);
        return result;
    }

    public static int getUpperSectionOfByte(byte b) {
        return (int) b >> 4;
    }

    public static int getLowerSectionOfByte(byte b) {
        return (b & 15);

    }

    public static byte getUpperSectionOfByteInByteFormat(byte b) {
        return (byte) ((b >> 4) & 0x0F);
    }

    public static byte getLowerSectionOfByteInByteFormat(byte b) {
        return (byte) (b & 15);

    }

    public static int getIntValueAt(byte b, int bitNumber) {
        return (b & getBitValue(bitNumber));
    }

    public static boolean getBoolValueAt(byte b, int bitNumber) {
        return (b & getBitValue(bitNumber)) != 0;
    }

    public static int getBitValue(int i) {
        int value = 0;
        switch (i) {
            case 0:
                value = 1;
                break;

            case 1:
                value = 2;
                break;

            case 2:
                value = 4;
                break;

            case 3:
                value = 8;
                break;

            case 4:
                value = 16;
                break;

            case 5:
                value = 32;
                break;

            case 6:
                value = 64;
                break;

            case 7:
                value = 128;
                break;

        }
        return value;
    }

    public static byte[] convertToFourBytesFormat(byte[] valueByteArray) {
        int resultLength = valueByteArray.length % 2 == 0 ? valueByteArray.length / 2 : ((valueByteArray.length / 2) + 1);
        byte[] result = new byte[resultLength];
        int index = 0;
        for (int i = 0; i < valueByteArray.length; i = i + 2) {
            if (valueByteArray[i] <= 10) {
                int upperSection = valueByteArray[i] << 4;
                int lowerSection = ((i + 1) >= valueByteArray.length) ? 0 : valueByteArray[i + 1];
                result[index++] = (byte) (upperSection + lowerSection);
            }
        }
        return result;
    }

    static public byte[] longToBytes(long in) {
        byte[] temp = new byte[8];
        temp[7] = (byte) (0xff & (in >> 56));
        temp[6] = (byte) (0xff & (in >> 48));
        temp[5] = (byte) (0xff & (in >> 40));
        temp[4] = (byte) (0xff & (in >> 32));
        temp[3] = (byte) (0xff & (in >> 24));
        temp[2] = (byte) (0xff & (in >> 16));
        temp[1] = (byte) (0xff & (in >> 8));
        temp[0] = (byte) (0xff & in);
        return (temp);
    }

    static public byte[] longToFiveByteArray(long in) {
        byte[] temp = new byte[5];
        temp[4] = (byte) (in >> 32);
        temp[3] = (byte) (in >> 24);
        temp[2] = (byte) (in >> 16);
        temp[1] = (byte) (in >> 8);
        temp[0] = (byte) in;
        return temp;
    }

    public static String getHex(byte[] raw) {
        if (raw == null) {
            return null;
        }

        StringBuffer hex = new StringBuffer();
        for (int i = raw.length - 1; i >= 0; i--) {
            byte b = raw[i];
            hex.append(HEX_STRING.charAt((b & 0xF0) >> 4))
                    .append(HEX_STRING.charAt((b & 0x0F)));
        }
        return hex.toString();
    }
//
//    public static String binaryToString(String binary) {
//        int offset = 4;
//        int length = binary.length();
//        String result = "";
//
//        for (int i = 0; i+offset <= length; i = i+offset)
//            result += Integer.parseInt( binary.substring(i, i+offset) , 2);
//
//        return result;
//    }

//    public static String bytesArrayToString(byte[] binary) {
//        String result;
//        String finalResult = "";
//        int value;
//        for (byte  b : binary ) {
//            value = b & 0xff;
//            result = Integer.toString(value, 2);
//            finalResult += computationBinaryAndFixedLength(result, 8);
//        }
////        System.out.println(finalResult);
//        return finalResult;
//    }
//
//    public static String computationBinaryAndFixedLength (String binaryStr, int paramLength) {
//
//        while(binaryStr.length() < paramLength)
//            binaryStr = "0" + binaryStr;
//
//        return binaryToString(binaryStr);
//    }

    public static byte[] intToBytes(int x) {
        byte[] bytes = new byte[4];

        for (int i = 0; x != 0; i++, x >>>= 8) {
            bytes[i] = (byte) (x & 0xFF);
        }

        return bytes;
    }

    public static byte[] convertStringToByteArray(String result) {
        try {
            return result.getBytes("UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static byte[] convertEncryptionKeyToByteArray(String result) {
        try {
            return result.getBytes("UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }


    /* size is the sms length limit.*/
    public static List<byte[]> partBinaryMessage(byte[] bytes, int size,  byte[] header) {

        List<byte[]> messageParts = new ArrayList<byte[]>();
        if(bytes.length == header.length) {
            messageParts.add(bytes);
            return messageParts;
        }

        int index = 0;
        int headerLength = header.length;
        int length = bytes.length - headerLength;
        int acceptableLength = size - headerLength;

        while (acceptableLength < length) {
            byte[] aPart = new byte[acceptableLength + headerLength];
            if(index == 0) {
                System.arraycopy(bytes, index, aPart, 0, acceptableLength + headerLength);
                index += (acceptableLength + headerLength); //index of bytes must be read
                length -= (acceptableLength);//remainding bytes in message

            } else {
                System.arraycopy(header, 0, aPart, 0, header.length);
                System.arraycopy(bytes, index, aPart,  header.length, acceptableLength);
                index += acceptableLength; //index of bytes must be read
                length -= acceptableLength;//remainding bytes in message

            }

            messageParts.add(aPart);

        }

//        System.out.println(length);
//        System.out.println(index);

        if(length > 0) {
            if(index == 0) {
                messageParts.add(bytes);

            } else {
                byte[] aPart = new byte[length + headerLength];
                System.arraycopy(header, 0, aPart, 0, header.length);
                System.arraycopy(bytes, index, aPart, header.length, length);
                messageParts.add(aPart);
            }
        }


        return messageParts;
    }

    public static String toHexString(byte[] bytes) {
        char[] hexArray = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for ( int j = 0; j < bytes.length; j++ ) {
            v = bytes[j] & 0xFF;
            hexChars[j*2] = hexArray[v/16];
            hexChars[j*2 + 1] = hexArray[v%16];
        }
        return new String(hexChars);
    }

    public static String byteArray2HexString(byte[] bytes) {
        if (bytes == null) {
            return null;
        }

        StringBuffer hex = new StringBuffer();
        for (byte b : bytes) {
            hex.append(HEX_STRING.charAt((b & 0xF0) >> 4))
                    .append(HEX_STRING.charAt((b & 0x0F)));
        }

        return hex.toString();
    }

    public static String insertPercentIntoHexString(String hexMessage) {
        if (hexMessage == null || hexMessage.trim().isEmpty())
            return null;

        String newHexMessage = "";
        for (int i = 0; i < hexMessage.length(); i = i + 2) {
            newHexMessage += "%" + hexMessage.substring(i, i+2);
        }

        return newHexMessage;
    }

    public static byte[] hexString2ByteArray(String hexString) {
        hexString = StringUtil.remove0FromLeft(hexString);
        if(hexString.length() % 2 > 0)
            hexString = "0" + hexString;
        hexString = hexString.toUpperCase();

        int n = hexString.length();
        byte[] out = new byte[n / 2];

        for( int i = 0; i < n; i += 2 ) {
            //make a bit representation in an int of the hex value
            int hn = HEX_STRING.indexOf(hexString.charAt(i));
            int ln = 0;
            if(i + 1 < n) {
                ln = HEX_STRING.indexOf(hexString.charAt(i + 1));
                hn = hn << 4;
            }
            //now just shift the high order nibble and add them together
            out[i / 2] = (byte) (hn | ln);
        }

        return out;
    }

    public static byte[] parseTimeToByte(String time)
    {
        byte[] timeByte = { 0, 0 };
        String[] timeArray = time.split(":");

        byte tmp = (byte)Integer.parseInt(timeArray[0]);
        if (tmp > 15)
            tmp = 15;

        tmp <<= 4;
        timeByte[0] += tmp;

        timeByte[1] = tmp = (byte)Integer.parseInt(timeArray[1]);
        tmp &= 60;//high Value of minute
        tmp >>= 2;
        timeByte[0] += tmp;

        timeByte[1] &= 3;//low Value of minute
        timeByte[1] <<= 6;

        tmp = (byte)Integer.parseInt(timeArray[2]);
        timeByte[1] += tmp;

        return timeByte;
    }

    public static byte[] persianDateToByte(String persianDate) {

        String[] dateParts = persianDate.split("-");
        byte[] result = new byte[2];

        int day = Integer.parseInt(dateParts[2]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[0]) - 1300;

        int tMonth1 = month << 5;
        int tMonth2 = month >> 3;

        int temp1 = (tMonth1 + day) & 0xFF;
        byte fb = (byte) (temp1);
        
        int tYear1 = year << 1;
        int temp = (tYear1 + tMonth2) & 0xFF;
        byte sb = (byte) temp;

        result[0] = sb;
        result[1] = fb;
        return result;
    }

    public static byte[] persianDateToTwoByte(String persianDate) {
        byte[] result = new byte[2];
        String[] parts = persianDate.split("-");

        int day = Integer.parseInt(parts[2]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[0]);

        int tMonth1 = month << 5;
        int tMonth2 = month >> 7;

        int temp1 = (tMonth1 + day) & 0xFF;
        byte fb = (byte) (temp1);
        int tYear1 = year << 1;
        int temp = (tYear1 + tMonth2) & 0xFF;
//        temp = temp > 127 ? -(temp-128) : temp;
        byte sb = (byte) temp;

        result[0] = sb;
        result[1] = fb;
        return result;
    }

    public static byte[] dateToTwoByte(Calendar date) {
        byte[] result = new byte[2];

        int day = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH);
        int year = date.get(Calendar.YEAR) - 1300;

        int tMonth1 = month << 5;
        int tMonth2 = month >> 7;

        int temp1 = (tMonth1 + day) & 0xFF;
        byte fb = (byte) (temp1);
        int tYear1 = year << 1;
        int temp = (tYear1 + tMonth2) & 0xFF;
//        temp = temp > 127 ? -(temp-128) : temp;
        byte sb = (byte) temp;

        result[0] = sb;
        result[1] = fb;
        return result;
    }

    public static Calendar twoByteToDate(byte[] date) {

        int day = date[1] & 31;
        int month = ((date[0] << 3)& 8) | ((date[1] >> 5) & 7);
        int year =  date[0] >> 1;
        year = (year & 0x7f) + 1300;

        String miladiDateStr = DateConverter.convertShamsiToMiladi(year + "-" + month + "-" + day);
        Date miladiDate = DateUtil.convertStringToDate(miladiDateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(miladiDate);

        return calendar;
    }

    public static Calendar fourByteToDate(byte[] date) {

        int day = date[1] & 31;
        int month = ((date[0] << 3)& 8) | ((date[1] >> 5) & 7);
        int year =  date[0] >> 1;
        year = (year & 0x7f) + 1300;

        String miladiDateStr = DateConverter.convertShamsiToMiladi(year + "-" + month + "-" + day);
        Date miladiDate = DateUtil.convertStringToDate(miladiDateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(miladiDate);

        return calendar;
    }

    public static byte[] parseDoubleTo3Byte(double value){
        value = DoubleUtil.round(value, 2);
        String doubleValueAsString = String.valueOf(value);
        String[] doubleValueParts = doubleValueAsString.trim().split("\\.");

        byte[] retVal = new byte[3];
        byte[] ret = shortToBytes(Integer.valueOf(doubleValueParts[0]));

        System.arraycopy(ret, 0, retVal, 0, 2);

        byte mantis = 0;
        if (doubleValueParts.length > 1)
            mantis = (byte) Integer.parseInt(doubleValueParts[1]);

        retVal[2] = mantis;
        return retVal;
    }

    public static byte[] parseDoubleTo2Byte(double value){
        value = DoubleUtil.round(value, 2);

        String doubleValueAsString = String.valueOf(value);
        String[] doubleValueParts = doubleValueAsString.trim().split("\\.");

        byte[] ret = new byte[2];
        ret[0] = (byte) Integer.parseInt(doubleValueParts[0]);
        if (doubleValueParts.length > 1)
            ret[1] = (byte) Integer.parseInt(doubleValueParts[1]);

        return ret;
    }

 static public long signedByteArrayToLong(byte[] b) {

        int test = b[0];
        byte sign;
        if (test >= 0) {
            sign = (byte) 0;
        } else {
            sign = (byte) 0xff;
        }

        if (b.length < 8) {
            byte[] temp = new byte[8];
            int diff = 8 - b.length;
            int i = 0;
            for (; i < diff; i++) {
                temp[i] = sign;
            }
            int j = 0;
            for (; i < 8; i++) {
                temp[i] = b[j++];
            }
            b = temp;
        }

        long l = 0;

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        try {
            l = dataInputStream.readLong();
        } catch (IOException e) {
            ////e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return l;
    }}



