package com.sefryek.broker.mobileHandler.handlers;

import com.sefryek.broker.mobileHandler.MIDletConstant;
import com.sefryek.broker.mobileHandler.MIDletHandler;
import com.sefryek.broker.state.TradingMessage;
import com.sefryek.broker.utils.ByteUtil;
import com.sefryek.broker.utils.sessionUtils.Session;
import com.sefryek.broker.utils.sessionUtils.SessionFactory;
import com.sefryek.broker.webservice.RequestManager;
import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Sina
 * Date: Feb 19, 2013
 * Time: 17:28:12 PM
 */
public class FinancialProviderHandler extends MIDletHandler {

    private static Logger logger = Logger.getLogger(FinancialProviderHandler.class);
    private TradingMessage tradingMessage;

    public FinancialProviderHandler(TradingMessage tradingMessage) {
        this.tradingMessage = tradingMessage;
    }

    public TradingMessage handleRequest() throws Exception {
        logger.debug("Handel request for serviceCode: " + (int) tradingMessage.getServiceCode());

        int brokerCode;
        int customerCode;
        int index = 0;

        byte[] bodyData = tradingMessage.getBodyData();


        brokerCode = ByteUtil.bytesToShort(ByteUtil.subArray(bodyData, index, 2));
        index += 2;

        customerCode = ByteUtil.fourBytesToInt(ByteUtil.subArray(bodyData, index, 4));
        index += 4;


        // check user Session is expired or not
        byte[] responseBody = null;
        SessionFactory factory = SessionFactory.getInstance();
        Session userSession = factory.getSessionAndUpdateLasSessionUsageTime("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));
        if (userSession != null) {
            responseBody = userSession.getManager().getFinancialProvider(tradingMessage, brokerCode, customerCode);

        } else {
            tradingMessage.setResponseCode(MIDletConstant.SESSION_EXPIRATION);
            tradingMessage.setFlags((byte) 0x00);
        }

        tradingMessage.createResponse(responseBody);
        return tradingMessage;


    }

}