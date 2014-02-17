/**
 * WsOrderType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev2;

public class WsOrderType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected WsOrderType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _LimiteOrder = "LimiteOrder";
    public static final java.lang.String _Market_on_Opening_order = "Market_on_Opening_order";
    public static final java.lang.String _Market_Order = "Market_Order";
    public static final java.lang.String _Stop_Order = "Stop_Order";
    public static final java.lang.String _Market_to_Limit_order = "Market_to_Limit_order";
    public static final java.lang.String _None = "None";
    public static final WsOrderType LimiteOrder = new WsOrderType(_LimiteOrder);
    public static final WsOrderType Market_on_Opening_order = new WsOrderType(_Market_on_Opening_order);
    public static final WsOrderType Market_Order = new WsOrderType(_Market_Order);
    public static final WsOrderType Stop_Order = new WsOrderType(_Stop_Order);
    public static final WsOrderType Market_to_Limit_order = new WsOrderType(_Market_to_Limit_order);
    public static final WsOrderType None = new WsOrderType(_None);
    public java.lang.String getValue() { return _value_;}
    public static WsOrderType fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        WsOrderType enumeration = (WsOrderType)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static WsOrderType fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WsOrderType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "WsOrderType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
