/**
 * WsMarketActivity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev5rlc;

public class WsMarketActivity  implements java.io.Serializable {
    private java.util.Calendar dateTime;

    private int totalNoTrade;

    private double totalTradeValue;

    private int totalNoSharesTraded;

    public WsMarketActivity() {
    }

    public WsMarketActivity(
           java.util.Calendar dateTime,
           int totalNoTrade,
           double totalTradeValue,
           int totalNoSharesTraded) {
           this.dateTime = dateTime;
           this.totalNoTrade = totalNoTrade;
           this.totalTradeValue = totalTradeValue;
           this.totalNoSharesTraded = totalNoSharesTraded;
    }


    /**
     * Gets the dateTime value for this WsMarketActivity.
     * 
     * @return dateTime
     */
    public java.util.Calendar getDateTime() {
        return dateTime;
    }


    /**
     * Sets the dateTime value for this WsMarketActivity.
     * 
     * @param dateTime
     */
    public void setDateTime(java.util.Calendar dateTime) {
        this.dateTime = dateTime;
    }


    /**
     * Gets the totalNoTrade value for this WsMarketActivity.
     * 
     * @return totalNoTrade
     */
    public int getTotalNoTrade() {
        return totalNoTrade;
    }


    /**
     * Sets the totalNoTrade value for this WsMarketActivity.
     * 
     * @param totalNoTrade
     */
    public void setTotalNoTrade(int totalNoTrade) {
        this.totalNoTrade = totalNoTrade;
    }


    /**
     * Gets the totalTradeValue value for this WsMarketActivity.
     * 
     * @return totalTradeValue
     */
    public double getTotalTradeValue() {
        return totalTradeValue;
    }


    /**
     * Sets the totalTradeValue value for this WsMarketActivity.
     * 
     * @param totalTradeValue
     */
    public void setTotalTradeValue(double totalTradeValue) {
        this.totalTradeValue = totalTradeValue;
    }


    /**
     * Gets the totalNoSharesTraded value for this WsMarketActivity.
     * 
     * @return totalNoSharesTraded
     */
    public int getTotalNoSharesTraded() {
        return totalNoSharesTraded;
    }


    /**
     * Sets the totalNoSharesTraded value for this WsMarketActivity.
     * 
     * @param totalNoSharesTraded
     */
    public void setTotalNoSharesTraded(int totalNoSharesTraded) {
        this.totalNoSharesTraded = totalNoSharesTraded;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WsMarketActivity)) return false;
        WsMarketActivity other = (WsMarketActivity) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dateTime==null && other.getDateTime()==null) || 
             (this.dateTime!=null &&
              this.dateTime.equals(other.getDateTime()))) &&
            this.totalNoTrade == other.getTotalNoTrade() &&
            this.totalTradeValue == other.getTotalTradeValue() &&
            this.totalNoSharesTraded == other.getTotalNoSharesTraded();
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
        if (getDateTime() != null) {
            _hashCode += getDateTime().hashCode();
        }
        _hashCode += getTotalNoTrade();
        _hashCode += new Double(getTotalTradeValue()).hashCode();
        _hashCode += getTotalNoSharesTraded();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WsMarketActivity.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "WsMarketActivity"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalNoTrade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TotalNoTrade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalTradeValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TotalTradeValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalNoSharesTraded");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TotalNoSharesTraded"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
