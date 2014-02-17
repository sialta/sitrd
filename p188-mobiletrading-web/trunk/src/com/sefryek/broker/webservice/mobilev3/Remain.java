/**
 * Remain.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev3;

public class Remain  implements java.io.Serializable {
    private double realBalance;

    private double blockedBalance;

    public Remain() {
    }

    public Remain(
           double realBalance,
           double blockedBalance) {
           this.realBalance = realBalance;
           this.blockedBalance = blockedBalance;
    }


    /**
     * Gets the realBalance value for this Remain.
     * 
     * @return realBalance
     */
    public double getRealBalance() {
        return realBalance;
    }


    /**
     * Sets the realBalance value for this Remain.
     * 
     * @param realBalance
     */
    public void setRealBalance(double realBalance) {
        this.realBalance = realBalance;
    }


    /**
     * Gets the blockedBalance value for this Remain.
     * 
     * @return blockedBalance
     */
    public double getBlockedBalance() {
        return blockedBalance;
    }


    /**
     * Sets the blockedBalance value for this Remain.
     * 
     * @param blockedBalance
     */
    public void setBlockedBalance(double blockedBalance) {
        this.blockedBalance = blockedBalance;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Remain)) return false;
        Remain other = (Remain) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.realBalance == other.getRealBalance() &&
            this.blockedBalance == other.getBlockedBalance();
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
        _hashCode += new Double(getRealBalance()).hashCode();
        _hashCode += new Double(getBlockedBalance()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Remain.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "Remain"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("realBalance");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "RealBalance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("blockedBalance");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "BlockedBalance"));
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
