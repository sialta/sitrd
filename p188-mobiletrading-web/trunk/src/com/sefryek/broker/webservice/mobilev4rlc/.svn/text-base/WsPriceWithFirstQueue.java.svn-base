/**
 * WsPriceWithFirstQueue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev4rlc;

public class WsPriceWithFirstQueue  extends com.sefryek.broker.webservice.mobilev4rlc.WsPrice  implements java.io.Serializable {
    private com.sefryek.broker.webservice.mobilev4rlc.WsQueue queueFirstRow;

    private java.math.BigDecimal closingPriceVar;

    private java.math.BigDecimal closingPriceChange;

    public WsPriceWithFirstQueue() {
    }

    public WsPriceWithFirstQueue(
           java.lang.String date,
           java.lang.String time,
           boolean isNegative,
           boolean isRight,
           boolean isFaraBourse,
           java.lang.String nscCode,
           int lastTradedPrice,
           org.apache.axis.types.UnsignedByte realChangePrice,
           org.apache.axis.types.UnsignedByte mantissa,
           int closingPrice,
           int highAllowedPrice,
           int lowAllowedPrice,
           double priceVar,
           int priceChange,
           long totalNumberOfSharesTraded,
           com.sefryek.broker.webservice.mobilev4rlc.WsQueue queueFirstRow,
           java.math.BigDecimal closingPriceVar,
           java.math.BigDecimal closingPriceChange) {
        super(
            date,
            time,
            isNegative,
            isRight,
            isFaraBourse,
            nscCode,
            lastTradedPrice,
            realChangePrice,
            mantissa,
            closingPrice,
            highAllowedPrice,
            lowAllowedPrice,
            priceVar,
            priceChange,
            totalNumberOfSharesTraded);
        this.queueFirstRow = queueFirstRow;
        this.closingPriceVar = closingPriceVar;
        this.closingPriceChange = closingPriceChange;
    }


    /**
     * Gets the queueFirstRow value for this WsPriceWithFirstQueue.
     * 
     * @return queueFirstRow
     */
    public com.sefryek.broker.webservice.mobilev4rlc.WsQueue getQueueFirstRow() {
        return queueFirstRow;
    }


    /**
     * Sets the queueFirstRow value for this WsPriceWithFirstQueue.
     * 
     * @param queueFirstRow
     */
    public void setQueueFirstRow(com.sefryek.broker.webservice.mobilev4rlc.WsQueue queueFirstRow) {
        this.queueFirstRow = queueFirstRow;
    }


    /**
     * Gets the closingPriceVar value for this WsPriceWithFirstQueue.
     * 
     * @return closingPriceVar
     */
    public java.math.BigDecimal getClosingPriceVar() {
        return closingPriceVar;
    }


    /**
     * Sets the closingPriceVar value for this WsPriceWithFirstQueue.
     * 
     * @param closingPriceVar
     */
    public void setClosingPriceVar(java.math.BigDecimal closingPriceVar) {
        this.closingPriceVar = closingPriceVar;
    }


    /**
     * Gets the closingPriceChange value for this WsPriceWithFirstQueue.
     * 
     * @return closingPriceChange
     */
    public java.math.BigDecimal getClosingPriceChange() {
        return closingPriceChange;
    }


    /**
     * Sets the closingPriceChange value for this WsPriceWithFirstQueue.
     * 
     * @param closingPriceChange
     */
    public void setClosingPriceChange(java.math.BigDecimal closingPriceChange) {
        this.closingPriceChange = closingPriceChange;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WsPriceWithFirstQueue)) return false;
        WsPriceWithFirstQueue other = (WsPriceWithFirstQueue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.queueFirstRow==null && other.getQueueFirstRow()==null) || 
             (this.queueFirstRow!=null &&
              this.queueFirstRow.equals(other.getQueueFirstRow()))) &&
            ((this.closingPriceVar==null && other.getClosingPriceVar()==null) || 
             (this.closingPriceVar!=null &&
              this.closingPriceVar.equals(other.getClosingPriceVar()))) &&
            ((this.closingPriceChange==null && other.getClosingPriceChange()==null) || 
             (this.closingPriceChange!=null &&
              this.closingPriceChange.equals(other.getClosingPriceChange())));
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
        if (getQueueFirstRow() != null) {
            _hashCode += getQueueFirstRow().hashCode();
        }
        if (getClosingPriceVar() != null) {
            _hashCode += getClosingPriceVar().hashCode();
        }
        if (getClosingPriceChange() != null) {
            _hashCode += getClosingPriceChange().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WsPriceWithFirstQueue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "WsPriceWithFirstQueue"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queueFirstRow");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "QueueFirstRow"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "WsQueue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("closingPriceVar");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ClosingPriceVar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("closingPriceChange");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ClosingPriceChange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
