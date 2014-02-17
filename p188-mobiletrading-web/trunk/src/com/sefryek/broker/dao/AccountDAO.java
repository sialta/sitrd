//package com.sefryek.broker.dao;
//
//import org.apache.log4j.Logger;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.Statement;
//import java.sql.ResultSet;
//import java.util.Date;
//import reflect.Field;
//import reflect.Array;
//
//import com.sefryek.broker.pool.JDBCConnectionPool.ConnectionFactory;
//import com.sefryek.broker.utils.DateUtil;
//import com.sefryek.broker.utils.MobileNumberUtil;
//import com.sefryek.broker.model.Account;
//import com.sefryek.broker.mobileHandler.MIDletConstant;
//
///**
// * Created by IntelliJ IDEA.
// * User: mahta
// * Date: May 21, 2011
// * Time: 8:55:33 AM
// */
//public class AccountDAO {
//    private static Logger logger = Logger.getLogger(AccountDAO.class);
//
//    public static Integer updateAccount(String accountNumber, String accountType, String username) {
//        logger.debug("Save or Update Account with no: " + accountNumber);
//        if(!isValidMobileNumber(username))
//            return null;
//
//        try {
//            ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
//            Connection connection = connectionFactory.getConnection();
//
//            if (connection != null && accountNumber != null && !accountNumber.trim().equals("")) {
//                logger.debug("DB Connection is not null.");
//
//                /*
//                User setString(int parameterIndex, String x) or setInt(int parameterIndex, int x) or ..  method of preparedStatement, to avoidance of sql injection ,
//                The first argument for each of these setter methods specifies the question mark placeholder.
//                 */
//                String outboundQuery = "select * from account where account_number = ? ;";
//                PreparedStatement preparedStatement = connection.prepareStatement(outboundQuery, Statement.RETURN_GENERATED_KEYS);
//                preparedStatement.setString(1, accountNumber.trim());
//                preparedStatement.execute();
//                ResultSet resultSet = preparedStatement.getResultSet();
//
//                int rowCount = 0;
//                while (resultSet.next()) {
//                    rowCount++;
//                }
//
//                if(rowCount == 0) {
//                    logger.debug("There is no account with no: " + accountNumber + ". So inserted a new one.");
//                    String date = DateUtil.getFormattedDate(new Date(), DateUtil.Pattern.YYYY_MM_DD_HH_MM_SS);
//                    String accountQuery = "insert into account (`account_number`, `account_type`, `mobile_number`, " +
//                            "`fa_name`, `en_name`,`action_permissions`, `password_try_times`,`status`,`creation_date`) " +
//                            "value (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//                    PreparedStatement stmt = connection.prepareStatement(accountQuery, Statement.RETURN_GENERATED_KEYS);
//                    stmt.setString(1, accountNumber);
//                    stmt.setString(2, (accountType == null ? "" : accountType));
//                    stmt.setString(3, (username == null ? "" : MobileNumberUtil.getStandardMobileNumber(username)));
//                    stmt.setString(4, null);
//                    stmt.setString(5, null);
//                    /*
//                     we have 20 services and the integer value of "11111111111111111" is 131071, which "11111111111111111" is the binary value of services permissions
//                     we have 20 services so need to set permission of 20, so by default set 1 for each service in out string of size 20.
//                     Then convert this binary string to integer and save it in db
//                      */
//                    Integer decimalValueOfPermissions = Integer.valueOf("11111111111111111111", 2);
//                    logger.debug("Decimal value of 20 digit permissions(11111111111111111111) is:" + decimalValueOfPermissions);
//                    stmt.setInt(6, decimalValueOfPermissions);
//                    stmt.setInt(7, 0);
//                    stmt.setString(8, Account.Status.ACTIVE.name());
//                    stmt.setString(9, date);
//
//                    stmt.executeUpdate();
//
//                    ResultSet keyset = stmt.getGeneratedKeys();
//                    keyset.next();
//                    Integer accountId = keyset.getInt(1);
//
//                    connection.commit();
//                    connection.close();
//                    return accountId;
//                }
//
//            }
//
//
//        } catch (Exception e) {
//            logger.debug("An exception occurred durring createing new account with no: " + accountNumber );
//            e.printStackTrace();
//            return 0;
//        }
//
//        logger.debug("End of adding account with no: " + accountNumber);
//        return 0;
//
//    }
//
//    public static int checkeUserStatusAndServicePermission(String accountNumber, Integer serviceCode) {
//        logger.debug("Check account's status and service permission for account with no: " + accountNumber);
//        if(serviceCode == MIDletConstant.SERVICE_CONTROL_ACCOUNT)
//            return 1;
//
//        try {
//            ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
//            Connection connection = connectionFactory.getConnection();
//
//            if (connection != null && accountNumber != null && !accountNumber.trim().equals("")) {
//                logger.debug("DB Connection is not null.");
//
//                /*
//               User setString(int parameterIndex, String x) or setInt(int parameterIndex, int x) or ..  method of preparedStatement, to avoidance of sql injection ,
//               The first argument for each of these setter methods specifies the question mark placeholder.
//                */
//                String outboundQuery = "select * from account where account_number = ? ";
//                PreparedStatement preparedStatement = connection.prepareStatement(outboundQuery);
//                preparedStatement.setString(1, accountNumber.trim());
//                preparedStatement.execute();
//                ResultSet resultSet = preparedStatement.getResultSet();
//
//                String status = "";
//                int actionPermissions = 0;
//
//                int rowCount = 0;
//                while (resultSet.next()) {
//
//                    if(rowCount == 0) {
//                        status = resultSet.getString("status");
//                        actionPermissions = resultSet.getInt("action_permissions");
//                    }
//                    rowCount++;
//                }
//
//                if(rowCount == 0) {
//                    return 1;
//                }
//
//                if(status.equals(Account.Status.BLOCKED.name()))
//                    return MIDletConstant.USER_ACCOUNT_BLOCKED;
//
//                String binaryPermissions = Integer.toBinaryString(actionPermissions);
//                while(binaryPermissions.length() < 20)
//                    binaryPermissions += "0";
//
//                if(binaryPermissions.charAt(serviceCode - 1) == '1')
//                    return 1;
//
//                return 0;
//
//            }
//
//
//        } catch (Exception e) {
//            logger.debug("An exception durring checking account status for account: " + accountNumber
//                    + ", and service coed:" + serviceCode);
//            e.printStackTrace();
//            return MIDletConstant.UNKNOWN_EXCEPTION;
//        }
//
//        logger.debug("End of adding account with no: " + accountNumber);
//        return MIDletConstant.DB_CONNECTION_ERROR;
//
//    }
//
//    public static void saveTheNameOfAccount(String accountNumber, String faName, String enName) {
//        logger.debug("Saving name of owner of account: " + accountNumber + ", fa name:" + faName + ", en name:" + enName);
//
//        try {
//            ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
//            Connection connection = connectionFactory.getConnection();
//
//            if (connection != null && accountNumber != null && !accountNumber.trim().equals("")) {
//                logger.debug("DB Connection is not null.");
//                /*
//                User setString(int parameterIndex, String x) or setInt(int parameterIndex, int x) or ..  method of preparedStatement, to avoidance of sql injection ,
//                The first argument for each of these setter methods specifies the question mark placeholder.
//                 */
//                String accountQuery = "UPDATE account SET fa_name=?, en_name=? where account_number = ? ";
//                PreparedStatement stmt = connection.prepareStatement(accountQuery);
//                stmt.setString(1, faName);
//                stmt.setString(2, enName);
//                stmt.setString(3, accountNumber.trim());
//
//                // for execute this UPDATE query, you should call  executeUpdate() method [without paramaters]
//                stmt.executeUpdate();
//                connection.commit();
//                connection.close();
//
//            }
//
//
//        } catch (Exception e) {
//            logger.debug("An exception durring saving name of owner of account: " + accountNumber
//                    + ", fa name:" + faName + ", en name:" + enName);
//            e.printStackTrace();
//            return;
//        }
//
//        logger.debug("End of saving name of owner of account: " + accountNumber
//                + ", fa name:" + faName + ", en name:" + enName);
//
//    }
//
//    public static void saveTheMobileNumberAndEncryptionKey(String username, String encryptionKey) {
//        logger.debug("Saving username : " + username + " and encryption key.");
//        if(!isValidMobileNumber(username))
//            return;
//
//        try {
//            ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
//            Connection connection = connectionFactory.getConnection();
//
//            if (connection != null && username != null && !username.trim().equals("")) {
//                logger.debug("DB Connection is not null.");
//
//                /*
//               User setString(int parameterIndex, String x) or setInt(int parameterIndex, int x) or ..  method of preparedStatement, to avoidance of sql injection ,
//               The first argument for each of these setter methods specifies the question mark placeholder.
//                */
//                String outboundQuery = "select * from mobile_key where mobile_number = ? ;";
//                PreparedStatement preparedStatement = connection.prepareStatement(outboundQuery, Statement.RETURN_GENERATED_KEYS);
//                preparedStatement.setString(1, MobileNumberUtil.getStandardMobileNumber(username));
//                preparedStatement.execute();
//                ResultSet resultSet = preparedStatement.getResultSet();
//
//                int rowCount = 0;
//                while (resultSet.next()) {
//                    rowCount++;
//                }
//
//                if(rowCount == 0) {
//                    logger.debug("There is no mobile_key with username: " + username + ". So insert a new one.");
//                    String accountQuery = "insert into mobile_key (`mobile_number`, `encryption_key`) value (?, ?)";
//
//                    PreparedStatement stmt = connection.prepareStatement(accountQuery);
//                    stmt.setString(1, (username == null ? "" : MobileNumberUtil.getStandardMobileNumber(username)));
//                    stmt.setString(2, encryptionKey == null ? "" : encryptionKey.trim());
//
//                    stmt.executeUpdate();
//                    connection.commit();
//                    connection.close();
//
//                } else {
//                    String accountQuery = "UPDATE mobile_key SET encryption_key = ? where mobile_number = ? ";
//                    PreparedStatement stmt = connection.prepareStatement(accountQuery);
//                    stmt.setString(1, encryptionKey == null ? "" : encryptionKey.trim());
//                    stmt.setString(2, MobileNumberUtil.getStandardMobileNumber(username));
//
//                    // for execute this UPDATE query, you should call  executeUpdate() method [without paramaters]
//                    stmt.executeUpdate();
//                    connection.commit();
//                    connection.close();
//                }
//            }
//
//
//
//
//        } catch (Exception e) {
//            logger.debug("An exception durring saving username : " + username);
//            e.printStackTrace();
//            return;
//        }
//
//        logger.debug("End of saving username: " + username);
//
//    }
//
//    public static void blockServiceIfUserEnteredWrongPassForThreeTimes(String accountNumber, Integer serviceCode, boolean wrong) {
//        logger.debug("Block service if user entered wrong pass for three times, user's account no: "
//                + accountNumber + " and service code: " + serviceCode);
//
//        try {
//            ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
//            Connection connection = connectionFactory.getConnection();
//
//            if (connection != null && accountNumber != null && !accountNumber.trim().equals("")) {
//                logger.debug("DB Connection is not null.");
//
//                // if user entered the correct password, reset the password_try_times column
//                if(!wrong) {
//                    String accountQuery = "update account set service_code = ?, password_try_times = 0 where account_number = ?";
//                    PreparedStatement stmt = connection.prepareStatement(accountQuery);
//                    stmt.setInt(1, serviceCode);
//                    stmt.setString(2, accountNumber.trim());
//
//                    stmt.executeUpdate(accountQuery);
//                    connection.commit();
//                    connection.close();
//                    return;
//
//                }
//
//                /*
//               User setString(int parameterIndex, String x) or setInt(int parameterIndex, int x) or ..  method of preparedStatement, to avoidance of sql injection ,
//               The first argument for each of these setter methods specifies the question mark placeholder.
//                */
//                String outboundQuery = "select * from account where account_number = ? ";
//                PreparedStatement preparedStatement = connection.prepareStatement(outboundQuery);
//                preparedStatement.setString(1, accountNumber.trim());
//                preparedStatement.execute();
//                ResultSet resultSet = preparedStatement.getResultSet();
//
//                int actionPermissions = 0;
//                int rowCount = 0;
//                int passwordTryTimes = 0;
//                int lastServiceCode = 0;
//
//                if(resultSet.next()) {
//                    actionPermissions = resultSet.getInt("action_permissions");
//                    passwordTryTimes = resultSet.getInt("password_try_times");
//                    lastServiceCode = resultSet.getInt("service_code");
//                }
//
//                if(rowCount == 0) {
//                    return;
//                }
//
//                /*
//                 if user entered the wrong password for an specific, if password_try_times >= 3, block service for that account,
//                 else if user entered the wrong pass for an specific service code but password_try_times < 3, just increase the password_try_times
//                 else if, the service code is diffrent from last called service, update service code and reset password_try_times
//                 */
//                if(lastServiceCode == serviceCode && passwordTryTimes >= 3) {
//
//                    String binaryPermissions = Integer.toBinaryString(actionPermissions);
//                    while(binaryPermissions.length() < 16)
//                        binaryPermissions = "0" + binaryPermissions;
//
//                    try {
//
//                        binaryPermissions = setChar(binaryPermissions, serviceCode - 1, '0');
//                        actionPermissions = Integer.valueOf(binaryPermissions, 2);
//
//                        /*
//                       User setString(int parameterIndex, String x) or setInt(int parameterIndex, int x) or ..  method of preparedStatement, to avoidance of sql injection ,
//                       The first argument for each of these setter methods specifies the question mark placeholder.
//                        */
//                        String accountQuery = "update account set action_permissions = ? , password_try_times = 0 where account_number = ? " ;
//                        PreparedStatement stmt = connection.prepareStatement(accountQuery);
//                        stmt.setInt(1, actionPermissions);
//                        stmt.setString(2, accountNumber.trim());
//                        stmt.executeUpdate(accountQuery);
//                        connection.commit();
//                        connection.close();
//                        return;
//
//                    } catch (Throwable throwable) {
//                        throwable.printStackTrace();
//                        return;
//                    }
//
//                } else  if(lastServiceCode == serviceCode && passwordTryTimes < 3) {
//                    /*
//                   User setString(int parameterIndex, String x) or setInt(int parameterIndex, int x) or ..  method of preparedStatement, to avoidance of sql injection ,
//                   The first argument for each of these setter methods specifies the question mark placeholder.
//                    */
//                    String accountQuery = "update account set password_try_times = ?  where account_number = ? ";
//                    PreparedStatement stmt = connection.prepareStatement(accountQuery);
//                    stmt.setInt(1, (passwordTryTimes + 1));
//                    stmt.setString(2, accountNumber.trim());
//
//                    stmt.executeUpdate(accountQuery);
//                    connection.commit();
//                    connection.close();
//                    return;
//
//                } else if(lastServiceCode != serviceCode) {
//                    /*
//                   User setString(int parameterIndex, String x) or setInt(int parameterIndex, int x) or ..  method of preparedStatement, to avoidance of sql injection ,
//                   The first argument for each of these setter methods specifies the question mark placeholder.
//                    */
//                    String accountQuery = "update account set service_code = ?, password_try_times = 0 where account_number = ?";
//                    PreparedStatement stmt = connection.prepareStatement(accountQuery);
//                    stmt.setInt(1, serviceCode);
//                    stmt.setString(2, accountNumber.trim());
//
//                    stmt.executeUpdate(accountQuery);
//                    connection.commit();
//                    connection.close();
//                    return;
//                }
//
//            }
//
//
//        } catch (Exception e) {
//            logger.debug("An exception durring checking account status for account: " + accountNumber
//                    + ", and service coed:" + serviceCode);
//            e.printStackTrace();
//            return;
//        }
//
//        logger.debug("End of adding account with no: " + accountNumber);
//
//    }
//
//    public static String setChar(String string, int index, char ch ) throws Throwable {
//        Field field = String.class.getDeclaredField("value");
//        field.setAccessible(true);
//        Array.setChar(field.get(string), index, ch);
//        return string;
//    }
//
//    public static String getEnkryptionKey(String username) {
//        logger.debug("Getting encryption key of mobile_key with username: "+ username);
//
//        try {
//            ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
//            Connection connection = connectionFactory.getConnection();
//
//            if (connection != null && username != null && !username.trim().equals("")) {
//                logger.debug("DB Connection is not null.");
//
//                String outboundQuery = "select * from mobile_key where mobile_number = ? ";
//                PreparedStatement preparedStatement = connection.prepareStatement(outboundQuery);
//                preparedStatement.setString(1, MobileNumberUtil.getStandardMobileNumber(username));
//                preparedStatement.execute();
//                ResultSet resultSet = preparedStatement.getResultSet();
//
//                if(resultSet.next()) {
//                    return resultSet.getString("encryption_key");
//                }
//
//            }
//
//        } catch (Exception e) {
//            logger.debug("An exception durring getting encryption key of account with username: " + username);
//            e.printStackTrace();
//        }
//
//        logger.debug("End of getting encryption key of account with username:" + username);
//        return null;
//
//    }
//
//    public static boolean isValidMobileNumber(String username) {
//        username = MobileNumberUtil.removeCountryCodeAndZero(username);
//        return !(username.equals("0000000000"));
//    }
//
//
//}
