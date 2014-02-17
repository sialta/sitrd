/**
 * WS_MobileV3Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev3rlc;

public class WS_MobileV3Locator extends org.apache.axis.client.Service implements com.sefryek.broker.webservice.mobilev3rlc.WS_MobileV3 {

    public WS_MobileV3Locator() {
    }


    public WS_MobileV3Locator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WS_MobileV3Locator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WS_MobileV3Soap12
    private java.lang.String WS_MobileV3Soap12_address = "http://94.232.172.215/tadbirrlc/WebService/WS_MobileV3.asmx";

    public java.lang.String getWS_MobileV3Soap12Address() {
        return WS_MobileV3Soap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WS_MobileV3Soap12WSDDServiceName = "WS_MobileV3Soap12";

    public java.lang.String getWS_MobileV3Soap12WSDDServiceName() {
        return WS_MobileV3Soap12WSDDServiceName;
    }

    public void setWS_MobileV3Soap12WSDDServiceName(java.lang.String name) {
        WS_MobileV3Soap12WSDDServiceName = name;
    }

    public com.sefryek.broker.webservice.mobilev3rlc.WS_MobileV3Soap_PortType getWS_MobileV3Soap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WS_MobileV3Soap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWS_MobileV3Soap12(endpoint);
    }

    public com.sefryek.broker.webservice.mobilev3rlc.WS_MobileV3Soap_PortType getWS_MobileV3Soap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sefryek.broker.webservice.mobilev3rlc.WS_MobileV3Soap12Stub _stub = new com.sefryek.broker.webservice.mobilev3rlc.WS_MobileV3Soap12Stub(portAddress, this);
            _stub.setPortName(getWS_MobileV3Soap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWS_MobileV3Soap12EndpointAddress(java.lang.String address) {
        WS_MobileV3Soap12_address = address;
    }


    // Use to get a proxy class for WS_MobileV3Soap
    private java.lang.String WS_MobileV3Soap_address = "http://94.232.172.215/tadbirrlc/WebService/WS_MobileV3.asmx";

    public java.lang.String getWS_MobileV3SoapAddress() {
        return WS_MobileV3Soap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WS_MobileV3SoapWSDDServiceName = "WS_MobileV3Soap";

    public java.lang.String getWS_MobileV3SoapWSDDServiceName() {
        return WS_MobileV3SoapWSDDServiceName;
    }

    public void setWS_MobileV3SoapWSDDServiceName(java.lang.String name) {
        WS_MobileV3SoapWSDDServiceName = name;
    }

    public com.sefryek.broker.webservice.mobilev3rlc.WS_MobileV3Soap_PortType getWS_MobileV3Soap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WS_MobileV3Soap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWS_MobileV3Soap(endpoint);
    }

    public com.sefryek.broker.webservice.mobilev3rlc.WS_MobileV3Soap_PortType getWS_MobileV3Soap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sefryek.broker.webservice.mobilev3rlc.WS_MobileV3Soap_BindingStub _stub = new com.sefryek.broker.webservice.mobilev3rlc.WS_MobileV3Soap_BindingStub(portAddress, this);
            _stub.setPortName(getWS_MobileV3SoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWS_MobileV3SoapEndpointAddress(java.lang.String address) {
        WS_MobileV3Soap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sefryek.broker.webservice.mobilev3rlc.WS_MobileV3Soap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sefryek.broker.webservice.mobilev3rlc.WS_MobileV3Soap12Stub _stub = new com.sefryek.broker.webservice.mobilev3rlc.WS_MobileV3Soap12Stub(new java.net.URL(WS_MobileV3Soap12_address), this);
                _stub.setPortName(getWS_MobileV3Soap12WSDDServiceName());
                return _stub;
            }
            if (com.sefryek.broker.webservice.mobilev3rlc.WS_MobileV3Soap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sefryek.broker.webservice.mobilev3rlc.WS_MobileV3Soap_BindingStub _stub = new com.sefryek.broker.webservice.mobilev3rlc.WS_MobileV3Soap_BindingStub(new java.net.URL(WS_MobileV3Soap_address), this);
                _stub.setPortName(getWS_MobileV3SoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WS_MobileV3Soap12".equals(inputPortName)) {
            return getWS_MobileV3Soap12();
        }
        else if ("WS_MobileV3Soap".equals(inputPortName)) {
            return getWS_MobileV3Soap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WS_MobileV3");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "WS_MobileV3Soap12"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "WS_MobileV3Soap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WS_MobileV3Soap12".equals(portName)) {
            setWS_MobileV3Soap12EndpointAddress(address);
        }
        else 
if ("WS_MobileV3Soap".equals(portName)) {
            setWS_MobileV3SoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
