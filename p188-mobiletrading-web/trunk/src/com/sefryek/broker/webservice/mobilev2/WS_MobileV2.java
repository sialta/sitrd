/**
 * WS_MobileV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev2;

public interface WS_MobileV2 extends javax.xml.rpc.Service {
    public java.lang.String getWS_MobileV2Soap12Address(String broker);

    public com.sefryek.broker.webservice.mobilev2.WS_MobileV2Soap_PortType getWS_MobileV2Soap12(String broker) throws javax.xml.rpc.ServiceException;

    public com.sefryek.broker.webservice.mobilev2.WS_MobileV2Soap_PortType getWS_MobileV2Soap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getWS_MobileV2SoapAddress(String broker);

    public com.sefryek.broker.webservice.mobilev2.WS_MobileV2Soap_PortType getWS_MobileV2Soap(String broker) throws javax.xml.rpc.ServiceException;

    public com.sefryek.broker.webservice.mobilev2.WS_MobileV2Soap_PortType getWS_MobileV2Soap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
