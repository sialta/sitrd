package com.sefryek.broker.utils.sessionUtils;

import com.sefryek.broker.webservice.RequestManager;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jun 20, 2011
 * Time: 9:51:25 AM
 */
public class Session {
    protected String brokerId;
    protected String customerId;
    protected String sessionId;

    protected String encryptionKey;
    protected RequestManager manager;

    protected long usageTime;
    protected String[] companyResult = null;


    public Session(String brokerId, String customerId, String sessionId, RequestManager manager, String encryptionKey, long usageTime) {
        this.brokerId = brokerId;
        this.customerId = customerId;
        this.sessionId = sessionId;
        this.manager = manager;
        this.encryptionKey = encryptionKey;
        this.usageTime = usageTime;
    }

    public String getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public RequestManager getManager() {
        return manager;
    }

    public void setManager(RequestManager manager) {
        this.manager = manager;
    }

    public long getUsageTime() {
        return usageTime;
    }

    public void setUsageTime(long usageTime) {
        this.usageTime = usageTime;
    }

    public String[] getCompanyResult() {
        return companyResult;
    }

    public void setCompanyResult(String[] companyResult) {
        this.companyResult = companyResult;
    }
}
