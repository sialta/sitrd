/**
 * ExchangeSymbols.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.sefryek.broker.webservice.mobilev3;

public class ExchangeSymbols  implements java.io.Serializable {
    private com.sefryek.broker.webservice.mobilev3.ExchangeCompanies exchangeCompanies;

    private java.lang.String enSymbol;

    private int symbolId;

    private long insCode;

    private java.lang.String marketCode;

    private com.sefryek.broker.webservice.mobilev3.MarketType marketType;

    private java.lang.String NSCCode;

    private java.lang.String symbol;

    private int symbolTypeId;

    private com.sefryek.broker.webservice.mobilev3.ExchangeSymbolsStateEnum symbolsState;

    private int highAllowedPrice;

    private int lowAllowedPrice;

    private com.sefryek.broker.webservice.mobilev3.GroupStateEnum groupState;

    private int LOT;

    private int isApproved;

    private int isTradable;

    private int hiddenPrice;

    private com.sefryek.broker.webservice.mobilev3.SymbolPrice symbolPrice;

    public ExchangeSymbols() {
    }

    public ExchangeSymbols(
           com.sefryek.broker.webservice.mobilev3.ExchangeCompanies exchangeCompanies,
           java.lang.String enSymbol,
           int symbolId,
           long insCode,
           java.lang.String marketCode,
           com.sefryek.broker.webservice.mobilev3.MarketType marketType,
           java.lang.String NSCCode,
           java.lang.String symbol,
           int symbolTypeId,
           com.sefryek.broker.webservice.mobilev3.ExchangeSymbolsStateEnum symbolsState,
           int highAllowedPrice,
           int lowAllowedPrice,
           com.sefryek.broker.webservice.mobilev3.GroupStateEnum groupState,
           int LOT,
           int isApproved,
           int isTradable,
           int hiddenPrice,
           com.sefryek.broker.webservice.mobilev3.SymbolPrice symbolPrice) {
           this.exchangeCompanies = exchangeCompanies;
           this.enSymbol = enSymbol;
           this.symbolId = symbolId;
           this.insCode = insCode;
           this.marketCode = marketCode;
           this.marketType = marketType;
           this.NSCCode = NSCCode;
           this.symbol = symbol;
           this.symbolTypeId = symbolTypeId;
           this.symbolsState = symbolsState;
           this.highAllowedPrice = highAllowedPrice;
           this.lowAllowedPrice = lowAllowedPrice;
           this.groupState = groupState;
           this.LOT = LOT;
           this.isApproved = isApproved;
           this.isTradable = isTradable;
           this.hiddenPrice = hiddenPrice;
           this.symbolPrice = symbolPrice;
    }


    /**
     * Gets the exchangeCompanies value for this ExchangeSymbols.
     * 
     * @return exchangeCompanies
     */
    public com.sefryek.broker.webservice.mobilev3.ExchangeCompanies getExchangeCompanies() {
        return exchangeCompanies;
    }


    /**
     * Sets the exchangeCompanies value for this ExchangeSymbols.
     * 
     * @param exchangeCompanies
     */
    public void setExchangeCompanies(com.sefryek.broker.webservice.mobilev3.ExchangeCompanies exchangeCompanies) {
        this.exchangeCompanies = exchangeCompanies;
    }


    /**
     * Gets the enSymbol value for this ExchangeSymbols.
     * 
     * @return enSymbol
     */
    public java.lang.String getEnSymbol() {
        return enSymbol;
    }


    /**
     * Sets the enSymbol value for this ExchangeSymbols.
     * 
     * @param enSymbol
     */
    public void setEnSymbol(java.lang.String enSymbol) {
        this.enSymbol = enSymbol;
    }


    /**
     * Gets the symbolId value for this ExchangeSymbols.
     * 
     * @return symbolId
     */
    public int getSymbolId() {
        return symbolId;
    }


    /**
     * Sets the symbolId value for this ExchangeSymbols.
     * 
     * @param symbolId
     */
    public void setSymbolId(int symbolId) {
        this.symbolId = symbolId;
    }


    /**
     * Gets the insCode value for this ExchangeSymbols.
     * 
     * @return insCode
     */
    public long getInsCode() {
        return insCode;
    }


    /**
     * Sets the insCode value for this ExchangeSymbols.
     * 
     * @param insCode
     */
    public void setInsCode(long insCode) {
        this.insCode = insCode;
    }


    /**
     * Gets the marketCode value for this ExchangeSymbols.
     * 
     * @return marketCode
     */
    public java.lang.String getMarketCode() {
        return marketCode;
    }


    /**
     * Sets the marketCode value for this ExchangeSymbols.
     * 
     * @param marketCode
     */
    public void setMarketCode(java.lang.String marketCode) {
        this.marketCode = marketCode;
    }


    /**
     * Gets the marketType value for this ExchangeSymbols.
     * 
     * @return marketType
     */
    public com.sefryek.broker.webservice.mobilev3.MarketType getMarketType() {
        return marketType;
    }


    /**
     * Sets the marketType value for this ExchangeSymbols.
     * 
     * @param marketType
     */
    public void setMarketType(com.sefryek.broker.webservice.mobilev3.MarketType marketType) {
        this.marketType = marketType;
    }


    /**
     * Gets the NSCCode value for this ExchangeSymbols.
     * 
     * @return NSCCode
     */
    public java.lang.String getNSCCode() {
        return NSCCode;
    }


    /**
     * Sets the NSCCode value for this ExchangeSymbols.
     * 
     * @param NSCCode
     */
    public void setNSCCode(java.lang.String NSCCode) {
        this.NSCCode = NSCCode;
    }


    /**
     * Gets the symbol value for this ExchangeSymbols.
     * 
     * @return symbol
     */
    public java.lang.String getSymbol() {
        return symbol;
    }


    /**
     * Sets the symbol value for this ExchangeSymbols.
     * 
     * @param symbol
     */
    public void setSymbol(java.lang.String symbol) {
        this.symbol = symbol;
    }


    /**
     * Gets the symbolTypeId value for this ExchangeSymbols.
     * 
     * @return symbolTypeId
     */
    public int getSymbolTypeId() {
        return symbolTypeId;
    }


    /**
     * Sets the symbolTypeId value for this ExchangeSymbols.
     * 
     * @param symbolTypeId
     */
    public void setSymbolTypeId(int symbolTypeId) {
        this.symbolTypeId = symbolTypeId;
    }


    /**
     * Gets the symbolsState value for this ExchangeSymbols.
     * 
     * @return symbolsState
     */
    public com.sefryek.broker.webservice.mobilev3.ExchangeSymbolsStateEnum getSymbolsState() {
        return symbolsState;
    }


    /**
     * Sets the symbolsState value for this ExchangeSymbols.
     * 
     * @param symbolsState
     */
    public void setSymbolsState(com.sefryek.broker.webservice.mobilev3.ExchangeSymbolsStateEnum symbolsState) {
        this.symbolsState = symbolsState;
    }


    /**
     * Gets the highAllowedPrice value for this ExchangeSymbols.
     * 
     * @return highAllowedPrice
     */
    public int getHighAllowedPrice() {
        return highAllowedPrice;
    }


    /**
     * Sets the highAllowedPrice value for this ExchangeSymbols.
     * 
     * @param highAllowedPrice
     */
    public void setHighAllowedPrice(int highAllowedPrice) {
        this.highAllowedPrice = highAllowedPrice;
    }


    /**
     * Gets the lowAllowedPrice value for this ExchangeSymbols.
     * 
     * @return lowAllowedPrice
     */
    public int getLowAllowedPrice() {
        return lowAllowedPrice;
    }


    /**
     * Sets the lowAllowedPrice value for this ExchangeSymbols.
     * 
     * @param lowAllowedPrice
     */
    public void setLowAllowedPrice(int lowAllowedPrice) {
        this.lowAllowedPrice = lowAllowedPrice;
    }


    /**
     * Gets the groupState value for this ExchangeSymbols.
     * 
     * @return groupState
     */
    public com.sefryek.broker.webservice.mobilev3.GroupStateEnum getGroupState() {
        return groupState;
    }


    /**
     * Sets the groupState value for this ExchangeSymbols.
     * 
     * @param groupState
     */
    public void setGroupState(com.sefryek.broker.webservice.mobilev3.GroupStateEnum groupState) {
        this.groupState = groupState;
    }


    /**
     * Gets the LOT value for this ExchangeSymbols.
     * 
     * @return LOT
     */
    public int getLOT() {
        return LOT;
    }


    /**
     * Sets the LOT value for this ExchangeSymbols.
     * 
     * @param LOT
     */
    public void setLOT(int LOT) {
        this.LOT = LOT;
    }


    /**
     * Gets the isApproved value for this ExchangeSymbols.
     * 
     * @return isApproved
     */
    public int getIsApproved() {
        return isApproved;
    }


    /**
     * Sets the isApproved value for this ExchangeSymbols.
     * 
     * @param isApproved
     */
    public void setIsApproved(int isApproved) {
        this.isApproved = isApproved;
    }


    /**
     * Gets the isTradable value for this ExchangeSymbols.
     * 
     * @return isTradable
     */
    public int getIsTradable() {
        return isTradable;
    }


    /**
     * Sets the isTradable value for this ExchangeSymbols.
     * 
     * @param isTradable
     */
    public void setIsTradable(int isTradable) {
        this.isTradable = isTradable;
    }


    /**
     * Gets the hiddenPrice value for this ExchangeSymbols.
     * 
     * @return hiddenPrice
     */
    public int getHiddenPrice() {
        return hiddenPrice;
    }


    /**
     * Sets the hiddenPrice value for this ExchangeSymbols.
     * 
     * @param hiddenPrice
     */
    public void setHiddenPrice(int hiddenPrice) {
        this.hiddenPrice = hiddenPrice;
    }


    /**
     * Gets the symbolPrice value for this ExchangeSymbols.
     * 
     * @return symbolPrice
     */
    public com.sefryek.broker.webservice.mobilev3.SymbolPrice getSymbolPrice() {
        return symbolPrice;
    }


    /**
     * Sets the symbolPrice value for this ExchangeSymbols.
     * 
     * @param symbolPrice
     */
    public void setSymbolPrice(com.sefryek.broker.webservice.mobilev3.SymbolPrice symbolPrice) {
        this.symbolPrice = symbolPrice;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExchangeSymbols)) return false;
        ExchangeSymbols other = (ExchangeSymbols) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.exchangeCompanies==null && other.getExchangeCompanies()==null) || 
             (this.exchangeCompanies!=null &&
              this.exchangeCompanies.equals(other.getExchangeCompanies()))) &&
            ((this.enSymbol==null && other.getEnSymbol()==null) || 
             (this.enSymbol!=null &&
              this.enSymbol.equals(other.getEnSymbol()))) &&
            this.symbolId == other.getSymbolId() &&
            this.insCode == other.getInsCode() &&
            ((this.marketCode==null && other.getMarketCode()==null) || 
             (this.marketCode!=null &&
              this.marketCode.equals(other.getMarketCode()))) &&
            ((this.marketType==null && other.getMarketType()==null) || 
             (this.marketType!=null &&
              this.marketType.equals(other.getMarketType()))) &&
            ((this.NSCCode==null && other.getNSCCode()==null) || 
             (this.NSCCode!=null &&
              this.NSCCode.equals(other.getNSCCode()))) &&
            ((this.symbol==null && other.getSymbol()==null) || 
             (this.symbol!=null &&
              this.symbol.equals(other.getSymbol()))) &&
            this.symbolTypeId == other.getSymbolTypeId() &&
            ((this.symbolsState==null && other.getSymbolsState()==null) || 
             (this.symbolsState!=null &&
              this.symbolsState.equals(other.getSymbolsState()))) &&
            this.highAllowedPrice == other.getHighAllowedPrice() &&
            this.lowAllowedPrice == other.getLowAllowedPrice() &&
            ((this.groupState==null && other.getGroupState()==null) || 
             (this.groupState!=null &&
              this.groupState.equals(other.getGroupState()))) &&
            this.LOT == other.getLOT() &&
            this.isApproved == other.getIsApproved() &&
            this.isTradable == other.getIsTradable() &&
            this.hiddenPrice == other.getHiddenPrice() &&
            ((this.symbolPrice==null && other.getSymbolPrice()==null) || 
             (this.symbolPrice!=null &&
              this.symbolPrice.equals(other.getSymbolPrice())));
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
        if (getExchangeCompanies() != null) {
            _hashCode += getExchangeCompanies().hashCode();
        }
        if (getEnSymbol() != null) {
            _hashCode += getEnSymbol().hashCode();
        }
        _hashCode += getSymbolId();
        _hashCode += new Long(getInsCode()).hashCode();
        if (getMarketCode() != null) {
            _hashCode += getMarketCode().hashCode();
        }
        if (getMarketType() != null) {
            _hashCode += getMarketType().hashCode();
        }
        if (getNSCCode() != null) {
            _hashCode += getNSCCode().hashCode();
        }
        if (getSymbol() != null) {
            _hashCode += getSymbol().hashCode();
        }
        _hashCode += getSymbolTypeId();
        if (getSymbolsState() != null) {
            _hashCode += getSymbolsState().hashCode();
        }
        _hashCode += getHighAllowedPrice();
        _hashCode += getLowAllowedPrice();
        if (getGroupState() != null) {
            _hashCode += getGroupState().hashCode();
        }
        _hashCode += getLOT();
        _hashCode += getIsApproved();
        _hashCode += getIsTradable();
        _hashCode += getHiddenPrice();
        if (getSymbolPrice() != null) {
            _hashCode += getSymbolPrice().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExchangeSymbols.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ExchangeSymbols"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exchangeCompanies");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ExchangeCompanies"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ExchangeCompanies"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enSymbol");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "EnSymbol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("symbolId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SymbolId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "InsCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("marketCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "MarketCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("marketType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "MarketType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "MarketType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NSCCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "NSCCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("symbol");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Symbol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("symbolTypeId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SymbolTypeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("symbolsState");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SymbolsState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ExchangeSymbolsStateEnum"));
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
        elemField.setFieldName("groupState");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GroupState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "GroupStateEnum"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "LOT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isApproved");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "IsApproved"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isTradable");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "IsTradable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hiddenPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "HiddenPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("symbolPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SymbolPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "SymbolPrice"));
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
