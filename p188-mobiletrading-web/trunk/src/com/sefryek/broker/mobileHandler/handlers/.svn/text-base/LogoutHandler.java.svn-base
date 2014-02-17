package com.sefryek.broker.mobileHandler.handlers;

import org.apache.log4j.Logger;
import com.sefryek.broker.mobileHandler.MIDletHandler;
import com.sefryek.broker.mobileHandler.MIDletConstant;
import com.sefryek.broker.state.TradingMessage;
import com.sefryek.broker.utils.ByteUtil;
import com.sefryek.broker.utils.sessionUtils.SessionFactory;

/**
 * Created by IntelliJ IDEA.
 * User: Mahta
 * Date: May 15, 2011
 * Time: 10:55:33 AM
 */
public class LogoutHandler extends MIDletHandler {

    private static Logger logger = Logger.getLogger(LogoutHandler.class);
    private TradingMessage tradingMessage;

    public LogoutHandler(TradingMessage tradingMessage) {
        this.tradingMessage = tradingMessage;
    }

    public TradingMessage handleRequest() throws Exception {
        logger.debug("Logout Handler.");
        byte[] bodyData = tradingMessage.getBodyData();


        int index = 0;

        byte[] param = ByteUtil.subArray(bodyData, index, HandlerConstants.BROKERAGE_CODE_LENGTH);
        int brokerCode = ByteUtil.bytesToShort(param);
        index += HandlerConstants.BROKERAGE_CODE_LENGTH;

        param = ByteUtil.subArray(bodyData, index, HandlerConstants.CLIENT_CODE_LENGTH);
        int customerCode = ByteUtil.fourBytesToInt(param);

        SessionFactory factory = SessionFactory.getInstance();
        factory.destroySessionBySessionId("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));

        tradingMessage.setResponseCode(MIDletConstant.SUCCESSFUL_OPERATION);
        tradingMessage.createResponse(null);
        return tradingMessage;

    }

}