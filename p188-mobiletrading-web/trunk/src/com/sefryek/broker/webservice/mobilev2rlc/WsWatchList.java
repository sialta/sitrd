/**
 * WsWatchList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev2rlc;

public class WsWatchList  implements java.io.Serializable {
    private java.lang.String[] NSCCode;

    public WsWatchList() {
    }

    public WsWatchList(
           java.lang.String[] NSCCode) {
           this.NSCCode = NSCCode;
    }


    /**
     * Gets the NSCCode value for this WsWatchList.
     * 
     * @return NSCCode
     */
    public java.lang.String[] getNSCCode() {
        return NSCCode;
    }


    /**
     * Sets the NSCCode value for this WsWatchList.
     * 
     * @param NSCCode
     */
    public void setNSCCode(java.lang.String[] NSCCode) {
        this.NSCCode = NSCCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WsWatchList)) return false;
        WsWatchList other = (WsWatchList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.NSCCode==null && other.getNSCCode()==null) || 
             (this.NSCCode!=null &&
              java.util.Arrays.equals(this.NSCCode, other.getNSCCode())));
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
        if (getNSCCode() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNSCCode());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNSCCode(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WsWatchList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "WsWatchList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NSCCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "NSCCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://tempuri.org/", "string"));
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
