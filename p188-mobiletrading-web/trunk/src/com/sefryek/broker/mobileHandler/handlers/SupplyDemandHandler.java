package com.sefryek.broker.mobileHandler.handlers;

import com.sefryek.broker.mobileHandler.MIDletHandler;
import com.sefryek.broker.mobileHandler.MIDletConstant;
import com.sefryek.broker.state.TradingMessage;
import com.sefryek.broker.utils.ByteUtil;
import com.sefryek.broker.utils.sessionUtils.SessionFactory;
import com.sefryek.broker.utils.sessionUtils.Session;
import com.sefryek.broker.webservice.MarketManager;
import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Sahar Ta
 * Date: Jul 25, 2011
 * Time: 4:42:46 PM
 */
public class SupplyDemandHandler extends MIDletHandler {

    private static Logger logger = Logger.getLogger(SupplyDemandHandler.class);
    private TradingMessage tradingMessage;

    public SupplyDemandHandler(TradingMessage tradingMessage) {
        this.tradingMessage = tradingMessage;
    }

    public TradingMessage handleRequest() throws Exception {

        logger.debug("Supply/Demand Queue handle request.");

        int brokerCode;
        int customerCode;
        String stockId;

        int index = 0;
        byte[] bodyData = tradingMessage.getBodyData();

        byte[] param = ByteUtil.subArray(bodyData, index, HandlerConstants.BROKERAGE_CODE_LENGTH);
        brokerCode = ByteUtil.bytesToShort(param);
        index += HandlerConstants.BROKERAGE_CODE_LENGTH;

        param = ByteUtil.subArray(bodyData, index, HandlerConstants.STOCK_ID_LENGTH);
        stockId = new String(param, "UTF-8").trim();
        index += HandlerConstants.STOCK_ID_LENGTH;

        param = ByteUtil.subArray(bodyData, index, HandlerConstants.CLIENT_CODE_LENGTH);
        customerCode = ByteUtil.fourBytesToInt(param);
        index += HandlerConstants.CLIENT_CODE_LENGTH;

        // check user Session is expired or not
        byte[] responseBody = null;
        SessionFactory factory = SessionFactory.getInstance();
        Session userSession = factory.getSessionAndUpdateLasSessionUsageTime("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));
        if(userSession != null) {
            responseBody = MarketManager.supplyDemandQueueService(tradingMessage, stockId);

        } else {
            tradingMessage.setResponseCode(MIDletConstant.SESSION_EXPIRATION);
            tradingMessage.setFlags((byte)0x00);
        }

        tradingMessage.createResponse(responseBody);
        return tradingMessage;

    }
}
