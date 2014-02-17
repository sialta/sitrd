package com.sefryek.broker.mobileHandler.handlers;

import org.apache.log4j.Logger;
import com.sefryek.broker.mobileHandler.MIDletHandler;
import com.sefryek.broker.mobileHandler.MIDletConstant;
import com.sefryek.broker.state.TradingMessage;
import com.sefryek.broker.utils.ByteUtil;
import com.sefryek.broker.utils.sessionUtils.SessionFactory;
import com.sefryek.broker.utils.sessionUtils.Session;

/**
 * Created by IntelliJ IDEA.
 * User: Mahta
 * Date: May 15, 2011
 * Time: 10:55:33 AM
 */
public class AccountHandler extends MIDletHandler {

    private static Logger logger = Logger.getLogger(AccountHandler.class);
    private TradingMessage tradingMessage;

    public AccountHandler(TradingMessage tradingMessage) {
        this.tradingMessage = tradingMessage;
    }

    public TradingMessage handleRequest() throws Exception {
        logger.debug("Handel request for serviceCode: " + (int)tradingMessage.getServiceCode());
        if(tradingMessage.getServiceCode() == MIDletConstant.VIEW_ACCOUNTS_SERVICE)
            return viewAccounts();

        return null;

    }

    private TradingMessage viewAccounts() throws Exception {
        logger.debug("view accounts.");
        //        سایز صفحه	شماره صفحه	کد مشتری	کد کارگزاری

        int brokerCode;   // 2 bytes
        int customerCode;   // 4 bytes
        int pageNumber;  // 1 bytes
        int pageSize; // 1 bytes
        int index = 0;

        byte[] bodyData = tradingMessage.getBodyData();

        brokerCode = ByteUtil.bytesToShort(ByteUtil.subArray(bodyData, index, 2));
        index += 2;

        customerCode = ByteUtil.fourBytesToInt(ByteUtil.subArray(bodyData, index, index + 4));
        index += 4;

        pageNumber = bodyData[index++];
        pageSize = bodyData[index];

        // initialize Session for this user
        byte[] responseBody = null;
        SessionFactory factory = SessionFactory.getInstance();
        Session userSession = factory.getSessionAndUpdateLasSessionUsageTime("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));
        if(userSession != null) {
            responseBody = userSession.getManager().viewAccount(tradingMessage, brokerCode, customerCode, pageNumber, pageSize);

        } else {
            tradingMessage.setResponseCode(MIDletConstant.SESSION_EXPIRATION);
            tradingMessage.setFlags((byte)0x00);
        }

        tradingMessage.createResponse(responseBody);
        return tradingMessage;
    }

}