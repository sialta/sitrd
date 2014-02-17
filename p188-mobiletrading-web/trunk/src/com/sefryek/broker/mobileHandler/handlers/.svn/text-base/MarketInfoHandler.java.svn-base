package com.sefryek.broker.mobileHandler.handlers;

import org.apache.log4j.Logger;
import com.sefryek.broker.state.TradingMessage;
import com.sefryek.broker.utils.ByteUtil;
import com.sefryek.broker.utils.sessionUtils.SessionFactory;
import com.sefryek.broker.utils.sessionUtils.Session;
import com.sefryek.broker.webservice.MarketManager;
import com.sefryek.broker.mobileHandler.MIDletHandler;
import com.sefryek.broker.mobileHandler.MIDletConstant;

/**
 * Created by IntelliJ IDEA.
 * User: Sarvenaz
 * Date: Jul 24, 2011
 * Time: 1:49:56 PM
 */
public class MarketInfoHandler extends MIDletHandler {

    private static Logger logger = Logger.getLogger(MarketInfoHandler.class);
    private TradingMessage tradingMessage;

    public MarketInfoHandler(TradingMessage tradingMessage) {
        this.tradingMessage = tradingMessage;
    }

    public TradingMessage handleRequest() throws Exception {
        logger.debug("MarketInfo handle request.");

        int brokerCode;

        int index = 0;
        byte[] bodyData = tradingMessage.getBodyData();

        byte[] param = ByteUtil.subArray(bodyData, index, 2);
        brokerCode = ByteUtil.bytesToShort(param);
        index += 2;

        int customerCode = ByteUtil.fourBytesToInt(ByteUtil.subArray(bodyData, index, 4));


        // check user Session is expired or not
        byte[] responseBody = null;
        SessionFactory factory = SessionFactory.getInstance();
        Session userSession = factory.getSessionAndUpdateLasSessionUsageTime("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));
        if(userSession != null) {
            responseBody = MarketManager.marketInfoService(tradingMessage);

        } else {
            tradingMessage.setResponseCode(MIDletConstant.SESSION_EXPIRATION);
            tradingMessage.setFlags((byte)0x00);
        }

        tradingMessage.createResponse(responseBody);
        return tradingMessage;

    }

}