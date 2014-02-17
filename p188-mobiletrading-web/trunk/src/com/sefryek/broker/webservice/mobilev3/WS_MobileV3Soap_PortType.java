/**
 * WS_MobileV3Soap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev3;

public interface WS_MobileV3Soap_PortType extends java.rmi.Remote {
    public com.sefryek.broker.webservice.mobilev3.MobileFinancialData[] getFinancialProviders() throws java.rmi.RemoteException;
    public java.lang.String addOrderWithFinancial(com.sefryek.broker.webservice.mobilev3.holders.WsOrderMessageWithFinancialHolder orderMessage) throws java.rmi.RemoteException;
    public java.lang.String modifyOrder(com.sefryek.broker.webservice.mobilev3.holders.WsOrderMessageWithFinancialHolder orderMessage) throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev3.WsOrderMessageWithFinancial[] getOrderBookV2(int customerId, int pageIndex, int pageSize, javax.xml.rpc.holders.IntHolder totalRow) throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev3.WsOrderMessageWithFinancial[] getOrderList2(int customerId, int pageIndex, int pageSize, javax.xml.rpc.holders.IntHolder totalRow) throws java.rmi.RemoteException;
    public java.lang.String addOrder(com.sefryek.broker.webservice.mobilev3.holders.WsOrderMessageHolder orderMessage) throws java.rmi.RemoteException;
    public java.lang.String cancelOrder(int orderId) throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev3.WsCirculationAccount[] getCirculationAccountList(int customerId, int pageIndex, int pageSize, javax.xml.rpc.holders.IntHolder totalRow) throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev3.WsOrderMessage[] getOrderBook(int customerId, int pageIndex, int pageSize, javax.xml.rpc.holders.IntHolder totalRow) throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev3.WsOrderMessage[] getOrderList(int customerId, int pageIndex, int pageSize, javax.xml.rpc.holders.IntHolder totalRow) throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev3.MobileOMSSetting getSetting() throws java.rmi.RemoteException;
    public com.sefryek.broker.webservice.mobilev3.WsPersonInfo login(java.lang.String userName, java.lang.String password) throws java.rmi.RemoteException;
}
