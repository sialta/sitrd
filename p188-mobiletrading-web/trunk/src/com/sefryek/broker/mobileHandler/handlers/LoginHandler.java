package com.sefryek.broker.mobileHandler.handlers;

import org.apache.log4j.Logger;
import com.sefryek.broker.mobileHandler.MIDletHandler;
import com.sefryek.broker.state.TradingMessage;
import com.sefryek.broker.utils.ByteUtil;
import com.sefryek.broker.webservice.RequestManager;

/**
 * Created by IntelliJ IDEA.
 * User: Mahta
 * Date: May 15, 2011
 * Time: 10:55:33 AM
 */
public class LoginHandler extends MIDletHandler {

    private static Logger logger = Logger.getLogger(LoginHandler.class);
    private TradingMessage tradingMessage;
    boolean flag = false;

    public LoginHandler(TradingMessage tradingMessage) {
        this.tradingMessage = tradingMessage;
    }

    public TradingMessage handleRequest() throws Exception {
        logger.debug("Login handle request.");
        int brokerCode;
        byte version;
        String username;
        String password;


        int index = 0;
        byte[] bodyData = tradingMessage.getBodyData();

        byte[] param = ByteUtil.subArray(bodyData, index, 2);
        brokerCode = ByteUtil.bytesToShort(param);
        index += 2;

        version = bodyData[index++];
        // check version

        int usernameLength = bodyData[index++] & 0xFF;
        int passwordLength = bodyData[index++] & 0xFF;

        param = ByteUtil.subArray(bodyData, index, usernameLength);
        username = new String(param, "UTF-8");
        index += usernameLength;

        param = ByteUtil.subArray(bodyData, index, passwordLength);
        password = new String(param, "UTF-8");

        byte[] responseBody = new RequestManager(brokerCode).login(username, password, tradingMessage, brokerCode);
        if(responseBody != null)
            logger.info(ByteUtil.getHex(responseBody));
        else
            logger.info("Response body is null.");


        tradingMessage.createResponse(responseBody);
        return tradingMessage;

    }

}
