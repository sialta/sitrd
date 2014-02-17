<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://tempuri.org/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" targetNamespace="http://tempuri.org/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://tempuri.org/">
      <s:element name="GetFinancialProviders">
        <s:complexType />
      </s:element>
      <s:element name="GetFinancialProvidersResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetFinancialProvidersResult" type="tns:ArrayOfMobileFinancialData" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfMobileFinancialData">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="MobileFinancialData" nillable="true" type="tns:MobileFinancialData" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="MobileFinancialData">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="Name" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="FinancialId" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="Names" type="tns:ArrayOfNameData" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ArrayOfNameData">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="NameData" nillable="true" type="tns:NameData" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="NameData">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="Lan" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Name" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="AddOrderWithFinancial">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="orderMessage" type="tns:WsOrderMessageWithFinancial" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="WsOrderMessageWithFinancial">
        <s:complexContent mixed="false">
          <s:extension base="tns:WsOrderMessage">
            <s:sequence>
              <s:element minOccurs="1" maxOccurs="1" name="FinancialId" type="s:int" />
              <s:element minOccurs="1" maxOccurs="1" name="ParentId" nillable="true" type="s:long" />
              <s:element minOccurs="0" maxOccurs="1" name="Lan" type="s:string" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:complexType name="WsOrderMessage">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="CustomerId" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="ExchangeSymbols" type="tns:ExchangeSymbols" />
          <s:element minOccurs="1" maxOccurs="1" name="ExcutedAmount" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="HidenOrder" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="Id" nillable="true" type="s:long" />
          <s:element minOccurs="1" maxOccurs="1" name="MaximumQuantity" nillable="true" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="MaxShown" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="MinimumQuantity" nillable="true" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="OrderEntryDate" type="s:dateTime" />
          <s:element minOccurs="1" maxOccurs="1" name="OrderPrice" type="s:decimal" />
          <s:element minOccurs="1" maxOccurs="1" name="OrderSide" type="tns:WsOrderSide" />
          <s:element minOccurs="1" maxOccurs="1" name="OrderState" type="tns:OrderState" />
          <s:element minOccurs="1" maxOccurs="1" name="OrderTotalQuantity" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="OrderType" type="tns:WsOrderType" />
          <s:element minOccurs="1" maxOccurs="1" name="OrderValidity" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="OrderValidityDate" type="s:dateTime" />
          <s:element minOccurs="1" maxOccurs="1" name="BrokerId" nillable="true" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="IsinCode" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="TriggerPrice" nillable="true" type="s:decimal" />
          <s:element minOccurs="0" maxOccurs="1" name="ReferenceKey" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ExchangeSymbols">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="ExchangeCompanies" type="tns:ExchangeCompanies" />
          <s:element minOccurs="0" maxOccurs="1" name="EnSymbol" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="SymbolId" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="InsCode" type="s:long" />
          <s:element minOccurs="0" maxOccurs="1" name="MarketCode" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="MarketType" type="tns:MarketType" />
          <s:element minOccurs="0" maxOccurs="1" name="NSCCode" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Symbol" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="SymbolTypeId" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="SymbolsState" type="tns:ExchangeSymbolsStateEnum" />
          <s:element minOccurs="1" maxOccurs="1" name="HighAllowedPrice" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="LowAllowedPrice" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="GroupState" type="tns:GroupStateEnum" />
          <s:element minOccurs="1" maxOccurs="1" name="LOT" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="IsApproved" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="IsTradable" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="HiddenPrice" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="SymbolPrice" type="tns:SymbolPrice" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ExchangeCompanies">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="ExchangeBoard" type="tns:ExchangeBoards" />
          <s:element minOccurs="0" maxOccurs="1" name="ManagerFullName" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="CurrentAsset" type="s:decimal" />
          <s:element minOccurs="0" maxOccurs="1" name="ExchangeCode" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="StockCompanyAddressId" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="StockHolderDepartmentManagerFullName" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="StockHolderDepartmentAddressId" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="SubSectorId" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="SectorId" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="BaseVolume" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="Title" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="EnTitle" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="IsActive" type="s:boolean" />
          <s:element minOccurs="0" maxOccurs="1" name="ISIN" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="WebSite" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="CurrentActivity" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="EPS" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="Id" type="s:int" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ExchangeBoards">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="ExchangeBoardId" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="Title" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Description" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ExchangeMarket" type="tns:ExchangeMarket" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ExchangeMarket">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="Title" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Description" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="ExchangeMarketId" type="s:int" />
        </s:sequence>
      </s:complexType>
      <s:simpleType name="MarketType">
        <s:restriction base="s:string">
          <s:enumeration value="None" />
          <s:enumeration value="All" />
          <s:enumeration value="TehranStock" />
          <s:enumeration value="TehranATIStock" />
          <s:enumeration value="IMEATIGoldCoin" />
          <s:enumeration value="IMEATIGoldCoinOffline" />
          <s:enumeration value="TME" />
        </s:restriction>
      </s:simpleType>
      <s:simpleType name="ExchangeSymbolsStateEnum">
        <s:restriction base="s:string">
          <s:enumeration value="NotProvided" />
          <s:enumeration value="Authorized" />
          <s:enumeration value="AuthorizedSuspend" />
          <s:enumeration value="AuthorizedReserve" />
          <s:enumeration value="AuthorizedFrozen" />
          <s:enumeration value="Forbidden" />
          <s:enumeration value="ForbiddenSuspend" />
          <s:enumeration value="ForbiddenReserve" />
          <s:enumeration value="ForbiddenFrozen" />
        </s:restriction>
      </s:simpleType>
      <s:simpleType name="GroupStateEnum">
        <s:restriction base="s:string">
          <s:enumeration value="None" />
          <s:enumeration value="Start_Consultation" />
          <s:enumeration value="Pre_opening" />
          <s:enumeration value="Opening_OR_Closing" />
          <s:enumeration value="Intervention_before_opening" />
          <s:enumeration value="Continuous_Trading" />
          <s:enumeration value="Trading_At_Last" />
          <s:enumeration value="Surveillance_intervention" />
          <s:enumeration value="End_of_consultation" />
          <s:enumeration value="Post_session" />
          <s:enumeration value="Forbidden" />
          <s:enumeration value="Interrupted" />
        </s:restriction>
      </s:simpleType>
      <s:complexType name="SymbolPrice">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="ClosingPrice" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="HighAllowedPrice" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="LowAllowedPrice" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="TotalNumberOfSharesTraded" type="s:long" />
          <s:element minOccurs="1" maxOccurs="1" name="TotalNumberOfTrades" type="s:short" />
          <s:element minOccurs="1" maxOccurs="1" name="TotalTradeValue" type="s:long" />
          <s:element minOccurs="1" maxOccurs="1" name="HighPrice" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="LowPrice" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="PriceVar" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="FirstTradedPrice" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="LastTradedPrice" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="SymbolFa" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="PreClosingPrice" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="TradeDate" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="RefPrice" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="VarSign" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="SymbolStateId" type="s:short" />
          <s:element minOccurs="1" maxOccurs="1" name="GroupStateId" type="s:short" />
          <s:element minOccurs="0" maxOccurs="1" name="NSCCode" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:simpleType name="WsOrderSide">
        <s:restriction base="s:string">
          <s:enumeration value="Buy" />
          <s:enumeration value="Sell" />
          <s:enumeration value="Cross" />
          <s:enumeration value="None" />
        </s:restriction>
      </s:simpleType>
      <s:simpleType name="OrderState">
        <s:restriction base="s:string">
          <s:enumeration value="None" />
          <s:enumeration value="Modify" />
          <s:enumeration value="Error" />
          <s:enumeration value="Cancel" />
          <s:enumeration value="Delete" />
          <s:enumeration value="Done" />
          <s:enumeration value="OnBoard" />
          <s:enumeration value="OnSending" />
          <s:enumeration value="PartiallyExcution" />
          <s:enumeration value="OnCanceling" />
          <s:enumeration value="OnCancelError" />
          <s:enumeration value="OnModifyError" />
          <s:enumeration value="DeleteByBroker" />
          <s:enumeration value="Expired" />
          <s:enumeration value="PartiallyExcutionAndExpired" />
          <s:enumeration value="CancelByBrokerForUnBlock" />
          <s:enumeration value="OnModify" />
          <s:enumeration value="DeleteByNSC" />
          <s:enumeration value="CancelByBrokerForOrderOnAir" />
          <s:enumeration value="OnModifyBoard" />
          <s:enumeration value="OrderExecuted" />
          <s:enumeration value="PendingConfirm" />
          <s:enumeration value="Confirmed" />
          <s:enumeration value="PendingCancelOrder" />
          <s:enumeration value="CancelOrderConfirmed" />
          <s:enumeration value="Reject" />
          <s:enumeration value="CancelPendingOrderByUser" />
        </s:restriction>
      </s:simpleType>
      <s:simpleType name="WsOrderType">
        <s:restriction base="s:string">
          <s:enumeration value="LimiteOrder" />
          <s:enumeration value="Market_on_Opening_order" />
          <s:enumeration value="Market_Order" />
          <s:enumeration value="Stop_Order" />
          <s:enumeration value="Market_to_Limit_order" />
          <s:enumeration value="None" />
        </s:restriction>
      </s:simpleType>
      <s:element name="AddOrderWithFinancialResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="AddOrderWithFinancialResult" type="tns:WsOrderActionResponse" />
            <s:element minOccurs="0" maxOccurs="1" name="orderMessage" type="tns:WsOrderMessageWithFinancial" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="WsOrderActionResponse">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="IsSuccesful" type="s:boolean" />
          <s:element minOccurs="1" maxOccurs="1" name="OrderId" nillable="true" type="s:long" />
          <s:element minOccurs="0" maxOccurs="1" name="ErrorCode" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ErrorDescription" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Lan" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="ModifyOrder">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="orderMessage" type="tns:WsOrderMessageWithFinancial" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ModifyOrderResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ModifyOrderResult" type="tns:WsOrderActionResponse" />
            <s:element minOccurs="0" maxOccurs="1" name="orderMessage" type="tns:WsOrderMessageWithFinancial" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetOrderBookV2">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="customerId" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="pageIndex" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="pageSize" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="totalRow" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetOrderBookV2Response">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetOrderBookV2Result" type="tns:ArrayOfWsOrderMessageWithFinancial" />
            <s:element minOccurs="1" maxOccurs="1" name="totalRow" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfWsOrderMessageWithFinancial">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="WsOrderMessageWithFinancial" nillable="true" type="tns:WsOrderMessageWithFinancial" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetOrderListV2">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="reportType" type="tns:OrderListReport" />
            <s:element minOccurs="1" maxOccurs="1" name="pageIndex" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="pageSize" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="totalRow" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:simpleType name="OrderListReport">
        <s:restriction base="s:string">
          <s:enumeration value="Trades" />
          <s:enumeration value="Orders" />
          <s:enumeration value="OpenOrders" />
        </s:restriction>
      </s:simpleType>
      <s:element name="GetOrderListV2Response">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetOrderListV2Result" type="tns:ArrayOfWsOrderMessageWithFinancial" />
            <s:element minOccurs="1" maxOccurs="1" name="totalRow" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetCustomerCdsPortfolio">
        <s:complexType />
      </s:element>
      <s:element name="GetCustomerCdsPortfolioResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetCustomerCdsPortfolioResult" type="tns:ArrayOfWsCdsPortfolio" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfWsCdsPortfolio">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="WsCdsPortfolio" nillable="true" type="tns:WsCdsPortfolio" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="WsCdsPortfolio">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="Count" type="s:long" />
          <s:element minOccurs="0" maxOccurs="1" name="SymbolISIN" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="AddOrder">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="orderMessage" type="tns:WsOrderMessage" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="AddOrderResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="AddOrderResult" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="orderMessage" type="tns:WsOrderMessage" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="CancelOrder">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="orderId" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="CancelOrderResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="CancelOrderResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetCirculationAccountList">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="customerId" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="pageIndex" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="pageSize" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="totalRow" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetCirculationAccountListResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetCirculationAccountListResult" type="tns:ArrayOfWsCirculationAccount" />
            <s:element minOccurs="1" maxOccurs="1" name="totalRow" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfWsCirculationAccount">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="WsCirculationAccount" nillable="true" type="tns:WsCirculationAccount" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="WsCirculationAccount">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="VoucherNo" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="AccountCode" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="VoucherDate" type="s:dateTime" />
          <s:element minOccurs="0" maxOccurs="1" name="DetailDescription" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="Debtor" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="Creditor" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="VoucherType" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="Balanced" type="s:double" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetOrderBook">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="customerId" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="pageIndex" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="pageSize" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="totalRow" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetOrderBookResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetOrderBookResult" type="tns:ArrayOfWsOrderMessage" />
            <s:element minOccurs="1" maxOccurs="1" name="totalRow" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfWsOrderMessage">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="WsOrderMessage" nillable="true" type="tns:WsOrderMessage" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetOrderList">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="customerId" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="pageIndex" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="pageSize" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="totalRow" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetOrderListResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetOrderListResult" type="tns:ArrayOfWsOrderMessage" />
            <s:element minOccurs="1" maxOccurs="1" name="totalRow" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetSetting">
        <s:complexType />
      </s:element>
      <s:element name="GetSettingResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetSettingResult" type="tns:MobileOMSSetting" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="MobileOMSSetting">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="ActiveRightForBuy" type="s:boolean" />
          <s:element minOccurs="1" maxOccurs="1" name="ActiveRightForSell" type="s:boolean" />
          <s:element minOccurs="1" maxOccurs="1" name="LoginSetting" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="MarketCloseTime" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="MarketOpenTime" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="MinimumOrderCountForBuy" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="MinimumOrderCountForSell" type="s:int" />
        </s:sequence>
      </s:complexType>
      <s:element name="Login">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="userName" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="LoginResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="LoginResult" type="tns:WsPersonInfo" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="WsPersonInfo">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="CustomerId" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="BourseCodes" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="IsinCodes" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Remain" type="tns:Remain" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="Remain">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="RealBalance" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="BlockedBalance" type="s:double" />
        </s:sequence>
      </s:complexType>
    </s:schema>
  </wsdl:types>
  <wsdl:message name="GetFinancialProvidersSoapIn">
    <wsdl:part name="parameters" element="tns:GetFinancialProviders" />
  </wsdl:message>
  <wsdl:message name="GetFinancialProvidersSoapOut">
    <wsdl:part name="parameters" element="tns:GetFinancialProvidersResponse" />
  </wsdl:message>
  <wsdl:message name="AddOrderWithFinancialSoapIn">
    <wsdl:part name="parameters" element="tns:AddOrderWithFinancial" />
  </wsdl:message>
  <wsdl:message name="AddOrderWithFinancialSoapOut">
    <wsdl:part name="parameters" element="tns:AddOrderWithFinancialResponse" />
  </wsdl:message>
  <wsdl:message name="ModifyOrderSoapIn">
    <wsdl:part name="parameters" element="tns:ModifyOrder" />
  </wsdl:message>
  <wsdl:message name="ModifyOrderSoapOut">
    <wsdl:part name="parameters" element="tns:ModifyOrderResponse" />
  </wsdl:message>
  <wsdl:message name="GetOrderBookV2SoapIn">
    <wsdl:part name="parameters" element="tns:GetOrderBookV2" />
  </wsdl:message>
  <wsdl:message name="GetOrderBookV2SoapOut">
    <wsdl:part name="parameters" element="tns:GetOrderBookV2Response" />
  </wsdl:message>
  <wsdl:message name="GetOrderListV2SoapIn">
    <wsdl:part name="parameters" element="tns:GetOrderListV2" />
  </wsdl:message>
  <wsdl:message name="GetOrderListV2SoapOut">
    <wsdl:part name="parameters" element="tns:GetOrderListV2Response" />
  </wsdl:message>
  <wsdl:message name="GetCustomerCdsPortfolioSoapIn">
    <wsdl:part name="parameters" element="tns:GetCustomerCdsPortfolio" />
  </wsdl:message>
  <wsdl:message name="GetCustomerCdsPortfolioSoapOut">
    <wsdl:part name="parameters" element="tns:GetCustomerCdsPortfolioResponse" />
  </wsdl:message>
  <wsdl:message name="AddOrderSoapIn">
    <wsdl:part name="parameters" element="tns:AddOrder" />
  </wsdl:message>
  <wsdl:message name="AddOrderSoapOut">
    <wsdl:part name="parameters" element="tns:AddOrderResponse" />
  </wsdl:message>
  <wsdl:message name="CancelOrderSoapIn">
    <wsdl:part name="parameters" element="tns:CancelOrder" />
  </wsdl:message>
  <wsdl:message name="CancelOrderSoapOut">
    <wsdl:part name="parameters" element="tns:CancelOrderResponse" />
  </wsdl:message>
  <wsdl:message name="GetCirculationAccountListSoapIn">
    <wsdl:part name="parameters" element="tns:GetCirculationAccountList" />
  </wsdl:message>
  <wsdl:message name="GetCirculationAccountListSoapOut">
    <wsdl:part name="parameters" element="tns:GetCirculationAccountListResponse" />
  </wsdl:message>
  <wsdl:message name="GetOrderBookSoapIn">
    <wsdl:part name="parameters" element="tns:GetOrderBook" />
  </wsdl:message>
  <wsdl:message name="GetOrderBookSoapOut">
    <wsdl:part name="parameters" element="tns:GetOrderBookResponse" />
  </wsdl:message>
  <wsdl:message name="GetOrderListSoapIn">
    <wsdl:part name="parameters" element="tns:GetOrderList" />
  </wsdl:message>
  <wsdl:message name="GetOrderListSoapOut">
    <wsdl:part name="parameters" element="tns:GetOrderListResponse" />
  </wsdl:message>
  <wsdl:message name="GetSettingSoapIn">
    <wsdl:part name="parameters" element="tns:GetSetting" />
  </wsdl:message>
  <wsdl:message name="GetSettingSoapOut">
    <wsdl:part name="parameters" element="tns:GetSettingResponse" />
  </wsdl:message>
  <wsdl:message name="LoginSoapIn">
    <wsdl:part name="parameters" element="tns:Login" />
  </wsdl:message>
  <wsdl:message name="LoginSoapOut">
    <wsdl:part name="parameters" element="tns:LoginResponse" />
  </wsdl:message>
  <wsdl:portType name="WS_MobileV3Soap">
    <wsdl:operation name="GetFinancialProviders">
      <wsdl:input message="tns:GetFinancialProvidersSoapIn" />
      <wsdl:output message="tns:GetFinancialProvidersSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="AddOrderWithFinancial">
      <wsdl:input message="tns:AddOrderWithFinancialSoapIn" />
      <wsdl:output message="tns:AddOrderWithFinancialSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ModifyOrder">
      <wsdl:input message="tns:ModifyOrderSoapIn" />
      <wsdl:output message="tns:ModifyOrderSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetOrderBookV2">
      <wsdl:input message="tns:GetOrderBookV2SoapIn" />
      <wsdl:output message="tns:GetOrderBookV2SoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetOrderListV2">
      <wsdl:input message="tns:GetOrderListV2SoapIn" />
      <wsdl:output message="tns:GetOrderListV2SoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCustomerCdsPortfolio">
      <wsdl:input message="tns:GetCustomerCdsPortfolioSoapIn" />
      <wsdl:output message="tns:GetCustomerCdsPortfolioSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="AddOrder">
      <wsdl:input message="tns:AddOrderSoapIn" />
      <wsdl:output message="tns:AddOrderSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="CancelOrder">
      <wsdl:input message="tns:CancelOrderSoapIn" />
      <wsdl:output message="tns:CancelOrderSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCirculationAccountList">
      <wsdl:input message="tns:GetCirculationAccountListSoapIn" />
      <wsdl:output message="tns:GetCirculationAccountListSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetOrderBook">
      <wsdl:input message="tns:GetOrderBookSoapIn" />
      <wsdl:output message="tns:GetOrderBookSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetOrderList">
      <wsdl:input message="tns:GetOrderListSoapIn" />
      <wsdl:output message="tns:GetOrderListSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetSetting">
      <wsdl:input message="tns:GetSettingSoapIn" />
      <wsdl:output message="tns:GetSettingSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Login">
      <wsdl:input message="tns:LoginSoapIn" />
      <wsdl:output message="tns:LoginSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="WS_MobileV3Soap" type="tns:WS_MobileV3Soap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="GetFinancialProviders">
      <soap:operation soapAction="http://tempuri.org/GetFinancialProviders" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="AddOrderWithFinancial">
      <soap:operation soapAction="http://tempuri.org/AddOrderWithFinancial" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ModifyOrder">
      <soap:operation soapAction="http://tempuri.org/ModifyOrder" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetOrderBookV2">
      <soap:operation soapAction="http://tempuri.org/GetOrderBookV2" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetOrderListV2">
      <soap:operation soapAction="http://tempuri.org/GetOrderListV2" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCustomerCdsPortfolio">
      <soap:operation soapAction="http://tempuri.org/GetCustomerCdsPortfolio" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="AddOrder">
      <soap:operation soapAction="http://tempuri.org/AddOrder" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CancelOrder">
      <soap:operation soapAction="http://tempuri.org/CancelOrder" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCirculationAccountList">
      <soap:operation soapAction="http://tempuri.org/GetCirculationAccountList" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetOrderBook">
      <soap:operation soapAction="http://tempuri.org/GetOrderBook" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetOrderList">
      <soap:operation soapAction="http://tempuri.org/GetOrderList" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSetting">
      <soap:operation soapAction="http://tempuri.org/GetSetting" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Login">
      <soap:operation soapAction="http://tempuri.org/Login" style="document" />
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
    <wsdl:operation name="GetFinancialProviders">
      <soap12:operation soapAction="http://tempuri.org/GetFinancialProviders" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="AddOrderWithFinancial">
      <soap12:operation soapAction="http://tempuri.org/AddOrderWithFinancial" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ModifyOrder">
      <soap12:operation soapAction="http://tempuri.org/ModifyOrder" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetOrderBookV2">
      <soap12:operation soapAction="http://tempuri.org/GetOrderBookV2" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetOrderListV2">
      <soap12:operation soapAction="http://tempuri.org/GetOrderListV2" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCustomerCdsPortfolio">
      <soap12:operation soapAction="http://tempuri.org/GetCustomerCdsPortfolio" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="AddOrder">
      <soap12:operation soapAction="http://tempuri.org/AddOrder" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CancelOrder">
      <soap12:operation soapAction="http://tempuri.org/CancelOrder" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCirculationAccountList">
      <soap12:operation soapAction="http://tempuri.org/GetCirculationAccountList" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetOrderBook">
      <soap12:operation soapAction="http://tempuri.org/GetOrderBook" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetOrderList">
      <soap12:operation soapAction="http://tempuri.org/GetOrderList" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSetting">
      <soap12:operation soapAction="http://tempuri.org/GetSetting" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Login">
      <soap12:operation soapAction="http://tempuri.org/Login" style="document" />
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
      <soap:address location="http://www.mofidonline.com/webservice/WS_MobileV3.asmx" />
    </wsdl:port>
    <wsdl:port name="WS_MobileV3Soap12" binding="tns:WS_MobileV3Soap12">
      <soap12:address location="http://www.mofidonline.com/webservice/WS_MobileV3.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>