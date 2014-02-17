package com.sefryek.broker.mobileHandler.handlers;

import com.sefryek.broker.mobileHandler.MIDletConstant;
import com.sefryek.broker.mobileHandler.MIDletHandler;
import com.sefryek.broker.state.TradingMessage;
import com.sefryek.broker.utils.ByteUtil;
import com.sefryek.broker.utils.sessionUtils.Session;
import com.sefryek.broker.utils.sessionUtils.SessionFactory;
import com.sefryek.broker.webservice.MarketManager;
import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Sarvenaz
 * Date: Jul 24, 2011
 * Time: 1:49:56 PM
 */
public class BestOfMarketHandlerWithFirstQueue extends MIDletHandler {

    private static Logger logger = Logger.getLogger(BestOfMarketHandlerWithFirstQueue.class);
    private TradingMessage tradingMessage;

    public BestOfMarketHandlerWithFirstQueue(TradingMessage tradingMessage) {
        this.tradingMessage = tradingMessage;
    }

    public TradingMessage handleRequest() throws Exception {
        logger.debug("BestOfMarket handle request.");

        int brokerCode;

        int index = 0;
        byte[] bodyData = tradingMessage.getBodyData();

        byte[] param = ByteUtil.subArray(bodyData, index, 2);
        brokerCode = ByteUtil.bytesToShort(param);
        index += 2;

        int customerCode = ByteUtil.fourBytesToInt(ByteUtil.subArray(bodyData, index, 4));
        index += 4;

        int pageNo = bodyData[index++];
        int pageSize = bodyData[index++];
        int status = bodyData[index];

        // check user Session is expired or not
        byte[] responseBody = null;
        SessionFactory factory = SessionFactory.getInstance();
        Session userSession = factory.getSessionAndUpdateLasSessionUsageTime("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));
        if (userSession != null) {
            responseBody = MarketManager.bestOfMarketServiceWithFirstQueue(tradingMessage, pageNo, pageSize, status);

        } else {
            tradingMessage.setResponseCode(MIDletConstant.SESSION_EXPIRATION);
            tradingMessage.setFlags((byte) 0x00);
        }

        tradingMessage.createResponse(responseBody);
        return tradingMessage;

    }

}