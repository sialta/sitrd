/**
 * WsOrderMessageWithFinancial.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev3;

public class WsOrderMessageWithFinancial  extends com.sefryek.broker.webservice.mobilev3.WsOrderMessage  implements java.io.Serializable {
    private int financialId;

    private java.lang.Long parentId;

    public WsOrderMessageWithFinancial() {
    }

    public WsOrderMessageWithFinancial(
           int customerId,
           com.sefryek.broker.webservice.mobilev3.ExchangeSymbols exchangeSymbols,
           int excutedAmount,
           int hidenOrder,
           java.lang.Long id,
           java.lang.Integer maximumQuantity,
           int maxShown,
           java.lang.Integer minimumQuantity,
           java.util.Calendar orderEntryDate,
           java.math.BigDecimal orderPrice,
           com.sefryek.broker.webservice.mobilev3.WsOrderSide orderSide,
           com.sefryek.broker.webservice.mobilev3.OrderState orderState,
           int orderTotalQuantity,
           com.sefryek.broker.webservice.mobilev3.WsOrderType orderType,
           int orderValidity,
           java.util.Calendar orderValidityDate,
           java.lang.Integer brokerId,
           java.lang.String isinCode,
           java.math.BigDecimal triggerPrice,
           java.lang.String referenceKey,
           int financialId,
           java.lang.Long parentId) {
        super(
            customerId,
            exchangeSymbols,
            excutedAmount,
            hidenOrder,
            id,
            maximumQuantity,
            maxShown,
            minimumQuantity,
            orderEntryDate,
            orderPrice,
            orderSide,
            orderState,
            orderTotalQuantity,
            orderType,
            orderValidity,
            orderValidityDate,
            brokerId,
            isinCode,
            triggerPrice,
            referenceKey);
        this.financialId = financialId;
        this.parentId = parentId;
    }


    /**
     * Gets the financialId value for this WsOrderMessageWithFinancial.
     * 
     * @return financialId
     */
    public int getFinancialId() {
        return financialId;
    }


    /**
     * Sets the financialId value for this WsOrderMessageWithFinancial.
     * 
     * @param financialId
     */
    public void setFinancialId(int financialId) {
        this.financialId = financialId;
    }


    /**
     * Gets the parentId value for this WsOrderMessageWithFinancial.
     * 
     * @return parentId
     */
    public java.lang.Long getParentId() {
        return parentId;
    }


    /**
     * Sets the parentId value for this WsOrderMessageWithFinancial.
     * 
     * @param parentId
     */
    public void setParentId(java.lang.Long parentId) {
        this.parentId = parentId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WsOrderMessageWithFinancial)) return false;
        WsOrderMessageWithFinancial other = (WsOrderMessageWithFinancial) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.financialId == other.getFinancialId() &&
            ((this.parentId==null && other.getParentId()==null) || 
             (this.parentId!=null &&
              this.parentId.equals(other.getParentId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        _hashCode += getFinancialId();
        if (getParentId() != null) {
            _hashCode += getParentId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WsOrderMessageWithFinancial.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "WsOrderMessageWithFinancial"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("financialId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "FinancialId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ParentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
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
