package com.sefryek.broker.pool.JDBCConnectionPool;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;


public class JDCConnectionDriver implements Driver {
    private static final Logger logger = Logger.getLogger(JDCConnectionDriver.class);

    public static final String URL_PREFIX = "jdbc:jdc:";
    private static final int MAJOR_VERSION = 1;
    private static final int MINOR_VERSION = 0;
    private JDCConnectionPool pool;

    public JDCConnectionDriver(String driver, String url, String user, String password) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, SQLException {

        // There is need to call DriverManager.registerDriver(this) because you are writing a new driver . so you should register it.
        DriverManager.registerDriver(this);
        Class.forName(driver).newInstance();
        pool = new JDCConnectionPool(url, user, password);
    }

    public Connection connect(String url, Properties props) throws SQLException {
        logger.debug("\"connect\" method of \"JDCConnectionDriver\" class has been called.");
        if(!url.startsWith(URL_PREFIX)) {
            return null;
        }
        return pool.getConnection();
    }

    public boolean acceptsURL(String url) {
        return url.startsWith(URL_PREFIX);
    }

    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    public int getMinorVersion() {
        return MINOR_VERSION;
    }

    public DriverPropertyInfo[] getPropertyInfo(String str, Properties props) {
        return new DriverPropertyInfo[0];
    }

    public boolean jdbcCompliant() {
        return false;
    }
}
