/**
 * Ws_Message.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev7rlc;

public class Ws_Message  implements java.io.Serializable {
    private int messageId;

    private java.util.Calendar messageDate;

    private java.lang.String messageTitle;

    private java.lang.String messageDetail;

    public Ws_Message() {
    }

    public Ws_Message(
           int messageId,
           java.util.Calendar messageDate,
           java.lang.String messageTitle,
           java.lang.String messageDetail) {
           this.messageId = messageId;
           this.messageDate = messageDate;
           this.messageTitle = messageTitle;
           this.messageDetail = messageDetail;
    }


    /**
     * Gets the messageId value for this Ws_Message.
     * 
     * @return messageId
     */
    public int getMessageId() {
        return messageId;
    }


    /**
     * Sets the messageId value for this Ws_Message.
     * 
     * @param messageId
     */
    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }


    /**
     * Gets the messageDate value for this Ws_Message.
     * 
     * @return messageDate
     */
    public java.util.Calendar getMessageDate() {
        return messageDate;
    }


    /**
     * Sets the messageDate value for this Ws_Message.
     * 
     * @param messageDate
     */
    public void setMessageDate(java.util.Calendar messageDate) {
        this.messageDate = messageDate;
    }


    /**
     * Gets the messageTitle value for this Ws_Message.
     * 
     * @return messageTitle
     */
    public java.lang.String getMessageTitle() {
        return messageTitle;
    }


    /**
     * Sets the messageTitle value for this Ws_Message.
     * 
     * @param messageTitle
     */
    public void setMessageTitle(java.lang.String messageTitle) {
        this.messageTitle = messageTitle;
    }


    /**
     * Gets the messageDetail value for this Ws_Message.
     * 
     * @return messageDetail
     */
    public java.lang.String getMessageDetail() {
        return messageDetail;
    }


    /**
     * Sets the messageDetail value for this Ws_Message.
     * 
     * @param messageDetail
     */
    public void setMessageDetail(java.lang.String messageDetail) {
        this.messageDetail = messageDetail;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ws_Message)) return false;
        Ws_Message other = (Ws_Message) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.messageId == other.getMessageId() &&
            ((this.messageDate==null && other.getMessageDate()==null) || 
             (this.messageDate!=null &&
              this.messageDate.equals(other.getMessageDate()))) &&
            ((this.messageTitle==null && other.getMessageTitle()==null) || 
             (this.messageTitle!=null &&
              this.messageTitle.equals(other.getMessageTitle()))) &&
            ((this.messageDetail==null && other.getMessageDetail()==null) || 
             (this.messageDetail!=null &&
              this.messageDetail.equals(other.getMessageDetail())));
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
        _hashCode += getMessageId();
        if (getMessageDate() != null) {
            _hashCode += getMessageDate().hashCode();
        }
        if (getMessageTitle() != null) {
            _hashCode += getMessageTitle().hashCode();
        }
        if (getMessageDetail() != null) {
            _hashCode += getMessageDetail().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ws_Message.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "Ws_Message"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "MessageId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "MessageDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "MessageTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "MessageDetail"));
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
