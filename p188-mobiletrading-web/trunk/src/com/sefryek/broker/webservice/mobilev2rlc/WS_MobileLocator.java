/**
 * WS_MobileLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev2rlc;

public class WS_MobileLocator extends org.apache.axis.client.Service implements com.sefryek.broker.webservice.mobilev2rlc.WS_Mobile {

    public WS_MobileLocator() {
    }


    public WS_MobileLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WS_MobileLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WS_MobileSoap12
    private java.lang.String WS_MobileSoap12_address = "http://tadbirrlc.com/WebService/WS_MobileV2.asmx";

    public java.lang.String getWS_MobileSoap12Address() {
        return WS_MobileSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WS_MobileSoap12WSDDServiceName = "WS_MobileSoap12";

    public java.lang.String getWS_MobileSoap12WSDDServiceName() {
        return WS_MobileSoap12WSDDServiceName;
    }

    public void setWS_MobileSoap12WSDDServiceName(java.lang.String name) {
        WS_MobileSoap12WSDDServiceName = name;
    }

    public com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap_PortType getWS_MobileSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WS_MobileSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWS_MobileSoap12(endpoint);
    }

    public com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap_PortType getWS_MobileSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap12Stub _stub = new com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap12Stub(portAddress, this);
            _stub.setPortName(getWS_MobileSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWS_MobileSoap12EndpointAddress(java.lang.String address) {
        WS_MobileSoap12_address = address;
    }


    // Use to get a proxy class for WS_MobileSoap
    private java.lang.String WS_MobileSoap_address = "http://tadbirrlc.com/WebService/WS_MobileV2.asmx";

    public java.lang.String getWS_MobileSoapAddress() {
        return WS_MobileSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WS_MobileSoapWSDDServiceName = "WS_MobileSoap";

    public java.lang.String getWS_MobileSoapWSDDServiceName() {
        return WS_MobileSoapWSDDServiceName;
    }

    public void setWS_MobileSoapWSDDServiceName(java.lang.String name) {
        WS_MobileSoapWSDDServiceName = name;
    }

    public com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap_PortType getWS_MobileSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WS_MobileSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWS_MobileSoap(endpoint);
    }

    public com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap_PortType getWS_MobileSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap_BindingStub _stub = new com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap_BindingStub(portAddress, this);
            _stub.setPortName(getWS_MobileSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWS_MobileSoapEndpointAddress(java.lang.String address) {
        WS_MobileSoap_address = address;
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
            if (com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap12Stub _stub = new com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap12Stub(new java.net.URL(WS_MobileSoap12_address), this);
                _stub.setPortName(getWS_MobileSoap12WSDDServiceName());
                return _stub;
            }
            if (com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap_BindingStub _stub = new com.sefryek.broker.webservice.mobilev2rlc.WS_MobileSoap_BindingStub(new java.net.URL(WS_MobileSoap_address), this);
                _stub.setPortName(getWS_MobileSoapWSDDServiceName());
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
        if ("WS_MobileSoap12".equals(inputPortName)) {
            return getWS_MobileSoap12();
        }
        else if ("WS_MobileSoap".equals(inputPortName)) {
            return getWS_MobileSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WS_Mobile");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "WS_MobileSoap12"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "WS_MobileSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WS_MobileSoap12".equals(portName)) {
            setWS_MobileSoap12EndpointAddress(address);
        }
        else 
if ("WS_MobileSoap".equals(portName)) {
            setWS_MobileSoapEndpointAddress(address);
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
