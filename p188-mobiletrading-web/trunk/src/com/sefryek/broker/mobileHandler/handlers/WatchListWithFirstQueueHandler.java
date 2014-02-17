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
 * User: Sahar Ta
 * Date: Jul 26, 2011
 * Time: 12:13:35 PM
 */
public class WatchListWithFirstQueueHandler extends MIDletHandler {

    private static Logger logger = Logger.getLogger(WatchListWithFirstQueueHandler.class);
    private TradingMessage tradingMessage;

    public WatchListWithFirstQueueHandler(TradingMessage tradingMessage) {
        this.tradingMessage = tradingMessage;
    }

    public TradingMessage handleRequest() throws Exception {

        logger.debug("Watch List handle request.");

        int brokerCode;
        int customerCode;
        int stockNo;
        String[] stockIds;

        int index = 0;
        byte[] bodyData = tradingMessage.getBodyData();

        byte[] param = ByteUtil.subArray(bodyData, index, HandlerConstants.BROKERAGE_CODE_LENGTH);
        brokerCode = ByteUtil.bytesToShort(param);
        index += HandlerConstants.BROKERAGE_CODE_LENGTH;

        param = ByteUtil.subArray(bodyData, index, HandlerConstants.CLIENT_CODE_LENGTH);
        customerCode = ByteUtil.fourBytesToInt(param);
        index += HandlerConstants.CLIENT_CODE_LENGTH;

        stockNo = bodyData[index++] & 0x0F;

        stockIds = new String[stockNo];
        for (int i = 0; i < stockNo; i++) {
            param = ByteUtil.subArray(bodyData, index, HandlerConstants.STOCK_ID_LENGTH);
            stockIds[i] = new String(param, "UTF-8").trim();
            index += HandlerConstants.STOCK_ID_LENGTH;
        }

        // check user Session is expired or not
        byte[] responseBody = null;
        SessionFactory factory = SessionFactory.getInstance();
        Session userSession = factory.getSessionAndUpdateLasSessionUsageTime("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));
        if(userSession != null) {
            responseBody = MarketManager.watchListWithFirstQueueService(tradingMessage, stockIds);

        } else {
            tradingMessage.setResponseCode(MIDletConstant.SESSION_EXPIRATION);
            tradingMessage.setFlags((byte)0x00);
        }

        tradingMessage.createResponse(responseBody);
        return tradingMessage;

    }
}
