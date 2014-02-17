package com.sefryek.broker.mobileHandler.handlers;

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
public class OrderHandler extends MIDletHandler {

    private static Logger logger = Logger.getLogger(OrderHandler.class);
    private TradingMessage tradingMessage;

    public OrderHandler(TradingMessage tradingMessage) {
        this.tradingMessage = tradingMessage;
    }

    public TradingMessage handleRequest() throws Exception {
        logger.debug("Handel request for serviceCode: " + (int)tradingMessage.getServiceCode());
        if(tradingMessage.getServiceCode() == MIDletConstant.ADD_ORDER_SERVICE)
            return addOrder();

        else if(tradingMessage.getServiceCode() == MIDletConstant.ORDER_LIST_SERVICE)
            return orderList();

        else if(tradingMessage.getServiceCode() == MIDletConstant.CANCEL_ORDER_SERVICE)
            return cancelOrder();

        return null;

    }

    private TradingMessage addOrder() throws Exception {
        logger.debug("Add order.");
        int brokerCode;
        String nscCode;
        byte status;
        int orderTotalQuantity;
        int orderPrice;
        int minimumQuantity;
        int maxShown;
        byte[] orderValidity;
        int customerCode;
        String isdn;
        int index = 0;

        byte[] bodyData = tradingMessage.getBodyData();

        brokerCode = ByteUtil.bytesToShort(ByteUtil.subArray(bodyData, index, 2));
        index += 2;

        nscCode = new String(ByteUtil.subArray(bodyData, index, 12), "UTF-8");
        index += 12;

        status = bodyData[index++];

        orderTotalQuantity = ByteUtil.threeBytesToInt(ByteUtil.subArray(bodyData, index, 3));
        index += 3;

        orderPrice = ByteUtil.fourBytesToInt(ByteUtil.subArray(bodyData, index, 4));
        index += 4;

        minimumQuantity = ByteUtil.threeBytesToInt(ByteUtil.subArray(bodyData, index, 3));
        index += 3;

        maxShown = ByteUtil.threeBytesToInt(ByteUtil.subArray(bodyData, index, 3));
        index += 3;

        orderValidity = ByteUtil.subArray(bodyData, index, 2);
        index += 2;

        customerCode = ByteUtil.fourBytesToInt(ByteUtil.subArray(bodyData, index, 4));
        index += 4;

        int isdnCodeLength = bodyData[index++];
        isdn = new String(ByteUtil.subArray(bodyData, index, isdnCodeLength), "UTF-8");

        // check user Session is expired or not
        byte[] responseBody = null;
        SessionFactory factory = SessionFactory.getInstance();
        Session userSession = factory.getSessionAndUpdateLasSessionUsageTime("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));
        if(userSession != null) {
            responseBody = userSession.getManager().addOrder(tradingMessage, brokerCode, nscCode, status, orderTotalQuantity,
                    orderPrice, minimumQuantity, maxShown, orderValidity, customerCode, isdn);

        } else {
            tradingMessage.setResponseCode(MIDletConstant.SESSION_EXPIRATION);
            tradingMessage.setFlags((byte)0x00);
        }

        tradingMessage.createResponse(responseBody);
        return tradingMessage;
    }

    private TradingMessage orderList() throws Exception {
        logger.debug("View orders list.");

        int brokerCode;   // 2 bytes
        int customerCode;   // 4 bytes
        int pageNumber;  // 1 bytes
        int pageSize; // 1 bytes
        int index = 0;

        byte[] bodyData = tradingMessage.getBodyData();

        brokerCode = ByteUtil.bytesToShort(ByteUtil.subArray(bodyData, index, 2));
        index += 2;

        customerCode = ByteUtil.fourBytesToInt(ByteUtil.subArray(bodyData, index, 4));
        index += 4;

        pageNumber = bodyData[index++];
        pageSize = bodyData[index];

        // check user Session is expired or not
        byte[] responseBody = null;
        SessionFactory factory = SessionFactory.getInstance();
        Session userSession = factory.getSessionAndUpdateLasSessionUsageTime("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));
        if(userSession != null) {
            responseBody = userSession.getManager().orderList(tradingMessage, RequestManager.OrderListType.ORDER_LIST,
                    brokerCode, customerCode, pageNumber, pageSize);

        } else {
            tradingMessage.setResponseCode(MIDletConstant.SESSION_EXPIRATION);
            tradingMessage.setFlags((byte)0x00);
        }

        tradingMessage.createResponse(responseBody);
        return tradingMessage;
    }

    private TradingMessage cancelOrder() throws Exception {
        logger.debug("Cancel order.");

        int brokerCode;
        long orderId;
        int customerCode;
        int index = 0;

        byte[] bodyData = tradingMessage.getBodyData();

        brokerCode = ByteUtil.bytesToShort(ByteUtil.subArray(bodyData, index, 2));
        index += 2;

        orderId =  ByteUtil.fiveBytesToLong(ByteUtil.subArray(bodyData, index, 5));
        index += 5;

        customerCode = ByteUtil.fourBytesToInt(ByteUtil.subArray(bodyData, index, 4));
        index += 4;

        // check user Session is expired or not
        byte[] responseBody = null;
        SessionFactory factory = SessionFactory.getInstance();
        Session userSession = factory.getSessionAndUpdateLasSessionUsageTime("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));
        if(userSession != null) {
            responseBody = userSession.getManager().cancelOrder(tradingMessage, orderId);

        } else {
            tradingMessage.setResponseCode(MIDletConstant.SESSION_EXPIRATION);
            tradingMessage.setFlags((byte)0x00);
        }

        tradingMessage.createResponse(responseBody);
        return tradingMessage;
    }


}