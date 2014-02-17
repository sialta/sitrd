package com.sefryek.broker.mobileHandler.handlers;

import org.apache.log4j.Logger;
import com.sefryek.broker.mobileHandler.MIDletHandler;
import com.sefryek.broker.mobileHandler.MIDletConstant;
import com.sefryek.broker.state.TradingMessage;
import com.sefryek.broker.utils.ByteUtil;
import com.sefryek.broker.utils.sessionUtils.SessionFactory;
import com.sefryek.broker.utils.sessionUtils.Session;
import com.sefryek.broker.webservice.MarketManager;

/**
 * Created by IntelliJ IDEA.
 * User: Mahta
 * Date: May 15, 2011
 * Time: 10:55:33 AM
 */
public class CompanyListHandler extends MIDletHandler {

    private static Logger logger = Logger.getLogger(CompanyListHandler.class);
    private TradingMessage tradingMessage;

    public CompanyListHandler(TradingMessage tradingMessage) {
        this.tradingMessage = tradingMessage;
    }

    public TradingMessage handleRequest() throws Exception {
        logger.debug("Handel request for serviceCode: " + (int) tradingMessage.getServiceCode());
        return companyList();

    }

    private TradingMessage companyList() throws Exception {
        logger.debug("Company List Handler.");

        int brokerCode;
        int customerCode;

        int index = 0;
        byte[] bodyData = tradingMessage.getBodyData();

        byte[] param = ByteUtil.subArray(bodyData, index, HandlerConstants.BROKERAGE_CODE_LENGTH);
        brokerCode = ByteUtil.bytesToShort(param);
        index += HandlerConstants.BROKERAGE_CODE_LENGTH;

        param = ByteUtil.subArray(bodyData, index, HandlerConstants.CLIENT_CODE_LENGTH);
        customerCode = ByteUtil.fourBytesToInt(param);
        index += HandlerConstants.CLIENT_CODE_LENGTH;

        int pageNo = bodyData[index];

        // check user Session is expired or not
        byte[] responseBody = null;
        SessionFactory factory = SessionFactory.getInstance();
        Session userSession = factory.getSessionAndUpdateLasSessionUsageTime("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));
        if(userSession != null) {
            responseBody = MarketManager.companyListService(tradingMessage, pageNo, userSession);

        } else {
            tradingMessage.setResponseCode(MIDletConstant.SESSION_EXPIRATION);
            tradingMessage.setFlags((byte)0x00);
        }

        tradingMessage.createResponse(responseBody);
        return tradingMessage;
    }

}