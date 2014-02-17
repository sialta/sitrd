package com.sefryek.broker.mobileHandler;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;

import com.sefryek.broker.state.TradingMessage;
import com.sefryek.broker.mobileHandler.handlers.*;
import com.sefryek.broker.utils.ByteUtil;

import static com.sefryek.broker.mobileHandler.MIDletConstant.*;


/**
 * Created by IntelliJ IDEA.
 * User: mahta
 * Date: May 14, 2011
 * Time: 4:47:47 PM
 */
public abstract class MIDletHandler implements Runnable {
    private static final Logger logger = Logger.getLogger(MIDletHandler.class);

    private Socket requestSocket = null;
    protected boolean proccessRequestInLocal = true;
    private OutputStream out;
    private InputStream is;

    protected MIDletHandler() {
    }

    public MIDletHandler(Socket requestSocket) {
        this.requestSocket = requestSocket;
    }

    public synchronized void run() {
        TradingMessage tradingReqRespMessage = new TradingMessage();

        try {
            logger.debug("Start of run method of Midlet Handler Class.");
            is = requestSocket.getInputStream();
            out = requestSocket.getOutputStream();

            // initiate TradingMessage, read bytes, decrypt the request and process ther request
            tradingReqRespMessage = new TradingMessage(is);
            MIDletHandler handler = getHandler(tradingReqRespMessage);
            if (handler != null)
                tradingReqRespMessage = handler.handleRequest();

        } catch (IOException e) {
            logger.error("Error communicating with client: " + e.getMessage(), e);
            logger.info(e.getMessage());
            createFatalErrorMessage(tradingReqRespMessage, null);


        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            createFatalErrorMessage(tradingReqRespMessage, null);

        } finally {
            closeSocket(out, is, tradingReqRespMessage);
        }
    }

    public static MIDletHandler getHandler(TradingMessage tradingMessage) {

        int serviceCode = tradingMessage.getServiceCode();
        logger.debug("Service code is: " + (byte) serviceCode);

        if (serviceCode != -1) {
            if (ADD_ORDER_SERVICE == (byte) serviceCode || ORDER_LIST_SERVICE == (byte) serviceCode
                    || CANCEL_ORDER_SERVICE == (byte) serviceCode) {
                return new OrderHandler(tradingMessage);

            } else if (LOGIN_SERVICE == (byte) serviceCode) {
                return new LoginHandler(tradingMessage);

            } else if (VIEW_ACCOUNTS_SERVICE == (byte) serviceCode) {
                return new AccountHandler(tradingMessage);

            } else if (LOGOUT_SERVICE == (byte) serviceCode) {
                return new LogoutHandler(tradingMessage);

            } else if (BOOK_ORDER_WITH_FINANCIAL_SERVICE == (byte) serviceCode) {
                return new BookHandler(tradingMessage);

            } else if (COMPANY_LIST_SERVICE == (byte) serviceCode) {
                return new CompanyListHandler(tradingMessage);

            } else if (STOCK_QUEUE_SERVICE == (byte) serviceCode) {
                return new SupplyDemandHandler(tradingMessage);

            } else if (MAIN_INDICATORS_SERVICE == serviceCode) {
                return new MainIndexHandler(tradingMessage);

            } else if (MARKET_INFO_SERVICE == serviceCode) {
                return new MarketInfoHandler(tradingMessage);

            } else if (WATCH_LIST_SERVICE == (byte) serviceCode) {
                return new WatchListHandler(tradingMessage);

            } else if (WATCH_LIST_WITH_FIRST_QUEUE_SERVICE == (byte) serviceCode) {
                return new WatchListWithFirstQueueHandler(tradingMessage);

            } else if (STOCK_PRICE_SERVICE == (byte) serviceCode) {
                return new StockHandler(tradingMessage);

            } else if (BEST_OF_MARKET_SERVICE == (byte) serviceCode) {
                return new BestOfMarketHandler(tradingMessage);

            } else if (BEST_OF_MARKET_WITH_FIRST_QUEUE_SERVICE == (byte) serviceCode) {
                return new BestOfMarketHandlerWithFirstQueue(tradingMessage);

            } else if (STOCK_PRICE_WITH_FIRST_QUEUE_SERVICE == (byte) serviceCode) {
                return new StockHandlerWithFirstQueue(tradingMessage);

            } else if (MESSAGE_LIST_SERVICE == (byte) serviceCode
                    || MESSAGE_DETAILS_SERVICE == (byte) serviceCode) {
                return new MessageHandler(tradingMessage);

            } else if (BROKER_LIST_SERVICE == (byte) serviceCode) {
                return new BrokerListHandler(tradingMessage);

                //added by alizadeh
            } else if (FINANCIAL_PROVIDER_SERVICE == (byte) serviceCode) {
                return new FinancialProviderHandler(tradingMessage);

            } else if (STOCK_BASKET_SERVICE == (byte) serviceCode) {
                return new StockBasketHandler(tradingMessage);
            }
            //added by alizadeh
            else if (ADD_ORDER_WITH_FINANCIAL_SERVICE == (byte) serviceCode || ORDER_LIST_WITH_FINACIAL_SERVICE == (byte) serviceCode) {
                return new OrderWithFinancialHandler(tradingMessage);
            }
            //added by alizadeh
            else if (MODIFY_ORDER_WITH_FINANCIAL_SERVICE == (byte) serviceCode) {
                return new OrderWithFinancialHandler(tradingMessage);
            }
            //added by alizadeh
        } else if (STOCK_PRICE_WITH_FIRST_QUEUE_SERVICE == (byte) serviceCode) {
            return new StockHandlerWithFirstQueue(tradingMessage);
        }




        return null;

    }

    public abstract TradingMessage handleRequest() throws Exception;

    public void closeSocket(OutputStream out, InputStream is, TradingMessage tradingMessage) {
        logger.debug("Close socket conection.");

        try {
            if (!requestSocket.isClosed()) {
                byte[] finalResponse = null;
                if (tradingMessage != null)
                    finalResponse = tradingMessage.getFinalResponse();

                if (finalResponse != null)
                    out.write(finalResponse);

                out.close();
                is.close();
                requestSocket.close();
            }

        } catch (IOException e) {
            logger.debug("An exception durring closeing socket is occurred.");
            logger.info(e.getMessage());
            e.printStackTrace();
        }
    }

    private static byte[] createFatalErrorMessage(TradingMessage tradingMessage, String serverErrorCode) {

        byte[] retVal;
        if (serverErrorCode == null) {
            retVal = ByteUtil.convertStringToByteArray("NO_CONNECTION_TO_SERVER");
            tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
            tradingMessage.setFlags((byte) 0x00);

        } else {
            // trading responsecode and flags have been set before
            retVal = ByteUtil.convertStringToByteArray(serverErrorCode);

        }

        byte[] buffer = new byte[retVal.length + 2];
        int index = 0;

        System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, index, 2);
        System.arraycopy(retVal, 0, buffer, 2, retVal.length);
        return buffer;

    }

}