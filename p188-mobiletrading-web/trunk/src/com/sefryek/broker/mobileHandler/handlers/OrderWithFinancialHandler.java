package com.sefryek.broker.mobileHandler.handlers;

import com.sefryek.broker.mobileHandler.MIDletConstant;
import com.sefryek.broker.mobileHandler.MIDletHandler;
import com.sefryek.broker.state.TradingMessage;
import com.sefryek.broker.utils.ByteUtil;
import com.sefryek.broker.utils.sessionUtils.Session;
import com.sefryek.broker.utils.sessionUtils.SessionFactory;
import com.sefryek.broker.webservice.RequestManager;
import com.sefryek.broker.webservice.mobilev7.OrderListReport;
import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Mahta
 * Date: May 15, 2011
 * Time: 10:55:33 AM
 */
public class OrderWithFinancialHandler extends MIDletHandler {

    private static Logger logger = Logger.getLogger(OrderWithFinancialHandler.class);
    private TradingMessage tradingMessage;

    public OrderWithFinancialHandler(TradingMessage tradingMessage) {
        this.tradingMessage = tradingMessage;
    }

    public TradingMessage handleRequest() throws Exception {
        logger.debug("Handel request for serviceCode: " + (int) tradingMessage.getServiceCode());


        if (tradingMessage.getServiceCode() == MIDletConstant.ADD_ORDER_WITH_FINANCIAL_SERVICE)
            return addOrderWithFinancial();

        else if (tradingMessage.getServiceCode() == MIDletConstant.ORDER_LIST_WITH_FINACIAL_SERVICE)
            return orderListWithFinancial();

        else if (tradingMessage.getServiceCode() == MIDletConstant.MODIFY_ORDER_WITH_FINANCIAL_SERVICE)
            return modifyOrderWithFinancial();
        return null;

    }

    private TradingMessage addOrderWithFinancial() throws Exception {


        int brokerCode;   //2
        String nscCode;   //12
        int financialId;  //4 bytes
        byte status;      //1
        int orderTotalQuantity;
        int orderPrice;
        int minimumQuantity;
        int maxShown;
        byte[] orderDate;
        byte[] orderValidityDate;
        byte orderValidityType;
        int customerCode;
        String isdn;
        int index = 0;

        byte[] bodyData = tradingMessage.getBodyData();

        brokerCode = ByteUtil.bytesToShort(ByteUtil.subArray(bodyData, index, 2));
        index += 2;

        nscCode = new String(ByteUtil.subArray(bodyData, index, 12), "UTF-8");
        index += 12;

        financialId = ByteUtil.bytesToShort(ByteUtil.subArray(bodyData, index, 4));
        index += 4;

        status = bodyData[index++];

        orderTotalQuantity = ByteUtil.threeBytesToInt(ByteUtil.subArray(bodyData, index, 3));
        index += 3;

        orderPrice = ByteUtil.fourBytesToInt(ByteUtil.subArray(bodyData, index, 4));
        index += 4;

        minimumQuantity = ByteUtil.threeBytesToInt(ByteUtil.subArray(bodyData, index, 3));
        index += 3;

        maxShown = ByteUtil.threeBytesToInt(ByteUtil.subArray(bodyData, index, 3));
        index += 3;

        orderDate = ByteUtil.subArray(bodyData, index, 2);
        index += 2;

        orderValidityDate = ByteUtil.subArray(bodyData, index, 2);
        index += 2;

        orderValidityType = bodyData[index];
        index += 1;

        customerCode = ByteUtil.fourBytesToInt(ByteUtil.subArray(bodyData, index, 4));
        index += 4;

        int isdnCodeLength = bodyData[index++];
        isdn = new String(ByteUtil.subArray(bodyData, index, isdnCodeLength), "UTF-8");

        // check user Session is expired or not
        byte[] responseBody = null;
        SessionFactory factory = SessionFactory.getInstance();
        Session userSession = factory.getSessionAndUpdateLasSessionUsageTime("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));
        if (userSession != null) {
            responseBody = userSession.getManager().addOrderWithFinancial(tradingMessage, brokerCode, nscCode, financialId, status, orderTotalQuantity,
                    orderPrice, minimumQuantity, maxShown, orderDate, orderValidityDate, orderValidityType, customerCode, isdnCodeLength, isdn);

        } else {
            tradingMessage.setResponseCode(MIDletConstant.SESSION_EXPIRATION);
            tradingMessage.setFlags((byte) 0x00);
        }

        tradingMessage.createResponse(responseBody);
        return tradingMessage;


    }


    private TradingMessage orderListWithFinancial() throws Exception {
        logger.debug("View orders list.");

        int brokerCode;   // 2 bytes
        int customerCode;   // 4 bytes
        int pageNumber;  // 1 byte
        int pageSize; // 1 byte
        int reportType; //1 byte
        int index = 0;

        byte[] bodyData = tradingMessage.getBodyData();

        brokerCode = ByteUtil.bytesToShort(ByteUtil.subArray(bodyData, index, 2));
        index += 2;

        customerCode = ByteUtil.fourBytesToInt(ByteUtil.subArray(bodyData, index, 4));
        index += 4;

        pageNumber = bodyData[index++];
        pageSize = bodyData[index++];
        reportType = bodyData[index];
        // check user Session is expired or not
        byte[] responseBody = null;
        SessionFactory factory = SessionFactory.getInstance();
        Session userSession = factory.getSessionAndUpdateLasSessionUsageTime("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));
        if (userSession != null) {
            responseBody = userSession.getManager().orderListWithFinancial(tradingMessage, RequestManager.OrderListType.ORDER_LIST,
                    brokerCode, customerCode, pageNumber, pageSize,reportType);

        } else {
            tradingMessage.setResponseCode(MIDletConstant.SESSION_EXPIRATION);
            tradingMessage.setFlags((byte) 0x00);
        }

        tradingMessage.createResponse(responseBody);
        return tradingMessage;
    }

    private TradingMessage modifyOrderWithFinancial() throws Exception {


        int brokerCode;   //2
        String nscCode;   //12
        int financialId;  //4 bytes
        long orderId ;     //5 bytes
        byte status;      //1
        int orderTotalQuantity;
        int orderPrice;
        int minimumQuantity;
        int maxShown;
        byte[] orderDate;
        byte[] orderValidityDate;
        int customerCode;
        String isdn;
        int index = 0;

        byte[] bodyData = tradingMessage.getBodyData();

        brokerCode = ByteUtil.bytesToShort(ByteUtil.subArray(bodyData, index, 2));
        index += 2;

        nscCode = new String(ByteUtil.subArray(bodyData, index, 12), "UTF-8");
        index += 12;

        financialId = ByteUtil.bytesToShort(ByteUtil.subArray(bodyData, index, 4));
        index += 4;

        orderId = ByteUtil.fiveBytesToLong(ByteUtil.subArray(bodyData, index, 5));
        index += 5;

        status = bodyData[index++];

        orderTotalQuantity = ByteUtil.threeBytesToInt(ByteUtil.subArray(bodyData, index, 3));
        index += 3;

        orderPrice = ByteUtil.fourBytesToInt(ByteUtil.subArray(bodyData, index, 4));
        index += 4;

        minimumQuantity = ByteUtil.threeBytesToInt(ByteUtil.subArray(bodyData, index, 3));
        index += 3;

        maxShown = ByteUtil.threeBytesToInt(ByteUtil.subArray(bodyData, index, 3));
        index += 3;

        orderDate = ByteUtil.subArray(bodyData, index, 2);
        index += 2;

        orderValidityDate = ByteUtil.subArray(bodyData, index, 2);
        index += 2;

        customerCode = ByteUtil.fourBytesToInt(ByteUtil.subArray(bodyData, index, 4));
        index += 4;

        int isdnCodeLength = bodyData[index++];
        isdn = new String(ByteUtil.subArray(bodyData, index, isdnCodeLength), "UTF-8");

        // check user Session is expired or not
        byte[] responseBody = null;
        SessionFactory factory = SessionFactory.getInstance();
        Session userSession = factory.getSessionAndUpdateLasSessionUsageTime("" + brokerCode, "" + customerCode, new String(tradingMessage.getSessionId(), "UTF-8"));
        if (userSession != null) {
            responseBody = userSession.getManager().modifyOrderWithFinancial(tradingMessage, brokerCode, nscCode, financialId, orderId, status, orderTotalQuantity,
                    orderPrice, minimumQuantity, maxShown, orderDate, orderValidityDate, customerCode, isdnCodeLength, isdn);

        } else {
            tradingMessage.setResponseCode(MIDletConstant.SESSION_EXPIRATION);
            tradingMessage.setFlags((byte) 0x00);
        }

        tradingMessage.createResponse(responseBody);
        return tradingMessage;


    }


}