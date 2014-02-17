package com.sefryek.broker.webservice;

//
//import com.sefryek.broker.webservice.mobilev2.WsOrderMessage;
//import com.sefryek.broker.webservice.mobilev2.holders.WsOrderMessageHolder;
import com.sefryek.broker.webservice.mobilev7.holders.WsOrderMessageHolder;
import com.sefryek.broker.webservice.mobilev7.holders.WsOrderMessageWithFinancialHolder;
import com.sefryek.broker.webservice.mobilev7.*;
import com.sefryek.broker.webservice.mobilev7.holders.WsOrderMessageWithFinancialHolder;
import net.sf.cglib.core.Local;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;

import javax.xml.rpc.ServiceException;
import javax.xml.rpc.holders.IntHolder;

import com.sefryek.broker.utils.*;
import com.sefryek.broker.utils.convertingDateUtil.GregorianCalendar;
import com.sefryek.broker.utils.convertingDateUtil.Calendar;
import com.sefryek.broker.utils.sessionUtils.SessionFactory;
import com.sefryek.broker.state.TradingMessage;
import com.sefryek.broker.mobileHandler.MIDletConstant;

import java.io.*;
import java.rmi.RemoteException;
import java.util.*;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: Mahta
 * Date: Jul 19, 2011
 * Time: 10:12:46 AM
 */
public class RequestManager {
    private static Logger logger = Logger.getLogger(RequestManager.class);

    private static int LoginResponseFixLength = 35;
    private static int ServerTime = 4;
    private static int CustomerId = 4;
    private static int RealBalance = 5;
    private static int BlockBalance = 5;

    private static int BourseCode = 6;
    private static int OpenMarketTime = 2;
    private static int CloseMarketTime = 2;
    private static int MinimumOrderCountForBuy = 2;
    private static int MinimumOrderCountForSell = 2;

    public static int TotalRowCount = 2;
    public static int PageRowCount = 1;
    public static int ResposneItemLength = 1;
    public static int OrderListResposneItemLength = 33;
    public static int OrderListWithFinancialResposneItemLength = 39;

    public static int OrderId = 5;
    public static int Symbol = 12;
    public static int State = 1;
    public static int OrderQuantiy = 3;
    public static int ExcutedAmount = 3;
    public static int OrderPrice = 4;
    //added by alizadeh
    public static int FinancialId = 4;
    public static int OrderValidityDate = 2;
    public static int LanguageLenght = 1;
//    public static int EnglishNameLenght = 1;
//    public static int ArabicNameLenght = 1;
    public static int CustomerTurnoverListLength = 23;

    public static int VoucherType = 1;
    public static int VoucherNo = 4;
    public static int Balance = 5;
    public static int VoucherDate = 2;
    public static int Debitor = 5;
    public static int Creditor = 5;
    public static int DescLength = 1;

    //    public static final String USER_NAME = "mobilewebservice";
    //    public static final String PASSWORD = "ws100";
    public WS_MobileV3Soap_BindingStub binding = null;
//    public com.sefryek.broker.webservice.mobilev2.WS_MobileV2Soap_BindingStub oldBinding = null;

    public static enum OrderListType {
        ORDER_LIST,
        ORDER_BOOK
    }

    public RequestManager(int brokerCode) {
        try {
            binding = (WS_MobileV3Soap_BindingStub) new WS_MobileV3Locator().getWS_MobileV3Soap();
            binding.setMaintainSession(true);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

//    //old version
//    public RequestManager(int brokerId) {
//        try {
//            oldBinding = (com.sefryek.broker.webservice.mobilev2.WS_MobileV2Soap_BindingStub) new com.sefryek.broker.webservice.mobilev2.WS_MobileV2Locator().getWS_MobileV2Soap("" + brokerId);
//            oldBinding.setMaintainSession(true);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//    }


    public byte[] login(String usernme, String password, TradingMessage tradingMessage, int brokerCode) {
        logger.info("Start of calling login web service with customer usernme and password.");

        try {
            if (binding == null)
                throw new ServiceException();

            //Validate username and password
            WsPersonInfo personInfo = binding.login(usernme, password);

            if (personInfo != null) {

                logger.info("person info is not null.");
                byte[] isinCodes = ByteUtil.convertStringToByteArray(personInfo.getIsinCodes());
                int IsinCode = isinCodes.length;

                //set the output array size
                byte[] buffer = new byte[LoginResponseFixLength + IsinCode + 1];
                byte setting = 0;
                int index = 0;

                // Server time length is 4 byte
                String servetDate = DateUtil.convertMiladiToShamsi(new Date());
                String serverTime = DateUtil.GetStringTime(new Date());
                logger.info("The server date and time when device is logging is :" + (servetDate + " " + serverTime));
                byte[] serverDateTime = DateUtil.parseJalaliDateToFourByte(servetDate.replaceAll("-", ""), serverTime);
                Date date = DateUtil.convertByteArrayToFullMiladiDate(serverDateTime);
                logger.info("The server date and time when device is logging is :" + (DateUtil.getFormattedDate(date, DateUtil.Pattern.YYYY_MM_DD_HH_MM_SS)));

                System.arraycopy(serverDateTime, 0, buffer, index, ServerTime);
                index += ServerTime;

                byte permission = 31;
                buffer[index++] = permission;

                System.arraycopy(ByteUtil.intToFourByte(personInfo.getCustomerId()), 0, buffer, index, CustomerId);
                index += CustomerId;

                buffer[index++] = (byte) IsinCode;


                Double realBalanceValue = personInfo.getRemain().getRealBalance();
                byte[] array = ByteUtil.longToFiveByte(Math.abs(realBalanceValue.longValue()));
                System.arraycopy(array, 0, buffer, index, RealBalance);
                index += RealBalance;
                if (realBalanceValue < 0) {
                    buffer[index++] = 1;
                } else {
                    buffer[index++] = 0;

                }

                Double blockedValue = personInfo.getRemain().getBlockedBalance();
                byte[] blockedBalanceArray = ByteUtil.longToFiveByte(blockedValue.longValue());
                System.arraycopy(blockedBalanceArray, 0, buffer, index, BlockBalance);
                index += BlockBalance;

                byte[] bourseCodeBytes = BourseEncoders.convertBourseCodeToByte(personInfo.getBourseCodes());
                System.arraycopy(bourseCodeBytes, 0, buffer, index, BourseCode);
                index += BourseCode;
                logger.info("Replacing bourse code successfully");

                MobileOMSSetting omsSetting = binding.getSetting();
                if (omsSetting.isActiveRightForBuy())
                    setting += 128;

                setting++;
                buffer[index++] = setting;

                System.arraycopy(ByteUtil.parseTimeToByte(omsSetting.getMarketOpenTime()), 0, buffer, index,
                        OpenMarketTime);
                index += OpenMarketTime;

                System.arraycopy(ByteUtil.parseTimeToByte(omsSetting.getMarketCloseTime()), 0, buffer, index,
                        CloseMarketTime);
                index += CloseMarketTime;

                System.arraycopy(ByteUtil.shortToBytes(omsSetting.getMinimumOrderCountForBuy()), 0, buffer, index,
                        MinimumOrderCountForBuy);
                index += MinimumOrderCountForBuy;

                System.arraycopy(ByteUtil.shortToBytes(omsSetting.getMinimumOrderCountForSell()), 0, buffer, index,
                        MinimumOrderCountForSell);
                index += MinimumOrderCountForSell;


                System.arraycopy(isinCodes, 0, buffer, index, IsinCode);

                tradingMessage.setResponseCode(MIDletConstant.SUCCESSFUL_OPERATION);
                tradingMessage.setFlags((byte) 0x00);
                logger.info("Setting flag successfuly");


                // initialize Session for this user
                SessionFactory factory = SessionFactory.getInstance();
                // generate random session id which has used by broker id and customer id
                String sessionId = MathUtil.randomString(8);

                byte[] sessionIdByte = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
                try {
                    sessionIdByte = sessionId.getBytes("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    logger.info("Sessoin id has not supported format - " + sessionId);
                }
                tradingMessage.setSessionId(sessionIdByte);

                logger.info("before initializing session");
                factory.initializeSession("" + brokerCode, "" + personInfo.getCustomerId(), sessionId, this, TradingMessage.encryptionKey);
                logger.info("after initializing session");

                return buffer;
            }

        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            byte[] retVal = ByteUtil.convertStringToByteArray("NO_CONNECTION_TO_SERVER");

            tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
            tradingMessage.setFlags((byte) 0x00);

            byte[] buffer = new byte[retVal.length + 2];
            int index = 0;

            System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, index, 2);
            System.arraycopy(retVal, 0, buffer, 2, retVal.length);
            return buffer;

        } catch (RemoteException e) {

            //Set error for login error
            byte[] retVal;
            if (e.getMessage().indexOf("LoginFailed") > 0) {
                String ret = "login_1000";
                tradingMessage.setResponseCode(MIDletConstant.SERVER_ERROR);
                tradingMessage.setFlags((byte) 0x00);
                retVal = ByteUtil.convertStringToByteArray(ret);

            } else if (e.getMessage().indexOf("UserNotApproved") > 0) {
                String ret = "login_1003";
                //comment for new version for error code
                //_header.ResponseCode = Convert.ToByte(ret);

                tradingMessage.setResponseCode(MIDletConstant.SERVER_ERROR);
                tradingMessage.setFlags((byte) 0x00);
                retVal = ByteUtil.convertStringToByteArray(ret);

            } else {
                logger.error("RemoteException is caught", e);

                retVal = ByteUtil.convertStringToByteArray("NO_CONNECTION_TO_SERVER");

                tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
                tradingMessage.setFlags((byte) 0x00);

            }

            if (retVal != null) {
                byte[] buffer = new byte[retVal.length + 2];
                int index = 0;

                System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, index, 2);
                System.arraycopy(retVal, 0, buffer, 2, retVal.length);
                return buffer;
            }
        }

        return null;
    }


    public byte[] addOrder(TradingMessage tradingMessage, int brokerCode,
                           String nscCode, byte status, int orderTotalQuantity, int orderPrice,
                           int minimumQuantity, int maxShown, byte[] orderValidity, int customerCode,
                           String isdn) {

        try {
            if (binding == null)
                throw new ServiceException();


            // send order message request but before it, we should set loging cookie for authorize user
            // so get the cookie from first login, if it is null, log in again and update login cookie in user session bject
            WsOrderMessage orderMessage = ConvertOrderToWsOrderMessage(brokerCode, nscCode, status,
                    orderTotalQuantity, orderPrice, minimumQuantity, maxShown, orderValidity, customerCode, isdn);

            WsOrderMessageHolder holder = new WsOrderMessageHolder(orderMessage);

            String returnVal = binding.addOrder(holder);


            if (returnVal == null) {
                return createFatalErrorMessage(tradingMessage, null);

            } else if (returnVal.trim().isEmpty() && holder.value.getId() != null) {
                tradingMessage.setResponseCode(MIDletConstant.SUCCESSFUL_OPERATION);
                tradingMessage.setFlags((byte) 0);

                byte[] orderResponse = new byte[6];

                long id = holder.value.getId();
                String orderState = holder.value.getOrderState().getValue();

                // Send order response to mobile woth format : status(1 byte) and order id(5 byte)
                orderResponse[0] = getOrderStatus(orderState);
                System.arraycopy(ByteUtil.longToFiveByte(id), 0, orderResponse, 1, 5);

                return orderResponse;

            } else {

                if (returnVal.toLowerCase().startsWith("oms_5000|"))
                    returnVal = returnVal.replaceAll("oms_5000|", "");

                tradingMessage.setResponseCode(MIDletConstant.SERVER_ERROR);
                tradingMessage.setFlags((byte) 0);

                byte[] retVal = ByteUtil.convertStringToByteArray(returnVal);
                byte[] retbuffer = new byte[retVal.length + 2];

                System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, retbuffer, 0, 2);
                System.arraycopy(retVal, 0, retbuffer, 2, retVal.length);
                return retbuffer;

            }  // end of else


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage, null);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(e.getMessage());
            logger.error(Constants.getStackTrace(e));

            String serverErrorCode;
            if (e.getMessage().indexOf("OMS_") > 0) {
                serverErrorCode = e.getMessage().trim();
                tradingMessage.setResponseCode(MIDletConstant.SERVER_ERROR);
                tradingMessage.setFlags((byte) 0x00);
            } else {
                serverErrorCode = "sendOrder";
                tradingMessage.setResponseCode(MIDletConstant.SERVER_ERROR);
                tradingMessage.setFlags((byte) 0x00);
            }

            return createFatalErrorMessage(tradingMessage, serverErrorCode);
        }

    }


    //added by alizadeh
    public byte[] addOrderWithFinancial(TradingMessage tradingMessage, int brokerCode,
                                        String nscCode, int financialId, byte status, int orderTotalQuantity, int orderPrice,
                                        int minimumQuantity, int maxShown, byte[] orderDate, byte[] orderValidityDate, byte orderValidityType, int customerCode,
                                        int isdnLenght, String isdn) {

        try {
            if (binding == null)
                throw new ServiceException();


            // send order message request but before it, we should set loging cookie for authorize user
            // so get the cookie from first login, if it is null, log in again and update login cookie in user session bject
            WsOrderMessageWithFinancial orderMessage = ConvertOrderToWsOrderMessageWithFinancial(brokerCode, nscCode, financialId, status,
                    orderTotalQuantity, orderPrice, minimumQuantity, maxShown, orderDate, orderValidityDate, orderValidityType, customerCode, isdn);

            WsOrderMessageWithFinancialHolder holder = new WsOrderMessageWithFinancialHolder(orderMessage);

            WsOrderActionResponse returnVal = binding.addOrderWithFinancial(holder);


            if (returnVal == null) {
                return createFatalErrorMessage(tradingMessage, null);

            } else if (returnVal.isIsSuccesful()) {
                tradingMessage.setResponseCode(MIDletConstant.SUCCESSFUL_OPERATION);
                tradingMessage.setFlags((byte) 0);

                byte[] orderResponse = new byte[6];

                long id = holder.value.getId();
                String orderState = holder.value.getOrderState().getValue();

                // Send order response to mobile woth format : status(1 byte) and order id(5 byte)
                orderResponse[0] = getOrderStatus(orderState);
                System.arraycopy(ByteUtil.longToFiveByte(id), 0, orderResponse, 1, 5);

                return orderResponse;

            } else {
//
//                if (returnVal.toLowerCase().startsWith("oms_5000|"))
//                    returnVal = returnVal.replaceAll("oms_5000|", "");

                tradingMessage.setResponseCode(MIDletConstant.SERVER_ERROR);
                tradingMessage.setFlags((byte) 0);

                byte[] retVal = ByteUtil.convertStringToByteArray(returnVal.getErrorDescription());
                byte[] retbuffer = new byte[retVal.length + 2];

                System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, retbuffer, 0, 2);
                System.arraycopy(retVal, 0, retbuffer, 2, retVal.length);
                return retbuffer;

            }  // end of else


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage, null);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(e.getMessage());
            logger.error(Constants.getStackTrace(e));

            String serverErrorCode;
            if (e.getMessage().indexOf("OMS_") > 0) {
                serverErrorCode = e.getMessage().trim();
                tradingMessage.setResponseCode(MIDletConstant.SERVER_ERROR);
                tradingMessage.setFlags((byte) 0x00);
            } else {
                serverErrorCode = "sendOrder";
                tradingMessage.setResponseCode(MIDletConstant.SERVER_ERROR);
                tradingMessage.setFlags((byte) 0x00);
            }

            return createFatalErrorMessage(tradingMessage, serverErrorCode);
        }

    }

    //added by alizadeh
    public byte[] modifyOrderWithFinancial(TradingMessage tradingMessage, int brokerCode,
                                        String nscCode, int financialId, long orderId, byte status, int orderTotalQuantity, int orderPrice,
                                        int minimumQuantity, int maxShown, byte[] orderDate, byte[] orderValidityDate, int customerCode,
                                        int isdnLenght, String isdn) {

        try {
            if (binding == null)
                throw new ServiceException();


            // send order message request but before it, we should set loging cookie for authorize user
            // so get the cookie from first login, if it is null, log in again and update login cookie in user session bject
            WsOrderMessageWithFinancial orderMessage = ConvertOrderToWsOrderMessageWithFinancial(brokerCode, nscCode, financialId, orderId, status,
                    orderTotalQuantity, orderPrice, minimumQuantity, maxShown, orderDate, orderValidityDate, customerCode, isdn);

            WsOrderMessageWithFinancialHolder holder = new WsOrderMessageWithFinancialHolder(orderMessage);

            WsOrderActionResponse returnVal = binding.modifyOrder(holder);


            if (returnVal == null) {
                return createFatalErrorMessage(tradingMessage, null);

            } else if (returnVal.isIsSuccesful()) {
                tradingMessage.setResponseCode(MIDletConstant.SUCCESSFUL_OPERATION);
                tradingMessage.setFlags((byte) 0);

                byte[] orderResponse = new byte[6];

                long id = holder.value.getId();
                String orderState = holder.value.getOrderState().getValue();

                // Send order response to mobile woth format : status(1 byte) and order id(5 byte)
                orderResponse[0] = getOrderStatus(orderState);
                System.arraycopy(ByteUtil.longToFiveByte(id), 0, orderResponse, 1, 5);

                return orderResponse;

            } else {

                tradingMessage.setResponseCode(MIDletConstant.SERVER_ERROR);
                tradingMessage.setFlags((byte) 0);

                byte[] retVal = ByteUtil.convertStringToByteArray(returnVal.getErrorDescription());
                byte[] retbuffer = new byte[retVal.length + 2];

                System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, retbuffer, 0, 2);
                System.arraycopy(retVal, 0, retbuffer, 2, retVal.length);
                return retbuffer;

            }  // end of else


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage, null);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(e.getMessage());
            logger.error(Constants.getStackTrace(e));

            String serverErrorCode;
            if (e.getMessage().indexOf("OMS_") > 0) {
                serverErrorCode = e.getMessage().trim();
                tradingMessage.setResponseCode(MIDletConstant.SERVER_ERROR);
                tradingMessage.setFlags((byte) 0x00);
            } else {
                serverErrorCode = "sendOrder";
                tradingMessage.setResponseCode(MIDletConstant.SERVER_ERROR);
                tradingMessage.setFlags((byte) 0x00);
            }

            return createFatalErrorMessage(tradingMessage, serverErrorCode);
        }

    }

        //added by alizadeh
    public byte[] getFinancialProvider(TradingMessage tradingMessage, int brokerCode, int customerCode) {

        try {
            if (binding == null)
                throw new ServiceException();


            // send order message request but before it, we should set loging cookie for authorize user
            // so get the cookie from first login, if it is null, log in again and update login cookie in user session bject
//            WsOrderMessageWithFinancial orderMessage = ConvertOrderToWsOrderMessageWithFinancial(brokerCode, customerCode);
//
//            WsOrderMessageWithFinancialHolder holder = new WsOrderMessageWithFinancialHolder(orderMessage);

            MobileFinancialData[] returnVal = binding.getFinancialProviders();


            if (returnVal == null) {
                return createFatalErrorMessage(tradingMessage, null);

            } else {
                tradingMessage.setResponseCode(MIDletConstant.SUCCESSFUL_OPERATION);
                tradingMessage.setFlags((byte) 0);
                byte numberOfAccounts = (byte) returnVal.length;
                 int index = 0;

                ByteArrayOutputStream byteArray = new ByteArrayOutputStream()  ;
                DataOutputStream dos = new DataOutputStream(byteArray);


                try {
                    dos.write(numberOfAccounts);
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                for (int i = 0; i < numberOfAccounts; i++) {

//                    System.arraycopy(ByteUtil.intToFourByte(returnVal[i].getFinancialId()) , 0, financialProviderBytes, index, FinancialId);
//                    index += FinancialId;

                    try {

                        dos.write(ByteUtil.intToFourByte(returnVal[i].getFinancialId()));
                        NameData names[] = returnVal[i].getNames();
                        
                        byte[] persianName = null;
                        byte[] englishName = null;
                        byte[] arabicName = null;
                        
                        int number = returnVal[i].getNames().length;
                        for(int lan = 0 ; lan < number ; lan++) {
                            if (names[lan].getLan().equals("fa")){
                                persianName = names[lan].getName().getBytes("UTF-8");
                                
                                    
                            } else if( names[lan].getLan().equals("en")){
                                englishName = names[lan].getName().getBytes("UTF-8");
                                
                            } else {
                                if( names[lan].getLan().equals("ar") ){
                                    arabicName = names[lan].getName().getBytes("UTF-8");

                                }
                            }
                        }
                        if (persianName != null) {
                            dos.write(persianName.length);
                            dos.write(persianName);
                        } else {
                            dos.write(0);

                        }
                        if (englishName != null) {
                            dos.write(englishName.length);
                            dos.write(englishName);
                        } else
                            dos.write(0);
                        if (arabicName != null) {
                            dos.write(arabicName.length);
                            dos.write(arabicName);
                        } else
                            dos.write(0);


                        
//                        int nameSeq = 0;
//                        for( int lan = 0 ; lan < number ; lan++ ){
//
//
//                             dos.write(names[nameSeq].getName().getBytes("UTF-8").length);
//                             dos.write(names[nameSeq].getName().getBytes("UTF-8"));
//                             nameSeq++;

//                    }

                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } 
                
                }
//                Byte[] bytesArray = financialProviderBytes.toArray(new Byte[financialProviderBytes.size()]);
                try {
                    dos.flush();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                return byteArray.toByteArray();
            }


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage, null);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(e.getMessage());
            logger.error(Constants.getStackTrace(e));

            String serverErrorCode;
            if (e.getMessage().indexOf("OMS_") > 0) {
                serverErrorCode = e.getMessage().trim();
                tradingMessage.setResponseCode(MIDletConstant.SERVER_ERROR);
                tradingMessage.setFlags((byte) 0x00);
            } else {
                serverErrorCode = "sendOrder";
                tradingMessage.setResponseCode(MIDletConstant.SERVER_ERROR);
                tradingMessage.setFlags((byte) 0x00);
            }

            return createFatalErrorMessage(tradingMessage, serverErrorCode);
        }

    }

    //added by alizadeh
    public byte[] getCustomerCdsPortfolio(TradingMessage tradingMessage, int brokerCode, int customerCode) {

        try {
            if (binding == null)
                throw new ServiceException();


            WsCdsPortfolio[] returnVal = binding.getCustomerCdsPortfolio();


            if (returnVal == null) {
                return createFatalErrorMessage(tradingMessage, null);
            } else {

                tradingMessage.setResponseCode(MIDletConstant.SUCCESSFUL_OPERATION);
                tradingMessage.setFlags((byte) 0);
                byte numberOfStocks = (byte) returnVal.length;


                byte[] portfolio = new byte[1 + (numberOfStocks * (16))];

                int index = 0;
                portfolio[index++] = numberOfStocks;

                for (int i = 0; i < numberOfStocks; i++) {
                    System.arraycopy(ByteUtil.convertStringToByteArray(returnVal[i].getSymbolISIN()), 0, portfolio, index, 12);
                        index += 12;
                    System.arraycopy(ByteUtil.intToFourByte((int)returnVal[i].getCount()), 0, portfolio, index, 4);
                        index += 4;
            }
                return portfolio;
            }

        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage, null);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(e.getMessage());
            logger.error(Constants.getStackTrace(e));

            String serverErrorCode;
            if (e.getMessage().indexOf("OMS_") > 0) {
                serverErrorCode = e.getMessage().trim();
                tradingMessage.setResponseCode(MIDletConstant.SERVER_ERROR);
                tradingMessage.setFlags((byte) 0x00);
            } else {
                serverErrorCode = "sendOrder";
                tradingMessage.setResponseCode(MIDletConstant.SERVER_ERROR);
                tradingMessage.setFlags((byte) 0x00);
            }

            return createFatalErrorMessage(tradingMessage, serverErrorCode);
        }
    }

    //added by alizadeh
    public static WsOrderMessageWithFinancial ConvertOrderToWsOrderMessageWithFinancial(int brokerCode,
                                                                                        int customerCode) {
        WsOrderMessageWithFinancial wsOrderMessage = new WsOrderMessageWithFinancial();

        wsOrderMessage.setBrokerId(brokerCode);
        wsOrderMessage.setCustomerId(customerCode);

        return wsOrderMessage;


    }

    //added by alizadeh
    public static WsOrderMessageWithFinancial ConvertOrderToWsOrderMessageWithFinancial(int brokerCode, String nscCode, int financialId, long orderId,
                                                                                        byte status, int orderTotalQuantity,
                                                                                        int orderPrice, int minimumQuantity,
                                                                                        int maxShown, byte[] orderDate, byte[] orderValidityDate,
                                                                                        int customerCode, String isdn) {
        WsOrderMessageWithFinancial wsOrderMessage = new WsOrderMessageWithFinancial();
        wsOrderMessage.setBrokerId(brokerCode);

        ExchangeSymbols exchangeSymbols = new ExchangeSymbols();
        exchangeSymbols.setNSCCode(nscCode);
        exchangeSymbols.setSymbolsState(ExchangeSymbolsStateEnum.Authorized);   // todo
        exchangeSymbols.setGroupState(GroupStateEnum.Continuous_Trading);       // todo
        exchangeSymbols.setMarketType(MarketType.None);
        wsOrderMessage.setFinancialId(financialId);
        wsOrderMessage.setExchangeSymbols(exchangeSymbols);
        wsOrderMessage.setOrderEntryDate(ByteUtil.twoByteToDate(orderDate));
        wsOrderMessage.setOrderPrice(Globals.SafeBigDecimal(orderPrice, -1));
        wsOrderMessage.setOrderTotalQuantity(orderTotalQuantity);

        int tmp = status;
        tmp &= 1;
        if (tmp == 1)
            wsOrderMessage.setOrderSide(WsOrderSide.Sell);
        else if (tmp == 0)
            wsOrderMessage.setOrderSide(WsOrderSide.Buy);
        else
            wsOrderMessage.setOrderSide(WsOrderSide.None);

        tmp = status;
        tmp = (tmp >> 3) & 7;

        if (tmp == -1)
            wsOrderMessage.setOrderType(WsOrderType.None);
        else if (tmp == 1)
            wsOrderMessage.setOrderType(WsOrderType.LimiteOrder);
        else if (tmp == 2)
            wsOrderMessage.setOrderType(WsOrderType.Market_on_Opening_order);
        else if (tmp == 3)
            wsOrderMessage.setOrderType(WsOrderType.Market_Order);
        else if (tmp == 4)
            wsOrderMessage.setOrderType(WsOrderType.Stop_Order);
        else if (tmp == 5)
            wsOrderMessage.setOrderType(WsOrderType.Market_to_Limit_order);
        else
            wsOrderMessage.setOrderType(WsOrderType.LimiteOrder);

        wsOrderMessage.setOrderState(OrderState.OnSending);             // todo: ask

        wsOrderMessage.setOrderValidity(74);
        // server request


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        String servetDate = DateUtil.convertMiladiToShamsi(calendar.getTime());
        byte[] serverDateTime = ByteUtil.persianDateToTwoByte(servetDate);

        wsOrderMessage.setOrderValidityDate(ByteUtil.twoByteToDate(orderValidityDate));
        wsOrderMessage.setTriggerPrice(BigDecimal.valueOf(0));
        wsOrderMessage.setMinimumQuantity(minimumQuantity);
        wsOrderMessage.setMaxShown(maxShown);

        wsOrderMessage.setIsinCode(isdn);
        wsOrderMessage.setCustomerId(customerCode);
        wsOrderMessage.setParentId(orderId);

        return wsOrderMessage;


    }

    //added by alizadeh
    public static WsOrderMessageWithFinancial ConvertOrderToWsOrderMessageWithFinancial(int brokerCode, String nscCode, int financialId,
                                                                                        byte status, int orderTotalQuantity,
                                                                                        int orderPrice, int minimumQuantity,
                                                                                        int maxShown, byte[] orderDate, byte[] orderValidityDate,
                                                                                        byte orderValidityType, int customerCode, String isdn) {
        WsOrderMessageWithFinancial wsOrderMessage = new WsOrderMessageWithFinancial();
        wsOrderMessage.setBrokerId(brokerCode);

        ExchangeSymbols exchangeSymbols = new ExchangeSymbols();
        exchangeSymbols.setNSCCode(nscCode);
        exchangeSymbols.setSymbolsState(ExchangeSymbolsStateEnum.Authorized);   // todo
        exchangeSymbols.setGroupState(GroupStateEnum.Continuous_Trading);       // todo
        exchangeSymbols.setMarketType(MarketType.None);
        wsOrderMessage.setFinancialId(financialId);
        wsOrderMessage.setExchangeSymbols(exchangeSymbols);
        wsOrderMessage.setOrderEntryDate(ByteUtil.twoByteToDate(orderDate));
        wsOrderMessage.setOrderPrice(Globals.SafeBigDecimal(orderPrice, -1));
        wsOrderMessage.setOrderTotalQuantity(orderTotalQuantity);

        int tmp = status;
        tmp &= 1;
        if (tmp == 1)
            wsOrderMessage.setOrderSide(WsOrderSide.Sell);
        else if (tmp == 0)
            wsOrderMessage.setOrderSide(WsOrderSide.Buy);
        else
            wsOrderMessage.setOrderSide(WsOrderSide.None);

        tmp = status;
        tmp = (tmp >> 3) & 7;

        if (tmp == -1)
            wsOrderMessage.setOrderType(WsOrderType.None);
        else if (tmp == 1)
            wsOrderMessage.setOrderType(WsOrderType.LimiteOrder);
        else if (tmp == 2)
            wsOrderMessage.setOrderType(WsOrderType.Market_on_Opening_order);
        else if (tmp == 3)
            wsOrderMessage.setOrderType(WsOrderType.Market_Order);
        else if (tmp == 4)
            wsOrderMessage.setOrderType(WsOrderType.Stop_Order);
        else if (tmp == 5)
            wsOrderMessage.setOrderType(WsOrderType.Market_to_Limit_order);
        else
            wsOrderMessage.setOrderType(WsOrderType.LimiteOrder);


        wsOrderMessage.setOrderState(OrderState.OnSending);             // todo: ask

        wsOrderMessage.setOrderValidity(orderValidityType);
        // server request


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        String servetDate = DateUtil.convertMiladiToShamsi(calendar.getTime());
        byte[] serverDateTime = ByteUtil.persianDateToTwoByte(servetDate);

        wsOrderMessage.setOrderValidityDate(ByteUtil.twoByteToDate(orderValidityDate));
        wsOrderMessage.setTriggerPrice(BigDecimal.valueOf(0));
        wsOrderMessage.setMinimumQuantity(minimumQuantity);
        wsOrderMessage.setMaxShown(maxShown);

        wsOrderMessage.setIsinCode(isdn);
        wsOrderMessage.setCustomerId(customerCode);

        return wsOrderMessage;


    }


    public static WsOrderMessage ConvertOrderToWsOrderMessage(int brokerCode, String nscCode,
                                                              byte status, int orderTotalQuantity,
                                                              int orderPrice, int minimumQuantity,
                                                              int maxShown, byte[] orderValidity,
                                                              int customerCode, String isdn) {
        WsOrderMessage wsOrderMessage = new WsOrderMessage();
        wsOrderMessage.setBrokerId(brokerCode);

        ExchangeSymbols exchangeSymbols = new ExchangeSymbols();
        exchangeSymbols.setNSCCode(nscCode);
        exchangeSymbols.setSymbolsState(ExchangeSymbolsStateEnum.Authorized);   // todo
        exchangeSymbols.setGroupState(GroupStateEnum.Continuous_Trading);       // todo
        exchangeSymbols.setMarketType(MarketType.None);

        wsOrderMessage.setExchangeSymbols(exchangeSymbols);
//        wsOrderMessage.setOrderEntryDate();
        wsOrderMessage.setOrderPrice(Globals.SafeBigDecimal(orderPrice, -1));
        wsOrderMessage.setOrderTotalQuantity(orderTotalQuantity);

        int tmp = status;
        tmp &= 1;
        if (tmp == 1)
            wsOrderMessage.setOrderSide(WsOrderSide.Sell);
        else if (tmp == 0)
            wsOrderMessage.setOrderSide(WsOrderSide.Buy);
        else
            wsOrderMessage.setOrderSide(WsOrderSide.None);

        tmp = status;
        tmp = (tmp >> 3) & 7;

        if (tmp == -1)
            wsOrderMessage.setOrderType(WsOrderType.None);
        else if (tmp == 1)
            wsOrderMessage.setOrderType(WsOrderType.LimiteOrder);
        else if (tmp == 2)
            wsOrderMessage.setOrderType(WsOrderType.Market_on_Opening_order);
        else if (tmp == 3)
            wsOrderMessage.setOrderType(WsOrderType.Market_Order);
        else if (tmp == 4)
            wsOrderMessage.setOrderType(WsOrderType.Stop_Order);
        else if (tmp == 5)
            wsOrderMessage.setOrderType(WsOrderType.Market_to_Limit_order);
        else
            wsOrderMessage.setOrderType(WsOrderType.LimiteOrder);

        wsOrderMessage.setOrderState(OrderState.OnSending);             // todo: ask

        wsOrderMessage.setOrderValidity(74);
        // server request


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        String servetDate = DateUtil.convertMiladiToShamsi(calendar.getTime());
        byte[] serverDateTime = ByteUtil.persianDateToTwoByte(servetDate);

        wsOrderMessage.setOrderValidityDate(ByteUtil.twoByteToDate(serverDateTime));
        wsOrderMessage.setTriggerPrice(BigDecimal.valueOf(0));
        wsOrderMessage.setMinimumQuantity(minimumQuantity);
        wsOrderMessage.setMaxShown(maxShown);

        wsOrderMessage.setIsinCode(isdn);
        wsOrderMessage.setCustomerId(customerCode);

        return wsOrderMessage;


    }

    public byte[] cancelOrder(TradingMessage tradingMessage, Long orderId) {

        try {
            if (binding == null)
                throw new ServiceException();

            // send cancel order request
            // send order message request but before it, we should set loging cookie for authorize user
            // so get the cookie from first login, if it is null, log in again and update login cookie in user session bject
            String returnVal = binding.cancelOrder(orderId.intValue());

            // return only response code
            tradingMessage.setFlags((byte) 0);
            if (returnVal == null || returnVal.trim().isEmpty()) {
                tradingMessage.setResponseCode(MIDletConstant.SUCCESSFUL_OPERATION);
                return null;

            } else {
                tradingMessage.setResponseCode(MIDletConstant.SERVER_ERROR);
                tradingMessage.setFlags((byte) 0x00);
                return createFatalErrorMessage(tradingMessage, returnVal);
            }

        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage, null);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(Constants.getStackTrace(e));

            String serverErrorCode = null;
            if (e.getMessage().indexOf("OMS_") > 0) {
                serverErrorCode = e.getMessage().trim();
                tradingMessage.setResponseCode(MIDletConstant.SERVER_ERROR);
                tradingMessage.setFlags((byte) 0x00);
            }

            return createFatalErrorMessage(tradingMessage, serverErrorCode);

        } // End of catch

    }


    public byte[] orderList(TradingMessage tradingMessage, OrderListType orderListType, int brokerCode,
                            int customerCode, int pageIndex, int pageSize) {
        try {
            if (binding == null)
                throw new ServiceException();

            WsOrderMessage[] wsOrderMessages;
            int totalRow = 0;

            if (orderListType == OrderListType.ORDER_LIST) {
                wsOrderMessages = binding.getOrderList(customerCode, pageIndex, pageSize, new IntHolder(totalRow));
                totalRow = wsOrderMessages.length;

            } else {
                wsOrderMessages = binding.getOrderBook(customerCode, pageIndex, pageSize, new IntHolder(totalRow));
                totalRow = wsOrderMessages.length;
            }

            int count = pageSize;
            if (pageSize > totalRow)
                count = totalRow;

            if (wsOrderMessages.length > 0) {
                byte[] buffer = new byte[count * OrderListResposneItemLength + PageRowCount +
                        OrderListResposneItemLength + ResposneItemLength];

                int index = 0;
                System.arraycopy(ByteUtil.shortToBytes(totalRow), 0, buffer, index, TotalRowCount);
                index += TotalRowCount;

                buffer[index++] = (byte) wsOrderMessages.length;
                buffer[index++] = (byte) OrderListResposneItemLength;

                for (WsOrderMessage message : wsOrderMessages) {
                    System.arraycopy(ByteUtil.longToFiveByte(message.getId()), 0, buffer, index, OrderId);
                    index += OrderId;

                    System.arraycopy(ByteUtil.convertStringToByteArray(message.getExchangeSymbols().getNSCCode()), 0,
                            buffer, index, Symbol);
                    index += Symbol;

                    byte tmp = 0;
                    if (message.getExchangeSymbols().getSymbolTypeId() == 6)
                        tmp++;
                    if (message.getOrderSide() == WsOrderSide.Sell)
                        tmp += 4;
                    if (message.getHidenOrder() > 0)
                        tmp += 8;

                    buffer[index++] = tmp;

                    System.arraycopy(ByteUtil.intToFourByte(message.getOrderTotalQuantity()), 0, buffer, index, OrderQuantiy);
                    index += OrderQuantiy;
                    System.arraycopy(ByteUtil.intToFourByte(message.getExcutedAmount()), 0, buffer, index, ExcutedAmount);
                    index += ExcutedAmount;
                    System.arraycopy(ByteUtil.intToFourByte(message.getOrderPrice().intValue()), 0, buffer, index, OrderPrice);
                    index += OrderPrice;

                    String orderStatus = message.getOrderState().getValue();

                    tmp = getOrderStatus(orderStatus);
                    buffer[index++] = tmp;

//                    String timeZone = "GMT+3:30";
//                    Date orderEntryDate = DateUtil.changeTimeZoneOfDateToThisZone(message.getOrderEntryDate().getTime(), timeZone);
                    Date orderEntryDate = message.getOrderEntryDate().getTime();
                    String servetDate = DateUtil.convertMiladiToShamsi(orderEntryDate);

                    System.out.println(DateUtil.getFormattedDate(orderEntryDate, DateUtil.Pattern.YYYY_MM_DD_HH_MM_SS));

                    String serverTime = DateUtil.GetStringTime(orderEntryDate);
                    byte[] serverDateTime = DateUtil.parseJalaliDateToFourByte(servetDate.replaceAll("-", ""), serverTime);
                    System.arraycopy(serverDateTime, 0, buffer, index, ServerTime);
                    index += ServerTime;

                }

                tradingMessage.setResponseCode(MIDletConstant.SUCCESSFUL_OPERATION);
                tradingMessage.setFlags((byte) 0x00);

                return buffer;

            } else {
                tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
                tradingMessage.setFlags((byte) 0x00);

                byte[] retVal = ByteUtil.convertStringToByteArray("noorder");
                byte[] buffer = new byte[retVal.length + 2];
                System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, 0, 2);
                System.arraycopy(retVal, 0, buffer, 2, retVal.length);

                return buffer;
            }


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage, null);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage, null);

        }

    }


    public byte[] orderListWithFinancial(TradingMessage tradingMessage, OrderListType orderListType, int brokerCode,
                                         int customerCode, int pageIndex, int pageSize, int reportType) {
        try {
            if (binding == null)
                throw new ServiceException();

            WsOrderMessageWithFinancial[] wsOrderMessages;
            int totalRow = 0;

            if (orderListType == OrderListType.ORDER_LIST) {
                OrderListReport orderListReport = null;
                if( reportType == 2 ){
                    orderListReport  = OrderListReport.fromString( OrderListReport._Orders );

                } else {
                    if( reportType == 3 ){
                        orderListReport  = OrderListReport.fromString( OrderListReport._OpenOrders );

                    }
                }
                wsOrderMessages = binding.getOrderListV2( orderListReport, pageIndex, pageSize, new IntHolder(totalRow) );
                totalRow = wsOrderMessages.length;

            } else {
                wsOrderMessages = binding.getOrderBookV2(customerCode, pageIndex, pageSize, new IntHolder(totalRow));
                totalRow = wsOrderMessages.length;
            }

            int count = pageSize;
            if (pageSize > totalRow)
                count = totalRow;

            if (wsOrderMessages.length > 0) {
                byte[] buffer = new byte[count * OrderListWithFinancialResposneItemLength + PageRowCount +
                        OrderListWithFinancialResposneItemLength + ResposneItemLength];

                int index = 0;
                System.arraycopy(ByteUtil.shortToBytes(totalRow), 0, buffer, index, TotalRowCount);
                index += TotalRowCount;

                buffer[index++] = (byte) wsOrderMessages.length;
                buffer[index++] = (byte) OrderListWithFinancialResposneItemLength;

                for (WsOrderMessageWithFinancial message : wsOrderMessages) {
                    System.arraycopy(ByteUtil.longToFiveByte(message.getId()), 0, buffer, index, OrderId);
                    index += OrderId;

                    System.arraycopy(ByteUtil.convertStringToByteArray(message.getExchangeSymbols().getNSCCode()), 0,
                            buffer, index, Symbol);
                    index += Symbol;

                    System.arraycopy(ByteUtil.intToFourByte(message.getFinancialId()), 0,
                            buffer, index, FinancialId);
                    index += FinancialId;

                    byte tmp = 0;
                    if (message.getExchangeSymbols().getSymbolTypeId() == 6)
                        tmp++;
                    if (message.getOrderSide() == WsOrderSide.Sell)
                        tmp += 4;
                    if (message.getHidenOrder() > 0)
                        tmp += 8;

                    buffer[index++] = tmp;

                    
                    Date orderEntryDate2 = message.getOrderEntryDate().getTime();
                    String orderValidityDate = DateUtil.convertMiladiToShamsi(orderEntryDate2);
                     byte[] ovDate = ByteUtil.persianDateToByte(orderValidityDate);
                    System.arraycopy(ovDate , 0, buffer, index, OrderValidityDate);
                    index += OrderValidityDate;
                    System.arraycopy(ByteUtil.intToFourByte(message.getOrderTotalQuantity()), 0, buffer, index, OrderQuantiy);
                    index += OrderQuantiy;
                    System.arraycopy(ByteUtil.intToFourByte(message.getExcutedAmount()), 0, buffer, index, ExcutedAmount);
                    index += ExcutedAmount;
                    System.arraycopy(ByteUtil.intToFourByte(message.getOrderPrice().intValue()), 0, buffer, index, OrderPrice);
                    index += OrderPrice;

                    String orderStatus = message.getOrderState().getValue();

                    tmp = getOrderStatus(orderStatus);
                    buffer[index++] = tmp;

//                    String timeZone = "GMT+3:30";
//                    Date orderEntryDate = DateUtil.changeTimeZoneOfDateToThisZone(message.getOrderEntryDate().getTime(), timeZone);
                    Date orderEntryDate = message.getOrderEntryDate().getTime();
                    String serverDate = DateUtil.convertMiladiToShamsi(orderEntryDate);

                    System.out.println(DateUtil.getFormattedDate(orderEntryDate, DateUtil.Pattern.YYYY_MM_DD_HH_MM_SS));

                    String serverTime = DateUtil.GetStringTime(orderEntryDate);
                    byte[] serverDateTime = DateUtil.parseJalaliDateToFourByte(serverDate.replaceAll("-", ""), serverTime);
                    System.arraycopy(serverDateTime, 0, buffer, index, ServerTime);
                    index += ServerTime;

                }

                tradingMessage.setResponseCode(MIDletConstant.SUCCESSFUL_OPERATION);
                tradingMessage.setFlags((byte) 0x00);

                return buffer;

            } else {
                tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
                tradingMessage.setFlags((byte) 0x00);

                byte[] retVal = ByteUtil.convertStringToByteArray("noorder");
                byte[] buffer = new byte[retVal.length + 2];
                System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, 0, 2);
                System.arraycopy(retVal, 0, buffer, 2, retVal.length);

                return buffer;
            }


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage, null);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage, null);

        }

    }

    public byte[] viewAccount(TradingMessage tradingMessage, int brokerCode,
                              int customerCode, int pageIndex, int pageSize) {
        try {
            if (binding == null)
                throw new ServiceException();

            if (customerCode > 0 && brokerCode > 0) {
                int totalRow = 0;
                WsCirculationAccount[] circulationAccounts = binding.getCirculationAccountList(customerCode, pageIndex, pageSize, new IntHolder(totalRow));
                totalRow = circulationAccounts.length;

                int count = pageSize;

                if (pageSize > circulationAccounts.length)
                    count = circulationAccounts.length;

                byte[][] desc = null;
                int descLength = 0;
                int i = 0;
                if (circulationAccounts.length > 0) {
                    desc = new byte[circulationAccounts.length][];
                    for (WsCirculationAccount account : circulationAccounts) {
                        desc[i] = ByteUtil.convertStringToByteArray(account.getDetailDescription() == null ? "" :
                                account.getDetailDescription());
                        descLength += desc[i].length;
                        i++;
                    }
                }

                i = 0;
                if (circulationAccounts.length > 0) {
                    byte[] buffer = new byte[count * CustomerTurnoverListLength + TotalRowCount +
                            ResposneItemLength + descLength + circulationAccounts.length];

                    int index = 0;
                    System.arraycopy(ByteUtil.shortToBytes(totalRow), 0, buffer, index, TotalRowCount);
                    index += TotalRowCount;
                    buffer[index++] = (byte) circulationAccounts.length;

                    for (WsCirculationAccount account : circulationAccounts) {
                        buffer[index++] = (byte) account.getVoucherType();
                        System.arraycopy(ByteUtil.intToFourByte(i + 1), 0, buffer, index, VoucherNo);
                        index += VoucherNo;

                        Double valuePositive = Math.abs(account.getBalanced());
                        byte[] balanced = ByteUtil.longToFiveByte(valuePositive.longValue());

                        System.arraycopy(balanced, 0, buffer, index, Balance);
                        index += Balance;
                        if (account.getBalanced() < 0) {
                            buffer[index++] = 1;
                        } else {
                            buffer[index++] = 0;
                        }

                        byte[] debit = ByteUtil.longToFiveByte(new Double(account.getDebtor()).longValue());
                        System.arraycopy(debit, 0, buffer, index, Debitor);
                        index += Debitor;

                        byte[] creditor = ByteUtil.longToFiveByte(new Double(account.getCreditor()).longValue());
                        System.arraycopy(creditor, 0, buffer, index, Creditor);
                        index += Creditor;
//                        long creditorLong = ByteUtil.fiveBytesToLong(creditor);

                        if (desc != null)
                            buffer[index++] = (byte) desc[i].length;

                        String servetDate = DateUtil.convertMiladiToShamsi(account.getVoucherDate().getTime());
                        byte[] voucherDate = ByteUtil.persianDateToByte(servetDate);
                        System.arraycopy(voucherDate, 0, buffer, index, VoucherDate);
                        index += VoucherDate;

                        if (desc != null) {
                            System.arraycopy(desc[i], 0, buffer, index, desc[i].length);
                            index += desc[i].length;
                        }
                        i++;
                    }

                    tradingMessage.setResponseCode(MIDletConstant.SUCCESSFUL_OPERATION);
                    tradingMessage.setFlags((byte) 0x00);

                    return buffer;

                } else {

                    tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
                    tradingMessage.setFlags((byte) 0x00);

                    byte[] retVal = ByteUtil.convertStringToByteArray("novoucher");
                    byte[] buffer = new byte[retVal.length + 2];

                    System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, 0, 2);
                    System.arraycopy(retVal, 0, buffer, 2, retVal.length);
                    return buffer;
                }
            }

        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage, null);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage, null);

        }

        return null;

    }

    private static byte getOrderStatus(String orderStatus) {
        if (orderStatus.equalsIgnoreCase(OrderState._None))
            return 0;
        else if (orderStatus.equalsIgnoreCase(OrderState._Modify))
            return 1;
        else if (orderStatus.equalsIgnoreCase(OrderState._Error))
            return 2;
        else if (orderStatus.equalsIgnoreCase(OrderState._Cancel))
            return 3;
        else if (orderStatus.equalsIgnoreCase(OrderState._Delete))
            return 4;
        else if (orderStatus.equalsIgnoreCase(OrderState._Done))
            return 5;
        else if (orderStatus.equalsIgnoreCase(OrderState._OnBoard))
            return 6;
        else if (orderStatus.equalsIgnoreCase(OrderState._OnSending))
            return 7;
        else if (orderStatus.equalsIgnoreCase(OrderState._PartiallyExcution))
            return 8;
        else if (orderStatus.equalsIgnoreCase(OrderState._OnCanceling))
            return 9;
        else if (orderStatus.equalsIgnoreCase(OrderState._OnCancelError))
            return 0xA;
        else if (orderStatus.equalsIgnoreCase(OrderState._OnModifyError))
            return 0xB;
        else if (orderStatus.equalsIgnoreCase(OrderState._DeleteByBroker))
            return 0xC;
        else if (orderStatus.equalsIgnoreCase(OrderState._Expired))
            return 0xD;
        else
            return 0xE;

    }

    private static byte[] createFatalErrorMessage(TradingMessage tradingMessage, String serverErrorCode) {

        byte[] retVal;
        if (serverErrorCode == null) {


            String lang = tradingMessage.getLanguage();
            Locale locale = new Locale(lang);
            ResourceBundle rb = ResourceBundle.getBundle("response",locale);
            retVal = ByteUtil.convertStringToByteArray(rb.getString("NO_CONNECTION_TO_SERVER"));
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
