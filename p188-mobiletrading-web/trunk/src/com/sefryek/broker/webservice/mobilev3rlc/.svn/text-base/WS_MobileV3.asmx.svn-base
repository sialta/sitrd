<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://tempuri.org/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" targetNamespace="http://tempuri.org/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://tempuri.org/">
      <s:element name="GetSymbolPriceWithFirstQueue">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="nscCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetSymbolPriceWithFirstQueueResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetSymbolPriceWithFirstQueueResult" type="tns:WsPriceWithFirstQueue" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="WsPriceWithFirstQueue">
        <s:complexContent mixed="false">
          <s:extension base="tns:WsPrice">
            <s:sequence>
              <s:element minOccurs="0" maxOccurs="1" name="QueueFirstRow" type="tns:WsQueue" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:complexType name="WsPrice">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="Date" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Time" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="IsNegative" type="s:boolean" />
          <s:element minOccurs="1" maxOccurs="1" name="IsRight" type="s:boolean" />
          <s:element minOccurs="1" maxOccurs="1" name="IsFaraBourse" type="s:boolean" />
          <s:element minOccurs="0" maxOccurs="1" name="NscCode" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="LastTradedPrice" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="RealChangePrice" type="s:unsignedByte" />
          <s:element minOccurs="1" maxOccurs="1" name="Mantissa" type="s:unsignedByte" />
          <s:element minOccurs="1" maxOccurs="1" name="ClosingPrice" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="HighAllowedPrice" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="LowAllowedPrice" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="PriceVar" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="PriceChange" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="TotalNumberOfSharesTraded" type="s:long" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="WsQueue">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="BestBuyPrice" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="BestSellPrice" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="BestSellQuantity" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="BestBuyQuantity" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="NoBestBuy" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="NoBestSell" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="NscCode" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetBestOfMarketWithFirstQueue">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="sorting" type="s:boolean" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetBestOfMarketWithFirstQueueResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetBestOfMarketWithFirstQueueResult" type="tns:ArrayOfWsPriceWithFirstQueue" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfWsPriceWithFirstQueue">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="WsPriceWithFirstQueue" nillable="true" type="tns:WsPriceWithFirstQueue" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetMainIndices">
        <s:complexType />
      </s:element>
      <s:element name="GetMainIndicesResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetMainIndicesResult" type="tns:ArrayOfWsIndices" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfWsIndices">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="WsIndices" nillable="true" type="tns:WsIndices" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="WsIndices">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="DateTime" type="s:dateTime" />
          <s:element minOccurs="0" maxOccurs="1" name="NscCode" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="LastValue" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="MaxValue" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="MinValue" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="ChangeReal" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="ChangePercent" type="s:double" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetMarketActivity">
        <s:complexType />
      </s:element>
      <s:element name="GetMarketActivityResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetMarketActivityResult" type="tns:WsMarketActivity" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="WsMarketActivity">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="DateTime" type="s:dateTime" />
          <s:element minOccurs="1" maxOccurs="1" name="TotalNoTrade" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="TotalTradeValue" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="TotalNoSharesTraded" type="s:int" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetSymbolPrice">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="nscCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetSymbolPriceResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetSymbolPriceResult" type="tns:WsPrice" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetWatchList">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="nscCodes" type="tns:WsWatchList" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="WsWatchList">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="NSCCode" type="tns:ArrayOfString" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ArrayOfString">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="string" nillable="true" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetWatchListResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetWatchListResult" type="tns:ArrayOfWsPrice" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfWsPrice">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="WsPrice" nillable="true" type="tns:WsPrice" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetBestOfMarket">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="sorting" type="s:boolean" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetBestOfMarketResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetBestOfMarketResult" type="tns:ArrayOfWsPrice" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetListOfMessages">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="lastReceived" type="s:dateTime" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetListOfMessagesResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetListOfMessagesResult" type="tns:ArrayOfWs_Message" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfWs_Message">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="Ws_Message" nillable="true" type="tns:Ws_Message" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="Ws_Message">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="MessageId" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="MessageDate" type="s:dateTime" />
          <s:element minOccurs="0" maxOccurs="1" name="MessageTitle" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="MessageDetail" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetMessageById">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="messageId" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMessageByIdResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetMessageByIdResult" type="tns:Ws_Message" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetSymbolQueue">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="nscCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetSymbolQueueResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetSymbolQueueResult" type="tns:ArrayOfWsQueue" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfWsQueue">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="WsQueue" nillable="true" type="tns:WsQueue" />
        </s:sequence>
      </s:complexType>
      <s:element name="ExchangeCompanyList">
        <s:complexType />
      </s:element>
      <s:element name="ExchangeCompanyListResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ExchangeCompanyListResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
  </wsdl:types>
  <wsdl:message name="GetSymbolPriceWithFirstQueueSoapIn">
    <wsdl:part name="parameters" element="tns:GetSymbolPriceWithFirstQueue" />
  </wsdl:message>
  <wsdl:message name="GetSymbolPriceWithFirstQueueSoapOut">
    <wsdl:part name="parameters" element="tns:GetSymbolPriceWithFirstQueueResponse" />
  </wsdl:message>
  <wsdl:message name="GetBestOfMarketWithFirstQueueSoapIn">
    <wsdl:part name="parameters" element="tns:GetBestOfMarketWithFirstQueue" />
  </wsdl:message>
  <wsdl:message name="GetBestOfMarketWithFirstQueueSoapOut">
    <wsdl:part name="parameters" element="tns:GetBestOfMarketWithFirstQueueResponse" />
  </wsdl:message>
  <wsdl:message name="GetMainIndicesSoapIn">
    <wsdl:part name="parameters" element="tns:GetMainIndices" />
  </wsdl:message>
  <wsdl:message name="GetMainIndicesSoapOut">
    <wsdl:part name="parameters" element="tns:GetMainIndicesResponse" />
  </wsdl:message>
  <wsdl:message name="GetMarketActivitySoapIn">
    <wsdl:part name="parameters" element="tns:GetMarketActivity" />
  </wsdl:message>
  <wsdl:message name="GetMarketActivitySoapOut">
    <wsdl:part name="parameters" element="tns:GetMarketActivityResponse" />
  </wsdl:message>
  <wsdl:message name="GetSymbolPriceSoapIn">
    <wsdl:part name="parameters" element="tns:GetSymbolPrice" />
  </wsdl:message>
  <wsdl:message name="GetSymbolPriceSoapOut">
    <wsdl:part name="parameters" element="tns:GetSymbolPriceResponse" />
  </wsdl:message>
  <wsdl:message name="GetWatchListSoapIn">
    <wsdl:part name="parameters" element="tns:GetWatchList" />
  </wsdl:message>
  <wsdl:message name="GetWatchListSoapOut">
    <wsdl:part name="parameters" element="tns:GetWatchListResponse" />
  </wsdl:message>
  <wsdl:message name="GetBestOfMarketSoapIn">
    <wsdl:part name="parameters" element="tns:GetBestOfMarket" />
  </wsdl:message>
  <wsdl:message name="GetBestOfMarketSoapOut">
    <wsdl:part name="parameters" element="tns:GetBestOfMarketResponse" />
  </wsdl:message>
  <wsdl:message name="GetListOfMessagesSoapIn">
    <wsdl:part name="parameters" element="tns:GetListOfMessages" />
  </wsdl:message>
  <wsdl:message name="GetListOfMessagesSoapOut">
    <wsdl:part name="parameters" element="tns:GetListOfMessagesResponse" />
  </wsdl:message>
  <wsdl:message name="GetMessageByIdSoapIn">
    <wsdl:part name="parameters" element="tns:GetMessageById" />
  </wsdl:message>
  <wsdl:message name="GetMessageByIdSoapOut">
    <wsdl:part name="parameters" element="tns:GetMessageByIdResponse" />
  </wsdl:message>
  <wsdl:message name="GetSymbolQueueSoapIn">
    <wsdl:part name="parameters" element="tns:GetSymbolQueue" />
  </wsdl:message>
  <wsdl:message name="GetSymbolQueueSoapOut">
    <wsdl:part name="parameters" element="tns:GetSymbolQueueResponse" />
  </wsdl:message>
  <wsdl:message name="ExchangeCompanyListSoapIn">
    <wsdl:part name="parameters" element="tns:ExchangeCompanyList" />
  </wsdl:message>
  <wsdl:message name="ExchangeCompanyListSoapOut">
    <wsdl:part name="parameters" element="tns:ExchangeCompanyListResponse" />
  </wsdl:message>
  <wsdl:portType name="WS_MobileV3Soap">
    <wsdl:operation name="GetSymbolPriceWithFirstQueue">
      <wsdl:input message="tns:GetSymbolPriceWithFirstQueueSoapIn" />
      <wsdl:output message="tns:GetSymbolPriceWithFirstQueueSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBestOfMarketWithFirstQueue">
      <wsdl:input message="tns:GetBestOfMarketWithFirstQueueSoapIn" />
      <wsdl:output message="tns:GetBestOfMarketWithFirstQueueSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMainIndices">
      <wsdl:input message="tns:GetMainIndicesSoapIn" />
      <wsdl:output message="tns:GetMainIndicesSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMarketActivity">
      <wsdl:input message="tns:GetMarketActivitySoapIn" />
      <wsdl:output message="tns:GetMarketActivitySoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetSymbolPrice">
      <wsdl:input message="tns:GetSymbolPriceSoapIn" />
      <wsdl:output message="tns:GetSymbolPriceSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetWatchList">
      <wsdl:input message="tns:GetWatchListSoapIn" />
      <wsdl:output message="tns:GetWatchListSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBestOfMarket">
      <wsdl:input message="tns:GetBestOfMarketSoapIn" />
      <wsdl:output message="tns:GetBestOfMarketSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetListOfMessages">
      <wsdl:input message="tns:GetListOfMessagesSoapIn" />
      <wsdl:output message="tns:GetListOfMessagesSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMessageById">
      <wsdl:input message="tns:GetMessageByIdSoapIn" />
      <wsdl:output message="tns:GetMessageByIdSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetSymbolQueue">
      <wsdl:input message="tns:GetSymbolQueueSoapIn" />
      <wsdl:output message="tns:GetSymbolQueueSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ExchangeCompanyList">
      <wsdl:input message="tns:ExchangeCompanyListSoapIn" />
      <wsdl:output message="tns:ExchangeCompanyListSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="WS_MobileV3Soap" type="tns:WS_MobileV3Soap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="GetSymbolPriceWithFirstQueue">
      <soap:operation soapAction="http://tempuri.org/GetSymbolPriceWithFirstQueue" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBestOfMarketWithFirstQueue">
      <soap:operation soapAction="http://tempuri.org/GetBestOfMarketWithFirstQueue" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMainIndices">
      <soap:operation soapAction="http://tempuri.org/GetMainIndices" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMarketActivity">
      <soap:operation soapAction="http://tempuri.org/GetMarketActivity" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSymbolPrice">
      <soap:operation soapAction="http://tempuri.org/GetSymbolPrice" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetWatchList">
      <soap:operation soapAction="http://tempuri.org/GetWatchList" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBestOfMarket">
      <soap:operation soapAction="http://tempuri.org/GetBestOfMarket" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetListOfMessages">
      <soap:operation soapAction="http://tempuri.org/GetListOfMessages" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMessageById">
      <soap:operation soapAction="http://tempuri.org/GetMessageById" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSymbolQueue">
      <soap:operation soapAction="http://tempuri.org/GetSymbolQueue" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExchangeCompanyList">
      <soap:operation soapAction="http://tempuri.org/ExchangeCompanyList" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="WS_MobileV3Soap12" type="tns:WS_MobileV3Soap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="GetSymbolPriceWithFirstQueue">
      <soap12:operation soapAction="http://tempuri.org/GetSymbolPriceWithFirstQueue" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBestOfMarketWithFirstQueue">
      <soap12:operation soapAction="http://tempuri.org/GetBestOfMarketWithFirstQueue" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMainIndices">
      <soap12:operation soapAction="http://tempuri.org/GetMainIndices" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMarketActivity">
      <soap12:operation soapAction="http://tempuri.org/GetMarketActivity" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSymbolPrice">
      <soap12:operation soapAction="http://tempuri.org/GetSymbolPrice" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetWatchList">
      <soap12:operation soapAction="http://tempuri.org/GetWatchList" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBestOfMarket">
      <soap12:operation soapAction="http://tempuri.org/GetBestOfMarket" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetListOfMessages">
      <soap12:operation soapAction="http://tempuri.org/GetListOfMessages" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMessageById">
      <soap12:operation soapAction="http://tempuri.org/GetMessageById" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSymbolQueue">
      <soap12:operation soapAction="http://tempuri.org/GetSymbolQueue" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExchangeCompanyList">
      <soap12:operation soapAction="http://tempuri.org/ExchangeCompanyList" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="WS_MobileV3">
    <wsdl:port name="WS_MobileV3Soap" binding="tns:WS_MobileV3Soap">
      <soap:address location="http://94.232.172.215/tadbirrlc/WebService/WS_MobileV3.asmx" />
    </wsdl:port>
    <wsdl:port name="WS_MobileV3Soap12" binding="tns:WS_MobileV3Soap12">
      <soap12:address location="http://94.232.172.215/tadbirrlc/WebService/WS_MobileV3.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>