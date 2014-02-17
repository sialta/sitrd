package com.sefryek.broker.pool.JDBCConnectionPool;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 * Created by IntelliJ IDEA.
 * User: mahta
 * Date: May 10, 2011
 * Time: 2:26:47 PM
 */
public class ConnectionFactory {
    private static final Logger logger = Logger.getLogger(ConnectionFactory.class);


    // Private constructor prevents instantiation from other classes
    private ConnectionFactory() {}

    /**
     * ConnectionFactoryHolder is loaded on the first execution of ConnectionFactory.getInstance()
     * or the first access to ConnectionFactoryHolder.INSTANCE, not before.
     */
    private static class ConnectionFactoryHolder {
        private static final ConnectionFactory INSTANCE = new ConnectionFactory();
    }

    public static ConnectionFactory getInstance() {
        return ConnectionFactoryHolder.INSTANCE;
    }



    //Static class instantiation
    static {
        try {
            new JDCConnectionDriver("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/behestandev",
                    "behestandev", "sefryek");

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        logger.debug("\"getConnection\" method of \"ConnectionFactory\" class has been called.");
        return DriverManager.getConnection("jdbc:jdc:jdcpool");
    }
}
