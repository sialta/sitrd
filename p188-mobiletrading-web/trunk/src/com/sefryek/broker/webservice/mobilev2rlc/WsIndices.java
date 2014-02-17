/**
 * WsIndices.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev2rlc;

public class WsIndices  implements java.io.Serializable {
    private java.util.Calendar dateTime;

    private java.lang.String nscCode;

    private double lastValue;

    private double maxValue;

    private double minValue;

    private double changeReal;

    private double changePercent;

    public WsIndices() {
    }

    public WsIndices(
           java.util.Calendar dateTime,
           java.lang.String nscCode,
           double lastValue,
           double maxValue,
           double minValue,
           double changeReal,
           double changePercent) {
           this.dateTime = dateTime;
           this.nscCode = nscCode;
           this.lastValue = lastValue;
           this.maxValue = maxValue;
           this.minValue = minValue;
           this.changeReal = changeReal;
           this.changePercent = changePercent;
    }


    /**
     * Gets the dateTime value for this WsIndices.
     * 
     * @return dateTime
     */
    public java.util.Calendar getDateTime() {
        return dateTime;
    }


    /**
     * Sets the dateTime value for this WsIndices.
     * 
     * @param dateTime
     */
    public void setDateTime(java.util.Calendar dateTime) {
        this.dateTime = dateTime;
    }


    /**
     * Gets the nscCode value for this WsIndices.
     * 
     * @return nscCode
     */
    public java.lang.String getNscCode() {
        return nscCode;
    }


    /**
     * Sets the nscCode value for this WsIndices.
     * 
     * @param nscCode
     */
    public void setNscCode(java.lang.String nscCode) {
        this.nscCode = nscCode;
    }


    /**
     * Gets the lastValue value for this WsIndices.
     * 
     * @return lastValue
     */
    public double getLastValue() {
        return lastValue;
    }


    /**
     * Sets the lastValue value for this WsIndices.
     * 
     * @param lastValue
     */
    public void setLastValue(double lastValue) {
        this.lastValue = lastValue;
    }


    /**
     * Gets the maxValue value for this WsIndices.
     * 
     * @return maxValue
     */
    public double getMaxValue() {
        return maxValue;
    }


    /**
     * Sets the maxValue value for this WsIndices.
     * 
     * @param maxValue
     */
    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }


    /**
     * Gets the minValue value for this WsIndices.
     * 
     * @return minValue
     */
    public double getMinValue() {
        return minValue;
    }


    /**
     * Sets the minValue value for this WsIndices.
     * 
     * @param minValue
     */
    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }


    /**
     * Gets the changeReal value for this WsIndices.
     * 
     * @return changeReal
     */
    public double getChangeReal() {
        return changeReal;
    }


    /**
     * Sets the changeReal value for this WsIndices.
     * 
     * @param changeReal
     */
    public void setChangeReal(double changeReal) {
        this.changeReal = changeReal;
    }


    /**
     * Gets the changePercent value for this WsIndices.
     * 
     * @return changePercent
     */
    public double getChangePercent() {
        return changePercent;
    }


    /**
     * Sets the changePercent value for this WsIndices.
     * 
     * @param changePercent
     */
    public void setChangePercent(double changePercent) {
        this.changePercent = changePercent;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WsIndices)) return false;
        WsIndices other = (WsIndices) obj;
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
            ((this.nscCode==null && other.getNscCode()==null) || 
             (this.nscCode!=null &&
              this.nscCode.equals(other.getNscCode()))) &&
            this.lastValue == other.getLastValue() &&
            this.maxValue == other.getMaxValue() &&
            this.minValue == other.getMinValue() &&
            this.changeReal == other.getChangeReal() &&
            this.changePercent == other.getChangePercent();
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
        if (getNscCode() != null) {
            _hashCode += getNscCode().hashCode();
        }
        _hashCode += new Double(getLastValue()).hashCode();
        _hashCode += new Double(getMaxValue()).hashCode();
        _hashCode += new Double(getMinValue()).hashCode();
        _hashCode += new Double(getChangeReal()).hashCode();
        _hashCode += new Double(getChangePercent()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WsIndices.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "WsIndices"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nscCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "NscCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "LastValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "MaxValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "MinValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changeReal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ChangeReal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changePercent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ChangePercent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
