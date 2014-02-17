/**
 * WsQueue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev7rlc;

public class WsQueue  implements java.io.Serializable {
    private int bestBuyPrice;

    private int bestSellPrice;

    private int bestSellQuantity;

    private int bestBuyQuantity;

    private int noBestBuy;

    private int noBestSell;

    private java.lang.String nscCode;

    public WsQueue() {
    }

    public WsQueue(
           int bestBuyPrice,
           int bestSellPrice,
           int bestSellQuantity,
           int bestBuyQuantity,
           int noBestBuy,
           int noBestSell,
           java.lang.String nscCode) {
           this.bestBuyPrice = bestBuyPrice;
           this.bestSellPrice = bestSellPrice;
           this.bestSellQuantity = bestSellQuantity;
           this.bestBuyQuantity = bestBuyQuantity;
           this.noBestBuy = noBestBuy;
           this.noBestSell = noBestSell;
           this.nscCode = nscCode;
    }


    /**
     * Gets the bestBuyPrice value for this WsQueue.
     * 
     * @return bestBuyPrice
     */
    public int getBestBuyPrice() {
        return bestBuyPrice;
    }


    /**
     * Sets the bestBuyPrice value for this WsQueue.
     * 
     * @param bestBuyPrice
     */
    public void setBestBuyPrice(int bestBuyPrice) {
        this.bestBuyPrice = bestBuyPrice;
    }


    /**
     * Gets the bestSellPrice value for this WsQueue.
     * 
     * @return bestSellPrice
     */
    public int getBestSellPrice() {
        return bestSellPrice;
    }


    /**
     * Sets the bestSellPrice value for this WsQueue.
     * 
     * @param bestSellPrice
     */
    public void setBestSellPrice(int bestSellPrice) {
        this.bestSellPrice = bestSellPrice;
    }


    /**
     * Gets the bestSellQuantity value for this WsQueue.
     * 
     * @return bestSellQuantity
     */
    public int getBestSellQuantity() {
        return bestSellQuantity;
    }


    /**
     * Sets the bestSellQuantity value for this WsQueue.
     * 
     * @param bestSellQuantity
     */
    public void setBestSellQuantity(int bestSellQuantity) {
        this.bestSellQuantity = bestSellQuantity;
    }


    /**
     * Gets the bestBuyQuantity value for this WsQueue.
     * 
     * @return bestBuyQuantity
     */
    public int getBestBuyQuantity() {
        return bestBuyQuantity;
    }


    /**
     * Sets the bestBuyQuantity value for this WsQueue.
     * 
     * @param bestBuyQuantity
     */
    public void setBestBuyQuantity(int bestBuyQuantity) {
        this.bestBuyQuantity = bestBuyQuantity;
    }


    /**
     * Gets the noBestBuy value for this WsQueue.
     * 
     * @return noBestBuy
     */
    public int getNoBestBuy() {
        return noBestBuy;
    }


    /**
     * Sets the noBestBuy value for this WsQueue.
     * 
     * @param noBestBuy
     */
    public void setNoBestBuy(int noBestBuy) {
        this.noBestBuy = noBestBuy;
    }


    /**
     * Gets the noBestSell value for this WsQueue.
     * 
     * @return noBestSell
     */
    public int getNoBestSell() {
        return noBestSell;
    }


    /**
     * Sets the noBestSell value for this WsQueue.
     * 
     * @param noBestSell
     */
    public void setNoBestSell(int noBestSell) {
        this.noBestSell = noBestSell;
    }


    /**
     * Gets the nscCode value for this WsQueue.
     * 
     * @return nscCode
     */
    public java.lang.String getNscCode() {
        return nscCode;
    }


    /**
     * Sets the nscCode value for this WsQueue.
     * 
     * @param nscCode
     */
    public void setNscCode(java.lang.String nscCode) {
        this.nscCode = nscCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WsQueue)) return false;
        WsQueue other = (WsQueue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.bestBuyPrice == other.getBestBuyPrice() &&
            this.bestSellPrice == other.getBestSellPrice() &&
            this.bestSellQuantity == other.getBestSellQuantity() &&
            this.bestBuyQuantity == other.getBestBuyQuantity() &&
            this.noBestBuy == other.getNoBestBuy() &&
            this.noBestSell == other.getNoBestSell() &&
            ((this.nscCode==null && other.getNscCode()==null) || 
             (this.nscCode!=null &&
              this.nscCode.equals(other.getNscCode())));
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
        _hashCode += getBestBuyPrice();
        _hashCode += getBestSellPrice();
        _hashCode += getBestSellQuantity();
        _hashCode += getBestBuyQuantity();
        _hashCode += getNoBestBuy();
        _hashCode += getNoBestSell();
        if (getNscCode() != null) {
            _hashCode += getNscCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WsQueue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "WsQueue"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bestBuyPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "BestBuyPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bestSellPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "BestSellPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bestSellQuantity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "BestSellQuantity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bestBuyQuantity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "BestBuyQuantity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noBestBuy");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "NoBestBuy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noBestSell");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "NoBestSell"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nscCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "NscCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
