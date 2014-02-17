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
 * User: Mahta
 * Date: Jul 25, 2011
 * Time: 11:02:14 AM
 */
public class StockHandler extends MIDletHandler {
    private static Logger logger = Logger.getLogger(LoginHandler.class);
    private TradingMessage tradingMessage;

    public StockHandler(TradingMessage tradingMessage) {
        this.tradingMessage = tradingMessage;
    }

    public TradingMessage handleRequest() throws Exception {
        logger.debug("Login handle request.");
        int brokerCode;   // 2 bytes
        String stockCode;  // 12 bytes
        int customerCode;   // 4 bytes
        int index = 0;


        byte[] bodyData = tradingMessage.getBodyData();

        brokerCode = ByteUtil.bytesToShort(ByteUtil.subArray(bodyData, index, 2));
        index += 2;

        stockCode = new String(ByteUtil.subArray(bodyData, index, 12), "UTF-8");
        index += 12;

        customerCode = ByteUtil.fourBytesToInt(ByteUtil.subArray(bodyData, index, 4));

        // check user Session is expired or not
        byte[] responseBody = null;
        SessionFactory factory = SessionFactory.getInstance();
        Session userSession = factory.getSessionAndUpdateLasSessionUsageTime("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));
        if(userSession != null) {
            responseBody = MarketManager.getStockPrice(tradingMessage, stockCode);

        } else {
            tradingMessage.setResponseCode(MIDletConstant.SESSION_EXPIRATION);
            tradingMessage.setFlags((byte)0x00);
        }

        tradingMessage.createResponse(responseBody);
        return tradingMessage;

    }

}
