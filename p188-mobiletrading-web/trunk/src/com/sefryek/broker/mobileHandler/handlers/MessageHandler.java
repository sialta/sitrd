package com.sefryek.broker.mobileHandler.handlers;

import org.apache.log4j.Logger;
import com.sefryek.broker.mobileHandler.MIDletHandler;
import com.sefryek.broker.mobileHandler.MIDletConstant;
import static com.sefryek.broker.mobileHandler.MIDletConstant.MESSAGE_LIST_SERVICE;
import com.sefryek.broker.state.TradingMessage;
import com.sefryek.broker.utils.ByteUtil;
import com.sefryek.broker.utils.sessionUtils.SessionFactory;
import com.sefryek.broker.utils.sessionUtils.Session;
import com.sefryek.broker.webservice.MessageManager;

/**
 * Created by IntelliJ IDEA.
 * User: Mahta
 * Date: May 15, 2011
 * Time: 10:55:33 AM
 */
public class MessageHandler extends MIDletHandler {

    private static Logger logger = Logger.getLogger(MessageHandler.class);
    private TradingMessage tradingMessage;

    public MessageHandler(TradingMessage tradingMessage) {
        this.tradingMessage = tradingMessage;
    }

    public TradingMessage handleRequest() throws Exception {
        logger.debug("Handel request for serviceCode: " + (int) tradingMessage.getServiceCode());

        if(tradingMessage.getServiceCode() == MESSAGE_LIST_SERVICE)
            return getMessageList();

        else
            return getMessageDetailsById();
    }

    private TradingMessage getMessageList() throws Exception {
        logger.debug("Message List Handler.");

        int brokerCode;
        int customerCode;
        byte[] lastDate;

        int index = 0;
        byte[] bodyData = tradingMessage.getBodyData();

        byte[] param = ByteUtil.subArray(bodyData, index, HandlerConstants.BROKERAGE_CODE_LENGTH);
        brokerCode = ByteUtil.bytesToShort(param);
        index += HandlerConstants.BROKERAGE_CODE_LENGTH;

        param = ByteUtil.subArray(bodyData, index, HandlerConstants.CLIENT_CODE_LENGTH);
        customerCode = ByteUtil.fourBytesToInt(param);
        index += HandlerConstants.CLIENT_CODE_LENGTH;

        lastDate = ByteUtil.subArray(bodyData, index, HandlerConstants.LASR_DATE_LENGTH);


        // check user Session is expired or not
        byte[] responseBody = null;
        SessionFactory factory = SessionFactory.getInstance();
        Session userSession = factory.getSessionAndUpdateLasSessionUsageTime("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));
        if(userSession != null) {
            responseBody = MessageManager.getListOfMessages(tradingMessage, brokerCode, customerCode, lastDate);

        } else {
            tradingMessage.setResponseCode(MIDletConstant.SESSION_EXPIRATION);
            tradingMessage.setFlags((byte)0x00);
        }

        tradingMessage.createResponse(responseBody);
        return tradingMessage;
    }

    private TradingMessage getMessageDetailsById() throws Exception {
        logger.debug("Message List Handler.");

        int brokerCode;
        int customerCode;
        int messageId;

        int index = 0;
        byte[] bodyData = tradingMessage.getBodyData();

        byte[] param = ByteUtil.subArray(bodyData, index, HandlerConstants.BROKERAGE_CODE_LENGTH);
        brokerCode = ByteUtil.bytesToShort(param);
        index += HandlerConstants.BROKERAGE_CODE_LENGTH;

        param = ByteUtil.subArray(bodyData, index, HandlerConstants.CLIENT_CODE_LENGTH);
        customerCode = ByteUtil.fourBytesToInt(param);
        index += HandlerConstants.CLIENT_CODE_LENGTH;

        param = ByteUtil.subArray(bodyData, index, HandlerConstants.MESSAGE_ID);
        messageId = ByteUtil.bytesToShort(param);
        index += HandlerConstants.MESSAGE_ID;


        // check user Session is expired or not
        byte[] responseBody = null;
        SessionFactory factory = SessionFactory.getInstance();
        Session userSession = factory.getSessionAndUpdateLasSessionUsageTime("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));
        if(userSession != null) {
            responseBody = MessageManager.getMessageDetailById(tradingMessage, brokerCode, customerCode, messageId);

        } else {
            tradingMessage.setResponseCode(MIDletConstant.SESSION_EXPIRATION);
            tradingMessage.setFlags((byte)0x00);
        }

        tradingMessage.createResponse(responseBody);
        return tradingMessage;
    }

}