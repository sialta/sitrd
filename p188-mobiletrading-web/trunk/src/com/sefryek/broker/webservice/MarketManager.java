package com.sefryek.broker.webservice;

import com.sefryek.broker.webservice.mobilev7rlc.*;
import com.sefryek.broker.webservice.mobilev7rlc.enums.*;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;
import javax.xml.rpc.ServiceException;
import com.sefryek.broker.utils.Constants;
import com.sefryek.broker.utils.ByteUtil;
import com.sefryek.broker.utils.DateUtil;
import com.sefryek.broker.utils.StringUtil;
import com.sefryek.broker.utils.sessionUtils.Session;
import com.sefryek.broker.state.TradingMessage;
import com.sefryek.broker.mobileHandler.MIDletConstant;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Mahta
 * Date: Jul 19, 2011
 * Time: 10:12:46 AM
 */
public class MarketManager {
    private static Logger logger = Logger.getLogger(MarketManager.class);

    //public static int fixStockResponseLen = 36;
    public static int fixStockResponseLen = 35;
    public static int state = 1;
    public static int lastTradedPrice = 4;
    //public static int ChangeValue = 3;
    public static int priceVarReal = 4;
    public static int priceVarMantissa = 1;
    public static int closePrice = 4;
    public static int closePriceVarReal = 4;
    public static int closePriceVarMantissa = 1;
    public static int highAllowedPrice = 4;
    public static int lowAllowedPrice = 4;
    public static int maxAllowedCount = 4;
    public static int realBalance = 5;
    public static int blockBalance = 5;
    //added by alizadeh
    public static int bestBuyPrice = 4;
    public static int bestSellPrice = 4;
    public static int brokerCode = 2;
    public static int TotalTradeCount = 4;
    public static int TotalTradeValue = 4;
    public static int HighestPrice = 4;
    public static int LowestPrice = 4;
    public static int FarsiNameLenght = 1;
    public static int EnglishNameLenght = 1;
    public static int ArabicNameLenght = 1;
    public static int LogoLenght = 1;
    public static final String USER_NAME = "mobilewebservice";     //fill this with your username
    public static final String PASSWORD = "ws100";                  //fill this with your password

    public static WS_MobileV3Soap_BindingStub binding = null;
    public static MainIndicesResponse mainIndicesResponse = new MainIndicesResponse();
    public static MarketActivityResponse marketActivityResponse = new MarketActivityResponse();
    public static BestOfMarketResponse bestOfMarketResponse = new BestOfMarketResponse();


    public static enum OrderListType {
        ORDER_LIST,
        ORDER_BOOK
    }

    static {
        try {
            binding = (WS_MobileV3Soap_BindingStub) new WS_MobileV3Locator().getWS_MobileV3Soap();
        } catch (ServiceException e) {
            // do nothing
        }
    }

    public static byte[] getStockPrice(TradingMessage tradingMessage, String stockCode) {

        try {
            if (binding == null)
                throw new ServiceException();

            //Validate username and password
            WsPrice price = binding.getSymbolPrice(stockCode);

            if (price != null) {
                //HeaderResponse headerResponse = new HeaderResponse();
                byte[] buffer = new byte[fixStockResponseLen];
                int index = 0;

                byte tmp = 0;
                if (price.isIsNegative())
                    tmp += 4;

                if (Math.abs(price.getPriceVar()) - Math.abs(price.getRealChangePrice().byteValue() & 0xFF) < 0.1)
                    tmp += 8;

                buffer[index++] = tmp;
                System.arraycopy(ByteUtil.intToFourByte(price.getLastTradedPrice()), 0, buffer, index, lastTradedPrice);
                index += lastTradedPrice;

//                int priceChange = price.getPriceChange();
//                if (priceChange < 0) priceChange *= -1;


                // Change Rate Precentage
                System.arraycopy(ByteUtil.intToFourByte(price.getRealChangePrice().byteValue() & 0xFF), 0, buffer, index, priceVarReal);
                index += priceVarReal;
                tmp = price.getMantissa().byteValue();
                buffer[index++] = tmp;

                System.arraycopy(ByteUtil.intToFourByte(price.getClosingPrice()), 0, buffer, index, closePrice);
                index += closePrice;
                System.arraycopy(ByteUtil.intToFourByte(price.getHighAllowedPrice()), 0, buffer, index, highAllowedPrice);
                index += highAllowedPrice;
                System.arraycopy(ByteUtil.intToFourByte(price.getLowAllowedPrice()), 0, buffer, index, lowAllowedPrice);
                index += lowAllowedPrice;
                System.arraycopy(ByteUtil.intToFourByte(0), 0, buffer, index, maxAllowedCount);
                index += maxAllowedCount;


                return buffer;

            } else {
                tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
                tradingMessage.setFlags((byte) 0x00);

                byte[] retVal = ByteUtil.convertStringToByteArray("noprice");
                byte[] buffer = new byte[retVal.length + 2];
                System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, 0, 2);
                System.arraycopy(retVal, 0, buffer, 2, retVal.length);
                return buffer;

            }


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        }

    }


    //added by sina alizadeh
    public static byte[] getStockPriceWithFirstQueue(TradingMessage tradingMessage, String stockCode) {

        try {
            if (binding == null)
                throw new ServiceException();

            //Validate username and password
            WsPriceWithFirstQueue symbolPrice = binding.getSymbolPriceWithFirstQueue(stockCode);



            if (symbolPrice != null) {
                //HeaderResponse headerResponse = new HeaderResponse();
                byte[] buffer = new byte[55];
                int index = 0;

                String fractional = String.valueOf(symbolPrice.getClosingPriceVar().abs());
                String frt = null;
                if(fractional.contains(".")){
                    StringTokenizer str =  new StringTokenizer(fractional , ".");
                    String real = str.nextToken();
                    frt = str.nextToken();

                } else {
                    frt = "0" ;
                }

                byte tmp = 0;
                if (symbolPrice.isIsNegative())
                    tmp |= 4;

                if (Math.abs(symbolPrice.getPriceVar()) - Math.abs(symbolPrice.getRealChangePrice().byteValue() & 0xFF) < 0.1)
                    tmp |= 8;
                if(symbolPrice.getClosingPriceVar().doubleValue() < 0)
                tmp|=16;
                if(symbolPrice.getClosingPriceVar().doubleValue() < 0.1)
                tmp|=32;
                


                buffer[index++] = tmp;
                System.arraycopy(ByteUtil.intToFourByte(symbolPrice.getLastTradedPrice()), 0, buffer, index, lastTradedPrice);
                index += lastTradedPrice;

//                int priceChange = price.getPriceChange();
//                if (priceChange < 0) priceChange *= -1;


                // Change Rate Precentage for last price
                System.arraycopy(ByteUtil.intToFourByte(symbolPrice.getRealChangePrice().byteValue() & 0xFF), 0, buffer, index, priceVarReal);
                index += priceVarReal;
                tmp = symbolPrice.getMantissa().byteValue();
                buffer[index++] = tmp;


                System.arraycopy(ByteUtil.intToFourByte(symbolPrice.getClosingPrice()), 0, buffer, index, closePrice);
                index += closePrice;


                // Change Rate Precentage for closing price
                System.arraycopy(ByteUtil.intToFourByte(symbolPrice.getClosingPriceVar().intValue()), 0, buffer, index, closePriceVarReal);
                index += closePriceVarReal;

//                String fractional = String.valueOf(symbolPrice.getClosingPriceVar().divideAndRemainder(BigDecimal.ONE)[1].floatValue()).substring(2, 4);
//                byte fr = (byte) Integer.parseInt(fractional);
                



                buffer[index++] = Byte.parseByte(frt);


                System.arraycopy(ByteUtil.intToFourByte(symbolPrice.getHighAllowedPrice()), 0, buffer, index, highAllowedPrice);
                index += highAllowedPrice;
                System.arraycopy(ByteUtil.intToFourByte(symbolPrice.getLowAllowedPrice()), 0, buffer, index, lowAllowedPrice);
                index += lowAllowedPrice;
                System.arraycopy(ByteUtil.intToFourByte(symbolPrice.getQueueFirstRow().getBestBuyPrice()), 0, buffer, index, bestBuyPrice);
                index += bestBuyPrice;
                System.arraycopy(ByteUtil.intToFourByte(symbolPrice.getQueueFirstRow().getBestSellPrice()), 0, buffer, index, bestSellPrice);
                index += bestSellPrice;
                System.arraycopy(ByteUtil.intToFourByte(symbolPrice.getMaxQuantityOrder().intValue()), 0, buffer, index, maxAllowedCount);
                index += maxAllowedCount;
                System.arraycopy(ByteUtil.intToFourByte((int)symbolPrice.getTotalNumberOfSharesTraded()), 0, buffer, index, TotalTradeCount);
                index += TotalTradeCount;
                System.arraycopy(ByteUtil.intToFourByte((int)symbolPrice.getTotalNumberOfTrades()), 0, buffer, index, TotalTradeValue);
                index += TotalTradeValue;
                System.arraycopy(ByteUtil.intToFourByte((int)symbolPrice.getHighPrice()), 0, buffer, index, HighestPrice);
                index += HighestPrice;
                System.arraycopy(ByteUtil.intToFourByte((int)symbolPrice.getLowPrice()), 0, buffer, index, LowestPrice);
                index += LowestPrice;

                return buffer;

            } else {
                tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
                tradingMessage.setFlags((byte) 0x00);

                byte[] retVal = ByteUtil.convertStringToByteArray("noprice");
                byte[] buffer = new byte[retVal.length + 2];
                System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, 0, 2);
                System.arraycopy(retVal, 0, buffer, 2, retVal.length);
                return buffer;

            }


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        } catch ( RemoteException e ) {
            logger.error("RemoteException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        }

    }


    public static byte[] mainIndexService(TradingMessage tradingMessage) {
        try {
            if (binding == null)
                throw new ServiceException();

            WsIndices[] indices = binding.getMainIndices();

            if (indices != null && indices.length > 0) {
                byte[] buffer = new byte[mainIndicesResponse.FixIndicesResponseLen + indices.length * mainIndicesResponse.IndicesResposneItemLength];
                int index = 0;

                String sTime = DateUtil.GetStringTime(new Date());
                String servetDate = DateUtil.convertMiladiToShamsi(new Date());
                byte[] serverTime = DateUtil.parseJalaliDateToFourByte(servetDate.replaceAll("-", ""), sTime);

                System.arraycopy(serverTime, 0, buffer, index, mainIndicesResponse.IndicesDateTime);
                index += mainIndicesResponse.IndicesDateTime;

                //index = Copy(Parser.GetInt2Byte(indices.Length), buffer, index, response.IndicesCount);

                buffer[index++] = (byte) indices.length;
                for (WsIndices wsIndices : indices) {
                    System.arraycopy(ByteUtil.convertStringToByteArray(wsIndices.getNscCode()), 0, buffer, index, mainIndicesResponse.NSCCode);
                    index += mainIndicesResponse.NSCCode;

                    System.arraycopy(ByteUtil.parseDoubleTo3Byte(wsIndices.getLastValue()), 0, buffer, index,
                            mainIndicesResponse.LatestValueReal + mainIndicesResponse.LatestValueMantissa);
                    index += mainIndicesResponse.LatestValueReal + mainIndicesResponse.LatestValueMantissa;

                    System.arraycopy(ByteUtil.parseDoubleTo3Byte(wsIndices.getMaxValue()), 0, buffer, index,
                            mainIndicesResponse.MaxValueReal + mainIndicesResponse.MaxValueMantissa);
                    index += mainIndicesResponse.MaxValueReal + mainIndicesResponse.MaxValueMantissa;

                    System.arraycopy(ByteUtil.parseDoubleTo3Byte(wsIndices.getMinValue()), 0, buffer, index,
                            mainIndicesResponse.MinValueReal + mainIndicesResponse.MinValueMantissa);
                    index += mainIndicesResponse.MinValueReal + mainIndicesResponse.MinValueMantissa;

                    System.arraycopy(ByteUtil.parseDoubleTo3Byte(wsIndices.getChangeReal()), 0, buffer, index,
                            mainIndicesResponse.ChangeValueReal + mainIndicesResponse.ChangeValueMantissa);
                    index += mainIndicesResponse.ChangeValueReal + mainIndicesResponse.ChangeValueMantissa;

                    System.arraycopy(ByteUtil.parseDoubleTo2Byte(wsIndices.getChangePercent()), 0, buffer, index,
                            mainIndicesResponse.PercentReal + mainIndicesResponse.PercentMantissa);
                    index += mainIndicesResponse.PercentReal + mainIndicesResponse.PercentMantissa;


                    byte state = 0;

                    if (wsIndices.getChangePercent() > 0)
                        state++;
                    else if (wsIndices.getChangePercent() < 0)
                        state += 2;

                    if (Math.abs(wsIndices.getChangePercent()) - Math.floor(Math.abs(wsIndices.getChangePercent())) < 0.1)
                        state += 4;

                    buffer[index++] = state;

                }
                return buffer;
            } else {

                tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
                tradingMessage.setFlags((byte) 0x00);

                byte[] retVal = ByteUtil.convertStringToByteArray("noindices");
                byte[] buffer = new byte[retVal.length + 2];
                System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, 0, 2);
                System.arraycopy(retVal, 0, buffer, 2, retVal.length);

                return buffer;

            }


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);
        }

    }

    public static byte[] marketInfoService(TradingMessage tradingMessage) {
        try {
            if (binding == null)
                throw new ServiceException();

            WsMarketActivity marketActivity = binding.getMarketActivity();

            if (marketActivity != null) {
                byte[] buffer = new byte[marketActivityResponse.MarketActivityResponseLen];
                int index = 0;

                String sTime = DateUtil.GetStringTime(new Date());
                String servetDate = DateUtil.convertMiladiToShamsi(new Date());
                byte[] serverTime = DateUtil.parseJalaliDateToFourByte(servetDate.replaceAll("-", ""), sTime);

                // Value example format: 6.43651922405E11  so convert double to long
                String totalTradeValStr = StringUtil.removeScientificSymbol(String.valueOf(marketActivity.getTotalTradeValue()));

                long totalTradeVal = Long.valueOf(totalTradeValStr) / 1000000;
                System.arraycopy(ByteUtil.longToBytes(totalTradeVal), 0, buffer, index, marketActivityResponse.TotalTradeValueField);
                index += marketActivityResponse.TotalTradeValueField;

                System.arraycopy(ByteUtil.longToBytes(marketActivity.getTotalNoSharesTraded()), 0, buffer, index,
                        marketActivityResponse.TotalNoSharesTradedField);
                index += marketActivityResponse.TotalNoSharesTradedField;

                System.arraycopy(ByteUtil.intToTwoByte(marketActivity.getTotalNoTrade()), 0, buffer, index, marketActivityResponse.TotalNoTradeField);
                index += marketActivityResponse.TotalNoTradeField;


                System.arraycopy(serverTime, 0, buffer, index, mainIndicesResponse.IndicesDateTime);
                return buffer;

            } else {

                tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
                tradingMessage.setFlags((byte) 0x00);

                byte[] retVal = ByteUtil.convertStringToByteArray("nomarketactivity");
                byte[] buffer = new byte[retVal.length + 2];
                System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, 0, 2);
                System.arraycopy(retVal, 0, buffer, 2, retVal.length);

                return buffer;

            }


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        }

    }

    public static byte[] bestOfMarketServiceWithFirstQueue(TradingMessage tradingMessage, int pageNo, int pageSize, int status) {
        try {
            if (binding == null)
                throw new ServiceException();

            WsPriceWithFirstQueue[] bestOfMarket;
            if (status == 0) {
                bestOfMarket = binding.getBestOfMarketWithFirstQueue(true);

            } else {
                bestOfMarket = binding.getBestOfMarketWithFirstQueue(false);
            }

            if (bestOfMarket != null) {
                int index = 0;
                byte[] buffer = new byte[bestOfMarketResponse.FixBestOfMarketResponseLen + bestOfMarket.length * bestOfMarketResponse.FixItemsLen];

                //We put bestOfMarket length
                byte[] totalTradedCompanies = ByteUtil.shortToBytes(bestOfMarket.length);
                System.arraycopy(buffer, 0, totalTradedCompanies, index, 2);
                index += 2;

                //Current datetime
                String sTime = DateUtil.GetStringTime(new Date());
                String servetDate = DateUtil.convertMiladiToShamsi(new Date());
                byte[] serverTime = DateUtil.parseJalaliDateToFourByte(servetDate.replaceAll("-", ""), sTime);

                System.arraycopy(serverTime, 0, buffer, index, bestOfMarketResponse.ServerDateTime);
                index += bestOfMarketResponse.ServerDateTime;

                //All items count
                byte tmp = (byte) (bestOfMarket.length & 0xFF);
                buffer[index++] = tmp;

                for (WsPriceWithFirstQueue wsPrice : bestOfMarket) {

                    System.arraycopy(ByteUtil.convertStringToByteArray(wsPrice.getNscCode()), 0, buffer, index, bestOfMarketResponse.NSCCode);
                    index += bestOfMarketResponse.NSCCode;

                    System.arraycopy(ByteUtil.intToFourByte(wsPrice.getQueueFirstRow().getBestBuyPrice()), 0, buffer, index, bestOfMarketResponse.BestBuyPrice);
                    index += bestOfMarketResponse.BestBuyPrice;

                    System.arraycopy(ByteUtil.intToFourByte(wsPrice.getQueueFirstRow().getBestSellPrice()), 0, buffer, index, bestOfMarketResponse.BestSellPrice);
                    index += bestOfMarketResponse.BestSellPrice;

                    System.arraycopy(ByteUtil.intToFourByte(wsPrice.getLastTradedPrice()), 0, buffer, index, bestOfMarketResponse.LastTradedPrice);
                    index += bestOfMarketResponse.LastTradedPrice;

                    int changePrice = wsPrice.getPriceChange();

                    //Make price change +
                    if (changePrice < 0) changePrice *= -1;

                    System.arraycopy(ByteUtil.intToThreeBytes(changePrice), 0, buffer, index, bestOfMarketResponse.PriceChange);
                    index += bestOfMarketResponse.PriceChange;

                    //Percent of price change
                    byte[] realChangePrice = ByteUtil.intToFourByte(wsPrice.getRealChangePrice().byteValue() & 0xFF);
                    System.arraycopy(realChangePrice, 0, buffer, index, bestOfMarketResponse.PriceVarReal);
                    index += bestOfMarketResponse.PriceVarReal;

                    buffer[index++] = wsPrice.getMantissa().byteValue();

                    //closing price
                    System.arraycopy(ByteUtil.intToFourByte(wsPrice.getClosingPrice()), 0, buffer, index, bestOfMarketResponse.ClosingPrice);
                    index += bestOfMarketResponse.ClosingPrice;

                    // Change Rate Precentage for closing price
                    System.arraycopy(ByteUtil.intToFourByte(wsPrice.getClosingPriceVar().intValue()), 0, buffer, index, closePriceVarReal);
                    index += closePriceVarReal;

                    String fractional = String.valueOf(wsPrice.getClosingPriceVar().abs());
                    String frt = null;
                    if(fractional.contains(".")){
                        StringTokenizer str =  new StringTokenizer(fractional , ".");
                        String real = str.nextToken();
                         frt = str.nextToken();

                   } else {
                         frt = "0" ;
                    }
                    buffer[index++] = Byte.parseByte(frt);

                    tmp = 0;
                    if (wsPrice.isIsNegative())
                        tmp += 1;

                    if (Math.abs(wsPrice.getPriceVar()) - Math.abs(wsPrice.getRealChangePrice().byteValue() & 0xFF) < 0.1)
                        tmp += 2;

                    buffer[index++] = tmp;
                }

                return buffer;

            } else {

                tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
                tradingMessage.setFlags((byte) 0x00);

                byte[] retVal = ByteUtil.convertStringToByteArray("nobestofmarket");
                byte[] buffer = new byte[retVal.length + 2];
                System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, 0, 2);
                System.arraycopy(retVal, 0, buffer, 2, retVal.length);

                return buffer;

            }


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        }

    }

    public static byte[] bestOfMarketService(TradingMessage tradingMessage, int pageNo, int pageSize, int status) {
        try {
            if (binding == null)
                throw new ServiceException();

            WsPrice[] bestOfMarket;
            if (status == 0) {
                bestOfMarket = binding.getBestOfMarket(true);

            } else {
                bestOfMarket = binding.getBestOfMarket(false);
            }

            if (bestOfMarket != null) {
                int index = 0;
                byte[] buffer = new byte[bestOfMarketResponse.FixBestOfMarketResponseLen + bestOfMarket.length * bestOfMarketResponse.FixItemsLen];

                //We put bestOfMarket length
                byte[] totalTradedCompanies = ByteUtil.shortToBytes(bestOfMarket.length);
                System.arraycopy(buffer, 0, totalTradedCompanies, index, 2);
                index += 2;

                //Current datetime
                String sTime = DateUtil.GetStringTime(new Date());
                String servetDate = DateUtil.convertMiladiToShamsi(new Date());
                byte[] serverTime = DateUtil.parseJalaliDateToFourByte(servetDate.replaceAll("-", ""), sTime);

                System.arraycopy(serverTime, 0, buffer, index, bestOfMarketResponse.ServerDateTime);
                index += bestOfMarketResponse.ServerDateTime;

                //All items count
                byte tmp = (byte) (bestOfMarket.length & 0xFF);
                buffer[index++] = tmp;

                for (WsPrice wsPrice : bestOfMarket) {

                    System.arraycopy(ByteUtil.convertStringToByteArray(wsPrice.getNscCode()), 0, buffer, index, bestOfMarketResponse.NSCCode);
                    index += bestOfMarketResponse.NSCCode;

                    System.arraycopy(ByteUtil.intToFourByte(wsPrice.getLastTradedPrice()), 0, buffer, index, bestOfMarketResponse.LastTradedPrice);
                    index += bestOfMarketResponse.LastTradedPrice;

                    int changePrice = wsPrice.getPriceChange();

                    //Make price change +
                    if (changePrice < 0) changePrice *= -1;

                    System.arraycopy(ByteUtil.intToThreeBytes(changePrice), 0, buffer, index, bestOfMarketResponse.PriceChange);
                    index += bestOfMarketResponse.PriceChange;

                    //Percent of price change
                    byte[] realChangePrice = ByteUtil.intToFourByte(wsPrice.getRealChangePrice().byteValue() & 0xFF);
                    System.arraycopy(realChangePrice, 0, buffer, index, bestOfMarketResponse.PriceVarReal);
                    index += bestOfMarketResponse.PriceVarReal;

                    buffer[index++] = wsPrice.getMantissa().byteValue();

                    tmp = 0;
                    if (wsPrice.isIsNegative())
                        tmp += 1;

                    if (Math.abs(wsPrice.getPriceVar()) - Math.abs(wsPrice.getRealChangePrice().byteValue() & 0xFF) < 0.1)
                        tmp += 2;

                    buffer[index++] = tmp;
                }

                return buffer;

            } else {

                tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
                tradingMessage.setFlags((byte) 0x00);

                byte[] retVal = ByteUtil.convertStringToByteArray("nobestofmarket");
                byte[] buffer = new byte[retVal.length + 2];
                System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, 0, 2);
                System.arraycopy(retVal, 0, buffer, 2, retVal.length);

                return buffer;

            }


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        }

    }

    public static byte[] supplyDemandQueueService(TradingMessage tradingMessage, String stockId) {

        try {
            if (binding == null)
                throw new ServiceException();

            WsQueue[] queues = binding.getSymbolQueue(stockId);

            if (queues != null) {
                int index = 0;


                byte[] buyQueuesTemp = new byte[queues.length * QueueResponse.FIX_ITEM_LENGTH];
                byte[] sellQueuesTemp = new byte[queues.length * QueueResponse.FIX_ITEM_LENGTH];

                int buyIndex = 0;
                int sellIndex = 0;
                int buyItemsNo = 0;
                int sellItemNo = 0;

                for (WsQueue queue : queues) {

                    if (queue.getBestBuyPrice() != 0) {
                        buyItemsNo++;
                        System.arraycopy(ByteUtil.intToFourByte(queue.getBestBuyPrice()), 0, buyQueuesTemp,
                                buyIndex, QueueResponse.BEST_PRICE_LENGTH);
                        buyIndex += QueueResponse.BEST_PRICE_LENGTH;

                        System.arraycopy(ByteUtil.intToFourByte(queue.getBestBuyQuantity()), 0, buyQueuesTemp,
                                buyIndex, QueueResponse.BEST_VALUE_LENGTH);
                        buyIndex += QueueResponse.BEST_VALUE_LENGTH;

                        System.arraycopy(ByteUtil.intToTwoByte(queue.getNoBestBuy()), 0, buyQueuesTemp,
                                buyIndex, QueueResponse.BEST_NO_LENGTH);
                        buyIndex += QueueResponse.BEST_NO_LENGTH;

                    }

                    if (queue.getBestSellPrice() != 0) {
                        sellItemNo++;
                        System.arraycopy(ByteUtil.intToFourByte(queue.getBestSellPrice()), 0, sellQueuesTemp,
                                sellIndex, QueueResponse.BEST_PRICE_LENGTH);
                        sellIndex += QueueResponse.BEST_PRICE_LENGTH;

                        System.arraycopy(ByteUtil.intToFourByte(queue.getBestSellQuantity()), 0, sellQueuesTemp,
                                sellIndex, QueueResponse.BEST_VALUE_LENGTH);
                        sellIndex += QueueResponse.BEST_VALUE_LENGTH;

                        System.arraycopy(ByteUtil.intToTwoByte(queue.getNoBestSell()), 0, sellQueuesTemp,
                                sellIndex, QueueResponse.BEST_NO_LENGTH);
                        sellIndex += QueueResponse.BEST_NO_LENGTH;

                    }
                }

                byte[] buyQueuesFinal = new byte[buyIndex];
                System.arraycopy(buyQueuesTemp, 0, buyQueuesFinal, 0, buyIndex);

                byte[] sellQueuesFinal = new byte[sellIndex];
                System.arraycopy(sellQueuesTemp, 0, sellQueuesFinal, 0, sellIndex);

                byte[] buffer = new byte[QueueResponse.NUMBER_OF_ITEM_LENGTH + sellQueuesFinal.length +
                        QueueResponse.NUMBER_OF_ITEM_LENGTH + buyQueuesFinal.length];

                buffer[index++] = (byte) sellItemNo;
                System.arraycopy(sellQueuesFinal, 0, buffer, index, sellQueuesFinal.length);
                index += sellQueuesFinal.length;

                buffer[index++] = (byte) buyItemsNo;
                System.arraycopy(buyQueuesFinal, 0, buffer, index, buyQueuesFinal.length);
                index += buyQueuesFinal.length;

                return buffer;

            } else {

                tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
                tradingMessage.setFlags((byte) 0x00);

                byte[] retVal = ByteUtil.convertStringToByteArray("noqueue");
                byte[] buffer = new byte[retVal.length + 2];
                System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, 0, 2);
                System.arraycopy(retVal, 0, buffer, 2, retVal.length);

                return buffer;

            }


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        }

    }

    public static byte[] watchListService(TradingMessage tradingMessage, String[] stockIds) {

        try {
            if (binding == null)
                throw new ServiceException();

            WsPrice[] prices = binding.getWatchList(new WsWatchList(stockIds));

            if (prices != null && prices.length > 0) {
                int index = 0;
                byte[] buffer = new byte[WatchListResponse.FIX_WATCH_LIST_RESPONSE_LEN +
                        prices.length * WatchListResponse.FIX_WATCH_ITEM_RESPONSE_LEN];
                buffer[index++] = (byte) prices.length;
                buffer[index++] = (byte) WatchListResponse.FIX_WATCH_ITEM_RESPONSE_LEN;

                for (WsPrice price : prices) {
                    System.arraycopy(ByteUtil.convertStringToByteArray(price.getNscCode()), 0, buffer, index,
                            WatchListResponse.STOCK_ID);
                    index += WatchListResponse.STOCK_ID;

                    System.arraycopy(ByteUtil.intToFourByte(price.getLastTradedPrice()), 0, buffer, index,
                            WatchListResponse.LAST_TRADE_PRICE);
                    index += WatchListResponse.LAST_TRADE_PRICE;

                    byte[] totalNumber = ByteUtil.longToByteArray(price.getTotalNumberOfSharesTraded());
                    System.arraycopy(totalNumber, 0, buffer, index, WatchListResponse.TOTLA_NO_SHARES_TRADED_FIELD);
                    index += WatchListResponse.TOTLA_NO_SHARES_TRADED_FIELD;

                    System.arraycopy(ByteUtil.intToFourByte(price.getRealChangePrice().byteValue() & 0xFF), 0, buffer, index,
                            WatchListResponse.PRICE_VAR_REAL);
                    index += WatchListResponse.PRICE_VAR_REAL;

                    buffer[index++] = price.getMantissa().byteValue();

                    byte tmp = 0;
                    if (price.isIsNegative())
                        tmp += 1;

                    if (Math.abs(price.getPriceVar()) - Math.abs(price.getRealChangePrice().byteValue() & 0xFF) < 0.1)
                        tmp += 2;

                    buffer[index++] = tmp;

                }

                return buffer;


            } else {

                tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
                tradingMessage.setFlags((byte) 0x00);

                byte[] retVal = ByteUtil.convertStringToByteArray("nowatchlist");
                byte[] buffer = new byte[retVal.length + 2];
                System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, 0, 2);
                System.arraycopy(retVal, 0, buffer, 2, retVal.length);

                return buffer;

            }


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        }


    }

    public static byte[] watchListWithFirstQueueService(TradingMessage tradingMessage, String[] stockIds) {

        try {
            if (binding == null)
                throw new ServiceException();

            WsPriceWithFirstQueue[] prices = binding.getWatchListNew(new WsWatchList(stockIds));

            if (prices != null && prices.length > 0) {
                int index = 0;
                byte[] buffer = new byte[WatchListResponse.FIX_WATCH_LIST_RESPONSE_LEN +
                        prices.length * WatchListResponse.FIX_WATCH_ITEM_RESPONSE_LEN];
                buffer[index++] = (byte) prices.length;
                buffer[index++] = (byte) WatchListResponse.FIX_WATCH_ITEM_RESPONSE_LEN;

                for (WsPriceWithFirstQueue price : prices) {
                    System.arraycopy(ByteUtil.convertStringToByteArray(price.getNscCode()), 0, buffer, index,
                            WatchListResponse.STOCK_ID);
                    index += WatchListResponse.STOCK_ID;

                    System.arraycopy(ByteUtil.intToFourByte(price.getQueueFirstRow().getBestBuyPrice()), 0, buffer, index,
                            WatchListResponse.BEST_BUY_PRICE);
                    index += WatchListResponse.BEST_BUY_PRICE;

                    System.arraycopy(ByteUtil.intToFourByte(price.getQueueFirstRow().getBestSellPrice()), 0, buffer, index,
                            WatchListResponse.BEST_SELL_PRICE);
                    index += WatchListResponse.BEST_SELL_PRICE;

                    System.arraycopy(ByteUtil.intToFourByte(price.getLastTradedPrice()), 0, buffer, index,
                            WatchListResponse.LAST_TRADE_PRICE);
                    index += WatchListResponse.LAST_TRADE_PRICE;

                    byte[] totalNumber = ByteUtil.longToByteArray(price.getTotalNumberOfSharesTraded());
                    System.arraycopy(totalNumber, 0, buffer, index, WatchListResponse.TOTLA_NO_SHARES_TRADED_FIELD);
                    index += WatchListResponse.TOTLA_NO_SHARES_TRADED_FIELD;


                    System.arraycopy(ByteUtil.intToFourByte(price.getRealChangePrice().byteValue() & 0xFF), 0, buffer, index,
                            WatchListResponse.PRICE_VAR_REAL);
                    index += WatchListResponse.PRICE_VAR_REAL;

                    buffer[index++] = price.getMantissa().byteValue();

                    System.arraycopy(ByteUtil.intToFourByte(price.getClosingPrice()), 0, buffer, index,
                            WatchListResponse.CLOSING_PRICE);
                    index += WatchListResponse.CLOSING_PRICE;

                    // Change Rate Precentage for closing price
                    System.arraycopy(ByteUtil.intToFourByte(price.getClosingPriceVar().abs().intValue()), 0, buffer, index, closePriceVarReal);
                    index += closePriceVarReal;

//                    String fractional2 = String.valueOf(price.getClosingPriceVar().abs().divide(BigDecimal.ONE));



                    String fractional = String.valueOf(price.getClosingPriceVar().abs());
                    String frt = null;
                    if(fractional.contains(".")){
                        StringTokenizer str =  new StringTokenizer(fractional , ".");
                        String real = str.nextToken();
                         frt = str.nextToken();


                    } else {
                         frt = "0" ;
                    }

                    buffer[index++] = (byte) Integer.parseInt(frt);

                    byte tmp = 0;
                    if (price.isIsNegative())
                        tmp += 1;

                    if (Math.abs(price.getPriceVar()) - Math.abs(price.getRealChangePrice().byteValue() & 0xFF) < 0.1)
                        tmp += 2;
                    if(price.getClosingPriceVar().doubleValue() < 0)
                        tmp|=4;
                    buffer[index++] = tmp;
                    if(Double.parseDouble(frt) < 0.1){
                        tmp|=8;
                    }

                }

                return buffer;


            } else {

                tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
                tradingMessage.setFlags((byte) 0x00);

                byte[] retVal = ByteUtil.convertStringToByteArray("nowatchlist");
                byte[] buffer = new byte[retVal.length + 2];
                System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, 0, 2);
                System.arraycopy(retVal, 0, buffer, 2, retVal.length);

                return buffer;

            }


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        }


    }

    public static byte[] getHistoryData(TradingMessage tradingMessage, String stockId, Calendar startTime, Calendar toDate, int timePart  ) {

        try {
            if (binding == null)
                throw new ServiceException();

            HistoryRequest req = new HistoryRequest(stockId,startTime, toDate, timePart);
            SymbolHistory[] history = binding.getSymbolHistoryData(req);

            if (history != null && history.length > 0) {
                int index = 0;
                byte[] buffer = new byte[history.length*8];
                buffer[index++] = (byte) history.length;

                for (SymbolHistory sh : history) {

                    //Current datetime
                    String sTime = DateUtil.GetStringTime(sh.getDateTime().getTime());
                    String servetDate = DateUtil.convertMiladiToShamsi(sh.getDateTime().getTime());
                    byte[] fromDate = DateUtil.parseJalaliDateToFourByte(servetDate.replaceAll("-", ""), sTime);
                    System.arraycopy(fromDate, 0, buffer, index,4);
                    index += 4;

                    System.arraycopy(sh.getValue(), 0, buffer, index,4);
                    index += 4;

                }

                return buffer;


            } else {

                tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
                tradingMessage.setFlags((byte) 0x00);

                byte[] retVal = ByteUtil.convertStringToByteArray("nowatchlist");
                byte[] buffer = new byte[retVal.length + 2];
                System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, 0, 2);
                System.arraycopy(retVal, 0, buffer, 2, retVal.length);

                return buffer;

            }


        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        }


    }


    //added by alizadeh
    public byte[] getBrokerList(TradingMessage tradingMessage) {

        try {
            if (binding == null)
                throw new ServiceException();


            // send order message request but before it, we should set loging cookie for authorize user
            // so get the cookie from first login, if it is null, log in again and update login cookie in user session bject
//            WsOrderMessageWithFinancial orderMessage = ConvertOrderToWsOrderMessageWithFinancial(brokerCode, customerCode);
//
//            WsOrderMessageWithFinancialHolder holder = new WsOrderMessageWithFinancialHolder(orderMessage);

            WsMobileBroker[] returnVal = binding.getBrokerList();


            if (returnVal == null) {
                return createFatalErrorMessage(tradingMessage);

            } else {
                tradingMessage.setResponseCode(MIDletConstant.SUCCESSFUL_OPERATION);
                tradingMessage.setFlags((byte) 0);
                byte numberOfBrokers = (byte) returnVal.length;

                int arabicLenght = 0;

//                byte[] brokerList = null;//new byte[1 + (numberOfBrokers * (brokerCode + FarsiNameLenght + returnVal[0].getName().length()+ EnglishNameLenght + returnVal[1].getName().length() + ArabicNameLenght + 0 ))];

                int index = 0;

                ByteArrayOutputStream byteArray = new ByteArrayOutputStream()  ;
                DataOutputStream dos = new DataOutputStream(byteArray);

                try {
                    dos.write(numberOfBrokers);
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                for (int i = 0; i < numberOfBrokers; i++) {

                    try{
                    dos.write(ByteUtil.shortToBytes(Short.parseShort(returnVal[i].getCode().trim())));

                    byte[] buffer = returnVal[i].getName().getBytes("UTF-8");
                        int len = buffer.length;
                        dos.writeByte(buffer.length);

                    dos.write(buffer);

                        byte[] bufferEn = returnVal[i].getEnName().getBytes("UTF-8");
                        dos.writeByte(bufferEn.length);

                        dos.write(bufferEn);


                    dos.write(0);

//                  dos.writeChars("");

                    dos.write(returnVal[i].getLogoUrl().length());

                    dos.writeChars(returnVal[i].getLogoUrl());

                    }catch(IOException e){
                        e.printStackTrace();
                    }


                }


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
            return createFatalErrorMessage(tradingMessage);

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

            return createFatalErrorMessage(tradingMessage);
        }

    }

    public static byte[] companyListService(TradingMessage tradingMessage, int pageNo, Session userSession) {

        try {
            if (binding == null)
                throw new ServiceException();

            String[] result;
            if (userSession.getCompanyResult() == null) {
                String companyListResult = binding.exchangeCompanyList();
                companyListResult = StringUtil.replaceParantezes(companyListResult);

                StringTokenizer tokenizer = new StringTokenizer(companyListResult, Constants.COMPANIES_DELEIMITER);
                int tokensNum = tokenizer.countTokens();
                result = new String[tokensNum];
                for (int i = 0; i < tokensNum; i++) {
                    String companyInfo = tokenizer.nextToken();
                    // skipping database id of company in tadbir
                    companyInfo = companyInfo.substring(companyInfo.indexOf(Constants.COMPANY_ITEM_DELEIMITER) + 1);
                    result[i] = companyInfo;
                }

                userSession.setCompanyResult(result);
            } else {
                result = userSession.getCompanyResult();
            }

            int totalPages = result.length / Constants.COMPANIES_PAGE_SIZE;
            if ((float) result.length / Constants.COMPANIES_PAGE_SIZE > totalPages)
                totalPages += 1;

            int startIndex = (pageNo - 1) * Constants.COMPANIES_PAGE_SIZE;
            int endIndex = pageNo * Constants.COMPANIES_PAGE_SIZE;
            if (endIndex > result.length)
                endIndex = result.length;

            String finalResult = "";
            for (int i = startIndex; i < endIndex; i++) {
                finalResult += result[i] + "\n";
            }

            if (!finalResult.isEmpty())
                finalResult = finalResult.substring(0, finalResult.length() - 1);

            if (pageNo == totalPages) {
                userSession.setCompanyResult(null);
            }

            byte[] listValue = ByteUtil.convertStringToByteArray(finalResult);

            byte[] buffer = new byte[listValue.length + 1];
            int index = 0;
            buffer[index++] = (byte) totalPages;

            System.arraycopy(listValue, 0, buffer, index, listValue.length);
            return buffer;

        } catch (ServiceException e) {
            logger.error("ServiceException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        } catch (RemoteException e) {
            logger.error("RemoteException is caught");
            logger.error(Constants.getStackTrace(e));
            return createFatalErrorMessage(tradingMessage);

        }


    }

    private static byte[] createFatalErrorMessage(TradingMessage tradingMessage) {
        byte[] retVal = ByteUtil.convertStringToByteArray("NO_CONNECTION_TO_SERVER");

        tradingMessage.setResponseCode(MIDletConstant.SERVER_INFO);
        tradingMessage.setFlags((byte) 0x00);

        byte[] buffer = new byte[retVal.length + 2];
        int index = 0;

        System.arraycopy(ByteUtil.shortToBytes(retVal.length), 0, buffer, index, 2);
        System.arraycopy(retVal, 0, buffer, 2, retVal.length);
        return buffer;

    }


}
