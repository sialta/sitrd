/**
 * ExchangeBoards.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev7;

public class ExchangeBoards  implements java.io.Serializable {
    private int exchangeBoardId;

    private java.lang.String title;

    private java.lang.String description;

    private com.sefryek.broker.webservice.mobilev7.ExchangeMarket exchangeMarket;

    public ExchangeBoards() {
    }

    public ExchangeBoards(
           int exchangeBoardId,
           java.lang.String title,
           java.lang.String description,
           com.sefryek.broker.webservice.mobilev7.ExchangeMarket exchangeMarket) {
           this.exchangeBoardId = exchangeBoardId;
           this.title = title;
           this.description = description;
           this.exchangeMarket = exchangeMarket;
    }


    /**
     * Gets the exchangeBoardId value for this ExchangeBoards.
     * 
     * @return exchangeBoardId
     */
    public int getExchangeBoardId() {
        return exchangeBoardId;
    }


    /**
     * Sets the exchangeBoardId value for this ExchangeBoards.
     * 
     * @param exchangeBoardId
     */
    public void setExchangeBoardId(int exchangeBoardId) {
        this.exchangeBoardId = exchangeBoardId;
    }


    /**
     * Gets the title value for this ExchangeBoards.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this ExchangeBoards.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the description value for this ExchangeBoards.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ExchangeBoards.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the exchangeMarket value for this ExchangeBoards.
     * 
     * @return exchangeMarket
     */
    public com.sefryek.broker.webservice.mobilev7.ExchangeMarket getExchangeMarket() {
        return exchangeMarket;
    }


    /**
     * Sets the exchangeMarket value for this ExchangeBoards.
     * 
     * @param exchangeMarket
     */
    public void setExchangeMarket(com.sefryek.broker.webservice.mobilev7.ExchangeMarket exchangeMarket) {
        this.exchangeMarket = exchangeMarket;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExchangeBoards)) return false;
        ExchangeBoards other = (ExchangeBoards) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.exchangeBoardId == other.getExchangeBoardId() &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.exchangeMarket==null && other.getExchangeMarket()==null) || 
             (this.exchangeMarket!=null &&
              this.exchangeMarket.equals(other.getExchangeMarket())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getExchangeBoardId();
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getExchangeMarket() != null) {
            _hashCode += getExchangeMarket().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExchangeBoards.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ExchangeBoards"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exchangeBoardId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ExchangeBoardId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exchangeMarket");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ExchangeMarket"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ExchangeMarket"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
