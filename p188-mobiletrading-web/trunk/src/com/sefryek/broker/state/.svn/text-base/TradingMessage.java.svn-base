package com.sefryek.broker.state;

import com.sefryek.broker.utils.ByteUtil;
import com.sefryek.broker.mobileHandler.MIDletConstant;
import static com.sefryek.broker.mobileHandler.MIDletConstant.CANCEL_ORDER_SERVICE;
import com.sefryek.broker.mobileHandler.exceptions.SessionExpirationException;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.util.Locale;

import net.sf.cglib.core.Local;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.BlowFish;
import org.bouncycastle.AESEncryption;

/**
 * Created by IntelliJ IDEA.
 * User: mahta
 * Date: May 18, 2011
 * Time: 10:46:22 AM
 */
public class TradingMessage {
    public final static String encryptionKey = "4AB39F076D1E09C8";
//    public final static String encryptionKey = "=dcbz!#xdA*W!pyP";

    private byte flags;
    private Integer messageLength;
    private byte seqNum;
    private byte responseCode;
    private byte[] sessionId = new byte[8];
    private byte serviceCode;
    private int countedTotalLength = 0;
    private byte[] bodyData;
    private byte[] finalResponse = null;
    private Double version;
    private static AESEncryption aesEncryption;
    private String language;

    static {
        aesEncryption = AESEncryption.getInstance(encryptionKey);
    }

    public TradingMessage() {}

    public TradingMessage(InputStream is) throws CryptoException, SessionExpirationException, IOException {
        try {
            int indicator = 0;

            byte[] encryptedData = readEncryptedData(is);
            // decrypt
            byte[] data = aesEncryption.decrypt(encryptedData);

            // read messageLength
            byte[] msgLength = new byte[2];
            System.arraycopy(data, 0, msgLength, 0, 2);
            indicator += 2;

            this.messageLength = ByteUtil.bytesToShort(msgLength);

            seqNum = data[indicator++];

            responseCode = data[indicator++];

            // read sessionId
            System.arraycopy(data, indicator, sessionId, 0, 8);
            indicator += 8;

            // flags size
            flags = data[indicator++];

            if((flags&0x02)>0){
                setLanguage("fa");
            }else if((flags&0x04)>0)
                setLanguage("en");
            else if((flags&0x06)>0)
                setLanguage("ar");



//            Locale presianLnag = new Locale("fa");
//            Locale englishLang = new Locale("en");
//            Locale arabicLang = new Locale("ar");

            // read partNo
            serviceCode = data[indicator++];

            // read body
            bodyData = new byte[messageLength];

            System.arraycopy(data, indicator, bodyData, 0, messageLength);
            countedTotalLength += messageLength;
            indicator += messageLength;

            // Check that totallengh which client added at the start of request is equal to calculated bytes lengh
            if(messageLength != countedTotalLength) {
                this.responseCode = MIDletConstant.SERVER_ERROR;
                createResponse(null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private byte[] readEncryptedData(InputStream is) throws CryptoException {
        try {
            // Read two bytes for request length
            byte[] messageLength = new byte[2];
            messageLength[0]= (byte)is.read();
            messageLength[1]= (byte)is.read();
            int requestLength = ByteUtil.unsignedShortToInt(messageLength);

            byte[] encryptedData = new byte[requestLength];
            // getting whole bytes of the response
            int index = 0;
            while (index < requestLength) {
                encryptedData[index++] = (byte) is.read();
            }

//            System.out.println("Read input stream and the return value is:" + ByteUtil.getHex(encryptedData)
//                    + " , and returnd byte array is:" + new String(encryptedData));

            return encryptedData;

        } catch (Exception e) {
            this.responseCode = MIDletConstant.SERVER_ERROR;
            createResponse(null);
        }

        return null;
    }

    public static byte[] encrypt(byte[] data, String encryptionKey) throws CryptoException {

        try {
            // 1 byte is excluded becouse this 1 byte is flags (wehich should not be encrypted)
            byte[] tempData = new byte[data.length - 1];
            System.arraycopy(data, 1, tempData, 0, data.length - 1);

            BlowFish blowFish = new BlowFish(encryptionKey.getBytes("UTF-8"));
            byte[] tempEncryptedDate = blowFish.encrypt(tempData);
            byte[] encryptedDate = new byte[1 + tempEncryptedDate.length];

            System.arraycopy(data, 0, encryptedDate, 0, 1);
            System.arraycopy(tempEncryptedDate, 0, encryptedDate, 1, tempEncryptedDate.length);

            return encryptedDate;


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static byte[] decrypt(byte[] encryptedData, String encryptionKey, byte flag) throws CryptoException, SessionExpirationException {

        try {
            BlowFish blowFish = new BlowFish(encryptionKey.getBytes("UTF-8"));
            byte[] data = blowFish.decrypt(encryptedData);

            return (data);

        } catch (CryptoException e) {
            if(!encryptionKey.equals(encryptionKey)) {
                decrypt(encryptedData, encryptionKey, flag);

            } else {
                if(((flag >> 1) & 0x01) == 1) {
                    throw new SessionExpirationException();

                } else {
                    throw e;
                }
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void createResponse(byte[] responseBody) {
        byte[] encryptData;

        byte[] responseBodyLength = responseBody == null ? null : ByteUtil.shortToBytes(responseBody.length);
        byte[] header = createFinalResponseHeader(responseBodyLength);

        byte[] appFinalResponse;
        if(responseBody != null) {
            appFinalResponse = new byte[header.length + responseBody.length];
            System.arraycopy(header, 0, appFinalResponse, 0, header.length);
            System.arraycopy(responseBody, 0, appFinalResponse, header.length, responseBody.length);

        } else if(CANCEL_ORDER_SERVICE != serviceCode) {

            responseBody = ByteUtil.convertStringToByteArray("NO_CONNECTION_TO_SERVER");
            setResponseCode(MIDletConstant.SERVER_INFO);
            setFlags((byte)0x00);

            appFinalResponse = new byte[header.length + responseBody.length];
            System.arraycopy(header, 0, appFinalResponse, 0, header.length);
            System.arraycopy(responseBody, 0, appFinalResponse, header.length, responseBody.length);

        } else {
            appFinalResponse = new byte[header.length];
            System.arraycopy(header, 0, appFinalResponse, 0, header.length);

        }


        try {
            encryptData = aesEncryption.encrypt(appFinalResponse);
//            System.out.println("Size of encrypted body: " + encryptData.length);

            // Add length of encrypted message
            byte[] messageLength = ByteUtil.shortToBytes(encryptData.length);
            byte[] finalRequest = new byte[encryptData.length + messageLength.length];
            System.arraycopy(messageLength, 0, finalRequest, 0, 2);
            System.arraycopy(encryptData, 0, finalRequest, 2, encryptData.length);

            setFinalResponse(finalRequest);

        } catch (CryptoException e) {
            e.printStackTrace();
        }

    }

    public byte[] createFinalResponseHeader(byte[] responseBodyLengh) {
        byte[] header = new byte[14];

        header[0] = responseBodyLengh == null ? 0 : responseBodyLengh[0];
        header[1] = responseBodyLengh == null ? 0 : responseBodyLengh[1];
        header[2] = getSeqNum();
        header[3] = getResponseCode();

        System.arraycopy(getSessionId(), 0, header, 4, 8);

        header[12] = getFlags();
        header[13] = getServiceCode();
        return header;
    }


    // Getters and Setters ---------------------------------------------------------------------------------------------
    public byte getFlags() {
        return 0x00;
    }

    public void setFlags(byte flags) {
        this.flags = flags;
    }

    public int getCountedTotalLength() {
        return countedTotalLength;
    }

    public void setCountedTotalLength(int countedTotalLength) {
        this.countedTotalLength = countedTotalLength;
    }

    public byte getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(byte seqNum) {
        this.seqNum = seqNum;
    }

    public byte getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(byte serviceCode) {
        this.serviceCode = serviceCode;
    }

    public Integer getMessageLength() {
        return messageLength;
    }

    public void setMessageLength(Integer messageLength) {
        this.messageLength = messageLength;
    }

    public byte[] getBodyData() {
        return bodyData;
    }

    public void setBodyData(byte[] bodyData) {
        this.bodyData = bodyData;
    }

    public byte getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(byte responseCode) {
        this.responseCode = responseCode;
    }

    public byte[] getFinalResponse() {
        return finalResponse;
    }

    public void setFinalResponse(byte[] finalResponse) {
        this.finalResponse = finalResponse;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public byte[] getSessionId() {
        return sessionId;
    }

    public void setSessionId(byte[] sessionId) {
        this.sessionId = sessionId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}