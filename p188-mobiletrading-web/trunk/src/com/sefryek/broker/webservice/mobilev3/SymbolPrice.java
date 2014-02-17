/**
 * SymbolPrice.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev3;

public class SymbolPrice  implements java.io.Serializable {
    private int closingPrice;

    private int highAllowedPrice;

    private int lowAllowedPrice;

    private long totalNumberOfSharesTraded;

    private short totalNumberOfTrades;

    private long totalTradeValue;

    private int highPrice;

    private int lowPrice;

    private double priceVar;

    private int firstTradedPrice;

    private int lastTradedPrice;

    private java.lang.String symbolFa;

    private int preClosingPrice;

    private java.lang.String tradeDate;

    private int refPrice;

    private java.lang.String varSign;

    private short symbolStateId;

    private short groupStateId;

    private java.lang.String NSCCode;

    public SymbolPrice() {
    }

    public SymbolPrice(
           int closingPrice,
           int highAllowedPrice,
           int lowAllowedPrice,
           long totalNumberOfSharesTraded,
           short totalNumberOfTrades,
           long totalTradeValue,
           int highPrice,
           int lowPrice,
           double priceVar,
           int firstTradedPrice,
           int lastTradedPrice,
           java.lang.String symbolFa,
           int preClosingPrice,
           java.lang.String tradeDate,
           int refPrice,
           java.lang.String varSign,
           short symbolStateId,
           short groupStateId,
           java.lang.String NSCCode) {
           this.closingPrice = closingPrice;
           this.highAllowedPrice = highAllowedPrice;
           this.lowAllowedPrice = lowAllowedPrice;
           this.totalNumberOfSharesTraded = totalNumberOfSharesTraded;
           this.totalNumberOfTrades = totalNumberOfTrades;
           this.totalTradeValue = totalTradeValue;
           this.highPrice = highPrice;
           this.lowPrice = lowPrice;
           this.priceVar = priceVar;
           this.firstTradedPrice = firstTradedPrice;
           this.lastTradedPrice = lastTradedPrice;
           this.symbolFa = symbolFa;
           this.preClosingPrice = preClosingPrice;
           this.tradeDate = tradeDate;
           this.refPrice = refPrice;
           this.varSign = varSign;
           this.symbolStateId = symbolStateId;
           this.groupStateId = groupStateId;
           this.NSCCode = NSCCode;
    }


    /**
     * Gets the closingPrice value for this SymbolPrice.
     * 
     * @return closingPrice
     */
    public int getClosingPrice() {
        return closingPrice;
    }


    /**
     * Sets the closingPrice value for this SymbolPrice.
     * 
     * @param closingPrice
     */
    public void setClosingPrice(int closingPrice) {
        this.closingPrice = closingPrice;
    }


    /**
     * Gets the highAllowedPrice value for this SymbolPrice.
     * 
     * @return highAllowedPrice
     */
    public int getHighAllowedPrice() {
        return highAllowedPrice;
    }


    /**
     * Sets the highAllowedPrice value for this SymbolPrice.
     * 
     * @param highAllowedPrice
     */
    public void setHighAllowedPrice(int highAllowedPrice) {
        this.highAllowedPrice = highAllowedPrice;
    }


    /**
     * Gets the lowAllowedPrice value for this SymbolPrice.
     * 
     * @return lowAllowedPrice
     */
    public int getLowAllowedPrice() {
        return lowAllowedPrice;
    }


    /**
     * Sets the lowAllowedPrice value for this SymbolPrice.
     * 
     * @param lowAllowedPrice
     */
    public void setLowAllowedPrice(int lowAllowedPrice) {
        this.lowAllowedPrice = lowAllowedPrice;
    }


    /**
     * Gets the totalNumberOfSharesTraded value for this SymbolPrice.
     * 
     * @return totalNumberOfSharesTraded
     */
    public long getTotalNumberOfSharesTraded() {
        return totalNumberOfSharesTraded;
    }


    /**
     * Sets the totalNumberOfSharesTraded value for this SymbolPrice.
     * 
     * @param totalNumberOfSharesTraded
     */
    public void setTotalNumberOfSharesTraded(long totalNumberOfSharesTraded) {
        this.totalNumberOfSharesTraded = totalNumberOfSharesTraded;
    }


    /**
     * Gets the totalNumberOfTrades value for this SymbolPrice.
     * 
     * @return totalNumberOfTrades
     */
    public short getTotalNumberOfTrades() {
        return totalNumberOfTrades;
    }


    /**
     * Sets the totalNumberOfTrades value for this SymbolPrice.
     * 
     * @param totalNumberOfTrades
     */
    public void setTotalNumberOfTrades(short totalNumberOfTrades) {
        this.totalNumberOfTrades = totalNumberOfTrades;
    }


    /**
     * Gets the totalTradeValue value for this SymbolPrice.
     * 
     * @return totalTradeValue
     */
    public long getTotalTradeValue() {
        return totalTradeValue;
    }


    /**
     * Sets the totalTradeValue value for this SymbolPrice.
     * 
     * @param totalTradeValue
     */
    public void setTotalTradeValue(long totalTradeValue) {
        this.totalTradeValue = totalTradeValue;
    }


    /**
     * Gets the highPrice value for this SymbolPrice.
     * 
     * @return highPrice
     */
    public int getHighPrice() {
        return highPrice;
    }


    /**
     * Sets the highPrice value for this SymbolPrice.
     * 
     * @param highPrice
     */
    public void setHighPrice(int highPrice) {
        this.highPrice = highPrice;
    }


    /**
     * Gets the lowPrice value for this SymbolPrice.
     * 
     * @return lowPrice
     */
    public int getLowPrice() {
        return lowPrice;
    }


    /**
     * Sets the lowPrice value for this SymbolPrice.
     * 
     * @param lowPrice
     */
    public void setLowPrice(int lowPrice) {
        this.lowPrice = lowPrice;
    }


    /**
     * Gets the priceVar value for this SymbolPrice.
     * 
     * @return priceVar
     */
    public double getPriceVar() {
        return priceVar;
    }


    /**
     * Sets the priceVar value for this SymbolPrice.
     * 
     * @param priceVar
     */
    public void setPriceVar(double priceVar) {
        this.priceVar = priceVar;
    }


    /**
     * Gets the firstTradedPrice value for this SymbolPrice.
     * 
     * @return firstTradedPrice
     */
    public int getFirstTradedPrice() {
        return firstTradedPrice;
    }


    /**
     * Sets the firstTradedPrice value for this SymbolPrice.
     * 
     * @param firstTradedPrice
     */
    public void setFirstTradedPrice(int firstTradedPrice) {
        this.firstTradedPrice = firstTradedPrice;
    }


    /**
     * Gets the lastTradedPrice value for this SymbolPrice.
     * 
     * @return lastTradedPrice
     */
    public int getLastTradedPrice() {
        return lastTradedPrice;
    }


    /**
     * Sets the lastTradedPrice value for this SymbolPrice.
     * 
     * @param lastTradedPrice
     */
    public void setLastTradedPrice(int lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }


    /**
     * Gets the symbolFa value for this SymbolPrice.
     * 
     * @return symbolFa
     */
    public java.lang.String getSymbolFa() {
        return symbolFa;
    }


    /**
     * Sets the symbolFa value for this SymbolPrice.
     * 
     * @param symbolFa
     */
    public void setSymbolFa(java.lang.String symbolFa) {
        this.symbolFa = symbolFa;
    }


    /**
     * Gets the preClosingPrice value for this SymbolPrice.
     * 
     * @return preClosingPrice
     */
    public int getPreClosingPrice() {
        return preClosingPrice;
    }


    /**
     * Sets the preClosingPrice value for this SymbolPrice.
     * 
     * @param preClosingPrice
     */
    public void setPreClosingPrice(int preClosingPrice) {
        this.preClosingPrice = preClosingPrice;
    }


    /**
     * Gets the tradeDate value for this SymbolPrice.
     * 
     * @return tradeDate
     */
    public java.lang.String getTradeDate() {
        return tradeDate;
    }


    /**
     * Sets the tradeDate value for this SymbolPrice.
     * 
     * @param tradeDate
     */
    public void setTradeDate(java.lang.String tradeDate) {
        this.tradeDate = tradeDate;
    }


    /**
     * Gets the refPrice value for this SymbolPrice.
     * 
     * @return refPrice
     */
    public int getRefPrice() {
        return refPrice;
    }


    /**
     * Sets the refPrice value for this SymbolPrice.
     * 
     * @param refPrice
     */
    public void setRefPrice(int refPrice) {
        this.refPrice = refPrice;
    }


    /**
     * Gets the varSign value for this SymbolPrice.
     * 
     * @return varSign
     */
    public java.lang.String getVarSign() {
        return varSign;
    }


    /**
     * Sets the varSign value for this SymbolPrice.
     * 
     * @param varSign
     */
    public void setVarSign(java.lang.String varSign) {
        this.varSign = varSign;
    }


    /**
     * Gets the symbolStateId value for this SymbolPrice.
     * 
     * @return symbolStateId
     */
    public short getSymbolStateId() {
        return symbolStateId;
    }


    /**
     * Sets the symbolStateId value for this SymbolPrice.
     * 
     * @param symbolStateId
     */
    public void setSymbolStateId(short symbolStateId) {
        this.symbolStateId = symbolStateId;
    }


    /**
     * Gets the groupStateId value for this SymbolPrice.
     * 
     * @return groupStateId
     */
    public short getGroupStateId() {
        return groupStateId;
    }


    /**
     * Sets the groupStateId value for this SymbolPrice.
     * 
     * @param groupStateId
     */
    public void setGroupStateId(short groupStateId) {
        this.groupStateId = groupStateId;
    }


    /**
     * Gets the NSCCode value for this SymbolPrice.
     * 
     * @return NSCCode
     */
    public java.lang.String getNSCCode() {
        return NSCCode;
    }


    /**
     * Sets the NSCCode value for this SymbolPrice.
     * 
     * @param NSCCode
     */
    public void setNSCCode(java.lang.String NSCCode) {
        this.NSCCode = NSCCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SymbolPrice)) return false;
        SymbolPrice other = (SymbolPrice) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.closingPrice == other.getClosingPrice() &&
            this.highAllowedPrice == other.getHighAllowedPrice() &&
            this.lowAllowedPrice == other.getLowAllowedPrice() &&
            this.totalNumberOfSharesTraded == other.getTotalNumberOfSharesTraded() &&
            this.totalNumberOfTrades == other.getTotalNumberOfTrades() &&
            this.totalTradeValue == other.getTotalTradeValue() &&
            this.highPrice == other.getHighPrice() &&
            this.lowPrice == other.getLowPrice() &&
            this.priceVar == other.getPriceVar() &&
            this.firstTradedPrice == other.getFirstTradedPrice() &&
            this.lastTradedPrice == other.getLastTradedPrice() &&
            ((this.symbolFa==null && other.getSymbolFa()==null) || 
             (this.symbolFa!=null &&
              this.symbolFa.equals(other.getSymbolFa()))) &&
            this.preClosingPrice == other.getPreClosingPrice() &&
            ((this.tradeDate==null && other.getTradeDate()==null) || 
             (this.tradeDate!=null &&
              this.tradeDate.equals(other.getTradeDate()))) &&
            this.refPrice == other.getRefPrice() &&
            ((this.varSign==null && other.getVarSign()==null) || 
             (this.varSign!=null &&
              this.varSign.equals(other.getVarSign()))) &&
            this.symbolStateId == other.getSymbolStateId() &&
            this.groupStateId == other.getGroupStateId() &&
            ((this.NSCCode==null && other.getNSCCode()==null) || 
             (this.NSCCode!=null &&
              this.NSCCode.equals(other.getNSCCode())));
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
        _hashCode += getClosingPrice();
        _hashCode += getHighAllowedPrice();
        _hashCode += getLowAllowedPrice();
        _hashCode += new Long(getTotalNumberOfSharesTraded()).hashCode();
        _hashCode += getTotalNumberOfTrades();
        _hashCode += new Long(getTotalTradeValue()).hashCode();
        _hashCode += getHighPrice();
        _hashCode += getLowPrice();
        _hashCode += new Double(getPriceVar()).hashCode();
        _hashCode += getFirstTradedPrice();
        _hashCode += getLastTradedPrice();
        if (getSymbolFa() != null) {
            _hashCode += getSymbolFa().hashCode();
        }
        _hashCode += getPreClosingPrice();
        if (getTradeDate() != null) {
            _hashCode += getTradeDate().hashCode();
        }
        _hashCode += getRefPrice();
        if (getVarSign() != null) {
            _hashCode += getVarSign().hashCode();
        }
        _hashCode += getSymbolStateId();
        _hashCode += getGroupStateId();
        if (getNSCCode() != null) {
            _hashCode += getNSCCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SymbolPrice.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "SymbolPrice"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("closingPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ClosingPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("highAllowedPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "HighAllowedPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lowAllowedPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "LowAllowedPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalNumberOfSharesTraded");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TotalNumberOfSharesTraded"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalNumberOfTrades");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TotalNumberOfTrades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalTradeValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TotalTradeValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("highPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "HighPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lowPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "LowPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priceVar");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PriceVar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstTradedPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "FirstTradedPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastTradedPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "LastTradedPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("symbolFa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SymbolFa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preClosingPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PreClosingPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tradeDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TradeDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "RefPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varSign");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "VarSign"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("symbolStateId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SymbolStateId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupStateId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GroupStateId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NSCCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "NSCCode"));
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
