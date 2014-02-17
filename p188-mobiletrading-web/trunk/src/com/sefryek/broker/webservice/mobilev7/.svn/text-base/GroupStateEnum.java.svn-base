/**
 * GroupStateEnum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev7;

public class GroupStateEnum implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected GroupStateEnum(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _None = "None";
    public static final java.lang.String _Start_Consultation = "Start_Consultation";
    public static final java.lang.String _Pre_opening = "Pre_opening";
    public static final java.lang.String _Opening_OR_Closing = "Opening_OR_Closing";
    public static final java.lang.String _Intervention_before_opening = "Intervention_before_opening";
    public static final java.lang.String _Continuous_Trading = "Continuous_Trading";
    public static final java.lang.String _Trading_At_Last = "Trading_At_Last";
    public static final java.lang.String _Surveillance_intervention = "Surveillance_intervention";
    public static final java.lang.String _End_of_consultation = "End_of_consultation";
    public static final java.lang.String _Post_session = "Post_session";
    public static final java.lang.String _Forbidden = "Forbidden";
    public static final java.lang.String _Interrupted = "Interrupted";
    public static final GroupStateEnum None = new GroupStateEnum(_None);
    public static final GroupStateEnum Start_Consultation = new GroupStateEnum(_Start_Consultation);
    public static final GroupStateEnum Pre_opening = new GroupStateEnum(_Pre_opening);
    public static final GroupStateEnum Opening_OR_Closing = new GroupStateEnum(_Opening_OR_Closing);
    public static final GroupStateEnum Intervention_before_opening = new GroupStateEnum(_Intervention_before_opening);
    public static final GroupStateEnum Continuous_Trading = new GroupStateEnum(_Continuous_Trading);
    public static final GroupStateEnum Trading_At_Last = new GroupStateEnum(_Trading_At_Last);
    public static final GroupStateEnum Surveillance_intervention = new GroupStateEnum(_Surveillance_intervention);
    public static final GroupStateEnum End_of_consultation = new GroupStateEnum(_End_of_consultation);
    public static final GroupStateEnum Post_session = new GroupStateEnum(_Post_session);
    public static final GroupStateEnum Forbidden = new GroupStateEnum(_Forbidden);
    public static final GroupStateEnum Interrupted = new GroupStateEnum(_Interrupted);
    public java.lang.String getValue() { return _value_;}
    public static GroupStateEnum fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        GroupStateEnum enumeration = (GroupStateEnum)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static GroupStateEnum fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(GroupStateEnum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "GroupStateEnum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
