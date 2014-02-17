/**
 * WS_MobileV3Soap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev5rlc;

public interface WS_MobileV3Soap_PortType extends java.rmi.Remote {
    public com.sefryek.broker.webservice.mobilev5rlc.WsPriceWithFirstQueue getSymbolPriceWithFirstQueue(java.lang.String nscCode) throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev5rlc.WsPriceWithFirstQueue[] getBestOfMarketWithFirstQueue(boolean sorting) throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev5rlc.WsPriceWithFirstQueue[] getWatchListNew(com.sefryek.broker.webservice.mobilev5rlc.WsWatchList nscCodes) throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev5rlc.WsMobileBroker[] getBrokerList() throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev5rlc.WsIndices[] getMainIndices() throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev5rlc.WsMarketActivity getMarketActivity() throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev5rlc.WsPrice getSymbolPrice(java.lang.String nscCode) throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev5rlc.WsPrice[] getWatchList(com.sefryek.broker.webservice.mobilev5rlc.WsWatchList nscCodes) throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev5rlc.WsPrice[] getBestOfMarket(boolean sorting) throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev5rlc.Ws_Message[] getListOfMessages(java.util.Calendar lastReceived) throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev5rlc.Ws_Message getMessageById(int messageId) throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev5rlc.WsQueue[] getSymbolQueue(java.lang.String nscCode) throws java.rmi.RemoteException;
    public java.lang.String exchangeCompanyList() throws java.rmi.RemoteException;
}
