/**
 * WsPersonInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev7;

public class WsPersonInfo  implements java.io.Serializable {
    private int customerId;

    private java.lang.String bourseCodes;

    private java.lang.String isinCodes;

    private com.sefryek.broker.webservice.mobilev7.Remain remain;

    public WsPersonInfo() {
    }

    public WsPersonInfo(
           int customerId,
           java.lang.String bourseCodes,
           java.lang.String isinCodes,
           com.sefryek.broker.webservice.mobilev7.Remain remain) {
           this.customerId = customerId;
           this.bourseCodes = bourseCodes;
           this.isinCodes = isinCodes;
           this.remain = remain;
    }


    /**
     * Gets the customerId value for this WsPersonInfo.
     * 
     * @return customerId
     */
    public int getCustomerId() {
        return customerId;
    }


    /**
     * Sets the customerId value for this WsPersonInfo.
     * 
     * @param customerId
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    /**
     * Gets the bourseCodes value for this WsPersonInfo.
     * 
     * @return bourseCodes
     */
    public java.lang.String getBourseCodes() {
        return bourseCodes;
    }


    /**
     * Sets the bourseCodes value for this WsPersonInfo.
     * 
     * @param bourseCodes
     */
    public void setBourseCodes(java.lang.String bourseCodes) {
        this.bourseCodes = bourseCodes;
    }


    /**
     * Gets the isinCodes value for this WsPersonInfo.
     * 
     * @return isinCodes
     */
    public java.lang.String getIsinCodes() {
        return isinCodes;
    }


    /**
     * Sets the isinCodes value for this WsPersonInfo.
     * 
     * @param isinCodes
     */
    public void setIsinCodes(java.lang.String isinCodes) {
        this.isinCodes = isinCodes;
    }


    /**
     * Gets the remain value for this WsPersonInfo.
     * 
     * @return remain
     */
    public com.sefryek.broker.webservice.mobilev7.Remain getRemain() {
        return remain;
    }


    /**
     * Sets the remain value for this WsPersonInfo.
     * 
     * @param remain
     */
    public void setRemain(com.sefryek.broker.webservice.mobilev7.Remain remain) {
        this.remain = remain;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WsPersonInfo)) return false;
        WsPersonInfo other = (WsPersonInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.customerId == other.getCustomerId() &&
            ((this.bourseCodes==null && other.getBourseCodes()==null) || 
             (this.bourseCodes!=null &&
              this.bourseCodes.equals(other.getBourseCodes()))) &&
            ((this.isinCodes==null && other.getIsinCodes()==null) || 
             (this.isinCodes!=null &&
              this.isinCodes.equals(other.getIsinCodes()))) &&
            ((this.remain==null && other.getRemain()==null) || 
             (this.remain!=null &&
              this.remain.equals(other.getRemain())));
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
        _hashCode += getCustomerId();
        if (getBourseCodes() != null) {
            _hashCode += getBourseCodes().hashCode();
        }
        if (getIsinCodes() != null) {
            _hashCode += getIsinCodes().hashCode();
        }
        if (getRemain() != null) {
            _hashCode += getRemain().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WsPersonInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "WsPersonInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CustomerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bourseCodes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "BourseCodes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isinCodes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "IsinCodes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remain");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Remain"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "Remain"));
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
