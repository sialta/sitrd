package com.sefryek.broker.model;

import java.util.Date;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Mahta
 * Date: May 15, 2011
 * Time: 3:42:00 PM
 */

public class Account implements Serializable {
    public static enum Status{ACTIVE, BLOCKED, DELETED}

    private Integer id;
    private String accountNo;
    private String accountType;
    private String mobileNumber;
    private String encryptionKey;
    private String fullName;
    private String status;

    // The defauls alue is 255 which in binary is 1111111111111111
    // the first digit: permission of add account
    // the second digit: permission of declare inventory
    // the second digit: permission of declare inventory
    // the third digit: permission of mony transfer
    // the forth digit: permission of n flow account
    // the fifth digit: permission of pay bill
    private int actionPermissions;

    private int serviceCode;
    private int passwordTryTimes;

    private Date date;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEncryptionKey() {
        return encryptionKey;
    }
    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public int getActionPermissions() {
        return actionPermissions;
    }
    public void setActionPermissions(int actionPermissions) {
        this.actionPermissions = actionPermissions;
    }

    public int getServiceCode() {
        return serviceCode;
    }
    public void setServiceCode(int serviceCode) {
        this.serviceCode = serviceCode;
    }

    public int getPasswordTryTimes() {
        return passwordTryTimes;
    }
    public void setPasswordTryTimes(int passwordTryTimes) {
        this.passwordTryTimes = passwordTryTimes;
    }

}
