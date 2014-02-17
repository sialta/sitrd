/**
 * WS_Mobile.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev2rlc;

public interface WS_Mobile extends javax.xml.rpc.Service {
    public java.lang.String getWS_MobileSoap12Address();

    public com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap_PortType getWS_MobileSoap12() throws javax.xml.rpc.ServiceException;

    public com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap_PortType getWS_MobileSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getWS_MobileSoapAddress();

    public com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap_PortType getWS_MobileSoap() throws javax.xml.rpc.ServiceException;

    public com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap_PortType getWS_MobileSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
