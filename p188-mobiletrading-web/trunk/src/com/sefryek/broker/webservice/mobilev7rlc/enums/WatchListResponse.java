package com.sefryek.broker.webservice.mobilev7rlc.enums;

/**
 * Created by IntelliJ IDEA.
 * User: Sahar Ta
 * Date: Jul 26, 2011
 * Time: 1:43:25 PM
 */
public interface WatchListResponse {


    public int FIX_WATCH_LIST_RESPONSE_LEN = 2;
    public int FIX_WATCH_ITEM_RESPONSE_LEN = 47;

    public int STOCK_ID = 12;
    public int BEST_BUY_PRICE = 4;
    public int BEST_SELL_PRICE = 4;
    public int LAST_TRADE_PRICE = 4;
    public int TOTLA_NO_SHARES_TRADED_FIELD = 8;
    public int PRICE_VAR_REAL = 4;
    public int PRICE_VAR_MANTISSA = 1;
    public int CLOSING_PRICE = 4;
    public int CLOSING_PRICE_VAR_REAL = 4;
    public int CLOSING_PRICE_VAR_MANTISSA = 1;
    public int STATE = 1;


}
