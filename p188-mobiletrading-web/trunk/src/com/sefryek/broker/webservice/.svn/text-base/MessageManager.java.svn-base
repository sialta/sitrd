package com.sefryek.broker.webservice;

import org.apache.log4j.Logger;
import org.hibernate.tool.hbm2x.StringUtils;

import javax.xml.rpc.ServiceException;

import com.sefryek.broker.utils.Constants;
import com.sefryek.broker.webservice.mobilev2rlc.enums.*;
import com.sefryek.broker.webservice.mobilev2rlc.*;
import com.sefryek.broker.utils.ByteUtil;
import com.sefryek.broker.utils.DateUtil;
import com.sefryek.broker.utils.StringUtil;
import com.sefryek.broker.state.TradingMessage;
import com.sefryek.broker.mobileHandler.MIDletConstant;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: Sarvenaz
 * Date: Jul 30, 2011
 * Time: 12:51:24 PM
 */
public class MessageManager {
    private static Logger logger = Logger.getLogger(MessageManager.class);

    public static final String USER_NAME = "mobilewebservice";     //fill this with your username
    public static final String PASSWORD = "ws100";                  //fill this with your password
    
    public static WS_MobileSoap_BindingStub binding = null;
    public static MainIndicesResponse mainIndicesResponse = new MainIndicesResponse();
    public static MarketActivityResponse marketActivityResponse = new MarketActivityResponse();
    public static BestOfMarketResponse bestOfMarketResponse = new BestOfMarketResponse();


    public static enum OrderListType {
        ORDER_LIST,
        ORDER_BOOK
    }

    static {
        try {
            binding = (WS_MobileSoap_BindingStub) new WS_MobileLocator().getWS_MobileSoap();
        } catch (ServiceException e) {
            // do nothing
        }
    }

    public static byte[] getListOfMessages(TradingMessage tradingMessage, int brokerCode, int customerCode, byte[] lastDate) {
        try {
            if (binding == null)
                throw new ServiceException();

            Date date = DateUtil.convertByteArrayToFullMiladiDate(lastDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            logger.info("The semt time from customer device is: " + DateUtil.getFormattedDate(date, DateUtil.Pattern.YYYY_MM_DD_HH_MM_SS));

            Ws_Message[] listOfMessages = binding.getListOfMessages(calendar);

            if (listOfMessages != null && listOfMessages.length > 0) {
                MessageListResponse messageListResponse = new MessageListResponse();
                int index = 0;
                int byetLen = messageListResponse.FixMessageListResponseLen;
                int messageCount = 0;
                for (Ws_Message listOfMessage : listOfMessages) {
                    if(!StringUtils.isEmpty(listOfMessage.getMessageDetail().trim())) {
                        byte[] strByteMessageText = ByteUtil.convertStringToByteArray(listOfMessage.getMessageTitle());
                        byetLen += strByteMessageText.length + messageListResponse.FixMessageItemLen;
                        messageCount++;
                    }
                }

                byte[] buffer = new byte[byetLen];

                //All items count
                byte tmp = (byte) (messageCount & 0xFF);
                buffer[index++] = tmp;


                for (Ws_Message listOfMessage : listOfMessages) {
                    if (!StringUtils.isEmpty(listOfMessage.getMessageDetail().trim())){
                        System.arraycopy(ByteUtil.intToTwoByte(listOfMessage.getMessageId()), 0, buffer, index,
                                messageListResponse.MessageId);
                        index += messageListResponse.MessageId;

                        //Current datetime
                        String sTime = DateUtil.GetStringTime(listOfMessage.getMessageDate().getTime());
                        String servetDate = DateUtil.convertMiladiToShamsi(listOfMessage.getMessageDate().getTime());
                        byte[] serverTime = DateUtil.parseJalaliDateToFourByte(servetDate.replaceAll("-", ""), sTime);

                        System.arraycopy(serverTime, 0, buffer, index, messageListResponse.MessageDate);
                        index += messageListResponse.MessageDate;

                        byte[] strByteMessageText = ByteUtil.convertStringToByteArray(listOfMessage.getMessageTitle());
                        buffer[index++] = (byte)(strByteMessageText.length);

                        System.arraycopy(strByteMessageText, 0, buffer, index, strByteMessageText.length);
                        index += strByteMessageText.length;

                        //Message Status
                        buffer[index++] = (byte)0;
                        
                    }
                }

                return buffer;

            } else {
                return new byte[]{0};
            }


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        }

    }

    public static byte[] getMessageDetailById(TradingMessage tradingMessage, int brokerCode, int customerCode, int messageId) {
        try {
            if (binding == null)
                throw new ServiceException();

            logger.debug("Message Details for message with id:" + messageId);
            Ws_Message messageDetail = binding.getMessageById(messageId);

            if (messageDetail!=null) {
                MessageDetailResponse messageDetailResponse = new MessageDetailResponse();
                int index = 0;

                String details = StringUtil.replaceParantezes(messageDetail.getMessageDetail());
                byte[] strByteMessageText = ByteUtil.convertStringToByteArray(details);
                byte[] buffer = new byte[messageDetailResponse.FixMessageDetailResponseLen + strByteMessageText.length];
                System.arraycopy(ByteUtil.intToTwoByte(messageDetail.getMessageId()), 0, buffer, index, messageDetailResponse.MessageId);
                index += messageDetailResponse.MessageId;

                System.arraycopy(ByteUtil.intToTwoByte(strByteMessageText.length), 0, buffer, index, messageDetailResponse.MessageLength);
                index += messageDetailResponse.MessageLength;

                System.arraycopy(strByteMessageText, 0, buffer, index, strByteMessageText.length);

                return buffer;

            } else {
                tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
                tradingMessage.setFlags((byte) 0x00);

                byte[] retVal = ByteUtil.convertStringToByteArray("nomessagefound");
                byte[] buffer = new byte[retVal.length + 2];
                System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, 0, 2);
                System.arraycopy(retVal, 0, buffer, 2, retVal.length);

                return buffer;
            }


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        }

    }

    private static byte[] createFatalErrorMessage(TradingMessage tradingMessage) {
        byte[] retVal = ByteUtil.convertStringToByteArray("NO_CONNECTION_TO_SERVER");

        tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
        tradingMessage.setFlags((byte)0x00);

        byte[] buffer = new byte[retVal.length + 2];
        int index = 0;

        System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, index, 2);
        System.arraycopy(retVal, 0, buffer, 2, retVal.length);
        return buffer;

    }



}