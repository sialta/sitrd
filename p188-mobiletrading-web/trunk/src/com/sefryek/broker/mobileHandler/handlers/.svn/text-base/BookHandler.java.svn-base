package com.sefryek.broker.mobileHandler.handlers;

import com.sefryek.broker.webservice.mobilev7.OrderListReport;
import org.apache.log4j.Logger;
import com.sefryek.broker.mobileHandler.MIDletHandler;
import com.sefryek.broker.mobileHandler.MIDletConstant;
import com.sefryek.broker.state.TradingMessage;
import com.sefryek.broker.utils.ByteUtil;
import com.sefryek.broker.utils.sessionUtils.SessionFactory;
import com.sefryek.broker.utils.sessionUtils.Session;
import com.sefryek.broker.webservice.RequestManager;

/**
 * Created by IntelliJ IDEA.
 * User: Mahta
 * Date: May 15, 2011
 * Time: 10:55:33 AM
 */
public class BookHandler extends MIDletHandler {

    private static Logger logger = Logger.getLogger(BookHandler.class);
    private TradingMessage tradingMessage;

    public BookHandler(TradingMessage tradingMessage) {
        this.tradingMessage = tradingMessage;
    }

    public TradingMessage handleRequest() throws Exception {
        logger.debug("Handel request for serviceCode: " + (int) tradingMessage.getServiceCode());
        return bookList();

    }

    private TradingMessage bookList() throws Exception {
        logger.debug("Book Handler Order.");

        int brokerCode;
        int customerCode;
        int pageNumber;
        int pageSize;

        int index = 0;
        byte[] bodyData = tradingMessage.getBodyData();

        byte[] param = ByteUtil.subArray(bodyData, index, HandlerConstants.BROKERAGE_CODE_LENGTH);
        brokerCode = ByteUtil.bytesToShort(param);
        index += HandlerConstants.BROKERAGE_CODE_LENGTH;

        param = ByteUtil.subArray(bodyData, index, HandlerConstants.CLIENT_CODE_LENGTH);
        customerCode = ByteUtil.fourBytesToInt(param);
        index += HandlerConstants.CLIENT_CODE_LENGTH;

        pageNumber = bodyData[index++] & 0x0F;
        pageSize = bodyData[index] & 0x0F;

        // check user Session is expired or not
        byte[] responseBody = null;
        int reportType =1;
        SessionFactory factory = SessionFactory.getInstance();
        Session userSession = factory.getSessionAndUpdateLasSessionUsageTime("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));
        if(userSession != null) {
            responseBody = userSession.getManager().orderListWithFinancial(tradingMessage, RequestManager.OrderListType.ORDER_BOOK,
                    brokerCode, customerCode, pageNumber, pageSize, reportType);

        } else {
            tradingMessage.setResponseCode(MIDletConstant.SESSION_EXPIRATION);
            tradingMessage.setFlags((byte)0x00);
        }

        tradingMessage.createResponse(responseBody);
        return tradingMessage;
    }

}